package cx.rain.mc.forgemod.sinocraft.data.gen.provider.language;

import cx.rain.mc.forgemod.sinocraft.SinoCraft;
import cx.rain.mc.forgemod.sinocraft.block.BlockItems;
import cx.rain.mc.forgemod.sinocraft.block.Blocks;
import cx.rain.mc.forgemod.sinocraft.entity.Entities;
import cx.rain.mc.forgemod.sinocraft.item.Items;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ProviderLanguageZHCN extends LanguageProvider {
    public ProviderLanguageZHCN(DataGenerator gen) {
        super(gen, SinoCraft.MODID, "zh_cn");
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
        add("advancement.sinocraft.basic.root.title","感谢使用华夏文明模组！");
        add("advancement.sinocraft.basic.root.description","感谢使用华夏文明模组！");
    }

    private void addItemGroups() {
        add("itemGroup.sinocraft.blocks", "华夏工艺 | 方块");
        add("itemGroup.sinocraft.decorate", "华夏工艺 | 装饰");
        add("itemGroup.sinocraft.agriculture", "华夏工艺 | 农业");
        add("itemGroup.sinocraft.foods", "华夏工艺 | 食物");
        add("itemGroup.sinocraft.combat", "华夏工艺 | 战斗");
        add("itemGroup.sinocraft.misc", "华夏工艺 | 杂项");
    }

    private void addItems() {
        addItem(Items.PEACH, "桃子");
        addItem(Items.CHILI_PEPPER_SEED, "辣椒种子");
        addItem(Items.GREEN_PEPPER_SEED, "青椒种子");
        addItem(Items.CABBAGE_SEED, "白菜种子");
        addItem(Items.EGGPLANT_SEED, "茄子种子");
        addItem(Items.RICE_SEED, "稻谷");
        addItem(Items.MILLET_SEED, "谷子");
        addItem(Items.SORGHUM_SEED, "高粱");
        addItem(Items.SOYBEAN, "大豆");
        addItem(Items.RICE, "大米");
        addItem(Items.MILLET, "小米");
        addItem(Items.SORGHUM, "高粱米");

        addItem(BlockItems.GREEN_RADISH, "青萝卜");
        addItem(BlockItems.SUMMER_RADISH, "水萝卜");
        addItem(BlockItems.WHITE_RADISH, "白萝卜");
        addItem(Items.CHILI_PEPPER, "辣椒");
        addItem(Items.GREEN_PEPPER, "青椒");
        addItem(Items.EGGPLANT, "茄子");
        addItem(Items.CABBAGE, "白菜");
    }

    private void addBlocks() {
        addBlock(Blocks.LOG_PEACH, "桃树原木");
        addBlock(Blocks.LOG_PEACH_STRIPPED, "去皮桃树原木");
        addBlock(Blocks.LOG_PEACH_BARK, "桃树树皮块");
        addBlock(Blocks.LOG_PEACH_STRIPPED_BARK, "去皮桃树树皮块");
        addBlock(Blocks.PLANK_PEACH, "桃树木板");
        addBlock(Blocks.LEAVES_PEACH, "桃树树叶");
        addBlock(Blocks.SAPLING_PEACH, "桃树树苗");

        addBlock(Blocks.LOG_WALNUT, "核桃树原木");
        addBlock(Blocks.LOG_WALNUT_STRIPPED, "去皮核桃树原木");
        addBlock(Blocks.LOG_WALNUT_BARK, "核桃树树皮块");
        addBlock(Blocks.LOG_WALNUT_STRIPPED_BARK, "去皮核桃树树皮块");
        addBlock(Blocks.PLANK_WALNUT, "核桃树木板");
        addBlock(Blocks.LEAVES_WALNUT, "核桃树树叶");
        addBlock(Blocks.SAPLING_WALNUT, "核桃树树苗");

        addBlock(Blocks.LOG_PLUM, "梅花原木");
        addBlock(Blocks.LOG_PLUM_STRIPPED, "去皮梅花原木");
        addBlock(Blocks.LOG_PLUM_BARK, "梅花树皮块");
        addBlock(Blocks.LOG_PLUM_STRIPPED_BARK, "去皮梅花树皮块");
        addBlock(Blocks.PLANK_PLUM, "梅花木板");
        addBlock(Blocks.LEAVES_PLUM, "梅花树叶");
        addBlock(Blocks.SAPLING_PLUM, "梅花树苗");

        addBlock(Blocks.LOG_MULBERRY, "桑树原木");
        addBlock(Blocks.LOG_MULBERRY_STRIPPED, "去皮桑树原木");
        addBlock(Blocks.LOG_MULBERRY_BARK, "桑树树皮块");
        addBlock(Blocks.LOG_MULBERRY_STRIPPED_BARK, "去皮桑树树皮块");
        addBlock(Blocks.PLANK_MULBERRY, "桑树木板");
        addBlock(Blocks.LEAVES_MULBERRY, "桑树树叶");
        addBlock(Blocks.SAPLING_MULBERRY, "桑树树苗");

        addBlock(Blocks.WHITE_MARBLE, "汉白玉大理石");
        addBlock(Blocks.RED_MARBLE, "南江红大理石");
        addBlock(Blocks.BLACK_MARBLE, "晶墨玉大理石");
    }

    private void addEntities() {
        addEntityType(() -> Entities.ENTITY_BUFFALO, "水牛");
    }
}
