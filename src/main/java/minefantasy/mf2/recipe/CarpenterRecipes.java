package minefantasy.mf2.recipe;

import minefantasy.mf2.api.MineFantasyAPI;
import minefantasy.mf2.block.list.BlockListMF;
import minefantasy.mf2.item.food.FoodListMF;
import minefantasy.mf2.item.list.ArmourListMF;
import minefantasy.mf2.item.list.ComponentListMF;
import minefantasy.mf2.item.list.ToolListMF;
import minefantasy.mf2.knowledge.KnowledgeListMF;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class CarpenterRecipes
{
	private static final String basic = "step.wood";
	private static final String chopping = "dig.wood";
	//private static final String engineering = "engineering";
	private static final String sewing = "step.cloth";
	private static final String carving = "dig.stone";
	//private static final String sawing = "step.gravel";
	private static final String mallet = "minefantasy2:block.carpentermallet";
	private static final String mixing = "step.wood";
	
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(BlockListMF.carpenter), new Object[]{
			"PBP",
			"P P",
			'B', Blocks.crafting_table,
			'P', ComponentListMF.plank,
		});
		addWoodworks();
		addStonemason();
		addCooking();
		addMisc();
		
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.swordTraining), carving, "knife", 1, 40 , new Object[]
		{
			" I  ",
			"SIII",
			" I  ",
			'S', ComponentListMF.plank,
			'I', Blocks.planks,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.waraxeTraining), carving, "knife", 1, 30 , new Object[]
		{
			" II",
			"SSI",
			"  I",
			'S', ComponentListMF.plank,
			'I', Blocks.planks,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.maceTraining), carving, "knife", 1, 35 , new Object[]
		{
			"  II",
			"SSII",
			'S', ComponentListMF.plank,
			'I', Blocks.planks,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.spearTraining), carving, "knife", 1, 20 , new Object[]
		{
			"SSSI",
			'S', ComponentListMF.plank,
			'I', Blocks.planks,
		});
		
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.bandage_crude, 2), sewing, "needle", -1, 10 , new Object[]
		{
			"LLL",
			'L', ComponentListMF.rawhideSmall,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.bandage_crude, 4), sewing, "needle", -1, 20 , new Object[]
		{
			"LLL",
			'L', ComponentListMF.rawhideMedium,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.bandage_crude, 6), sewing, "needle", -1, 30 , new Object[]
		{
			"LLL",
			'L', ComponentListMF.rawhideLarge,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.bandage_wool, 4), sewing, "needle", 1, 10 , new Object[]
		{
			"CCC",
			'C', Blocks.wool,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.bandage_tough), sewing, "needle", 2, 20 , new Object[]
		{
			"L",
			"B",
			'L', Items.leather,
			'B', ToolListMF.bandage_wool
		});
		
		
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.padding), sewing, "needle", 2, 50 , new Object[]
		{
			" L ",
			"FFF",
			" C ",
			'L', Items.leather,
			'F', Items.feather,
			'C', Blocks.wool
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ComponentListMF.fireclay) , new Object[]
		{
			ComponentListMF.kaolinite_dust,
			Items.clay_ball
		});
		GameRegistry.addShapelessRecipe(new ItemStack(ComponentListMF.fireclay_brick) , new Object[]
		{
			ComponentListMF.fireclay
		});
		
		MineFantasyAPI.addCarpenterRecipe(ArmourListMF.armour(ArmourListMF.leather, 2, 0), sewing, "needle", 2, 50 , new Object[]
		{
			" U ",
			"UPU",
			" U ",
			'P', Items.leather_helmet,
			'U', Items.leather
		});
		MineFantasyAPI.addCarpenterRecipe(ArmourListMF.armour(ArmourListMF.leather, 2, 1), sewing, "needle", 2, 80 , new Object[]
		{
			" U ",
			"UPU",
			" U ",
			'P', Items.leather_chestplate,
			'U', Items.leather
		});
		MineFantasyAPI.addCarpenterRecipe(ArmourListMF.armour(ArmourListMF.leather, 2, 2), sewing, "needle", 2, 70 , new Object[]
		{
			" U ",
			"UPU",
			" U ",
			'P', Items.leather_leggings,
			'U', Items.leather
		});
		MineFantasyAPI.addCarpenterRecipe(ArmourListMF.armour(ArmourListMF.leather, 2, 3), sewing, "needle", 2, 40 , new Object[]
		{
			" U ",
			"UPU",
			" U ",
			'P', Items.leather_boots,
			'U', Items.leather
		});
	}

	private static void addWoodworks()
	{
		for(ItemStack planks : OreDictionary.getOres("plankWood"))
		{
			GameRegistry.addRecipe(new ItemStack(ToolListMF.malletWood), new Object[]
			{
				"W",
				"P",
				
				'P', ComponentListMF.plank,
				'W', planks,
			});
		}
		GameRegistry.addRecipe(new ItemStack(ToolListMF.spoonWood), new Object[]
		{
			"W",
			"P",
			
			'W', ComponentListMF.plank,
			'P', Items.stick,
		});
	}
	
	private static void addStonemason()
	{
	}
	
	private static void addCooking()
	{
		String meats = "isMeatCooked";
		OreDictionary.registerOre(meats, Items.cooked_beef);
		OreDictionary.registerOre(meats, Items.cooked_chicken);
		OreDictionary.registerOre(meats, Items.cooked_porkchop);
		OreDictionary.registerOre(meats, FoodListMF.wolf_cooked);
		OreDictionary.registerOre(meats, FoodListMF.horse_cooked);
		OreDictionary.registerOre(meats, Items.cooked_fished);
		OreDictionary.registerOre(meats, new ItemStack(Items.cooked_fished, 1, 1));
		
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.oats), chopping, "knife", -1, 20, new Object[]{
			"M",
			"B",
			'M', Items.wheat,
			'B', Items.bowl
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.breadroll, 4), chopping, "knife", -1, 15, new Object[]{
			"M",
			'M', Items.bread,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.sweetroll_raw), basic, 12, new Object[]{
			" S ",
			"BEB",
			" F ",
			'S', Items.sugar,
			'B', FoodListMF.berries,
			'E', Items.egg,
			'F', FoodListMF.flour,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.icing), mixing, "spoon", -1, 10, new Object[]{
			"S",
			"B",
			'S', Items.sugar,
			'B', Items.bowl,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.sweetroll), basic, "knife", -1, 15, new Object[]{
			"I",
			"R",
			'I', FoodListMF.icing,
			'R', FoodListMF.sweetroll_uniced,
		});
		for(ItemStack food: OreDictionary.getOres(meats))
		{
			MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.stew), chopping, "knife", -1, 15, new Object[]{
				"M",
				"B",
				'M', food,
				'B', Items.bowl
			});
			MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.jerky, 2), chopping, "knife", 2, 20, new Object[]{
				"M",
				'M', food,
			});
			MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.pie_meat_uncooked), chopping, "knife", 2, 150, new Object[]{
				"FFF",
				"MMM",
				"FEF",
				" T ",
				'F', FoodListMF.flour,
				'E', Items.egg,
				'M', food,
				'T', FoodListMF.pie_tray,
			});
			MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.sandwitch_meat), chopping, "knife", 2, 50, new Object[]{
				"B",
				"M",
				"B",
				'M', food,
				'B', FoodListMF.breadroll
			});
			MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.pie_shepard_uncooked), chopping, "knife", 3, 200, new Object[]{
				"PPP",
				"MMM",
				"FEF",
				" T ",
				'P', Items.potato,
				'F', FoodListMF.flour,
				'E', Items.egg,
				'M', food,
				'T', FoodListMF.pie_tray,
			});
		}
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.pie_apple_uncooked), chopping, "knife", 2, 120, new Object[]{
			"FSF",
			"MMM",
			"FEF",
			" T ",
			'F', FoodListMF.flour,
			'E', Items.egg,
			'M', Items.apple,
			'S', Items.sugar,
			'T', FoodListMF.pie_tray,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.pie_berry_uncooked), chopping, "knife", 2, 100, new Object[]{
			"FSF",
			"MMM",
			"FEF",
			" T ",
			'F', FoodListMF.flour,
			'E', Items.egg,
			'M', FoodListMF.berries,
			'S', Items.sugar,
			'T', FoodListMF.pie_tray,
		});
		
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.cake_raw), mixing, "spoon", -1, 20, new Object[]{
			"SMS",
			"SES",
			"FFF",
			" T ",
			'F', FoodListMF.flour,
			'E', Items.egg,
			'M', Items.milk_bucket,
			'S', Items.sugar,
			'T', FoodListMF.cake_tin,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.cake_carrot_raw), mixing, "spoon", -1, 25, new Object[]{
			"SMS",
			"SES",
			"CCC",
			"FTF",
			'C', Items.carrot,
			'F', FoodListMF.flour,
			'E', Items.egg,
			'M', Items.milk_bucket,
			'S', Items.sugar,
			'T', FoodListMF.cake_tin,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.cake_choc_raw), mixing, "spoon", -1, 25, new Object[]{
			"SMS",
			"SES",
			"CCC",
			"FTF",
			'C', new ItemStack(Items.dye, 1, 3),//ItemDye
			'F', FoodListMF.flour,
			'E', Items.egg,
			'M', Items.milk_bucket,
			'S', Items.sugar,
			'T', FoodListMF.cake_tin,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.cake_bf_raw), mixing, "spoon", -1, 30, new Object[]{
			"SMMS",
			"SEES",
			"CBBC",
			"FTFF",
			'B', FoodListMF.berriesJuicy,
			'C', new ItemStack(Items.dye, 1, 3),//ItemDye
			'F', FoodListMF.flour,
			'E', Items.egg,
			'M', Items.milk_bucket,
			'S', Items.sugar,
			'T', FoodListMF.cake_tin,
		});
		
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(BlockListMF.cake_vanilla), basic, "knife", -1, 60, new Object[]{
			"III",
			" R ",
			'I', FoodListMF.icing,
			'R', FoodListMF.cake_uniced,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(BlockListMF.cake_carrot), basic, "knife", -1, 60, new Object[]{
			"III",
			" R ",
			'I', FoodListMF.icing,
			'R', FoodListMF.cake_carrot_uniced,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(BlockListMF.cake_chocolate), basic, "knife", -1, 60, new Object[]{
			"ICI",
			" R ",
			'C', new ItemStack(Items.dye, 1, 3),
			'I', FoodListMF.icing,
			'R', FoodListMF.cake_carrot_uniced,
		});
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(BlockListMF.cake_bf), basic, "knife", -1, 100, new Object[]{
			"BBB",
			"III",
			"CRC",
			'C', new ItemStack(Items.dye, 1, 3),
			'B', FoodListMF.berries,
			'I', FoodListMF.icing,
			'R', FoodListMF.cake_bf_uniced,
		});
		
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.cheese_roll), chopping, "knife", 1, 30, new Object[]{
			"C",
			"R",
			'C', FoodListMF.cheese_slice,
			'R', FoodListMF.breadroll,
		});
		
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(FoodListMF.flour), chopping, 1, new Object[]{
			"C",
			'C', Items.wheat,
		});
	}
	
	private static void addMisc()
	{
		//Fletching
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.fletching, 16), "arrows", chopping, 4, new Object[]
		{
			"PFP",
			'F', Items.feather,
			'P', Items.paper,
		});
		
		for(int id = 0; id < ToolListMF.weaponMats.length; id ++)
		{
			MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.arrows[id]), "arrows", chopping, 1, new Object[]
			{
				"H",
				"S",
				"F",
				'H', ComponentListMF.arrowheads[id],
				'S', Items.stick,
				'F', ComponentListMF.fletching,
			});
		}
		for(int id = 0; id < ToolListMF.weaponMats.length-1; id ++)
		{
			MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.bodkinArrows[id]), "arrowsBodkin", chopping, 1, new Object[]
			{
				"H",
				"S",
				"F",
				'H', ComponentListMF.bodkinheads[id],
				'S', Items.stick,
				'F', ComponentListMF.fletching,
			});
			MineFantasyAPI.addCarpenterRecipe(new ItemStack(ToolListMF.broadArrows[id]), "arrowsBroad", chopping, 1, new Object[]
			{
				"H",
				"S",
				"F",
				'H', ComponentListMF.broadheads[id],
				'S', Items.stick,
				'F', ComponentListMF.fletching,
			});
		}
		
		//BOMBS
		KnowledgeListMF.bombCaseCeramicR = 
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.bomb_casing_uncooked, 2), "bombCeramic", basic, 2, new Object[]
		{
			" C ",
			"C C",
			" C ",
			'C', Items.clay_ball,
		});
		KnowledgeListMF.mineCaseCeramicR = 
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.mine_casing_uncooked), "mineCeramic", basic, 2, new Object[]
		{
			" P ",
			"C C",
			" C ",
			
			'P', Blocks.stone_pressure_plate,
			'C', Items.clay_ball,
		});
		KnowledgeListMF.bombCaseCrystalR = 
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.bomb_casing_crystal), "bombCrystal", basic, 10, new Object[]
		{
			" D ",
			"R R",
			" B ",
			'B', Items.glass_bottle,
			'D', ComponentListMF.diamond_shards,
			'R', Items.redstone
		});
		KnowledgeListMF.mineCaseCrystalR = 
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.mine_casing_crystal), "mineCrystal", basic, 10, new Object[]
		{
			" P ",
			"RDR",
			" B ",
			'P', Blocks.heavy_weighted_pressure_plate,
			'B', Items.glass_bottle,
			'D', ComponentListMF.diamond_shards,
			'R', Items.redstone
		});
		
		KnowledgeListMF.bombFuseR =
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.bomb_fuse, 8), "bombs", basic, 4, new Object[]
		{
			"R",
			"C",
			"S",
			'S', Items.string,
			'C', ComponentListMF.coalDust,
			'R', Items.redstone,
		});
		KnowledgeListMF.longFuseR =
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.bomb_fuse_long), "bombs", basic, 1, new Object[]
		{
			"F",
			"R",
			"F",
			'F', ComponentListMF.bomb_fuse,
			'R', Items.redstone,
		});
		
		KnowledgeListMF.blackpowderRec =
		MineFantasyAPI.addShapelessCarpenterRecipe(new ItemStack(ComponentListMF.blackpowder, 4), "blackpowder", "basic", 2, new Object[]
		{
			new ItemStack(ComponentListMF.coalDust),
			new ItemStack(ComponentListMF.coalDust),
			new ItemStack(ComponentListMF.sulfur),
			new ItemStack(ComponentListMF.nitre),
		});
		KnowledgeListMF.advblackpowderRec =
		MineFantasyAPI.addShapelessCarpenterRecipe(new ItemStack(ComponentListMF.blackpowder_advanced), "advblackpowder", "basic", 2, new Object[]
		{
			new ItemStack(ComponentListMF.blackpowder),
			new ItemStack(Items.redstone),
			new ItemStack(Items.glowstone_dust)
		});
		
		KnowledgeListMF.magmaRefinedR =
		MineFantasyAPI.addCarpenterRecipe(new ItemStack(ComponentListMF.magma_cream_refined, 8), "firebomb", "basic", 5, new Object[]
		{
			"PCP",
			"CDC",
			"PCP",
			'D', ComponentListMF.dragon_heart,
			'C', Items.magma_cream,
			'P', Items.blaze_powder
		});
	}
}
