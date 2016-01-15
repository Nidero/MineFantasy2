package minefantasy.mf2.item.archery;

import java.text.DecimalFormat;
import java.util.List;

import minefantasy.mf2.MineFantasyII;
import minefantasy.mf2.api.archery.Arrows;
import minefantasy.mf2.api.archery.IArrowMF;
import minefantasy.mf2.api.archery.IDisplayMFArrows;
import minefantasy.mf2.entity.EntityArrowMF;
import minefantasy.mf2.item.list.CreativeTabMF;
import minefantasy.mf2.material.BaseMaterialMF;
import minefantasy.mf2.mechanics.MFArrowDispenser;
import mods.battlegear2.api.quiver.QuiverArrowRegistry;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
/**
 * @author Anonymous Productions
 */
public class ItemArrowMF extends Item implements IDisplayMFArrows, IArrowMF
{
	protected float damage;
	protected String arrowName;
	protected ArrowType design;
	private ToolMaterial arrowMat;
	public static final DecimalFormat decimal_format = new DecimalFormat("#.##");
	public static final MFArrowDispenser dispenser = new MFArrowDispenser();
	public ItemArrowMF(String name)
	{
		this(name, 0, ToolMaterial.WOOD);
	}
	public ItemArrowMF(String name, int rarity, ToolMaterial material)
	{
		this(name, rarity, material, ArrowType.NORMAL);
	}
	public ItemArrowMF(String name, int rarity, ToolMaterial material, ArrowType type)
	{
		name = convertName(name);
		material = convertMaterial(material);
		
		super.setUnlocalizedName(type == ArrowType.EXPLOSIVE ? name : (name+"_arrow"));
		name = getName(name, type);
		design = type;
		arrowName = name;
		arrowMat = material;
		damage = ((material.getDamageVsEntity()/2F) + 3.0F)*type.damageModifier;
		if(type == ArrowType.EXPLOSIVE)
		{
			damage = 1;
		}
		itemRarity = rarity;
		setTextureName("minefantasy2:Ammo/"+name);
		setCreativeTab(CreativeTabMF.tabArcher);
		GameRegistry.registerItem(this, "MF_Com_"+name, MineFantasyII.MODID);
		
		Arrows.addArrow(new ItemStack(this));
		QuiverArrowRegistry.addArrowToRegistry(new ItemStack(this), null);
		BlockDispenser.dispenseBehaviorRegistry.putObject(this, dispenser);
	}
	private ToolMaterial convertMaterial(ToolMaterial material) 
	{
		if(material == BaseMaterialMF.getMaterial("ornate").getToolConversion())
		{
			return BaseMaterialMF.getMaterial("silver").getToolConversion();
		}
		return material;
	}
	private String convertName(String name) 
	{
		if(name.equalsIgnoreCase("ornate"))
		{
			return "silver";
		}
		return name;
	}
	@Override
	public String getItemStackDisplayName(ItemStack item)
    {
        String name = ("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(item) + ".name")).trim();
        
        if(design != ArrowType.NORMAL && design != ArrowType.EXPLOSIVE)
        {
        	name += " (" +  StatCollector.translateToLocal("arrow.head."+ design.name.toLowerCase() +".name") + ")";
        }
        
        return name;
    }
	
	private String getName(String mat, ArrowType type) 
	{
		if(type == ArrowType.EXPLOSIVE)
		{
			return "exploding_arrow";
		}
		if(type.name.equalsIgnoreCase("normal"))
		{
			return mat +"_arrow";
		}
		return mat + "_arrow_" + type.name.toLowerCase();
	}

	private int itemRarity;
    @Override
	public EnumRarity getRarity(ItemStack item)
	{
		int lvl = itemRarity;
		
		EnumRarity[] rarity = new EnumRarity[]{EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic};
		if(item.isItemEnchanted())
		{
			if(lvl == 0)
			{
				lvl++;
			}
			lvl ++;
		}
		if(lvl >= rarity.length)
		{
			lvl = rarity.length-1;
		}
		return rarity[lvl];
	}
    
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
    }
    
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List desc, boolean flag) 
    {
    	//desc.add(StatCollector.translateToLocal("arrow.head."+ design.name.toLowerCase() +".name"));
		super.addInformation(item, player, desc, flag);
		desc.add(EnumChatFormatting.BLUE + StatCollector.translateToLocal("attribute.arrowPower.name") + ": " + decimal_format.format(damage));
        
    }
    
    public EntityArrowMF getFiredArrow(EntityArrowMF instance, ItemStack arrow)
    {
    	instance.modifyVelocity(design.velocity);
    	return instance.setArrow(arrow).setArrowTex(arrowName);
    }
    
    @Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	{
    	Arrows.presetArrow(player, item);
    	return item;
	}
	@Override
	public float getDamageModifier(ItemStack arrow)
	{
		return damage;
	}
	@Override
	public float getGravityModifier(ItemStack arrow)
	{
		return 1.0F * design.weightModifier;
	}
	@Override
	public float getBreakChance(Entity entityArrow, ItemStack arrow)
	{
		if(arrowMat == BaseMaterialMF.getMaterial("ignotumite").getToolConversion() || arrowMat == BaseMaterialMF.getMaterial("mithium").getToolConversion() || arrowMat == BaseMaterialMF.getMaterial("ender").getToolConversion())
		{
			return 0F;
		}
		
		return 1F / (arrowMat.getMaxUses()/150);
	}
	@Override
	public void onHitEntity(Entity arrowInstance, Entity shooter, Entity hit, float damage) 
	{
		if(arrowMat == BaseMaterialMF.getMaterial("dragonforge").getToolConversion())
		{
			hit.setFire((int)(damage * (arrowInstance.isBurning() ? 2.0F : 1.0F)));
		}
	}
}
