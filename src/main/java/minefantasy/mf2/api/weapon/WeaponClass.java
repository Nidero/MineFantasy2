package minefantasy.mf2.api.weapon;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import minefantasy.mf2.api.rpg.Skill;
import minefantasy.mf2.api.rpg.SkillList;

public class WeaponClass 
{
	public static HashMap<String, WeaponClass>classes = new HashMap<String, WeaponClass>();
	
	public static WeaponClass FIST = new WeaponClass("fist", SkillList.unarmed, "blunt");
	
	public static WeaponClass BLADE = new WeaponClass("blade", SkillList.blade, "blunt");
	public static WeaponClass BLUNT = new WeaponClass("blunt", SkillList.blunt, "blade");
	public static WeaponClass AXE = new WeaponClass("axe", SkillList.axe, "blade");
	public static WeaponClass POLEARM = new WeaponClass("polearm", SkillList.polearm, "blade");
	public static WeaponClass EXOTIC = new WeaponClass("exotic", SkillList.exotic, "blade");
	
	public Skill parentSkill;
	public String name;
	public String sound;
	
	public WeaponClass(String name, Skill parent, String sound)
	{
		this.name = name;
		this.parentSkill = parent;
		this.sound = sound;
		classes.put(name, this);
	}
	public String getSound() 
	{
		return sound;
	}
	
	public static WeaponClass getWeaponClass(String name)
	{
		WeaponClass WC = classes.get(name);
		return WC != null ? WC : WeaponClass.EXOTIC;
	}
	public static WeaponClass getWeaponClass(ItemStack weapon)
	{
		if(weapon == null)
		{
			return WeaponClass.FIST;
		}
		if(weapon.getItem() instanceof IWeaponClass)
		{
			return ((IWeaponClass)weapon.getItem()).getWeaponClass();
		}
		return WeaponClass.BLADE;
	}
	
	public static WeaponClass findClassForAny(ItemStack weapon)
	{
		if(weapon == null)return FIST;
		if(weapon.getItem() instanceof IWeaponClass || weapon.getItem() instanceof ItemSword)
		{
			return getWeaponClass(weapon);
		}
		return null;
	}
}