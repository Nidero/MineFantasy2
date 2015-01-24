package minefantasy.mf2.item.list;

import java.awt.Color;

import cpw.mods.fml.common.registry.GameRegistry;
import minefantasy.mf2.MineFantasyII;
import minefantasy.mf2.api.armour.ArmourDesign;
import minefantasy.mf2.api.armour.ArmourMaterialMF;
import minefantasy.mf2.item.FuelHandlerMF;
import minefantasy.mf2.item.ItemComponentMF;
import minefantasy.mf2.item.armour.ItemArmourMF;
import minefantasy.mf2.item.tool.ToolMaterialMF;
import minefantasy.mf2.material.BaseMaterialMF;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.oredict.OreDictionary;
/**
 * @author Anonymous Productions
 */
public class ComponentListMF 
{
	public static final BaseMaterialMF[] ingotMats = new BaseMaterialMF[]
	{
		BaseMaterialMF.copper,
		BaseMaterialMF.tin,
		BaseMaterialMF.bronze,
		BaseMaterialMF.pigiron,
		BaseMaterialMF.steel,
		BaseMaterialMF.encrusted,
		BaseMaterialMF.weakblacksteel,
		BaseMaterialMF.blacksteel,
		BaseMaterialMF.dragonforge,
		BaseMaterialMF.silver,
		BaseMaterialMF.goldPure,
		BaseMaterialMF.weakredsteel,
		BaseMaterialMF.redsteel,
		BaseMaterialMF.weakbluesteel,
		BaseMaterialMF.bluesteel,
		BaseMaterialMF.adamantium,
		BaseMaterialMF.mithril,
		BaseMaterialMF.ignotumite,
		BaseMaterialMF.mithium,
		BaseMaterialMF.enderforge,
	};
	public static final BaseMaterialMF[] hunkMats = new BaseMaterialMF[]
	{
		BaseMaterialMF.copper,
		BaseMaterialMF.tin,
		BaseMaterialMF.bronze,
		BaseMaterialMF.iron,
		BaseMaterialMF.pigiron,
		BaseMaterialMF.steel,
		BaseMaterialMF.encrusted,
		BaseMaterialMF.blacksteel,
		BaseMaterialMF.dragonforge,
		BaseMaterialMF.silver,
		BaseMaterialMF.gold,
		BaseMaterialMF.redsteel,
		BaseMaterialMF.bluesteel,
		BaseMaterialMF.adamantium,
		BaseMaterialMF.mithril,
		BaseMaterialMF.ignotumite,
		BaseMaterialMF.mithium,
		BaseMaterialMF.enderforge,
	};
	
	public static ItemComponentMF[] ingots = new ItemComponentMF[ingotMats.length];
	public static ItemComponentMF[] hunks = new ItemComponentMF[hunkMats.length];
	public static ItemComponentMF[] chainmeshes = new ItemComponentMF[ArmourListMF.mats.length];
	public static ItemComponentMF[] plates = new ItemComponentMF[ArmourListMF.mats.length-1];
	public static Item plank = new ItemComponentMF("plank", 0);
	public static Item vine = new ItemComponentMF("vine", -1);
	public static Item sharp_rock = new ItemComponentMF("sharp_rock", -1);
	public static ItemComponentMF[] arrowheads = new ItemComponentMF[ToolListMF.weaponMats.length];
	
	public static Item flux = new ItemComponentMF("flux", 0);
	public static Item flux_strong = new ItemComponentMF("flux_strong", 0);
	public static Item bloom = new ItemComponentMF("bloom", 0);
	//public static Item iron_dust = new ItemComponentMF("iron_dust", 0);
	//public static Item iron_prep = new ItemComponentMF("iron_prep", 0);
	
	public static Item coalDust = new ItemComponentMF("coalDust", 0);
	public static Item nitre = new ItemComponentMF("nitre", 0);
	public static Item sulfur = new ItemComponentMF("sulfur", 0);
	public static Item blackpowder = new ItemComponentMF("blackpowder", 0);
	public static Item bomb_casing_uncooked = new ItemComponentMF("bomb_casing_uncooked", 0);
	public static Item bomb_casing = new ItemComponentMF("bomb_casing", 0);
	
