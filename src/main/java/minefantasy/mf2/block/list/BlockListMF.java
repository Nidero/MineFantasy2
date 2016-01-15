package minefantasy.mf2.block.list;

import minefantasy.mf2.block.basic.*;
import minefantasy.mf2.block.crafting.*;
import minefantasy.mf2.block.decor.*;
import minefantasy.mf2.block.food.*;
import minefantasy.mf2.block.refining.*;
import minefantasy.mf2.item.food.FoodListMF;
import minefantasy.mf2.item.list.ComponentListMF;
import minefantasy.mf2.material.BaseMaterialMF;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlockListMF
{
	public static final String[] metalBlocks = new String[]
	{
		"copper", "tin", "silver", "bronze", "pigiron", "steel", "blacksteel", "redsteel", "bluesteel", "adamantium", "mithril", "ignotumite", "mithium", "ender"
	};
	public static final String[] specialMetalBlocks = new String[]
	{
		"bronze", "iron", "steel", "blacksteel", "dragonforge", "redsteel", "bluesteel"
	};
	public static final String[] anvils = new String[]
	{
		"bronze", "iron", "steel", "blacksteel", "bluesteel", "redsteel"
	};
	
	public static Block oreCopper = new BlockOreMF("oreCopper", 0, -1).setHardness(2.0F).setResistance(3.0F);
	public static Block oreTin = new BlockOreMF("oreTin", 0).setHardness(2.5F).setResistance(4.0F);
	public static Block oreSilver = new BlockOreMF("oreSilver", 2).setHardness(3.0F).setResistance(5.0F);
	public static Block oreMythic = new BlockMythicOre("oreMythic", false).setHardness(10.0F).setResistance(100.0F);
	
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
	public static Block thatch_stair = new ConstructionBlockMF.StairsConstBlock("thatch_stair", thatch).register("thatch_stair");
	
//	public static Block limestone_cobblestone = new BasicBlockMF("limestone_cobblestone", Material.rock).setHardness(0.8F).setResistance(4.0F).setStepSound(Block.soundTypePiston);
//	public static Block limestone = new BasicBlockMF("limestone", Material.rock, limestone_cobblestone).setHardness(1.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);
	
	public static Block limestone = new ConstructionBlockMF("limestone").setHardness(1.2F).setResistance(8F);
	
	public static Block firebricks = new BasicBlockMF("firebricks", Material.rock).setHardness(5.0F).setResistance(15.0F).setStepSound(Block.soundTypePiston);
	public static Block clayWall = new BasicBlockMF("clayWall", Material.wood).setHardness(1.0F).setResistance(1.0F).setStepSound(Block.soundTypeWood);
	
	public static BlockMetalBarsMF[] bars = new BlockMetalBarsMF[specialMetalBlocks.length];
	public static BlockMetalMF[] storage = new BlockMetalMF[metalBlocks.length];
	public static BlockAnvilMF anvilStone;
	public static BlockAnvilMF[] anvil = new BlockAnvilMF[anvils.length];
	public static BlockCarpenter carpenter = new BlockCarpenter();
	public static BlockBombBench bombBench = new BlockBombBench();
	
	public static Block cheese_wheel = new BlockCakeMF("cheese", FoodListMF.cheese_slice);
	
	public static Block cake_vanilla = new BlockCakeMF("cake_vanilla", FoodListMF.cake_slice);
	public static Block cake_carrot = new BlockCakeMF("cake_carrot", FoodListMF.carrotcake_slice);
	public static Block cake_chocolate = new BlockCakeMF("cake_chocolate", FoodListMF.choccake_slice);
	public static Block cake_bf = new BlockCakeMF("cake_bf", FoodListMF.bfcake_slice);
	
	public static Block pie_meat = new BlockPie("pie_meat", FoodListMF.meatpie_slice);
	
	public static Block pie_apple = new BlockPie("pie_apple", FoodListMF.pieslice_apple);
	public static Block pie_berry = new BlockPie("pie_berry", FoodListMF.pieslice_berry);
	
	public static Block pie_shepards = new BlockPie("pie_shepards", FoodListMF.pieslice_shepards);
	
	public static Block berryBush = new BlockBerryBush("berries");
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
	
	public static Block tanner = new BlockTanningRack(0, "");
	
	public static Block forge = new BlockForge("stone", 0, false);
	public static Block forge_active = new BlockForge("stone", 0, true);
	public static Block forge_metal = new BlockForge("metal", 1, false);
	public static Block forge_metal_active = new BlockForge("metal", 1, true);
	
	public static Block repair_basic = new BlockRepairKit("basic", 0.25F, 0.05F, 0.2F);
	public static Block repair_advanced = new BlockRepairKit("advanced", 1.0F, 0.2F, 0.05F);
	public static Block repair_ornate = new BlockRepairKit("ornate", 1.0F, 0.05F, 0.05F).setOrnate(0.5F);
	
	public static Block bellows = new BlockBellows();
	
	public static Block refined_planks = new BasicBlockMF("refined_planks", Material.wood).setHardness(2.5F).setResistance(10F).setStepSound(Block.soundTypeWood);
	
	public static Block reinforced_stone = new BasicBlockMF("reinforced_stone", Material.rock).setHardness(2.0F).setResistance(15F).setStepSound(Block.soundTypeStone);
	public static Block reinforced_stone_bricks = new BasicBlockMF("reinforced_stone_bricks", Material.rock).setHardness(2.0F).setResistance(15F).setStepSound(Block.soundTypeStone);
	public static Block reinforced_stone_framed = new BasicBlockMF("reinforced_stone_framed", Material.rock).setHardness(2.5F).setResistance(20F).setStepSound(Block.soundTypeStone);
	
	public static Block advTanner = new BlockTanningRack(1, "Strong");
	public static Block research = new BlockResearchStation();
	public static Block trough_wood = new BlockTrough("Basic", Material.wood, 32);
	public static Block trough_rock = new BlockTrough("Rock", Material.wood, 64);
	public static Block trough_strongwood = new BlockTrough("Refinedwood", Material.wood, 100);
	public static Block engTanner = new BlockEngineerTanner(2, "Metal");
	
	public static Block bombPress = new BlockBombPress();
	
	public static Block road = new BlockRoad("road_mf", 14F);
	public static Block lowroad = new BlockRoad("road_mf_short", 7F);
	//public static Block railForged = new BlockRailMF(BaseMaterialMF.steel);
	//public static Block railAuto = new BlockPowRailMF(BaseMaterialMF.steel, "auto");
	
	public static void init()
	{
		anvilStone = new BlockAnvilMF(BaseMaterialMF.getMaterial("stone"));
		//5:20 default planks
		Blocks.fire.setFireInfo(refined_planks, 3, 10);//Half
		for(int a = 0; a < specialMetalBlocks.length; a++)
		{
			BaseMaterialMF material = BaseMaterialMF.getMaterial(specialMetalBlocks[a]);
			if(material != null)
			{
				bars[a] = new BlockMetalBarsMF(material);
			}
		}
		for(int a = 0; a < metalBlocks.length; a++)
		{
			BaseMaterialMF material = BaseMaterialMF.getMaterial(metalBlocks[a]);
			if(material != null)
			{
				storage[a] = new BlockMetalMF(material);
			}
		}
		for(int a = 0; a < anvils.length; a++)
		{
			BaseMaterialMF material = BaseMaterialMF.getMaterial(anvils[a]);
			if(material != null)
			{
				anvil[a] = new BlockAnvilMF(material);
			}
		}
		
		OreDictionary.registerOre("cobblestone", new ItemStack(limestone, 1, 1));
		OreDictionary.registerOre("stone", new ItemStack(limestone, 1, 0));
		OreDictionary.registerOre("limestone", new ItemStack(limestone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestone", new ItemStack(cobble_brick, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestone", new ItemStack(cobble_pavement, 1, OreDictionary.WILDCARD_VALUE));
		
		OreDictionary.registerOre("blockGlass", new ItemStack(window, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockGlass", new ItemStack(framed_glass, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(window_pane, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(framed_pane, 1, OreDictionary.WILDCARD_VALUE));
	}
}
