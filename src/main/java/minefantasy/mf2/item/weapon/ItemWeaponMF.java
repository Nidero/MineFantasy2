package minefantasy.mf2.item.weapon;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import minefantasy.mf2.MineFantasyII;
import minefantasy.mf2.api.helpers.ArmourCalculator;
import minefantasy.mf2.api.helpers.TacticalManager;
import minefantasy.mf2.api.helpers.ToolHelper;
import minefantasy.mf2.api.stamina.IHeldStaminaItem;
import minefantasy.mf2.api.stamina.IStaminaWeapon;
import minefantasy.mf2.api.stamina.StaminaBar;
import minefantasy.mf2.api.tier.IToolMaterial;
import minefantasy.mf2.api.weapon.*;
import minefantasy.mf2.config.ConfigStamina;
import minefantasy.mf2.config.ConfigWeapon;
import minefantasy.mf2.item.list.ComponentListMF;
import minefantasy.mf2.item.list.CreativeTabMF;
import minefantasy.mf2.item.list.ToolListMF;
import minefantasy.mf2.item.tool.ToolMaterialMF;
import minefantasy.mf2.item.tool.crafting.ItemKnifeMF;
import minefantasy.mf2.mechanics.CombatMechanics;
import minefantasy.mf2.mechanics.StaminaMechanics;
import mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent;
import mods.battlegear2.api.weapons.IBackStabbable;
import mods.battlegear2.api.weapons.IBattlegearWeapon;
import mods.battlegear2.api.weapons.IExtendedReachWeapon;
import mods.battlegear2.api.weapons.IHitTimeModifier;
import mods.battlegear2.api.weapons.IPenetrateWeapon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

//Made this extend the sword class (allows them to be enchanted)
public abstract class ItemWeaponMF extends ItemSword implements IPowerAttack, IDamageType, IKnockbackWeapon, IWeaponSpeed, IHeldStaminaItem, IStaminaWeapon, IBattlegearWeapon, IToolMaterial, IWeightedWeapon, IParryable, ISpecialEffect, IDamageModifier
{
    public static final DecimalFormat decimal_format = new DecimalFormat("#.#");

    protected final ToolMaterial material;
	protected String name;
	protected float baseDamage;
	protected Random rand = new Random();
	
	
	protected float jumpEvade_cost = 30;
	protected float evade_cost = 10;
	
	protected float lunge_cost = 25;
	protected float charge_cost = 10;
	protected float jump_cost = 2;
	
	protected float cleave_cost = 40;
	
	/**
	 * The base file for Weapons in MineFantasy
	 * 
	 * Size Varients, (Normal and Heavy)
	 * Normal weapons are as is, regular damage and weight
	 * Heavy weapons do more damage, exhaust more and have balance offset (+50% dam)
	 * 
	 * Weapon Types:
	 * Blade: Parry Defensive, average damage and speed
	 * Axe: Brutal Offensive, slower than sword, more damage
	 * Blunt: Simple Offensive, slower than axe, more damage
	 * Polearm: Ranged Versitile
	 * Lightblade: Fast Offensive
	 */
	public ItemWeaponMF(ToolMaterial material, String named, int rarity, float weight) 
	{
		super(material);
		materialWeight = weight;
		itemRarity = rarity;
		//May be unsafe, but will allow others to add weapons using custom materials (also more efficent)
		name = named;
		this.material = material;
		setCreativeTab(CreativeTabMF.tabWeapon);
        setTextureName("minefantasy2:Weapon/"+name);
		GameRegistry.registerItem(this, name, MineFantasyII.MODID);
		this.setUnlocalizedName(name);
		
		this.baseDamage = 4 + material.getDamageVsEntity() + getDamageModifier();
		
		if(material == ToolMaterialMF.TRAINING)
		{
			baseDamage = 0F;
		}
	}
	
	/**
	 * Gets the amount more damaged added to each item
	 */
	public float getDamageModifier()
	{
		return 0;
	}
	
	/**
	 * Determines if the item can block/parry
	 */
	public boolean canBlock() 
	{
		return true;
	}
	/**
	 * Determines if the weapon can parry
	 */
	public boolean canWeaponParry() 
	{
		return true;
	}
	/**
	 * Gets the angle the weapon can parry
	 */
	public float getParryAngleModifier(EntityLivingBase user) 
	{
		return 0.75F;
	}
	/**
	 * Gets the multiplier for the parry threshold
	 * @return
	 */
	public float getParryDamageModifier(EntityLivingBase user) 
	{
		return 1.0F;
	}
	/**
	 * Determines if the weapon can do those cool ninja evades
	 * @return
	 */
	public boolean canWeaponEvade() 
	{
		return true;
	}
	
