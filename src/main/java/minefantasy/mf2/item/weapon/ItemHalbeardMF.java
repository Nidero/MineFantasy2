package minefantasy.mf2.item.weapon;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import minefantasy.mf2.MineFantasyII;
import minefantasy.mf2.api.helpers.ArmourCalculator;
import minefantasy.mf2.api.helpers.TacticalManager;
import minefantasy.mf2.item.list.CreativeTabMF;
import minefantasy.mf2.item.tool.ToolMaterialMF;
import mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent;
import mods.battlegear2.api.shield.IShield;
import mods.battlegear2.api.weapons.IExtendedReachWeapon;
import mods.battlegear2.api.weapons.IHitTimeModifier;
import mods.battlegear2.api.weapons.ISpecialEffect;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * @author Anonymous Productions
 */
public class ItemHalbeardMF extends ItemSpearMF
{
	/**
	 * The halbeard is the heavy counterpart for the spear: It has increased damage, knockback distance and parry arc
	 * 
	 * Halbeards use a swinging attack rather than a stab, but will still stab when sprinting
	 */
    public ItemHalbeardMF(String name, ToolMaterial material, int rarity, float weight)
    {
    	super(name, material, rarity, weight);
    	setMaxDamage(getMaxDamage()*2);
    	baseDamage *= 1.5F;
    }

    @Override
	public boolean allowOffhand(ItemStack mainhand, ItemStack offhand) 
    {
		return false;
	}
    
	@Override
	public float getReachModifierInBlocks(ItemStack stack)
	{
		return 2.5F;
	}
	
	@Override
	public boolean playCustomParrySound(EntityLivingBase blocker, Entity attacker, ItemStack weapon) 
	{
		blocker.worldObj.playSoundAtEntity(blocker, "minefantasy2:weapon.wood_parry", 1.0F, 0.7F);
		return true;
	}
	
	@Override
	protected int getParryDamage(float dam) 
	{
		return (int)dam;
	}
	/**
	 * Gets the angle the weapon can parry
	 */
	@Override
	public float getParryAngleModifier(EntityLivingBase user) 
	{
		return user.isSneaking() ? 1.5F: 1.0F;
	}
	@Override
	public float getBalance()
	{
		return 0.8F;
	}
	
	@Override
	protected float getKnockbackStrength() 
	{
		return 3.5F;
	}
	@Override
	public int modifyHitTime(EntityLivingBase user, ItemStack item)
	{
		return super.modifyHitTime(user, item) + speedModSpear;
	}
	/**
	 * gets the time after being hit your guard will be let down
	 */
	@Override
	public int getParryCooldown(DamageSource source, float dam, ItemStack weapon) 
	{
		return spearParryTime + heavyParryTime;
	}
	
	@Override
	protected float getStaminaMod() 
	{
		return heavyStaminaCost*spearStaminaCost;
	}
}
