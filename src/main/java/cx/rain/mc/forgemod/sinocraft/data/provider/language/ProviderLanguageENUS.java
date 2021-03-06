package cx.rain.mc.forgemod.sinocraft.data.provider.language;

import cx.rain.mc.forgemod.sinocraft.block.ModBlockItems;
import cx.rain.mc.forgemod.sinocraft.block.ModBlocks;
import cx.rain.mc.forgemod.sinocraft.data.provider.base.ProviderLanguage;
import cx.rain.mc.forgemod.sinocraft.entity.EntityRegister;
import cx.rain.mc.forgemod.sinocraft.entity.ModEntities;
import cx.rain.mc.forgemod.sinocraft.item.ModGroups;
import cx.rain.mc.forgemod.sinocraft.item.ModItems;
import cx.rain.mc.forgemod.sinocraft.item.ModSpawnEggItem;
import net.minecraft.data.DataGenerator;

public class ProviderLanguageENUS extends ProviderLanguage {
    public ProviderLanguageENUS(DataGenerator gen) {
        super(gen, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItemGroups();
        addItems();
        addBlocks();
        addEntities();
        addAdvancements();
        addMisc();
        addGui();
    }

    private void addAdvancements() {
        add("advancement.sinocraft.root.title", "Welcome to SinoCraft!");
        add("advancement.sinocraft.root.description", "Welcome to SinoCraft!");

        add("advancement.sinocraft.knife.title", "Knife");
        add("advancement.sinocraft.knife.description", "Get a knife.");

        add("advancement.sinocraft.kill_entity_by_knives.title", "Knife can kill too");
        add("advancement.sinocraft.kill_entity_by_knives.description", "Kill a entity with a knife.");

        add("advancement.sinocraft.get_bark.title", "Strip the tree!");
        add("advancement.sinocraft.get_bark.description", "Shave a tree with knife and get the bark.");

        add("advancement.sinocraft.kill_all_mobs_with_knife.title", "Mob Master");
        add("advancement.sinocraft.kill_all_mobs_with_knife.description", "Kill one of every mobs with knife.");

        add("advancement.sinocraft.kill_all_entities_with_knife.title", "Real slaughter!");
        add("advancement.sinocraft.kill_all_entities_with_knife.description", "Kill one of every living entities with knife.");

        add("advancement.sinocraft.get_china_ink.title", "Smell of ink!");
        add("advancement.sinocraft.get_china_ink.description", "Get china ink.");

        add("advancement.sinocraft.get_stone_mill.title", "Miller");
        add("advancement.sinocraft.get_stone_mill.description", "Get stone mill.");
    }

    private void addItemGroups() {
        addItemGroup(ModGroups.BLOCKS, "SinoCraft | Blocks");
        addItemGroup(ModGroups.AGRICULTURE, "SinoCraft | Agriculture And Food");
        addItemGroup(ModGroups.MISC, "SinoCraft | Miscellaneous");
    }

    private void addMisc() {
        add("gui.sinocraft.category.soak", "Soak");
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
        addItem(ModItems.BARK, "Bark");
        addItem(ModItems.KNIFE_IRON, "Iron Knife");
        addItem(ModItems.KNIFE_GOLD, "Gold Knife");
        addItem(ModItems.KNIFE_DIAMOND, "Diamond Knife");
        addItem(ModItems.CHINESE_BRUSH, "Chinese Brush");
        addItem(ModItems.CHINESE_INK, "China Ink");
        addItem(ModItems.CHARCOAL_BLACK, "Charcoal Black");
        addItem(ModItems.INK_STONE, "Ink Stone");
        addItem(ModItems.XUAN_PAPER, "Xuan Paper");
        addItem(ModItems.BUCKET_WOOD_PULP, "Wood Pulp Bucket");
//        addItem(ModItems.TUTORIAL_BOOK, "《SinoCraft》");
        addItem(ModItems.TEA_LEAF, "Tea Leaf");
        addItem(ModItems.TEACUP, "Teacup");
        addItem(ModItems.TEAPOT, "Teapot");
        addItem(ModItems.BOWL_WITH_RICE, "Rice");
        addItem(ModItems.BOWL_WITH_WATER, "Bowl With Water");
        addItem(ModItems.BOWL_WITH_PORRIDGE, "Porridge");
    }

    private void addBlocks() {
        addBlock(ModBlocks.PEACH_LOG, "Peach Log");
        addBlock(ModBlocks.PEACH_LOG_STRIPPED, "Stripped Peach Log");
        addBlock(ModBlocks.PEACH_LOG_BARK, "Peach Wood");
        addBlock(ModBlocks.PEACH_LOG_STRIPPED_BARK, "Stripped Peach Wood");
        addBlock(ModBlocks.PEACH_PLANK, "Peach Plank");
        addBlock(ModBlocks.PEACH_LEAVES, "Peach Leaves");
        addBlock(ModBlocks.PEACH_SAPLING, "Peach Sapling");

        addBlock(ModBlocks.WALNUT_LOG, "Walnut Log");
        addBlock(ModBlocks.WALNUT_LOG_STRIPPED, "Stripped Walnut Log");
        addBlock(ModBlocks.WALNUT_LOG_BARK, "Walnut Wood");
        addBlock(ModBlocks.WALNUT_LOG_STRIPPED_BARK, "Stripped Walnut Wood");
        addBlock(ModBlocks.WALNUT_PLANK, "Walnut Plank");
        addBlock(ModBlocks.WALNUT_LEAVES, "Walnut Leaves");
        addBlock(ModBlocks.WALNUT_SAPLING, "Walnut Sapling");

        addBlock(ModBlocks.PLUM_LOG, "Plum Log");
        addBlock(ModBlocks.PLUM_LOG_STRIPPED, "Stripped Plum Log");
        addBlock(ModBlocks.PLUM_LOG_BARK, "Plum Wood");
        addBlock(ModBlocks.PLUM_LOG_STRIPPED_BARK, "Stripped Plum Wood");
        addBlock(ModBlocks.PLUM_PLANK, "Plum Plank");
        addBlock(ModBlocks.PLUM_LEAVES, "Plum Leaves");
        addBlock(ModBlocks.PLUM_SAPLING, "Plum Sapling");

        addBlock(ModBlocks.MULBERRY_LOG, "Mulberry Log");
        addBlock(ModBlocks.MULBERRY_LOG_STRIPPED, "Stripped Mulberry Log");
        addBlock(ModBlocks.MULBERRY_LOG_BARK, "Mulberry Wood");
        addBlock(ModBlocks.MULBERRY_LOG_STRIPPED_BARK, "Stripped Mulberry Wood");
        addBlock(ModBlocks.MULBERRY_PLANK, "Mulberry Plank");
        addBlock(ModBlocks.MULBERRY_LEAVES, "Mulberry Leaves");
        addBlock(ModBlocks.MULBERRY_SAPLING, "Mulberry Sapling");

        addBlock(ModBlocks.WHITE_MARBLE, "White Marble");
        addBlock(ModBlocks.RED_MARBLE, "Red Marble");
        addBlock(ModBlocks.BLACK_MARBLE, "Black Marble");

        addBlock(ModBlocks.STOVE, "Stove");
        addBlock(ModBlocks.POT, "Pot");
        addBlock(ModBlocks.VAT, "Vat");
        addBlock(ModBlocks.PAPER_DRYING_RACK, "Paper Drying Rack");
        addBlock(ModBlocks.STONE_MILL, "Stone Mill");

        addBlock(ModBlocks.TEA_TABLE, "");
        addBlock(ModBlocks.BELLOWS, "Bellows");
    }

    private void addEntities() {
        add(ModSpawnEggItem.TRANSLATION_KEY, "%s Spawn Egg");
        for (EntityRegister.RegistryEntry<?> entry : ModEntities.REGISTRY.entries.values()) {
            addEntityType(entry.getTypeObj(), entry.langEn);
        }
    }

    private void addGui() {
        add("sinocraft.jei.recipe.cooking", "Iron Pot");
        add("sinocraft.jei.recipe.soaking", "Vat");
        add("sinocraft.jei.recipe.steamer", "Food Steamer");
        add("config.waila.plugin_sinocraft", "SinoCraft");
        add("config.waila.plugin_sinocraft.enabled", "Enabled");
    }
}
