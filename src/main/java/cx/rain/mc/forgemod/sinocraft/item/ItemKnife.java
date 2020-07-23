package cx.rain.mc.forgemod.sinocraft.item;

import cx.rain.mc.forgemod.sinocraft.api.interfaces.IFactory;
import cx.rain.mc.forgemod.sinocraft.api.interfaces.IShave;
import cx.rain.mc.forgemod.sinocraft.api.interfaces.defaultImpl.ShaveBase;
import cx.rain.mc.forgemod.sinocraft.block.base.BlockLog;
import cx.rain.mc.forgemod.sinocraft.group.Groups;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemKnife extends Item {
	public static List<IFactory<IShave,ItemUseContext>> shaveManagers = new ArrayList();

	public static class DefaultManager implements IFactory<IShave, ItemUseContext> {
        private static Map<Block, IShave> recipes = new HashMap();

        public DefaultManager(){
            initIShave();
        }

        private void initIShave(){

        }

        public static void addShaveRecipe(Block block,IShave shave){
            recipes.put(block,shave);
        }

        public static void addShaveRecipe(Block block, BlockState replace, ItemStack... stacks){
            addShaveRecipe(block,new ShaveBase(replace,stacks));
        }

        @Override
        public IShave get(ItemUseContext type, @Nullable Object[] args){
            if(recipes.containsKey(type.getWorld().getBlockState(type.getPos()).getBlock())){
                return recipes.get(type.getWorld().getBlockState(type.getPos()).getBlock());
            }
            return null;
        }
    }

    private static class ShaveBarkManager implements IFactory<IShave, ItemUseContext> {
        public ShaveBarkManager(){

        }

        @Override
        public IShave get(ItemUseContext type, @Nullable Object[] args){
            if(type.getWorld().getBlockState(type.getPos()).getBlock() instanceof BlockLog){
                return (context) -> {
                    BlockLog block = (BlockLog)context.getWorld().getBlockState(context.getPos()).getBlock();
                    context.getWorld().setBlockState(context.getPos(),
                            block.type.getTag().LogStripped.get().getDefaultState());
                    context.getWorld().addEntity(new ItemEntity(context.getWorld(),
                            context.getPos().getX(),context.getPos().getY(),context.getPos().getZ(),
                            new ItemStack(block.type.getTag().Bark.get(),
                                    context.getWorld().getRandom().nextInt(2))
                    ));
                };
            }
            return null;
        }
    }

    public ItemKnife() {
        super(new Item.Properties().group(Groups.MISC));
    }

    void initManager(){
	    shaveManagers.add(new DefaultManager());
	    shaveManagers.add(new ShaveBarkManager());
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
	    for(IFactory<IShave,ItemUseContext> shaveManager : shaveManagers){
            try {
                IShave shave=shaveManager.get(context,null);
                if(shave!=null){
                    shave.Shave(context);
                    break;
                }
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return ActionResultType.FAIL;
    }
}