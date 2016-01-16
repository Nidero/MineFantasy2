package minefantasy.mf2.api.material;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomMaterial
{
	public static final String NBTBase = "MF_CustomMaterials";
	public static HashMap<String, CustomMaterial> materialList = new HashMap<String, CustomMaterial>();
	public static HashMap<String, ArrayList<CustomMaterial>> typeList = new HashMap<String, ArrayList<CustomMaterial>>();
	
	public ArrayList<ItemStack>items = new ArrayList<ItemStack>();
	/** The material colour*/
	public int[] colourRGB = new int[]{255, 255, 255};
	/** Base threshold for armour rating*/
	public float hardness;
	/** The Modifier for durability (1pt per 250 uses)*/
	public float durability;
	/** used for bow power.. >1 weakens blunt prot, <1 weakens piercing prot*/
	public float flexibility;
	/** The Efficiency modifier (Like ToolMaterial) Also does damage*/
	public float sharpness;
	/** The modifier to resist elements like fire and corrosion)*/
	public float resistance;
	/** The weight Kg/U (Kilogram per unit)*/
	public float density;
	public int tier;
	public String type, name;
	private float[] armourProtection = new float[]{1.0F, 1.0F, 1.0F};
	public int rarityID = 0;
	
	public int crafterTier = 0;
	public int crafterAnvilTier = 0;
	
	public CustomMaterial(String name, String type, int tier, float hardness, float durability, float flexibility, float resistance, float sharpness, float density)
	{
		this.name = name;
		this.type = type;
		this.tier = tier;
		this.hardness = hardness;
		this.durability = durability;
		this.flexibility = flexibility;
		this.sharpness = sharpness;
		this.density = density;
		this.resistance = resistance;
	}
	public CustomMaterial setCrafterTiers(int tier)
	{
		this.crafterTier = tier;
		this.crafterAnvilTier = Math.min(tier, 4);
		return this;
	}
	public CustomMaterial setArmourStats(float cutting, float blunt, float piercing)
	{
		armourProtection = new float[]{cutting, blunt, piercing};
		return this;
	}
	public CustomMaterial setRarity(int id)
	{
		rarityID = id;
		return this;
	}
	public CustomMaterial setColour(int red, int green, int blue)
	{
		colourRGB = new int[]{red, green, blue};
		return this;
	}
	
	public CustomMaterial register()
	{
		materialList.put(name.toLowerCase(), this);
		getList(type).add(this);
		return this;
	}
	public int getColourInt() 
	{
		return (colourRGB[0] << 16) + (colourRGB[1] << 8) + colourRGB[2];
	}
	
	/**
	 * Gets a material by name
	 */
	public static CustomMaterial getMaterial(String name)
	{
		return materialList.get(name.toLowerCase());
	}
	
	/**
	 * Adds a new material
	 * @param name The name of the material (and registration)
	 * @param type What it is (Metal, Wood, etc)
	 * @param tier The tier of the material
	 * @param hardness How hard the material is to break
	 * @param flexibility How well the material can bend and retract
	 * @param sharpness How well it can be sharpened
	 * @param resistance How well it can handle destructive elements like fire and corrosion, and increased heating temperature
	 * @param density how dense the element is, increasing mass per unit. (KG/Units)
	 */
	public static CustomMaterial getOrAddMaterial(String name, String type, int tier, float hardness, float durability, float flexibility, float sharpness, float resistance, float density, int red, int green, int blue)
	{
		if(getMaterial(name) != null)
		{
			return getMaterial(name);
		}
		return new CustomMaterial(name, type, tier, hardness, durability, flexibility, sharpness, resistance, density).setColour(red, green, blue).register();
	}
	
	public static void addMaterial(ItemStack item, String slot, String material)
	{
		if(material == null || material.isEmpty())
		{
			return;
		}
		NBTTagCompound nbt = getNBT(item, true);
		nbt.setString(slot, material);
	}
	public static CustomMaterial getMaterialFor(ItemStack item, String slot)
	{
		NBTTagCompound nbt = getNBT(item, false);
		if(nbt != null)
		{
			if(nbt.hasKey(slot))
			{
				return getMaterial(nbt.getString(slot));
			}
		}
		return null;
	}
	public static NBTTagCompound getNBT(ItemStack item, boolean createNew)
	{
		if(item != null && item.hasTagCompound() && item.getTagCompound().hasKey(NBTBase))
		{
			return (NBTTagCompound) item.getTagCompound().getTag(NBTBase);
		}
		if(createNew)
		{
			NBTTagCompound nbt = new NBTTagCompound();
			NBTTagCompound nbt2 = new NBTTagCompound();
			item.setTagCompound(nbt);
			nbt.setTag(NBTBase, nbt2);
			return nbt2;
		}
		return null;
	}
	
	public static ArrayList<CustomMaterial> getList(String type)
	{
		if(typeList.get(type) == null)
		{
			typeList.put(type, new ArrayList<CustomMaterial>());
		}
		return typeList.get(type);
	}
	
	public static void addOreDict(String material, String name)
	{
		if(getMaterial(name) != null)
		{
			getMaterial(name).addOreDict(material);
		}
	}
	public void addOreDict(String name)
	{
		for(ItemStack item: OreDictionary.getOres(name))
		{
			items.add(item);
		}
	}
	public boolean isItemApplicable(ItemStack item)
	{
		return this.items.contains(item);
	}
	@SideOnly(Side.CLIENT)
	public static String getWeightString(float mass) 
	{
		String s = "attribute.weightKg.name";
		if(mass < 1.0F)
		{
			s = "attribute.weightg.name";
			mass = (int)(mass*1000F);
		}
		return StatCollector.translateToLocalFormatted(s, mass);
	}
	@SideOnly(Side.CLIENT)
	public String getMaterialString() 
	{
		return StatCollector.translateToLocalFormatted("materialtype."+this.type+".name", this.tier);
	}
	
	public float getArmourProtection(int id)
	{
		return armourProtection[id];
	}
}