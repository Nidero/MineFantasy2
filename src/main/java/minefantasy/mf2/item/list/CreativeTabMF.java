package minefantasy.mf2.item.list;

import minefantasy.mf2.block.list.BlockListMF;
import minefantasy.mf2.item.food.FoodListMF;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class CreativeTabMF extends CreativeTabs
{
	public static CreativeTabs tabTool = new CreativeTabMF(CreativeTabs.getNextID(), "forgedtool", 1);
	public static CreativeTabs tabWeapon = new CreativeTabMF(CreativeTabs.getNextID(), "forgedweapon", 2);
	public static CreativeTabs tabArmour = new CreativeTabMF(CreativeTabs.getNextID(), "forgedarmour", 3);
	public static CreativeTabs tabArcher = new CreativeTabMF(CreativeTabs.getNextID(), "MFBows", 4);
	public static CreativeTabs tabUtil = new CreativeTabMF(CreativeTabs.getNextID(), "MFUtil", 5);
	public static CreativeTabs tabGadget = new CreativeTabMF(CreativeTabs.getNextID(), "MFGadgets", 6);
	public static CreativeTabs tabMaterialsMF = new CreativeTabMF(CreativeTabs.getNextID(), "MFMaterials", 7);
	public static CreativeTabs tabToolAdvanced = new CreativeTabMF(CreativeTabs.getNextID(), "MFadvancedtool", 8);
	public static CreativeTabs tabCraftTool = new CreativeTabMF(CreativeTabs.getNextID(), "MFcrafttool", 9);
	public static CreativeTabs tabOres = new CreativeTabMF(CreativeTabs.getNextID(), "MFore", 10);
	public static CreativeTabs tabFood = new CreativeTabMF(CreativeTabs.getNextID(), "MFfood", 11);
	public static CreativeTabs tabDragonforged = new CreativeTabMF(CreativeTabs.getNextID(), "MFdragonforged", 12);
	public static CreativeTabs tabOldTools = new CreativeTabMF(CreativeTabs.getNextID(), "MFOld", 13);
	//public static CreativeTabs tabDwarven = new CreativeTabMF(CreativeTabs.getNextID(), "MFdwarven", 14);
	//public static CreativeTabs tabGnomish = new CreativeTabMF(CreativeTabs.getNextID(), "MFgnomish", 15);
	
	
	private int type;
    CreativeTabMF(int id, String item, int t)
    {
        super(id, item);
        type = t;
    }
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
	{
		switch(type)
		{
			case 1: return new ItemStack(CustomToolListMF.standard_axe);
			case 2: return new ItemStack(CustomToolListMF.standard_sword);
			case 3: return new ItemStack(CustomArmourListMF.standard_plate_helmet);
			case 4: return new ItemStack(CustomToolListMF.standard_bow);
			case 5: return new ItemStack(BlockListMF.anvil[1]);
			case 6: return new ItemStack(ToolListMF.bomb_custom);
			case 7: return new ItemStack(ComponentListMF.plank);
			case 8: return new ItemStack(CustomToolListMF.standard_handpick);
			case 9: return new ItemStack(CustomToolListMF.standard_hammer);
			case 10: return new ItemStack(BlockListMF.oreCopper);
			case 11: return new ItemStack(FoodListMF.sweetroll);
			case 12: return new ItemStack(ComponentListMF.dragon_heart);
			case 13: return new ItemStack(ToolListMF.pickStone);
		}
		return new ItemStack(ComponentListMF.ingots[3]);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return CustomToolListMF.standard_axe;
	}
}
