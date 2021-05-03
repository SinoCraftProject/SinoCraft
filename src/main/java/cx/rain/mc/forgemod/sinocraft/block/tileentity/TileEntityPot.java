package cx.rain.mc.forgemod.sinocraft.block.tileentity;

import cx.rain.mc.forgemod.sinocraft.api.crafting.ironpot.IronPotRecipes;
import cx.rain.mc.forgemod.sinocraft.api.crafting.ironpot.ModIronPotRecipes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

/**
 * @author NmmOC7
 */
public class TileEntityPot extends TileEntityUpdatableBase implements IInventory {
    private final IronPotItemHandler ITEM_HANDLER = new IronPotItemHandler();

    @OnlyIn(Dist.CLIENT)
    public NonNullList<ItemStack> clientInput = ITEM_HANDLER.getInput();
    @OnlyIn(Dist.CLIENT)
    public ItemStack clientOutput = ITEM_HANDLER.getOutput();

    public TileEntityPot() {
        super(ModTileEntities.IRON_POT.get());
    }

    private int progress = 0;

    @Override
    public void tick() {
        if (!this.world.isRemote) {
            progress++;

            if (progress >= 40 && ITEM_HANDLER.getOutput().isEmpty()) {
                for (IronPotRecipes recipe : ModIronPotRecipes.IRON_POT_RECIPES) {
                    if (recipe.matches(this, this.world)) {
                        for (ItemStack input : recipe.input) {
                            for (int i = 0; i < ITEM_HANDLER.getSlots() - 1; i++) {
                                ItemStack stack = ITEM_HANDLER.getStackInSlot(i);

                                if (stack.isItemEqual(input) && stack.getCount() >= input.getCount()) {
                                    ITEM_HANDLER.decrStackSize(i, input.getCount());
                                    break;
                                }
                            }
                        }

                        this.ITEM_HANDLER.setOutput(recipe.getCraftingResult(this));
                        this.progress = 0;
                    }
                }
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return ITEM_HANDLER.getSlots();
    }

    @Override
    public boolean isEmpty() {
        return ITEM_HANDLER.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return ITEM_HANDLER.getStackInSlot(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ITEM_HANDLER.decrStackSize(index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack result = ITEM_HANDLER.getStackInSlot(index).copy();

        this.ITEM_HANDLER.setStackInSlot(index, ItemStack.EMPTY);

        return result;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.ITEM_HANDLER.setStackInSlot(index, stack);
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        this.ITEM_HANDLER.clear();
    }

    public boolean hasItemStack(ItemStack stack) {
        for (ItemStack input: ITEM_HANDLER.getInput()) {
            if (stack.isItemEqual(input) && stack.getCount() <= input.getCount()) {
                return true;
            }
        }

        return false;
    }

    public int addStackToInput(ItemStack stack) {
        return ITEM_HANDLER.addStack(stack);
    }

    public ItemStack removeStackOnInput() {
        ItemStack result = ItemStack.EMPTY;

        for (int i = 0; i < 6; i++) {
            if (!this.getStackInSlot(i).isEmpty()) {
                result = this.getStackInSlot(i).copy();
                this.setInventorySlotContents(i, ItemStack.EMPTY);

                break;
            }
        }

        return result;
    }

    public ItemStack removeStackOnOutput() {
        ItemStack result = ItemStack.EMPTY;

        if (!ITEM_HANDLER.getOutput().isEmpty()) {
            result = ITEM_HANDLER.getOutput();
            ITEM_HANDLER.setOutput(ItemStack.EMPTY);
        }

        return result;
    }

    public NonNullList<ItemStack> getInput() {
        return ITEM_HANDLER.getInput();
    }

    public ItemStack getOutput() {
        return ITEM_HANDLER.getOutput();
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();

        ListNBT inputs = new ListNBT();

        for (ItemStack input: ITEM_HANDLER.getInput()) {
            CompoundNBT inputNBT = new CompoundNBT();
            input.write(inputNBT);
            inputs.add(inputNBT);
        }

        compoundNBT.put("inputs", inputs);

        CompoundNBT outputNBT = new CompoundNBT();
        ITEM_HANDLER.getOutput().write(outputNBT);
        compoundNBT.put("output", outputNBT);

        return compoundNBT;
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        ListNBT inputs = tag.getList("inputs", 9);
        NonNullList<ItemStack> stacks = NonNullList.withSize(7, ItemStack.EMPTY);

        for (INBT nbt: inputs) {
            stacks.add(ItemStack.read((CompoundNBT) nbt));
        }

        CompoundNBT outputNBT = tag.getCompound("output");
        stacks.set(6, ItemStack.read(outputNBT));

        ITEM_HANDLER.setInput(stacks);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
          CompoundNBT updateNBT = new CompoundNBT();
          CompoundNBT changedItemNBT = new CompoundNBT();
          ITEM_HANDLER.changedItem.getStack().write(changedItemNBT);

          updateNBT.putInt("slot", ITEM_HANDLER.changedItem.getSlot());
          updateNBT.put("stack", changedItemNBT);

          return new SUpdateTileEntityPacket(pos, 1, updateNBT);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
          CompoundNBT updateNBT = pkt.getNbtCompound();

          ITEM_HANDLER.setStackInSlot(updateNBT.getInt("slot"), ItemStack.read(updateNBT.getCompound("stack")));
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ListNBT inputs = new ListNBT();

        for (ItemStack stack: ITEM_HANDLER.getInput()) {
            CompoundNBT stackNBT = new CompoundNBT();
            stack.write(stackNBT);
            inputs.add(stackNBT);
        }

        compound.put("inputs", inputs);

        CompoundNBT outputNBT = new CompoundNBT();
        ITEM_HANDLER.getOutput().write(outputNBT);
        compound.put("output", outputNBT);

        return super.write(compound);
    }

    @Override
    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);

        NonNullList<ItemStack> stacks = NonNullList.withSize(7, ItemStack.EMPTY);

        for (INBT inputNBT: compound.getList("inputs", 9)) {
            stacks.add(ItemStack.read((CompoundNBT) inputNBT));
        }

        stacks.set(6, ItemStack.read(compound.getCompound("output")));

        ITEM_HANDLER.setInput(stacks);

        for (int i = 0; i < 7; i++) {
            ITEM_HANDLER.onContentsChanged(i);
        }
    }

    private class IronPotItemHandler extends ItemStackHandler {
        public IronPotItemHandler() {
            super(7);
        }

        public void setInput(NonNullList<ItemStack> stacks) {
            this.stacks = stacks;
        }

        public NonNullList<ItemStack> getInput() {
            NonNullList<ItemStack> result = NonNullList.withSize(6, ItemStack.EMPTY);

            for (int i = 0; i < 6; i++) {
                result.set(i, this.stacks.get(i).copy());
            }

            return result;
        }

        public ItemStack getOutput() {
            return this.stacks.get(6).copy();
        }

        public void setOutput(ItemStack output) {
            this.setStackInSlot(6, output);
        }

        public int addStack(ItemStack stack) {
            int remain = stack.getCount();

            for (int i = 0; i <= 5; i++) {
                ItemStack input = this.getStackInSlot(i);

                if (input.isEmpty()) {
                    ItemStack newStack = stack.copy();
                    newStack.setCount(remain);

                    setStackInSlot(i, newStack);
                    remain = 0;
                    break;
                }
                else if (input.getItem() == stack.getItem()) {
                    if (input.getMaxStackSize() - remain >= stack.getCount()) {
                        ItemStack newStack = input.copy();
                        newStack.setCount(remain + stack.getCount());

                        setStackInSlot(i, newStack);
                        remain = 0;
                        break;
                    }
                    else {
                        ItemStack newStack = stack.copy();
                        newStack.setCount(stack.getMaxStackSize());

                        setStackInSlot(i, newStack);
                        remain -= input.getMaxStackSize() - input.getCount();
                    }
                }
            }

            return remain;
        }

        public void clear() {
            this.stacks.clear();
        }

        @Override
        protected void onContentsChanged(int slot) {
            if (!world.isRemote) {
                changedItem = new ChangedItem(slot, getStackInSlot(slot));
                markDirty();
            }
        }

        public ChangedItem changedItem = new ChangedItem(0, ItemStack.EMPTY);

        private class ChangedItem {
            private final int slot;
            private final ItemStack stack;

            public ChangedItem(int slot, ItemStack stack) {
                this.slot = slot;
                this.stack = stack;
            }

            public int getSlot() {
                return slot;
            }

            public ItemStack getStack() {
                return stack;
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return true;
        }

        public boolean isEmpty() {
            boolean result = true;

            for (ItemStack stack: this.stacks) {
                if (!stack.isEmpty()) {
                    result = false;
                    break;
                }
            }

            return result;
        }

        public ItemStack decrStackSize(int index, int count) {
            return ItemStackHelper.getAndSplit(this.stacks, index, count);
        }
    }
}