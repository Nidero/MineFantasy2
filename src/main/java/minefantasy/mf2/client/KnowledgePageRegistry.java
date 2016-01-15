package minefantasy.mf2.client;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import minefantasy.mf2.api.knowledge.client.*;
import minefantasy.mf2.block.list.BlockListMF;
import minefantasy.mf2.item.food.FoodListMF;
import minefantasy.mf2.item.list.ComponentListMF;
import minefantasy.mf2.knowledge.KnowledgeListMF;
import minefantasy.mf2.recipe.ForgingRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KnowledgePageRegistry
{
	public static void registerPages()
	{
		KnowledgeListMF.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.1"), new EntryPageText("knowledge.gettingStarted.2"));
		KnowledgeListMF.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.carpenter"), new EntryPageRecipeBase(KnowledgeListMF.carpenterRecipe));
		KnowledgeListMF.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.tanning"), new EntryPageRecipeBase(KnowledgeListMF.tannerRecipe), new EntryPageRecipeBase(KnowledgeListMF.stoneKnifeR));
		KnowledgeListMF.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.forging"), new EntryPageText("knowledge.gettingStarted.forging.2"), new EntryPageRecipeBase(KnowledgeListMF.stoneAnvilRecipe), new EntryPageRecipeBase(KnowledgeListMF.forgeRecipe), new EntryPageRecipeBase(KnowledgeListMF.stoneHammerR), new EntryPageRecipeBase(KnowledgeListMF.stoneTongsR), new EntryPageRecipeCarpenter(KnowledgeListMF.dryrocksR), new EntryPageRecipeBase(KnowledgeListMF.apronRecipe));
		KnowledgeListMF.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.3"), new EntryPageRecipeAnvil(KnowledgeListMF.shearsR), new EntryPageText("knowledge.gettingStarted.4"), new EntryPageText("knowledge.gettingStarted.5"), new EntryPageRecipeAnvil(KnowledgeListMF.hammerR), new EntryPageRecipeAnvil(KnowledgeListMF.tongsR), new EntryPageText("knowledge.gettingStarted.6"));
		KnowledgeListMF.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.upgrade"), new EntryPageRecipeBase(KnowledgeListMF.researchTableRecipe), new EntryPageText("knowledge.gettingStarted.7"), new EntryPageText("knowledge.gettingStarted.8"), new EntryPageText("knowledge.gettingStarted.9"));
		KnowledgeListMF.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.10"), new EntryPageRecipeCarpenter(KnowledgeListMF.potRecipe), new EntryPageSmelting(ComponentListMF.clay_pot_uncooked, ComponentListMF.clay_pot), new EntryPageRecipeBase(KnowledgeListMF.pestleR), new EntryPageText("knowledge.gettingStarted.11"), new EntryPageText("knowledge.gettingStarted.12"));
				
		KnowledgeListMF.research.addPages(new EntryPageText("knowledge.research.1"), new EntryPageText("knowledge.research.2"), new EntryPageRecipeBase(KnowledgeListMF.researchTableRecipe), new EntryPageText("knowledge.research.3"));
		KnowledgeListMF.talisman.addPages(new EntryPageText("knowledge.talisman.1"), new EntryPageRecipeAnvil(KnowledgeListMF.talismanRecipe), new EntryPageRecipeBase(KnowledgeListMF.artBookR), new EntryPageRecipeBase(KnowledgeListMF.conBookR), new EntryPageRecipeBase(KnowledgeListMF.proBookR), new EntryPageRecipeBase(KnowledgeListMF.engBookR), new EntryPageRecipeBase(KnowledgeListMF.comBookR), new EntryPageText("knowledge.talisman.2"), new EntryPageRecipeAnvil(KnowledgeListMF.greatTalismanRecipe));
		KnowledgeListMF.stamina.addPages(new EntryPageText("knowledge.stamina.1"), new EntryPageText("knowledge.stamina.2"));
		KnowledgeListMF.combat.addPages(new EntryPageText("knowledge.combat.1"), new EntryPageText("knowledge.combat.2"), new EntryPageText("knowledge.parry.info"), new EntryPageText("knowledge.parry.info2"), new EntryPageText("knowledge.advparry.info"), new EntryPageText("knowledge.poweratt.info"));
		KnowledgeListMF.craftArmourBasic.addPages(new EntryPageText("knowledge.craftArmourBasic.1"), new EntryPageRecipeBase(KnowledgeListMF.hideHelmR), new EntryPageRecipeBase(KnowledgeListMF.hideChestR), new EntryPageRecipeBase(KnowledgeListMF.hideLegsR), new EntryPageRecipeBase(KnowledgeListMF.hideBootsR));
		 KnowledgeListMF.craftArmourBasic.addPages(new EntryPageRecipeCarpenter(KnowledgeListMF.roughHelmetR), new EntryPageRecipeCarpenter(KnowledgeListMF.roughChestR), new EntryPageRecipeCarpenter(KnowledgeListMF.roughLegsR), new EntryPageRecipeCarpenter(KnowledgeListMF.roughBootsR));
		 
		KnowledgeListMF.carpenter.addPages(new EntryPageText("knowledge.carpenter.1"), new EntryPageRecipeBase(KnowledgeListMF.carpenterRecipe));
		
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.1"));
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.plank"), new EntryPageRecipeBase(KnowledgeListMF.plankRecipe), new EntryPageRecipeBase(KnowledgeListMF.stickRecipe));
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.refinedplank"),  new EntryPageRecipeCarpenter(KnowledgeListMF.jugRecipe), new EntryPageSmelting(FoodListMF.jug_uncooked, FoodListMF.jug_empty), new EntryPageRecipeBase(KnowledgeListMF.plantOilR), new EntryPageRecipeBase(KnowledgeListMF.refinedPlankR));
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.flux"), new EntryPageRecipeAnvil(KnowledgeListMF.fluxR));
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.hunks"), new EntryPageRecipeAnvil(KnowledgeListMF.hunkR), new EntryPageRecipeAnvil(KnowledgeListMF.ingotR));
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.nail"), new EntryPageRecipeAnvil(KnowledgeListMF.nailR));
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.rivet"), new EntryPageRecipeAnvil(KnowledgeListMF.rivetR));
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.leatherstrip"), new EntryPageRecipeCarpenter(KnowledgeListMF.lStripsR));
		KnowledgeListMF.commodities.addPages(new EntryPageText("knowledge.commodities.thread"), new EntryPageRecipeCarpenter(KnowledgeListMF.threadR), new EntryPageRecipeCarpenter(KnowledgeListMF.stringR));
		
		KnowledgeListMF.dust.addPages(new EntryPageText("knowledge.dust.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.potRecipe), new EntryPageSmelting(ComponentListMF.clay_pot_uncooked, ComponentListMF.clay_pot), new EntryPageRecipeBase(KnowledgeListMF.pestleR));
		KnowledgeListMF.dust.addPages(new EntryPageRecipeCarpenter(KnowledgeListMF.coalDustR), new EntryPageRecipeCarpenter(KnowledgeListMF.kaoDustR), new EntryPageRecipeCarpenter(KnowledgeListMF.flourRecipe));
		KnowledgeListMF.dust.addPages(new EntryPageText("knowledge.dust.icing"), new EntryPageRecipeBase(KnowledgeListMF.spoonR), new EntryPageRecipeCarpenter(KnowledgeListMF.icingRecipe));
		
		KnowledgeListMF.ores.addPages(new EntryPageText("knowledge.ores.1"));
		KnowledgeListMF.ores.addPages(assembleOreDesc("copper", BlockListMF.oreCopper, ComponentListMF.ingots[0]));
		KnowledgeListMF.ores.addPages(assembleOreDesc("tin", BlockListMF.oreTin, ComponentListMF.ingots[1]));
		KnowledgeListMF.ores.addPages(assembleOreDesc("silver", BlockListMF.oreSilver, ComponentListMF.ingots[8]));
		KnowledgeListMF.ores.addPages(assembleOreDesc("mythic", BlockListMF.oreMythic));
		KnowledgeListMF.ores.addPages(new EntryPageText("knowledge.ores.2"));
		KnowledgeListMF.ores.addPages(assembleOreDesc("clay", BlockListMF.oreClay));
		KnowledgeListMF.ores.addPages(assembleOreDesc("kaolinite", BlockListMF.oreKaolinite));
		KnowledgeListMF.ores.addPages(assembleOreDesc("limestone", BlockListMF.limestone));
		KnowledgeListMF.ores.addPages(assembleOreDesc("borax", BlockListMF.oreBorax));
		KnowledgeListMF.ores.addPages(assembleOreDesc("nitre", BlockListMF.oreNitre));
		KnowledgeListMF.ores.addPages(assembleOreDesc("sulfur", BlockListMF.oreSulfur));
		
		KnowledgeListMF.chimney.addPages(new EntryPageText("knowledge.chimney.1"), new EntryPageText("knowledge.chimney.2"), new EntryPageRecipeCarpenter(KnowledgeListMF.chimneyRecipe), new EntryPageRecipeCarpenter(KnowledgeListMF.wideChimneyRecipe), new EntryPageText("knowledge.chimney.3"), new EntryPageRecipeCarpenter(KnowledgeListMF.extractChimneyRecipe));
		KnowledgeListMF.tanning.addPages(new EntryPageText("knowledge.tanning.1"), new EntryPageRecipeBase(KnowledgeListMF.tannerRecipe), new EntryPageText("knowledge.tanning.2"), new EntryPageText("knowledge.tanning.3"), new EntryPageRecipeCarpenter(KnowledgeListMF.strongRackR));
		
		KnowledgeListMF.crucible.addPages(new EntryPageText("knowledge.crucible.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.crucibleRecipe), new EntryPageText("knowledge.crucible.2"), new EntryPageText("knowledge.crucible.3"));
		KnowledgeListMF.crucible2.addPages(new EntryPageText("knowledge.crucible2.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.kaoDustR), new EntryPageRecipeBase(KnowledgeListMF.fireclayR), new EntryPageRecipeCarpenter(KnowledgeListMF.advCrucibleRecipe));
		
		KnowledgeListMF.smeltCopper.addPages(new EntryPageText("knowledge.smeltCopper.1"), new EntryPageSmelting(new ItemStack(BlockListMF.oreCopper), new ItemStack(ComponentListMF.ingots[0])));
		KnowledgeListMF.smeltBronze.addPages(new EntryPageText("knowledge.smeltBronze.1"), new EntryPageSmelting(new ItemStack(BlockListMF.oreTin), new ItemStack(ComponentListMF.ingots[1])), new EntryPageCrucible(KnowledgeListMF.bronze));
		KnowledgeListMF.smeltIron.addPages(new EntryPageText("knowledge.smeltIron.1"), new EntryPageSmelting(new ItemStack(Blocks.iron_ore), new ItemStack(Items.iron_ingot)));
		KnowledgeListMF.smeltPig.addPages(new EntryPageText("knowledge.smeltPig.1"), new EntryPageRecipeAnvil(KnowledgeListMF.ironPrepR), new EntryPageRecipeAnvil(KnowledgeListMF.ironPrepR2), new EntryPageBlastFurnace(ComponentListMF.iron_prep, ComponentListMF.ingots[3]), new EntryPageText("knowledge.blastfurn.9"));
		KnowledgeListMF.smeltSteel.addPages(new EntryPageText("knowledge.smeltSteel.1"), new EntryPageRecipeAnvil(KnowledgeListMF.steelR), new EntryPageCrucible(KnowledgeListMF.steel));
		KnowledgeListMF.encrusted.addPages(new EntryPageText("knowledge.smeltEncrusted.1"), new EntryPageRecipeAnvil(KnowledgeListMF.diamondR), new EntryPageRecipeAnvil(KnowledgeListMF.encrustedR));
		
		KnowledgeListMF.apron.addPages(new EntryPageText("knowledge.apron.1"), new EntryPageRecipeBase(KnowledgeListMF.apronRecipe));
		KnowledgeListMF.bellows.addPages(new EntryPageText("knowledge.bellows.1"), new EntryPageText("knowledge.bellows.2"), new EntryPageRecipeCarpenter(KnowledgeListMF.bellowsRecipe));
		KnowledgeListMF.trough.addPages(new EntryPageText("knowledge.trough.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.woodTroughRecipe), new EntryPageRecipeCarpenter(KnowledgeListMF.rockTroughRecipe), new EntryPageRecipeCarpenter(KnowledgeListMF.strongwoodTroughRecipe));
		KnowledgeListMF.forge.addPages(new EntryPageText("knowledge.forge.1"), new EntryPageRecipeBase(KnowledgeListMF.forgeRecipe), new EntryPageText("knowledge.forge.2"), new EntryPageText("knowledge.forge.3"));
		KnowledgeListMF.anvil.addPages(new EntryPageText("knowledge.anvil.1"), new EntryPageRecipeBase(KnowledgeListMF.stoneAnvilRecipe), new EntryPageRecipeAnvil(ForgingRecipes.recipeMap.get("anvilCrafting")), new EntryPageText( "knowledge.anvil.2"), new EntryPageImage("textures/gui/knowledge/anvilGuiExample.png", 128, 128, "knowledge.guiSubtitle"), new EntryPageText( "knowledge.anvil.3"), new EntryPageText( "knowledge.anvil.4"), new EntryPageText( "knowledge.anvil.5"));
		KnowledgeListMF.anvil.addPages(new EntryPageText("knowledge.anvil.6"), new EntryPageImage("textures/gui/knowledge/qualityExample.png", 128, 128, "knowledge.guiSubtitle"), new EntryPageText("knowledge.anvil.7"), new EntryPageText("knowledge.anvil.8"));
				
	    KnowledgeListMF.smeltDragonforge.addPages(new EntryPageText("knowledge.smeltDragonforge.1"), new EntryPageText("knowledge.smeltDragonforge.2"));
	   
	    KnowledgeListMF.craftArmourLight.addPages(new EntryPageText("knowledge.craftArmourLight.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.roughHelmetR), new EntryPageRecipeCarpenter(KnowledgeListMF.roughChestR), new EntryPageRecipeCarpenter(KnowledgeListMF.roughLegsR), new EntryPageRecipeCarpenter(KnowledgeListMF.roughBootsR));
	    KnowledgeListMF.craftArmourLight.addPages(new EntryPageRecipeCarpenter(KnowledgeListMF.reHelmetR), new EntryPageRecipeCarpenter(KnowledgeListMF.reChestR), new EntryPageRecipeCarpenter(KnowledgeListMF.reLegsR), new EntryPageRecipeCarpenter(KnowledgeListMF.reBootsR));
	    KnowledgeListMF.craftArmourLight.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.studHelmetR), new EntryPageRecipeAnvil(KnowledgeListMF.studChestR), new EntryPageRecipeAnvil(KnowledgeListMF.studLegsR), new EntryPageRecipeAnvil(KnowledgeListMF.studBootsR));
	    KnowledgeListMF.craftArmourLight.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.scaleHelmR), new EntryPageRecipeAnvil(KnowledgeListMF.scaleChestR), new EntryPageRecipeAnvil(KnowledgeListMF.scaleLegsR), new EntryPageRecipeAnvil(KnowledgeListMF.scaleBootsR));
	    KnowledgeListMF.craftArmourMedium.addPages(new EntryPageText("knowledge.craftArmourMedium.1"), new EntryPageRecipeAnvil(KnowledgeListMF.mailRecipes), new EntryPageRecipeAnvil(KnowledgeListMF.mailHelmetR), new EntryPageRecipeAnvil(KnowledgeListMF.mailChestR), new EntryPageRecipeAnvil(KnowledgeListMF.mailLegsR), new EntryPageRecipeAnvil(KnowledgeListMF.mailBootsR));
	    KnowledgeListMF.craftArmourHeavy.addPages(new EntryPageText("knowledge.craftArmourHeavy.1"), new EntryPageRecipeAnvil(KnowledgeListMF.mailRecipes), new EntryPageRecipeAnvil(KnowledgeListMF.plateRecipes), new EntryPageRecipeCarpenter(KnowledgeListMF.padding), new EntryPageRecipeAnvil(KnowledgeListMF.plateHelmetR), new EntryPageRecipeAnvil(KnowledgeListMF.plateChestR), new EntryPageRecipeAnvil(KnowledgeListMF.plateLegsR), new EntryPageRecipeAnvil(KnowledgeListMF.plateBootsR));
	
	    KnowledgeListMF.blastfurn.addPages(new EntryPageText("knowledge.blastfurn.1"), new EntryPageText("knowledge.blastfurn.2"));
	    KnowledgeListMF.blastfurn.addPages(new EntryPageRecipeCarpenter(KnowledgeListMF.kaoDustR), new EntryPageRecipeBase(KnowledgeListMF.fireclayR), new EntryPageRecipeBase(KnowledgeListMF.fireBrickR), new EntryPageSmelting(new ItemStack(ComponentListMF.fireclay_brick), new ItemStack(ComponentListMF.strong_brick)), new EntryPageRecipeBase(KnowledgeListMF.fireBricksR));
	    KnowledgeListMF.blastfurn.addPages(new EntryPageText("knowledge.blastfurn.3"), new EntryPageRecipeAnvil(KnowledgeListMF.blastChamR), new EntryPageRecipeAnvil(KnowledgeListMF.blastHeatR), new EntryPageText("knowledge.blastfurn.4"), new EntryPageText("knowledge.blastfurn.5"));
	    KnowledgeListMF.blastfurn.addPages(new EntryPageImage("textures/gui/knowledge/blast_example.png", 96, 96, ""));
	    KnowledgeListMF.blastfurn.addPages(new EntryPageText("knowledge.blastfurn.6"), new EntryPageText("knowledge.blastfurn.7"), new EntryPageText("knowledge.blastfurn.8"));
	    
	    KnowledgeListMF.etools.addPages(new EntryPageText("knowledge.etools.1"), new EntryPageRecipeAnvil(KnowledgeListMF.spannerRecipe), new EntryPageRecipeAnvil(KnowledgeListMF.blkspannerR), new EntryPageRecipeAnvil(KnowledgeListMF.eatoolsR));
	    KnowledgeListMF.ecomponents.addPages(new EntryPageText("knowledge.ecomponents.1"), new EntryPageRecipeAnvil(KnowledgeListMF.boltR), new EntryPageText("knowledge.ecomponents.2"), new EntryPageRecipeAnvil(KnowledgeListMF.iframeR), new EntryPageRecipeAnvil(KnowledgeListMF.bgearR), new EntryPageRecipeAnvil(KnowledgeListMF.istrutR), new EntryPageRecipeAnvil(KnowledgeListMF.stubeR));
	    KnowledgeListMF.climber.addPages(new EntryPageText("knowledge.climber.1"), new EntryPageRecipeAnvil(KnowledgeListMF.climbPickbR), new EntryPageText("knowledge.climber.2"));
	    KnowledgeListMF.spyglass.addPages(new EntryPageText("knowledge.spyglass.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.spyglassR));
	    KnowledgeListMF.parachute.addPages(new EntryPageText("knowledge.parachute.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.parachuteR));
	    KnowledgeListMF.syringe.addPages(new EntryPageText("knowledge.syringe.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.syringeR));
	    KnowledgeListMF.engTanner.addPages(new EntryPageText("knowledge.engTanner.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.engTannerR));
	    KnowledgeListMF.advforge.addPages(new EntryPageText("knowledge.advforge.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.advancedForgeR));
	    
	    KnowledgeListMF.blackpowder.addPages(new EntryPageText("knowledge.blackpowder.1"),new EntryPageText("knowledge.blackpowder.2"), new EntryPageRecipeCarpenter(KnowledgeListMF.coalDustR), new EntryPageRecipeCarpenter(KnowledgeListMF.blackpowderRec));
	    KnowledgeListMF.advblackpowder.addPages(new EntryPageText("knowledge.advblackpowder.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.advblackpowderRec));
	    KnowledgeListMF.bombs.addPages(new EntryPageText("knowledge.bombs.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.bombBenchCraft), new EntryPageText("knowledge.bombs.2"), new EntryPageImage("textures/gui/knowledge/bombGuiExample.png", 128, 128, "knowledge.guiSubtitle"), new EntryPageText("knowledge.bombs.3"), new EntryPageText("knowledge.bombs.4"));
	    KnowledgeListMF.bpress.addPages(new EntryPageText("knowledge.bpress.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.bombPressCraft));
	    KnowledgeListMF.bombarrow.addPages(new EntryPageText("knowledge.bombarrow.1"), new EntryPageRecipeAnvil(KnowledgeListMF.bombarrowR));
	    KnowledgeListMF.shrapnel.addPages(new EntryPageText("knowledge.shrapnel.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.shrapnelR));
	    KnowledgeListMF.firebomb.addPages(new EntryPageText("knowledge.firebomb.1"), new EntryPageText("knowledge.firebomb.2"), new EntryPageText("knowledge.firebomb.3"), new EntryPageRecipeCarpenter(KnowledgeListMF.magmaRefinedR));
	    KnowledgeListMF.bombCeramic.addPages(new EntryPageText("knowledge.bombCeramic.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.bombCaseCeramicR), new EntryPageSmelting(ComponentListMF.bomb_casing_uncooked, ComponentListMF.bomb_casing));
	    KnowledgeListMF.bombIron.addPages(new EntryPageText("knowledge.bombIron.1"), new EntryPageRecipeAnvil(KnowledgeListMF.bombCaseIronR));
	    KnowledgeListMF.bombObsidian.addPages(new EntryPageText("knowledge.bombObsidian.1"), new EntryPageRecipeAnvil(KnowledgeListMF.bombCaseObsidianR));
	    KnowledgeListMF.bombCrystal.addPages(new EntryPageText("knowledge.bombCrystal.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.bombCaseCrystalR));
	    
	    KnowledgeListMF.mineCeramic.addPages(new EntryPageText("knowledge.mineCeramic.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.mineCaseCeramicR), new EntryPageSmelting(ComponentListMF.mine_casing_uncooked, ComponentListMF.mine_casing));
	    KnowledgeListMF.mineIron.addPages(new EntryPageText("knowledge.mineIron.1"), new EntryPageRecipeAnvil(KnowledgeListMF.mineCaseIronR));
	    KnowledgeListMF.mineObsidian.addPages(new EntryPageText("knowledge.mineObsidian.1"), new EntryPageRecipeAnvil(KnowledgeListMF.mineCaseObsidianR));
	    KnowledgeListMF.mineCrystal.addPages(new EntryPageText("knowledge.mineCrystal.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.mineCaseCrystalR));
	    
	    KnowledgeListMF.bombFuse.addPages(new EntryPageText("knowledge.bombFuse.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.bombFuseR), new EntryPageText("knowledge.bombFuse.2"), new EntryPageRecipeCarpenter(KnowledgeListMF.longFuseR));
	    
	    KnowledgeListMF.stickybomb.addPages(new EntryPageText("knowledge.stickybomb.1"), new EntryPageText("knowledge.stickybomb.2"));
	    
	    KnowledgeListMF.craftOrnateWeapons.addPages(new EntryPageText("knowledge.craftOrnateWeapons.1"));
	    
	    KnowledgeListMF.repair_basic.addPages(new EntryPageText("knowledge.repair_basic.1"), new EntryPageText("knowledge.repair_basic.2"), new EntryPageRecipeCarpenter(KnowledgeListMF.repairBasicR));
	    KnowledgeListMF.repair_advanced.addPages(new EntryPageText("knowledge.repair_advanced.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.repairAdvancedR));
	    KnowledgeListMF.repair_ornate.addPages(new EntryPageText("knowledge.repair_ornate.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.repairOrnateR));
	    
	    KnowledgeListMF.refined_planks.addPages(new EntryPageText("knowledge.refined_planks.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.refinedPlankBlockR));
	    KnowledgeListMF.reinforced_stone.addPages(new EntryPageText("knowledge.reinforced_stone.1"), new EntryPageCrucible(KnowledgeListMF.reStone), new EntryPageText("knowledge.reinforced_stone.2"), new EntryPageRecipeAnvil(KnowledgeListMF.framedStoneR));
	    KnowledgeListMF.brickworks.addPages(new EntryPageText("knowledge.brickworks.1"), new EntryPageRecipeBase(KnowledgeListMF.stoneBricksR));
	    KnowledgeListMF.clay_wall.addPages(new EntryPageText("knowledge.clay_wall.1"), new EntryPageRecipeBase(KnowledgeListMF.clayWallR));
	    KnowledgeListMF.glass.addPages(new EntryPageText("knowledge.glass.1"), new EntryPageRecipeBase(KnowledgeListMF.framedGlassR), new EntryPageRecipeBase(KnowledgeListMF.windowR));
	    KnowledgeListMF.thatch.addPages(new EntryPageText("knowledge.thatch.1"), new EntryPageRecipeBase(KnowledgeListMF.thatchR));
	    KnowledgeListMF.bars.addPages(new EntryPageText("knowledge.bars.1"), new EntryPageRecipeAnvil(KnowledgeListMF.barsR));
	    
	    
	    for(int a = 0; a < KnowledgeListMF.ornateWepsR.size(); a++)
	    {
	    	KnowledgeListMF.craftOrnateWeapons.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.ornateWepsR.get(a)));
	    }
	    KnowledgeListMF.craftAdvOrnateWeapons.addPages(new EntryPageText("knowledge.craftAdvOrnateWeapons.1"));
	    for(int a = 0; a < KnowledgeListMF.advOrnateWepsR.size(); a++)
	    {
	    	KnowledgeListMF.craftAdvOrnateWeapons.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.advOrnateWepsR.get(a)));
	    }
	    
	    KnowledgeListMF.craftTools.addPages(new EntryPageText("knowledge.craftTools.1"));
	    KnowledgeListMF.craftTools.addPages(new EntryPageText("knowledge.craftTools.pick"));
	    KnowledgeListMF.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.pickR));
	    KnowledgeListMF.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.axeR));
	    KnowledgeListMF.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.spadeR));
	    KnowledgeListMF.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.hoeR));
	    KnowledgeListMF.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.shearsR));
	    
	    KnowledgeListMF.craftAdvTools.addPages(new EntryPageText("knowledge.craftAdvTools.1"));
	    KnowledgeListMF.craftAdvTools.addPages(new EntryPageText("knowledge.handpick.info"), new EntryPageRecipeAnvil(KnowledgeListMF.handpickR));
	    KnowledgeListMF.craftAdvTools.addPages(new EntryPageText("knowledge.hvypick.info"), new EntryPageRecipeAnvil(KnowledgeListMF.hvyPickR));
	    KnowledgeListMF.craftAdvTools.addPages(new EntryPageText("knowledge.trow.info"), new EntryPageRecipeAnvil(KnowledgeListMF.trowR));
	    KnowledgeListMF.craftAdvTools.addPages(new EntryPageText("knowledge.hvyshovel.info"), new EntryPageRecipeAnvil(KnowledgeListMF.hvyShovelR));
	    KnowledgeListMF.craftAdvTools.addPages(new EntryPageText("knowledge.scythe.info"), new EntryPageRecipeAnvil(KnowledgeListMF.scytheR));
	    KnowledgeListMF.craftAdvTools.addPages(new EntryPageText("knowledge.mattock.info"));
	    
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.craftCrafters.1"));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.dryrocks.info"), new EntryPageRecipeCarpenter(KnowledgeListMF.dryrocksR));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.hammer.info"), new EntryPageRecipeBase(KnowledgeListMF.stoneHammerR), new EntryPageRecipeAnvil(KnowledgeListMF.hammerR));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.hvyhammer.info"), new EntryPageRecipeAnvil(KnowledgeListMF.hvyHammerR));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.tongs.info"), new EntryPageRecipeBase(KnowledgeListMF.stoneTongsR), new EntryPageRecipeAnvil(KnowledgeListMF.tongsR));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.knife.info"), new EntryPageRecipeBase(KnowledgeListMF.stoneKnifeR), new EntryPageRecipeAnvil(KnowledgeListMF.knifeR));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.saw.info"), new EntryPageRecipeAnvil(KnowledgeListMF.sawsR));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.needle.info"), new EntryPageRecipeBase(KnowledgeListMF.boneNeedleR), new EntryPageRecipeAnvil(KnowledgeListMF.needleR));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.mallet.info"), new EntryPageRecipeBase(KnowledgeListMF.malletR));
	    KnowledgeListMF.craftCrafters.addPages(new EntryPageText("knowledge.spoon.info"), new EntryPageRecipeBase(KnowledgeListMF.spoonR));
	    
	    KnowledgeListMF.craftWeapons.addPages(new EntryPageText("knowledge.craftWeapons.1"));
	    KnowledgeListMF.craftWeapons.addPages(new EntryPageText("knowledge.dagger.info"), new EntryPageRecipeAnvil(KnowledgeListMF.daggerR));
	    KnowledgeListMF.craftWeapons.addPages(new EntryPageText("knowledge.sword.info"), new EntryPageRecipeAnvil(KnowledgeListMF.swordR));
	    KnowledgeListMF.craftWeapons.addPages(new EntryPageText("knowledge.waraxe.info"), new EntryPageRecipeAnvil(KnowledgeListMF.waraxeR));
	    KnowledgeListMF.craftWeapons.addPages(new EntryPageText("knowledge.mace.info"), new EntryPageRecipeAnvil(KnowledgeListMF.maceR));
	    KnowledgeListMF.craftWeapons.addPages(new EntryPageText("knowledge.spear.info"), new EntryPageRecipeAnvil(KnowledgeListMF.spearR));
	    KnowledgeListMF.craftWeapons.addPages(new EntryPageText("knowledge.bow.info"), new EntryPageRecipeAnvil(KnowledgeListMF.bowR));
	    
	    KnowledgeListMF.craftAdvWeapons.addPages(new EntryPageText("knowledge.craftAdvWeapons.1"));
	    KnowledgeListMF.craftAdvWeapons.addPages(new EntryPageText("knowledge.katana.info"), new EntryPageRecipeAnvil(KnowledgeListMF.katanaR));
	    KnowledgeListMF.craftAdvWeapons.addPages(new EntryPageText("knowledge.greatsword.info"), new EntryPageRecipeAnvil(KnowledgeListMF.gswordR));
	    KnowledgeListMF.craftAdvWeapons.addPages(new EntryPageText("knowledge.battleaxe.info"), new EntryPageRecipeAnvil(KnowledgeListMF.battleaxeR));
	    KnowledgeListMF.craftAdvWeapons.addPages(new EntryPageText("knowledge.warhammer.info"), new EntryPageRecipeAnvil(KnowledgeListMF.whammerR));
	    KnowledgeListMF.craftAdvWeapons.addPages(new EntryPageText("knowledge.halbeard.info"), new EntryPageRecipeAnvil(KnowledgeListMF.halbeardR));
	    KnowledgeListMF.craftAdvWeapons.addPages(new EntryPageText("knowledge.lance.info"), new EntryPageRecipeAnvil(KnowledgeListMF.lanceR));
	    
	    KnowledgeListMF.arrows.addPages(new EntryPageText("knowledge.arrows.1"));
	    KnowledgeListMF.arrows.addPages(new EntryPageRecipeCarpenter(KnowledgeListMF.fletchingR));
	    KnowledgeListMF.arrows.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.arrowheadR));
	    KnowledgeListMF.arrows.addPages(new EntryPageRecipeCarpenter(KnowledgeListMF.arrowR));
	    KnowledgeListMF.arrowsBodkin.addPages(new EntryPageText("knowledge.arrowsBodkin.1"));
	    KnowledgeListMF.arrowsBodkin.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.bodkinheadR));
	    KnowledgeListMF.arrowsBroad.addPages(new EntryPageText("knowledge.arrowsBroad.1"));
	    KnowledgeListMF.arrowsBroad.addPages(new EntryPageRecipeAnvil(KnowledgeListMF.broadheadR));
	    
	    KnowledgeListMF.smeltBlackSteel.addPages(new EntryPageText("knowledge.smeltBlackSteel.1"), new EntryPageCrucible(KnowledgeListMF.black), new EntryPageBlastFurnace(ComponentListMF.ingots[6], ComponentListMF.ingots[7]));
	    KnowledgeListMF.smeltRedSteel.addPages(new EntryPageText("knowledge.smeltRedSteel.1"), new EntryPageCrucible(KnowledgeListMF.red), new EntryPageBlastFurnace(ComponentListMF.ingots[9], ComponentListMF.ingots[10]));
	    KnowledgeListMF.smeltBlueSteel.addPages(new EntryPageText("knowledge.smeltBlueSteel.1"), new EntryPageCrucible(KnowledgeListMF.blue), new EntryPageBlastFurnace(ComponentListMF.ingots[11], ComponentListMF.ingots[12]));
	    KnowledgeListMF.smeltAdamant.addPages(new EntryPageText("knowledge.smeltAdamantium.1"), new EntryPageCrucible(KnowledgeListMF.adamantium));
	    KnowledgeListMF.smeltMithril.addPages(new EntryPageText("knowledge.smeltMithril.1"), new EntryPageCrucible(KnowledgeListMF.mithril));
	    
	    KnowledgeListMF.smeltMaster.addPages(new EntryPageText("knowledge.smeltMaster.1"), new EntryPageText("knowledge.smeltMaster.2"), new EntryPageText("knowledge.smeltMaster.3"));
	    KnowledgeListMF.smeltIgnotumite.addPages(new EntryPageText("knowledge.smeltIgnotumite.1"), new EntryPageCrucible(KnowledgeListMF.ignotumite), new EntryPageText("knowledge.masterHaft"), new EntryPageRecipeAnvil(KnowledgeListMF.haftGold), new EntryPageText("knowledge.masterArmour"), new EntryPageRecipeAnvil(KnowledgeListMF.mailIgno), new EntryPageRecipeAnvil(KnowledgeListMF.plateIgno));
	    KnowledgeListMF.smeltMithium.addPages(new EntryPageText("knowledge.smeltMithium.1"), new EntryPageCrucible(KnowledgeListMF.mithium), new EntryPageText("knowledge.masterHaft"), new EntryPageRecipeAnvil(KnowledgeListMF.haftSilver), new EntryPageText("knowledge.masterArmour"), new EntryPageRecipeAnvil(KnowledgeListMF.mailMithi), new EntryPageRecipeAnvil(KnowledgeListMF.plateMithi));
	    KnowledgeListMF.smeltEnderforge.addPages(new EntryPageText("knowledge.smeltEnderforge.1"), new EntryPageCrucible(KnowledgeListMF.enderforge), new EntryPageText("knowledge.masterHaft"), new EntryPageRecipeAnvil(KnowledgeListMF.haftObsidian), new EntryPageText("knowledge.masterArmour"), new EntryPageRecipeAnvil(KnowledgeListMF.mailEnder), new EntryPageRecipeAnvil(KnowledgeListMF.plateEnder));
	    
	    KnowledgeListMF.cookingutensil.addPages(new EntryPageText("knowledge.cookingutensil.1"), new EntryPageRecipeBase(KnowledgeListMF.caketinRecipe), new EntryPageRecipeBase(KnowledgeListMF.pietrayRecipe));
	    KnowledgeListMF.salt.addPages(new EntryPageText("knowledge.salt.1"), new EntryPageSmelting(new ItemStack(FoodListMF.bowl_water_salt), new ItemStack(FoodListMF.salt)));
	    KnowledgeListMF.jug.addPages(new EntryPageText("knowledge.jug.1"),  new EntryPageRecipeCarpenter(KnowledgeListMF.jugRecipe), new EntryPageSmelting(FoodListMF.jug_uncooked, FoodListMF.jug_empty), new EntryPageText("knowledge.jug.2"), new EntryPageRecipeBase(KnowledgeListMF.waterJugR), new EntryPageRecipeBase(KnowledgeListMF.milkJugR));
	    
	    KnowledgeListMF.generic_meat.addPages(new EntryPageText("knowledge.generic_meat.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.meatRecipes), new EntryPageRecipeCarpenter(KnowledgeListMF.meatStripR), new EntryPageRecipeCarpenter(KnowledgeListMF.meatHunkR), new EntryPageRecipeCarpenter(KnowledgeListMF.minceR));
	    KnowledgeListMF.stew.addPages(new EntryPageText("knowledge.stew.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.stewRecipe));
	    KnowledgeListMF.jerky.addPages(new EntryPageText("knowledge.jerky.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.jerkyRecipe));
	    KnowledgeListMF.saussage.addPages(new EntryPageText("knowledge.saussage.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.gutsRecipe), new EntryPageRecipeCarpenter(KnowledgeListMF.bcrumbsR), new EntryPageRecipeCarpenter(KnowledgeListMF.bcrumbsR2), new EntryPageRecipeCarpenter(KnowledgeListMF.saussageR), new EntryPageSmelting(new ItemStack(FoodListMF.saussage_raw), new ItemStack(FoodListMF.saussage_cooked)));
	    KnowledgeListMF.sandwitch.addPages(new EntryPageText("knowledge.sandwitch.1"),  new EntryPageRecipeCarpenter(KnowledgeListMF.breadSliceR), new EntryPageRecipeCarpenter(KnowledgeListMF.sandwitchRecipe));
	    KnowledgeListMF.sandwitchBig.addPages(new EntryPageText("knowledge.sandwitchBig.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.sandwitchBigRecipe));
	    KnowledgeListMF.meatpie.addPages(new EntryPageText("knowledge.meatpie.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.meatPieRecipe), new EntryPageSmelting(new ItemStack(FoodListMF.pie_meat_uncooked), new ItemStack(BlockListMF.pie_meat)), new EntryPageRecipeBase(KnowledgeListMF.meatpieOut));
	    KnowledgeListMF.shepardpie.addPages(new EntryPageText("knowledge.shepardpie.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.shepardRecipe), new EntryPageSmelting(new ItemStack(FoodListMF.pie_shepard_uncooked), new ItemStack(BlockListMF.pie_shepards)), new EntryPageRecipeBase(KnowledgeListMF.shepardOut));
	    
	    KnowledgeListMF.bread.addPages(new EntryPageText("knowledge.bread.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.flourRecipe), new EntryPageRecipeCarpenter(KnowledgeListMF.doughRecipe), new EntryPageSmelting(new ItemStack(FoodListMF.dough), new ItemStack(FoodListMF.breadroll)), new EntryPageRecipeCarpenter(KnowledgeListMF.breadRecipe), new EntryPageSmelting(new ItemStack(FoodListMF.raw_bread), new ItemStack(Items.bread)), new EntryPageRecipeCarpenter(KnowledgeListMF.pastryRecipe), new EntryPageRecipeCarpenter(KnowledgeListMF.bcrumbsR), new EntryPageRecipeCarpenter(KnowledgeListMF.bcrumbsR2));
	    KnowledgeListMF.oats.addPages(new EntryPageText("knowledge.oats.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.oatsRecipe));
	    
	    KnowledgeListMF.berry.addPages(assembleImgPage("berry", BlockListMF.berryBush));
	    KnowledgeListMF.icing.addPages(new EntryPageText("knowledge.icing.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.sugarGrindR), new EntryPageRecipeBase(KnowledgeListMF.sugarRecipe), new EntryPageText("knowledge.icing.2"), new EntryPageRecipeCarpenter(KnowledgeListMF.icingRecipe));
	    KnowledgeListMF.sweetroll.addPages(new EntryPageText("knowledge.sweetroll.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.sweetrollRecipe), new EntryPageSmelting(new ItemStack(FoodListMF.sweetroll_raw), new ItemStack(FoodListMF.sweetroll_uniced)), new EntryPageRecipeCarpenter(KnowledgeListMF.iceSR));
	    KnowledgeListMF.cake.addPages(new EntryPageText("knowledge.cake.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.cakeR), new EntryPageSmelting(new ItemStack(FoodListMF.cake_raw), new ItemStack(FoodListMF.cake_uniced)), new EntryPageRecipeCarpenter(KnowledgeListMF.cakeI));
	    KnowledgeListMF.carrotcake.addPages(new EntryPageText("knowledge.carrotcake.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.carrotCakeR), new EntryPageSmelting(new ItemStack(FoodListMF.cake_carrot_raw), new ItemStack(FoodListMF.cake_carrot_uniced)), new EntryPageRecipeCarpenter(KnowledgeListMF.carrotCakeI));
	    KnowledgeListMF.chococake.addPages(new EntryPageText("knowledge.chococake.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.chocoCakeR), new EntryPageSmelting(new ItemStack(FoodListMF.cake_choc_raw), new ItemStack(FoodListMF.cake_choc_uniced)), new EntryPageRecipeCarpenter(KnowledgeListMF.chocoCakeI));
	    KnowledgeListMF.bfcake.addPages(new EntryPageText("knowledge.bfcake.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.bfCakeR), new EntryPageSmelting(new ItemStack(FoodListMF.cake_bf_raw), new ItemStack(FoodListMF.cake_bf_uniced)), new EntryPageRecipeCarpenter(KnowledgeListMF.bfCakeI));
	    KnowledgeListMF.berrypie.addPages(new EntryPageText("knowledge.berrypie.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.berryR), new EntryPageSmelting(new ItemStack(FoodListMF.pie_berry_uncooked), new ItemStack(BlockListMF.pie_berry)), new EntryPageRecipeBase(KnowledgeListMF.berryOut));
	    KnowledgeListMF.applepie.addPages(new EntryPageText("knowledge.applepie.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.appleR), new EntryPageSmelting(new ItemStack(FoodListMF.pie_apple_uncooked), new ItemStack(BlockListMF.pie_apple)), new EntryPageRecipeBase(KnowledgeListMF.appleOut));
	    KnowledgeListMF.eclair.addPages(new EntryPageText("knowledge.eclair.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.eclairDoughR), new EntryPageSmelting(new ItemStack(FoodListMF.eclair_raw), new ItemStack(FoodListMF.eclair_uniced)), new EntryPageRecipeCarpenter(KnowledgeListMF.eclairIceR), new EntryPageRecipeCarpenter(KnowledgeListMF.custardRecipe), new EntryPageRecipeCarpenter(KnowledgeListMF.eclairFillR));
	    
	    KnowledgeListMF.cheese.addPages(new EntryPageText("knowledge.cheese.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.curdRecipe), new EntryPageSmelting(new ItemStack(FoodListMF.curds), new ItemStack(BlockListMF.cheese_wheel)));
	    KnowledgeListMF.cheeseroll.addPages(new EntryPageText("knowledge.cheeseroll.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.cheeserollR));
	    
	    KnowledgeListMF.bandage.addPages(new EntryPageText("knowledge.bandage.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.badBandageR), new EntryPageRecipeCarpenter(KnowledgeListMF.bandageR));
	    KnowledgeListMF.bandageadv.addPages(new EntryPageText("knowledge.bandageadv.1"), new EntryPageRecipeCarpenter(KnowledgeListMF.goodBandageR));
	
	    //MASTERY
	    KnowledgeListMF.toughness.addPages(new EntryPageText("knowledge.toughness.1"));
	    KnowledgeListMF.fitness.addPages(new EntryPageText("knowledge.fitness.1"));
	    KnowledgeListMF.armourpro.addPages(new EntryPageText("knowledge.armourpro.1"));
	    KnowledgeListMF.parrypro.addPages(new EntryPageText("knowledge.parrypro.1"));
	    KnowledgeListMF.counteratt.addPages(new EntryPageText("knowledge.counteratt.1"), new EntryPageText("knowledge.counteratt.2"));
	    KnowledgeListMF.autoparry.addPages(new EntryPageText("knowledge.autoparry.1"));
	    KnowledgeListMF.firstaid.addPages(new EntryPageText("knowledge.firstaid.1"));
	    KnowledgeListMF.doctor.addPages(new EntryPageText("knowledge.doctor.1"));
	}
	
	private static EntryPage[] assembleOreDesc(String orename, Block ore, Item ingot)
	{
		return new EntryPage[]{new EntryPageImage("textures/gui/knowledge/image/"+orename+".png", 96, 96, ore.getUnlocalizedName()+".name"), new EntryPageText("knowledge.ores."+orename), new EntryPageSmelting(new ItemStack(ore), new ItemStack(ingot))};
	}
	private static EntryPage[] assembleOreDesc(String orename, Block ore)
	{
		return new EntryPage[]{new EntryPageImage("textures/gui/knowledge/image/"+orename+".png", 96, 96, ore.getUnlocalizedName()+".name"), new EntryPageText("knowledge.minerals."+orename)};
	}
	private static EntryPage[] assembleImgPage(String name, Block blockname)
	{
		return new EntryPage[]{new EntryPageImage("textures/gui/knowledge/image/"+name+".png", 96, 96, blockname.getUnlocalizedName()+".name"), new EntryPageText("knowledge."+name+".1")};
	}
}