	//MECHANICS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@Override
	public ToolMaterial getMaterial() 
	{
		return this.material;
	}
	
	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap map = HashMultimap.create();
		map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.baseDamage, 0));

        return map;
    }

    @Override
    public void addInformation(ItemStack weapon, EntityPlayer user, List list, boolean extra) 
    {
        super.addInformation(weapon, user, list, extra);
        
        if(material == ToolMaterialMF.TRAINING)
        {
        	return;
        }
        
        if(this instanceof IExtendedReachWeapon || this instanceof IPenetrateWeapon || this instanceof IHitTimeModifier){
            list.add("");

            if(this instanceof IPenetrateWeapon)
            {
                list.add(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocalFormatted("attribute.modifier.plus."+ 1, decimal_format.format(getAPDamText()), StatCollector.translateToLocal("attribute.weapon.penetrateArmor")));
            }

            if(this instanceof IExtendedReachWeapon){
                float reach = ((IExtendedReachWeapon)this).getReachModifierInBlocks(weapon);

                if(reach > 0){
                    list.add(EnumChatFormatting.DARK_GREEN+
                            StatCollector.translateToLocalFormatted("attribute.modifier.plus."+ 0,
                                    decimal_format.format(reach),
                                            StatCollector.translateToLocal("attribute.weapon.extendedReach")));
                }else{
                    list.add(EnumChatFormatting.RED+
                            StatCollector.translateToLocalFormatted("attribute.modifier.take."+ 0,
                                    decimal_format.format(-1 * reach),
                                            StatCollector.translateToLocal("attribute.weapon.extendedReach")));
                }
            }

            if(this instanceof IHitTimeModifier){
                int hitMod = ((IHitTimeModifier)this).getHitTime(weapon, null);
                if(hitMod > 0){
                    list.add(EnumChatFormatting.RED+
                            StatCollector.translateToLocalFormatted("attribute.modifier.take."+ 1,
                                    decimal_format.format((float)hitMod / 10F * 100),
                                            StatCollector.translateToLocal("attribute.weapon.attackSpeed")));
                }else{
                    list.add(EnumChatFormatting.DARK_GREEN+
                            StatCollector.translateToLocalFormatted("attribute.modifier.plus."+ 1,
                                    decimal_format.format(-(float)hitMod / 10F * 100),
                                            StatCollector.translateToLocal("attribute.weapon.attackSpeed")));
                }
            }

            if(this instanceof IBackStabbable){
                list.add(EnumChatFormatting.GOLD+
                        StatCollector.translateToLocal("attribute.weapon.backstab"));

            }
        }
    }
    
    protected float getAPDamText()
    {
		return 0F;
	}

	@Override
	public boolean sheatheOnBack(ItemStack item)
	{
		return false;
	}

	@Override
	public boolean isOffhandHandDual(ItemStack off)
	{
		return true;
	}

	@Override
	public boolean offhandAttackEntity(OffhandAttackEvent event, ItemStack mainhandItem, ItemStack offhandItem) 
	{
		return true;
	}

	@Override
	public boolean offhandClickAir(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem) 
	{
		return true;
	}

	@Override
	public boolean offhandClickBlock(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem) 
	{
		return true;
	}

	@Override
	public void performPassiveEffects(Side effectiveSide, ItemStack mainhandItem, ItemStack offhandItem)
	{
	}

	@Override
	public boolean allowOffhand(ItemStack mainhand, ItemStack offhand)
	{
		return true;
	}
	protected int itemRarity;

    @Override
	public EnumRarity getRarity(ItemStack item)
	{
		int lvl = itemRarity+1;
		
		if(item.isItemEnchanted())
		{
			if(lvl == 0)
			{
				lvl++;
			}
			lvl ++;
		}
		if(lvl >= ToolListMF.rarity.length)
		{
			lvl = ToolListMF.rarity.length-1;
		}
		return ToolListMF.rarity[lvl];
	}
    
    protected void addXp(EntityLivingBase user, int chance)
    {
    	if(ConfigWeapon.xpTrain && user instanceof EntityPlayer && material == ToolMaterialMF.TRAINING)
		{
			if(chance == 0 || user.getRNG().nextInt(chance) == 0)
			{
				((EntityPlayer)user).addExperience(1);
			}
		}
    }
    
    @SideOnly(Side.CLIENT)
    public static int getParry(ItemStack item)
    {
    	if(item.hasTagCompound())
    	{
    		if(item.getTagCompound().hasKey("ParryAnimation"))
    		{
    			return item.getTagCompound().getInteger("ParryAnimation");
    		}
    	}
    	return -1;
    }
    
    public static void setParry(ItemStack item, int i)
    {
    	NBTTagCompound nbt = getOrCreateNBT(item);
    	
    	nbt.setInteger("ParryAnimation", i);
    }

	public static NBTTagCompound getOrCreateNBT(ItemStack item) 
	{
		if(!item.hasTagCompound())
		{
			item.setTagCompound(new NBTTagCompound());
		}
		return item.getTagCompound();
	}
	@Override
	public void onParry(DamageSource source, EntityLivingBase user, Entity attacker, float dam) 
	{
		boolean groundBlock = user.onGround;
		ItemStack weapon = user.getHeldItem();
		
		//Redirect
		if(!user.worldObj.isRemote && !TacticalManager.isRanged(source))
		{
			if(canEvade(user))
			{
				float powerMod = attacker.isSprinting() ? 4.0F : 2.5F;
				
				attacker.setSprinting(false);
				TacticalManager.lungeEntity(attacker, user, powerMod, 0.0F);
				TacticalManager.lungeEntity(user, attacker, 3F, 0.0F);
				addXp(user, 30);
			}
		}
		int pd = getParryDamage(dam);
		if(pd > 0)
		{
			weapon.damageItem(pd, user);
		}
		addXp(user, 30);
	}

	/**
	 * Gets the amount of durability lost when parrying
	 */
	protected int getParryDamage(float dam) 
	{
		return (int)dam;
	}

	/**
	 * Determines if an evade can be made (jump or normal)
	 */
	private boolean canEvade(EntityLivingBase user)
	{
		if(!canWeaponEvade())
		{
			return false;
		}
		if(user instanceof EntityPlayer)
		{
			if(!user.isSneaking())
			{
				return false;
			}
		}
		else
		{
			if(rand.nextInt(canAnyMobParry() ? 10 : 5) != 0)//Mobs can evade
			{
				return false;
			}
		}
		
		if(!user.onGround && !tryJumpEvade(user))
		{
			return false;
		}
		return tryGroundEvade(user);
	}
	/**
	 * If the player can slip past enemies
	 * Should be any armour but heavy
	 */
	private boolean tryGroundEvade(EntityLivingBase user) 
	{
		return tryPerformAbility(user, evade_cost, true, false);
	}

	/**
	 * If the player can jump over enemies in evading
	 * Only ment for unarmoured/Lightarmour
	 */
	private boolean tryJumpEvade(EntityLivingBase user) 
	{
		return tryPerformAbility(user, jumpEvade_cost, true, false);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	{
		if((StaminaBar.isSystemActive && TacticalManager.shouldStaminaBlock  && !StaminaBar.isAnyStamina(player, false)) || !CombatMechanics.isParryAvailable(player))
		{
			return item;
		}
		if(canBlock())
    	{
    		super.onItemRightClick(item, world, player);
    	}
		return item;
	}

	@Override
	public float getMaxDamageParry(EntityLivingBase user, ItemStack weapon) 
	{
		float mod = 1.0F;
		return baseDamage*getParryDamageModifier(user)*mod;
	}
	
	@Override
	public float getParryAngle(DamageSource source, EntityLivingBase blocker, ItemStack item)
	{
		float base = 30;
		
		if(source.isProjectile())
		{
			if(!(blocker instanceof EntityPlayer))
			{
				base = 0F;
			}
			base *= 0.25F;
		}
		if(blocker instanceof EntityZombie && !(blocker instanceof EntityPigZombie))
		{
			base *= 2;
		}
		return base * getParryAngleModifier(blocker);
	}

	@Override
	public void onProperHit(EntityLivingBase user, ItemStack weapon, Entity hit, float dam)
	{
		if(ConfigWeapon.xpTrain && user instanceof EntityLivingBase && material == ToolMaterialMF.TRAINING)
		{
			addXp(user, 50);
		}
	}

	protected float getKnockbackStrength() 
	{
		return 0;
	}

	@Override
	public boolean playCustomParrySound(EntityLivingBase blocker, Entity attacker, ItemStack weapon) 
	{
		if(material == ToolMaterialMF.TRAINING)
		{
			blocker.worldObj.playSoundAtEntity(blocker, "minefantasy2:weapon.wood_parry", 1.0F, 1.0F);
			return true;
		}
		if(material == ToolMaterialMF.STONE)
		{
			blocker.worldObj.playSoundAtEntity(blocker, "dig.stone", 1.0F, 0.1F);
			return true;
		}
		return false;
	}
	@Override
	public boolean canParry(DamageSource source, EntityLivingBase blocker, ItemStack item)
	{
		return canWeaponParry();
	}
	@Override
	public float getBalance(EntityLivingBase user)
	{
		return getBalance();
	}
	public float getBalance()
	{
		return 0.0F;
	}
	
	@Override
	public float getStaminaDrainOnHit(EntityLivingBase user, ItemStack item)
	{
		return 5F * getStaminaMod() * getMaterialWeight(item);
	}

	protected float getStaminaMod() 
	{
		return 1.0F;
	}
	
	protected boolean canPerformAbility(EntityLivingBase user, float points)
	{
		return tryPerformAbility(user, points, false, true, true, false);
	}
	protected boolean tryPerformAbility(EntityLivingBase user, float points)
	{
		return tryPerformAbility(user, points, true, true);
	}
	
	protected boolean tryPerformAbility(EntityLivingBase user, float points, boolean armour, boolean weapon)
	{
		return tryPerformAbility(user, points, true, armour, weapon, true);
	}
	
	protected boolean tryPerformAbility(EntityLivingBase user, float points, boolean flash, boolean armour, boolean weapon, boolean takePoints)
	{
		if(StaminaBar.isSystemActive && StaminaBar.doesAffectEntity(user))
		{
			points *= StaminaBar.getBaseDecayModifier(user, armour, weapon);
			if(StaminaBar.isStaminaAvailable(user, points, flash))
			{
				if(takePoints)
				{
					applyFatigue(user, points);
				}
				return true;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	public static void applyFatigue(EntityLivingBase user, float points) 
	{
		applyFatigue(user, points, 50F);
	}
	public static void applyFatigue(EntityLivingBase user, float points, float pause) 
	{
		if(StaminaBar.isSystemActive && StaminaBar.doesAffectEntity(user))
		{
			float stam = StaminaBar.getStaminaValue(user);
			if(stam > 0)
			{
				StaminaBar.modifyStaminaValue(user, -points);
			}
			StaminaBar.setIdleTime(user, pause * StaminaBar.pauseModifier);
		}
	}
	@Override
	public float getDecayMod(EntityLivingBase user, ItemStack item)
	{
		return getDecayModifier(user, item) * getMaterialWeight(item);
	}
	
	/**
	 * The Modifier for the weapon
	 */
	public float getDecayModifier(EntityLivingBase user, ItemStack item)
	{
		return 1.0F;
	}
	
	@Override
	public float getRegenModifier(EntityLivingBase user, ItemStack item) 
	{
		return 1.0F;
	}

	@Override
	public float getIdleModifier(EntityLivingBase user, ItemStack item) 
	{
		return 1.0F;
	}
	
	protected void hurtInRange(EntityLivingBase user, double range) 
	{
		AxisAlignedBB bb = user.boundingBox.expand(range, range, range);
		List<Entity>hurt = user.worldObj.getEntitiesWithinAABBExcludingEntity(user, bb);
		Iterator list = hurt.iterator();
		while(list.hasNext())
		{
			Entity hit = (Entity) list.next();
			
			if(user.canEntityBeSeen(hit))
			{
				TacticalManager.knockbackEntity(hit, user, 1.5F, 0.2F);
				if(StaminaBar.isSystemActive)
				{
					StaminaBar.setIdleTime(user, 60);
				}
				if(hit instanceof EntityLivingBase)
				{
					hit.worldObj.playSoundAtEntity(hit, "minefantasy2:weapon.critical", 0.8F, 2.0F);
					for(int a = 0; a < 4; a ++)
					{
						hit.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.redstone_block) + "_0", hit.posX, hit.posY+hit.getEyeHeight(), hit.posZ, rand.nextDouble()/2D, rand.nextDouble()/2D, rand.nextDouble()/2D);
					}
					((EntityLivingBase) hit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
				}
			}
		}
	}
	public boolean canUserParry(EntityLivingBase user)
	{
		return user instanceof EntityPlayer || (canAnyMobParry() || rand.nextFloat() < 0.20F);
	}

	protected boolean canAnyMobParry() 
	{
		return false;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		int dura = super.getMaxDamage();
    	if(ToolMaterialMF.isUnbreakable(material))
		{
    		ToolMaterialMF.setUnbreakable(stack);
		}
		return ToolHelper.setDuraOnQuality(stack, dura);
	}
	@Override
	public float getAddedKnockback(EntityLivingBase user, ItemStack item)
	{
		return getKnockbackStrength();
	}
	
	@Override
	public int modifyHitTime(EntityLivingBase user, ItemStack item)
	{
		return 0;
	}
	
	@Override
	public float[] getDamageRatio(Object implement)
	{
		return getWeaponRatio((ItemStack)implement);
	}
	@Override
	public float getPenetrationLevel(Object implement)
	{
		ItemStack item = (ItemStack)implement;
		return 0F;
	}
	
	protected float[] getWeaponRatio(ItemStack implement)
	{
		return new float[]{1F, 0F};
	}
	
	protected float[] maceRatio = new float[]{0F, 1F};
	protected float[] hammerRatio = new float[]{0F, 1F};
	
	protected float[] waraxeRatio = new float[]{4F, 1F};
	protected float[] battleaxeRatio = new float[]{3F, 1F};
	
	protected float[] heavyRatio = new float[]{9F, 1F};
	private float	materialWeight  = 1.0F;
	
	protected static int speedModHeavy = 5;
	
	protected static int speedModSword = 0;
	protected static int speedModAxe = 1;
	protected static int speedModMace = 2;
	protected static int speedModKatana = -5;
	protected static int speedModSpear = 2;
	
	protected static float damageModSword = 0.0F;
	protected static float damageModAxe = 0.5F;
	protected static float damageModMace = 1.0F;
	
	public static float axeAPModifier = -0.1F;
	
	@Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
		if(this instanceof ItemKnifeMF)
		{
			super.getSubItems(item, tab, list);
			return;
		}
		if(this != ToolListMF.swordTraining)
		{
			return;
		}
		list.add(new ItemStack(ToolListMF.swordTraining));
		list.add(new ItemStack(ToolListMF.waraxeTraining));
		list.add(new ItemStack(ToolListMF.maceTraining));
		list.add(new ItemStack(ToolListMF.spearTraining));
		
		list.add(new ItemStack(ToolListMF.swordStone));
		list.add(new ItemStack(ToolListMF.waraxeStone));
		list.add(new ItemStack(ToolListMF.maceStone));
		list.add(new ItemStack(ToolListMF.spearStone));
		
		addSet(list, ToolListMF.swords);
		addSet(list, ToolListMF.waraxes);
		addSet(list, ToolListMF.maces);
		addSet(list, ToolListMF.spears);
		addSet(list, ToolListMF.daggers);
		
		addSet(list, ToolListMF.greatswords);
		addSet(list, ToolListMF.battleaxes);
		addSet(list, ToolListMF.warhammers);
		addSet(list, ToolListMF.halbeards);
		addSet(list, ToolListMF.katanas);
		
		addSet(list, ToolListMF.lances);
    }
	
	protected float getMaterialWeight(ItemStack stack)
	{
		return materialWeight ;
	}

	private void addSet(List list, Item[] items) 
	{
		for(Item item:items)
		{
			list.add(new ItemStack(item));
		}
	}

	@Override
	public float modifyDamage(ItemStack item, EntityLivingBase wielder, Entity hit, float initialDam, boolean properHit)
	{
		return initialDam;
	}
	
	@Override
	public float getParryStaminaDecay(DamageSource source, ItemStack weapon)
	{
		return 1.0F;
	}
	@Override
	public int getParryCooldown(DamageSource source, float dam, ItemStack weapon)
	{
		return 15;
	}
	@Override
	public int getParryModifier(ItemStack weapon, EntityLivingBase user, Entity target)
	{
		return 30;
	}
	@Override
	public void onPowerAttack(float dam, EntityLivingBase user, Entity target, boolean properHit)
	{
		
	}
	protected int defParryTime = 15;
	protected int swordParryTime = 10;
	protected int axeParryTime = 15;
	protected int maceParryTime = 15;
	protected int daggerParryTime = 5;
	protected int spearParryTime = 20;
	
	protected int heavyParryTime = 10;
	
	protected float heavyParryFatigue = 2.0F;
	
	protected float daggerStaminaCost = 0.50F;
	protected float swordStaminaCost =  1.00F;
	protected float katanaStaminaCost = 0.75F;
	protected float axeStaminaCost =    1.20F;
	protected float maceStaminaCost =   1.30F;
	protected float spearStaminaCost =  1.40F;
	
	protected float heavyStaminaCost =  1.50F;
}
