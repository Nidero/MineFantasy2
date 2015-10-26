package minefantasy.mf2.config;

import minefantasy.mf2.api.knowledge.InformationBase;
import minefantasy.mf2.api.knowledge.ResearchLogic;
import minefantasy.mf2.mechanics.CombatMechanics;

public class ConfigHardcore extends ConfigurationBaseMF
{
	public static final String CATEGORY_CRAFTING = "Hardcore Crafting";
	public static final String CATEGORY_RESEARCH = "Research";
	
	public static final String CATEGORY_FOOD = "Food and Hunting";
	
	public static boolean hunterKnife;
	public static boolean lessHunt;
	
	
	public static final String CATEGORY_MOB = "Monster Upgrades";
	
	public static boolean upgradeZombieWep;
	public static float zombieWepChance;
	public static boolean fastZombies;
	
	public static final String CATEGORY_USER = "Player Debuffs";
	public static boolean critLimp;
	
	@Override
	protected void loadConfig()
	{
		InformationBase.unlockAll = Boolean.parseBoolean(config.get(CATEGORY_RESEARCH, "Unlock entries", false, "If you don't want to research, this will unlock all entries.").getString());
		InformationBase.easyResearch = Boolean.parseBoolean(config.get(CATEGORY_RESEARCH, "Easy Research", false, "This makes entries unlock as soon as their puchased (Removing the research table process).").getString());
		ResearchLogic.knowledgelyr = Integer.parseInt(config.get("###CHANGE RESEARCH ID###", "Research ID", 0, "This changes the research ID, removing all entries").getString());
				
		hunterKnife = Boolean.parseBoolean(config.get(CATEGORY_FOOD, "Restrict to hunting weapon", false, "This option means animals ONLY drop meat and hide when killed with a hunting weapon such as a knife, only the killing blow counts").getString());
		lessHunt = Boolean.parseBoolean(config.get(CATEGORY_FOOD, "Reduce Meat Drops", false, "This will alter the stack size of animal meat drops, meaning they only drop 1 every time").getString());
		
		upgradeZombieWep = Boolean.parseBoolean(config.get(CATEGORY_MOB, "Give Zombie Weapon", true, "Zombies have a chance on spawning with forged iron weapons, It also controls some zombies having MF armour").getString());
		zombieWepChance = Float.parseFloat(config.get(CATEGORY_MOB, "Zombie Weapon Spawn Chance Modifier", 1.0F, "Chance for Zombies to have forged weapons, increased with difficulty").getString());
		fastZombies = Boolean.parseBoolean(config.get(CATEGORY_MOB, "Speed up zombies", true, "Speed up zombies (Sure it's not as real.. but it makes them a bit more dangerous)").getString());
		critLimp = Boolean.parseBoolean(config.get(CATEGORY_MOB, "Critical Injury Limp", true, "This means when you're badly wounded, you slow down and limp").getString());
		CombatMechanics.swordSkeleton = Boolean.parseBoolean(config.get(CATEGORY_MOB, "Skeleton Swords", true, "Skeletons pull out swords when dying in melee").getString());
	}

}
