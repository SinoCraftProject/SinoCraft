package cx.rain.mc.forgemod.sinocraft.data.gen.provider.language;

import cx.rain.mc.forgemod.sinocraft.SinoCraft;
import cx.rain.mc.forgemod.sinocraft.block.ModBlockItems;
import cx.rain.mc.forgemod.sinocraft.block.ModBlocks;
import cx.rain.mc.forgemod.sinocraft.entity.ModEntities;
import cx.rain.mc.forgemod.sinocraft.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ProviderLanguageENUS extends LanguageProvider {
    public ProviderLanguageENUS(DataGenerator gen) {
        super(gen, SinoCraft.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItemGroups();
        addItems();
        addBlocks();
        addEntities();
        addAdvancements();
    }

    private void addAdvancements(){
        add("advancement.sinocraft.basic.root.title","Welcome to SinoCraft!");
        add("advancement.sinocraft.basic.root.description","Welcome to SinoCraft!");

        add("advancement.sinocraft.basic.knife.title","Knife");
        add("advancement.sinocraft.basic.knife.description","Get a knife.");

        add("advancement.sinocraft.basic.knife_killed.title","Knife can kill too");
        add("advancement.sinocraft.basic.knife_killed.description","Kill a entity with a knife.");

        add("advancement.sinocraft.basic.get_bark.title","Strip the tree!");
        add("advancement.sinocraft.basic.get_bark.description","Shave a tree with knife and get the bark.");

        add("advancement.minecraft.adventure.kill_all_entities.title","Slaughter!");
        add("advancement.minecraft.adventure.kill_all_entities.description","Kill one of every living entities.");

        add("advancement.sinocraft.basic.kill_all_mobs_with_knife.title","Mob Master");
        add("advancement.sinocraft.basic.kill_all_mobs_with_knife.description","Kill one of every mobs with knife.");

        add("advancement.sinocraft.basic.kill_all_entities_with_knife.title","Real slaughter!");
        add("advancement.sinocraft.basic.kill_all_entities_with_knife.description","Kill one of every living entities with knife.");

        add("advancement.sinocraft.basic.get_china_ink.title","Smell of ink!");
        add("advancement.sinocraft.basic.get_china_ink.description","Get china ink.");

        add("advancement.sinocraft.basic.get_stone_mill.title","Miller");
        add("advancement.sinocraft.basic.get_stone_mill.description","Get stone mill.");
    }

    private void addItemGroups() {
        add("itemGroup.sinocraft.blocks", "SinoCraft | Blocks");
        add("itemGroup.sinocraft.decorate", "SinoCraft | Decorate");
        add("itemGroup.sinocraft.agriculture", "SinoCraft | Agriculture");
        add("itemGroup.sinocraft.foods", "SinoCraft | Foods");
        add("itemGroup.sinocraft.combat", "SinoCraft | Combat");
        add("itemGroup.sinocraft.misc", "SinoCraft | Miscellaneous");
    }

    private void addItems() {
        addItem(ModItems.PEACH, "Peach");
        addItem(ModItems.CHILI_PEPPER_SEED, "Chilipepper Seeds");
        addItem(ModItems.GREEN_PEPPER_SEED, "Green Pepper Seeds");
        addItem(ModItems.CABBAGE_SEED, "Chinese Cabbage Seeds");
        addItem(ModItems.EGGPLANT_SEED, "Eggplant Seeds");
        addItem(ModItems.RICE_SEED, "Rice Seeds");
        addItem(ModItems.MILLET_SEED, "Millet Seeds");
        addItem(ModItems.SORGHUM_SEED, "Sorghum Seeds");
        addItem(ModItems.SOYBEAN, "Soybean");
        addItem(ModItems.RICE, "Rice");
        addItem(ModItems.MILLET, "Millet");
        addItem(ModItems.SORGHUM, "Sorghum");

        addItem(ModItems.FLOUR, "Flour");
        addItem(ModItems.DOUGH, "Dough");
        addItem(ModItems.DUMPLING, "Dumpling");
        addItem(ModItems.DUMPLING_WRAPPER, "Dumpling Wrapper");
        addItem(ModItems.COOKED_DUMPLING, "Cooked Dumpling");
        addItem(ModItems.STUFFING, "Stuffing");

        addItem(ModBlockItems.GREEN_RADISH, "Green Radish");
        addItem(ModBlockItems.SUMMER_RADISH, "Summer Radish");
        addItem(ModBlockItems.WHITE_RADISH, "White Radish");
        addItem(ModItems.CHILI_PEPPER, "Chilipepper");
        addItem(ModItems.GREEN_PEPPER, "Green Pepper");
        addItem(ModItems.EGGPLANT, "Eggplant");
        addItem(ModItems.CABBAGE, "Chinese Cabbage");
        addItem(ModItems.BARK,"Bark");
        addItem(ModItems.KNIFE_IRON,"Iron Knife");
        addItem(ModItems.KNIFE_GOLD,"Gold Knife");
        addItem(ModItems.KNIFE_DIAMOND,"Diamond Knife");
        addItem(ModItems.CHINESE_BRUSH,"Chinese Brush");
        addItem(ModItems.CHINA_INK,"China Ink");
        addItem(ModItems.CHARCOAL_BLACK,"Charcoal Black");
        addItem(ModItems.INK_STONE, "Ink Stone");
        addItem(ModItems.XUAN_PAPER, "Xuan Paper");
        addItem(ModItems.BUCKET_WOOD_PULP, "Wood Pulp Bucket");
    }

    private void addBlocks() {
        addBlock(ModBlocks.LOG_PEACH, "Peach Log");
        addBlock(ModBlocks.LOG_PEACH_STRIPPED, "Stripped Peach Log");
        addBlock(ModBlocks.LOG_PEACH_BARK, "Peach Wood");
        addBlock(ModBlocks.LOG_PEACH_STRIPPED_BARK, "Stripped Peach Wood");
        addBlock(ModBlocks.PLANK_PEACH, "Peach Plank");
        addBlock(ModBlocks.LEAVES_PEACH, "Peach Leaves");
        addBlock(ModBlocks.SAPLING_PEACH, "Peach Sapling");

        addBlock(ModBlocks.LOG_WALNUT, "Walnut Log");
        addBlock(ModBlocks.LOG_WALNUT_STRIPPED, "Stripped Walnut Log");
        addBlock(ModBlocks.LOG_WALNUT_BARK, "Walnut Wood");
        addBlock(ModBlocks.LOG_WALNUT_STRIPPED_BARK, "Stripped Walnut Wood");
        addBlock(ModBlocks.PLANK_WALNUT, "Walnut Plank");
        addBlock(ModBlocks.LEAVES_WALNUT, "Walnut Leaves");
        addBlock(ModBlocks.SAPLING_WALNUT, "Walnut Sapling");

        addBlock(ModBlocks.LOG_PLUM, "Plum Log");
        addBlock(ModBlocks.LOG_PLUM_STRIPPED, "Stripped Plum Log");
        addBlock(ModBlocks.LOG_PLUM_BARK, "Plum Wood");
        addBlock(ModBlocks.LOG_PLUM_STRIPPED_BARK, "Stripped Plum Wood");
        addBlock(ModBlocks.PLANK_PLUM, "Plum Plank");
        addBlock(ModBlocks.LEAVES_PLUM, "Plum Leaves");
        addBlock(ModBlocks.SAPLING_PLUM, "Plum Sapling");

        addBlock(ModBlocks.LOG_MULBERRY, "Mulberry Log");
        addBlock(ModBlocks.LOG_MULBERRY_STRIPPED, "Stripped Mulberry Log");
        addBlock(ModBlocks.LOG_MULBERRY_BARK, "Mulberry Wood");
        addBlock(ModBlocks.LOG_MULBERRY_STRIPPED_BARK, "Stripped Mulberry Wood");
        addBlock(ModBlocks.PLANK_MULBERRY, "Mulberry Plank");
        addBlock(ModBlocks.LEAVES_MULBERRY, "Mulberry Leaves");
        addBlock(ModBlocks.SAPLING_MULBERRY, "Mulberry Sapling");

        addBlock(ModBlocks.WHITE_MARBLE, "White Marble");
        addBlock(ModBlocks.RED_MARBLE, "Red Marble");
        addBlock(ModBlocks.BLACK_MARBLE, "Black Marble");

        addBlock(ModBlocks.STOVE, "Stove");
        addBlock(ModBlocks.VAT, "Vat");
        addBlock(ModBlocks.PAPER_DRYING_RACK, "Paper Drying Rack");
        addBlock(ModBlocks.STONE_MILL, "Stone Mill");
    }

    private void addEntities() {
        addEntityType(() -> ModEntities.ENTITY_BUFFALO.get(), "Buffalo");
    }
}