	public static Item coke = new ItemComponentMF("coke", 0);
	public static Item diamond_shards = new ItemComponentMF("diamond_shards", 0);
	public static Item diamond_dust = new ItemComponentMF("diamond_dust", 0);
	
	public static Item clay_brick = new ItemComponentMF("clay_brick", 0);
	public static Item kaolinite = new ItemComponentMF("kaolinite", 0);
	public static Item kaolinite_dust = new ItemComponentMF("kaolinite_dust", 0);
	public static Item fireclay = new ItemComponentMF("fireclay", 0);
	public static Item fireclay_brick = new ItemComponentMF("fireclay_brick", 0);
	public static Item strong_brick = new ItemComponentMF("strong_brick", 0);
	
	public static Item rawhideSmall = new ItemComponentMF("rawhideSmall", -1);
	public static Item rawhideMedium = new ItemComponentMF("rawhideMedium", -1);
	public static Item rawhideLarge = new ItemComponentMF("rawhideLarge", -1);
	public static Item hideSmall = new ItemComponentMF("hideSmall", 0);
	public static Item hideMedium = new ItemComponentMF("hideMedium", 0);
	public static Item hideLarge = new ItemComponentMF("hideLarge", 0);
	
	public static Item dragon_heart = new ItemComponentMF("dragon_heart", 1);
	
	public static Item padding = new ItemComponentMF("padding", 0);
	
	public static void init() 
	{
		GameRegistry.registerFuelHandler(new FuelHandlerMF());
		OreDictionary.registerOre("ingotIron", Items.iron_ingot);
		Items.potionitem.setMaxStackSize(16);
		Items.iron_ingot.setTextureName("minefantasy2:component/ingotWroughtIron");
		Blocks.iron_block.setBlockTextureName("minefantasy2:metal/iron_block");
		Blocks.iron_bars.setBlockTextureName("minefantasy2:metal/iron_bars");
		for(int a = 0; a < ingotMats.length; a ++)
		{
			BaseMaterialMF mat = ingotMats[a];
			String name = mat.name;
			int rarity = mat.rarity;
			
			ingots[a] = new ItemComponentMF("ingot"+name, rarity);
			OreDictionary.registerOre("ingot"+name, ingots[a]);
			
			if(name.equalsIgnoreCase("PigIron"))
			{
				OreDictionary.registerOre("ingotRefinedIron", ingots[a]);
			}
		}
		
		for(int a = 0; a < hunkMats.length; a ++)
		{
			BaseMaterialMF mat = hunkMats[a];
			String name = mat.name;
			int rarity = mat.rarity;
			
			hunks[a] = new ItemComponentMF("hunk"+name, rarity);
			OreDictionary.registerOre("hunk"+name, hunks[a]);
		}
		
		for(int a = 0; a < ArmourListMF.mats.length; a ++)
		{
			BaseMaterialMF baseMat = ArmourListMF.mats[a];
			
			String name=baseMat.name;
			int rarity = baseMat.rarity;
			
			chainmeshes[a] = new ItemComponentMF("chainmesh"+name, rarity);
			OreDictionary.registerOre("chainmesh"+name, chainmeshes[a]);
			if(a > 0)
			{
				plates[a-1] = new ItemComponentMF("plate"+name, rarity);
				OreDictionary.registerOre("plate"+name, plates[a-1]);
			}
		}
		for(int a = 0; a < ToolListMF.weaponMats.length; a ++)
		{
			BaseMaterialMF mat = ToolListMF.weaponMats[a];
			String name = mat.name.toLowerCase();
			int rarity = mat.rarity;
			
			arrowheads[a] = new ItemComponentMF(name+"_arrow_head", rarity);
			OreDictionary.registerOre(name+"_arrow_head", arrowheads[a]);
		}
	}
}
