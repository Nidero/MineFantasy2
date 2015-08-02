package minefantasy.mf2.block.list;

import minefantasy.mf2.MineFantasyII;
import minefantasy.mf2.block.basic.*;
import minefantasy.mf2.block.crafting.*;
import minefantasy.mf2.block.food.*;
import minefantasy.mf2.block.refining.*;
import minefantasy.mf2.item.food.FoodListMF;
import minefantasy.mf2.item.list.ComponentListMF;
import minefantasy.mf2.material.BaseMaterialMF;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class BlockListMF
{
	public static final BaseMaterialMF[] metalBlocks = new BaseMaterialMF[]
	{
		BaseMaterialMF.copper,
		BaseMaterialMF.tin,
		BaseMaterialMF.silver,
		BaseMaterialMF.bronze,
		BaseMaterialMF.pigiron,
		BaseMaterialMF.steel,
		BaseMaterialMF.blacksteel,
		
		BaseMaterialMF.redsteel,
		BaseMaterialMF.bluesteel,
		
		BaseMaterialMF.adamantium,
		BaseMaterialMF.mithril,
		
		BaseMaterialMF.ignotumite,
		BaseMaterialMF.mithium,
		
		BaseMaterialMF.enderforge,
	};
	public static final BaseMaterialMF[] specialMetalBlocks = new BaseMaterialMF[]
	{
		BaseMaterialMF.bronze,
		BaseMaterialMF.iron,
		BaseMaterialMF.steel,
		BaseMaterialMF.blacksteel,
		BaseMaterialMF.dragonforge,
		BaseMaterialMF.redsteel,
		BaseMaterialMF.bluesteel,
	};
	public static final BaseMaterialMF[] anvils = new BaseMaterialMF[]
	{
		//BaseMaterialMF.stone,
		BaseMaterialMF.bronze,
		BaseMaterialMF.iron,
		BaseMaterialMF.steel,
		BaseMaterialMF.blacksteel,
		BaseMaterialMF.bluesteel,
		BaseMaterialMF.redsteel,
	};
	
	public static Block oreCopper = new BlockOreMF("oreCopper", 0, -1).setHardness(2.0F).setResistance(3.0F);
	public static Block oreTin = new BlockOreMF("oreTin", 0).setHardness(2.5F).setResistance(4.0F);
	public static Block oreSilver = new BlockOreMF("oreSilver", 2).setHardness(3.0F).setResistance(5.0F);
	public static Block oreMythic = new BlockMythicOre("oreMythic").setHardness(10.0F).setResistance(100.0F);
	
	public static Block oreKaolinite = new BlockOreMF("oreKaolinite", 1, 0, ComponentListMF.kaolinite, 1, 1, 1).setHardness(3.0F).setResistance(5.0F);
	public static Block oreNitre = new BlockOreMF("oreNitre", 2, 0, ComponentListMF.nitre, 1, 2, 1).setHardness(3.0F).setResistance(5.0F);
	public static Block oreSulfur = new BlockOreMF("oreSulfur", 2, 0, ComponentListMF.sulfur, 1, 4, 2).setHardness(3.0F).setResistance(2.0F);
	public static Block oreBorax = new BlockOreMF("oreBorax", 2, 0, ComponentListMF.flux_strong, 1, 4, 4).setHardness(3.0F).setResistance(2.0F);
	public static Block oreClay = new BlockOreMF("oreClay", 0, 0, Items.clay_ball, 1, 4, 1, Material.ground).setHardness(0.5F).setStepSound(Block.soundTypeGravel);
	
	public static Block mud_brick = new BasicBlockMF("mud_brick", Material.ground).setHardness(1.0F).setResistance(0.5F).setStepSound(Block.soundTypePiston);
	public static Block mud_pavement = new BasicBlockMF("mud_pavement", Material.ground).setHardness(0.5F).setStepSound(Block.soundTypePiston);
	
	public static Block cobble_brick = new BasicBlockMF("cobble_brick", Material.rock).setHardness(2.5F).setResistance(12.0F).setStepSound(Block.soundTypePiston);
	public static Block cobble_pavement = new BasicBlockMF("cobble_pavement", Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston);
	
	public static Block window = new BasicBlockMF("window", Material.glass).setHardness(0.9F).setResistance(0.1F).setStepSound(Block.soundTypeGlass);
	public static Block framed_glass = new BasicBlockMF("framed_glass", Material.glass).setHardness(0.6F).setResistance(0.2F).setStepSound(Block.soundTypeGlass);
	public static Block framed_pane = new BlockPaneMF("framed_pane", "framed_glass", "framed_glass_pane", Material.glass, true).setHardness(0.6F).setResistance(0.1F).setStepSound(Block.soundTypeGlass);
	public static Block window_pane = new BlockPaneMF("window_pane", "window", "framed_glass_pane", Material.glass, true).setHardness(0.9F).setResistance(0.2F).setStepSound(Block.soundTypeGlass);
	
	public static Block thatch = new BasicBlockMF("thatch", Material.leaves).setHardness(1.0F).setStepSound(Block.soundTypeGrass);
	public static Block thatch_stairs = new ConstructionBlockMF.StairsConstBlock("thatch_stairs", thatch).register("thatch_stair");
	
	
	
//	public static Block limestone_cobblestone = new BasicBlockMF("limestone_cobblestone", Material.rock).setHardness(0.8F).setResistance(4.0F).setStepSound(Block.soundTypePiston);
//	public static Block limestone = new BasicBlockMF("limestone", Material.rock, limestone_cobblestone).setHardness(1.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	
	public static Block limestone = new ConstructionBlockMF("limestone").setHardness(1.2F).setResistance(8F);
	
	public static Block firebricks = new BasicBlockMF("firebricks", Material.rock).setHardness(5.0F).setResistance(15.0F).setStepSound(Block.soundTypePiston);
	public static Block clayWall = new BasicBlockMF("clayWall", Material.wood).setHardness(1.0F).setResistance(1.0F).setStepSound(Block.soundTypeWood);
	
	public static Block cheese_wheel = new BlockCakeMF("cheese", FoodListMF.cheese_slice);
	
	public static Block cake_vanilla = new BlockCakeMF("cake_vanilla", FoodListMF.cake_slice);
	public static Block cake_carrot = new BlockCakeMF("cake_carrot", FoodListMF.carrotcake_slice);
	public static Block cake_chocolate = new BlockCakeMF("cake_chocolate", FoodListMF.choccake_slice);
	public static Block cake_bf = new BlockCakeMF("cake_bf", FoodListMF.bfcake_slice);
	
	public static Block pie_meat = new BlockPie("pie_meat", FoodListMF.pieslice_meat);
	
	public static Block pie_apple = new BlockPie("pie_apple", FoodListMF.pieslice_apple);
	public static Block pie_berry = new BlockPie("pie_berry", FoodListMF.pieslice_berry);
	
	public static Block pie_shepards = new BlockPie("pie_shepards", FoodListMF.pieslice_shepards);
	
	public static Block berryBush = new BlockBerryBush("berryBush");
	public static Block blast_chamber = new BlockBFC();
	public static Block blast_heater = new BlockBFH(false);
	public static Block blast_heater_active = new BlockBFH(true).setLightLevel(10F);
	
	public static Block crucible = new BlockCrucible("stone", 0, false);
	public static Block crucible_active = new BlockCrucible("stone", 0, true).setLightLevel(12F);
	public static Block crucibleadv = new BlockCrucible("fireclay", 1, false);
	public static Block crucibleadv_active = new BlockCrucible("fireclay", 1, true).setLightLevel(12F);
	
	public static Block chimney_stone = new BlockChimney("stone", false, false, 5);
	public static Block chimney_stone_wide = new BlockChimney("stone", true, false, 10);
	public static Block chimney_stone_extractor = new BlockChimney("stone_extractor", true, true, 15);
	
	public static Block reinforced_stone = new BasicBlockMF("reinforced_stone", Material.rock).setHardness(2.0F).setResistance(15F).setStepSound(Block.soundTypeStone);
	public static Block reinforced_stone_bricks = new BasicBlockMF("reinforced_stone_bricks", Material.rock).setHardness(2.0F).setResistance(15F).setStepSound(Block.soundTypeStone);
	public static Block reinforced_stone_framed = new BasicBlockMF("reinforced_stone_framed", Material.rock).setHardness(2.5F).setResistance(20F).setStepSound(Block.soundTypeStone);
	
	
	public static Block tanner = new BlockTanningRack(0, "");
	
	public static Block forge = new BlockForge("stone", 0, false);
	public static Block forge_active = new BlockForge("stone", 0, true);
	
	public static Block repair_basic = new BlockRepairKit("basic", 0.25F, 0.05F, 0.1F);
	public static Block repair_advanced = new BlockRepairKit("advanced", 1.0F, 0.2F, 0F);
	public static Block repair_ornate = new BlockRepairKit("ornate", 1.0F, 0.05F, 0F).setOrnate(0.5F);
	
	public static BlockMetalBarsMF[] bars = new BlockMetalBarsMF[specialMetalBlocks.length];
	public static BlockMetalMF[] storage = new BlockMetalMF[metalBlocks.length];
	public static BlockAnvilMF anvilStone = new BlockAnvilMF(BaseMaterialMF.stone);
	public static BlockAnvilMF[] anvil = new BlockAnvilMF[anvils.length];
	public static BlockCarpenter carpenter = new BlockCarpenter();
	public static BlockBombBench bombBench = new BlockBombBench();
	
	public static Block bellows = new BlockBellows();
	
	public static Block refined_planks = new BasicBlockMF("refined_planks", Material.wood).setHardness(2.5F).setResistance(10F).setStepSound(Block.soundTypeWood);
	
	public static Block advTanner = new BlockTanningRack(1, "Strong");
	public static Block research = new BlockResearchStation();
	
	
	public static void init(FMLPreInitializationEvent event)
	{
		//5:20 default planks
		Blocks.fire.setFireInfo(refined_planks, 3, 10);//Half
		for(int a = 0; a < specialMetalBlocks.length; a++)
		{
			BaseMaterialMF material = specialMetalBlocks[a];
			if(material != null)
			{
				bars[a] = new BlockMetalBarsMF(material);
			}
		}
		for(int a = 0; a < metalBlocks.length; a++)
		{
			BaseMaterialMF material = metalBlocks[a];
			if(material != null)
			{
				storage[a] = new BlockMetalMF(material);
			}
		}
		for(int a = 0; a < anvils.length; a++)
		{
			BaseMaterialMF material = anvils[a];
			if(material != null)
			{
				anvil[a] = new BlockAnvilMF(material);
			}
		}
		
		
		
		if(event.getSide() == Side.CLIENT)
    	{
			
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem(); 
    		String MODID = MineFantasyII.MODID;
    		
    		Block[] ores = {oreCopper,oreTin,oreSilver,oreMythic,oreKaolinite,oreNitre,oreSulfur,oreBorax,oreClay};
    		Block[] food = {cheese_wheel,cake_vanilla,cake_carrot,cake_chocolate,cake_bf,pie_meat,pie_apple,pie_berry,pie_shepards};
    		Block[] repair = {repair_basic,repair_advanced,repair_ornate};
    		Block[] construction = {mud_brick,mud_pavement,cobble_brick,cobble_pavement,window,limestone,framed_glass,framed_pane,window_pane,thatch,thatch_stairs,refined_planks,reinforced_stone,reinforced_stone_bricks,reinforced_stone_framed};
    		Block[] chimney = {chimney_stone,chimney_stone_wide,chimney_stone_extractor};
    		Block[] crucib = {blast_chamber,blast_heater,blast_heater_active,crucible,crucible_active,crucibleadv,crucibleadv_active};
    		
    		//OPTIMIZE
    		for (Block block :food) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + ((BlockCakeMF)block).getName(), "inventory"));
    		}
    		
    		for (Block block :ores) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + ((BlockOreMF)block).Name, "inventory"));
    		}

    		for (BlockMetalBarsMF block :bars) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + block.Name, "inventory"));
    		}
    		
    		for (BlockMetalMF block :storage) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + block.Name, "inventory"));
    		}
    		
    		for (BlockAnvilMF block :anvil) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + block.Name, "inventory"));
    		}
    		
    		for (Block block :repair) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + ((BlockRepairKit)block).getName(), "inventory"));
    		}
    		
    		for (Block block :construction) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + ((ConstructionBlockMF)block).getName(new ItemStack(block)), "inventory"));
    		}
    		
    		for (Block block :chimney) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + ((BlockChimney)block).getName(), "inventory"));
    		}
    		
    		for (Block block :crucib) {
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + ((BlockBFC)block).getName(), "inventory"));
    		}
    		
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(anvilStone), 0, new ModelResourceLocation(MODID + ":" + anvilStone.Name, "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(firebricks), 0, new ModelResourceLocation(MODID + ":" + ((BasicBlockMF)firebricks).Name, "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(clayWall), 0, new ModelResourceLocation(MODID + ":" + ((BasicBlockMF)clayWall).Name, "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(carpenter), 0, new ModelResourceLocation(MODID + ":" + carpenter.getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(bombBench), 0, new ModelResourceLocation(MODID + ":" + bombBench.getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(berryBush), 0, new ModelResourceLocation(MODID + ":" + ((BlockBerryBush)berryBush).Name, "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(tanner), 0, new ModelResourceLocation(MODID + ":" + ((BlockTanningRack)tanner).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(forge), 0, new ModelResourceLocation(MODID + ":" + ((BlockForge)forge).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(forge_active), 0, new ModelResourceLocation(MODID + ":" + ((BlockForge)forge_active).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(bellows), 0, new ModelResourceLocation(MODID + ":" + ((BlockBellows)bellows).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(advTanner), 0, new ModelResourceLocation(MODID + ":" + ((BlockTanningRack)advTanner).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(research), 0, new ModelResourceLocation(MODID + ":" + ((BlockResearchStation)research).getName(), "inventory"));
    	}
	}
	
	public static int anvil_RI = 100;
	public static int carpenter_RI = 101;
	public static int bomb_RI = 102;
	public static int tanner_RI = 103;
	public static int forge_RI = 104;
	public static int bellows_RI = 105;
	public static int research_RI = 106;
}
