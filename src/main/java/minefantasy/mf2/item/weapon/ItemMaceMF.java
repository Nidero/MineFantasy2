package minefantasy.mf2.item.weapon;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import minefantasy.mf2.MineFantasyII;
import minefantasy.mf2.api.helpers.ArmourCalculator;
import minefantasy.mf2.api.helpers.TacticalManager;
import minefantasy.mf2.api.weapon.IDamageModifier;
import minefantasy.mf2.item.list.CreativeTabMF;
import minefantasy.mf2.item.tool.ToolMaterialMF;
import mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent;
import mods.battlegear2.api.weapons.IHitTimeModifier;
import mods.battlegear2.api.weapons.IPenetrateWeapon;
import mods.battlegear2.api.weapons.IPotionEffect;
import mods.battlegear2.api.weapons.ISpecialEffect;

/**
 * @author Anonymous Productions
 */
public class ItemMaceMF extends ItemWeaponMF
{
	private float stunChance = 0.20F;
	/**
	 * The mace does the most damage
	 * Maces also have more durability
	 * 
	 * These are for the player who just wants to hit stuff
	 */
    public ItemMaceMF(String name, ToolMaterial material, int rarity, float weight)
    {
        super(material, name, rarity, weight);
		this.setMaxDamage((int) (getMaxDamage()*2F));
    }

	@Override
	protected int getParryDamage(float dam) 
	{
		return (int)(dam*2F);
	}
	
	@Override
	public void onProperHit(EntityLivingBase user, ItemStack weapon, Entity hit, float dam)
	{
		if(!user.worldObj.isRemote && user.getRNG().nextInt(5) == 0)
		{
			if(hit instanceof EntityLivingBase)
			{
				((EntityLivingBase)hit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1));
			}
		}
		super.onProperHit(user, weapon, hit, dam);
	}
	
	@Override
	public float getDigSpeed(ItemStack itemstack, Block block, int metadata)
	{
		return super.getDigSpeed(itemstack, block, metadata)*1.5F;
	}

	@Override
	public boolean playCustomParrySound(EntityLivingBase blocker, Entity attacker, ItemStack weapon) 
	{
		blocker.worldObj.playSoundAtEntity(blocker, "minefantasy2:weapon.wood_parry", 1.0F, 1.0F);
		return true;
	}
	
	protected float getKnockbackStrength() 
	{
		return 1.5F;
	}

	@Override
	public int modifyHitTime(EntityLivingBase user, ItemStack item)
	{
		return super.modifyHitTime(user, item) + speedModMace;
	}
	@Override
	public float getDamageModifier()
	{
		return damageModMace;
	}
	
	@Override
	protected float[] getWeaponRatio(ItemStack implement)
	{
		return maceRatio;
	}
	/**
	 * gets the time after being hit your guard will be let down
	 */
	@Override
	public int getParryCooldown(DamageSource source, float dam, ItemStack weapon) 
	{
		return maceParryTime;
	}
	@Override
	public int getParryModifier(ItemStack weapon, EntityLivingBase user, Entity target)
	{
		return 40;
	}
	@Override
	protected float getStaminaMod() 
	{
		return maceStaminaCost;
	}
}
