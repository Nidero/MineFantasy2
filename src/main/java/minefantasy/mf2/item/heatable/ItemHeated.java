package minefantasy.mf2.item.heatable;

import java.awt.Color;
import java.util.List;

import minefantasy.mf2.MineFantasyII;
import minefantasy.mf2.api.heating.Heatable;
import minefantasy.mf2.api.heating.IHotItem;
import minefantasy.mf2.api.helpers.GuiHelper;
import minefantasy.mf2.item.list.ComponentListMF;
import minefantasy.mf2.util.MFLogUtil;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHeated extends Item implements IHotItem
{
	public ItemHeated() 
	{
		GameRegistry.registerItem(this, "MF_Hot_Item", MineFantasyII.MODID);
		setUnlocalizedName("MF_Hot_Item");
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
	}

	public static int getTemp(ItemStack item) {
		return Heatable.getTemp(item);
	}
	public static int getWorkTemp(ItemStack item) {
		return Heatable.getWorkTemp(item);
	}
	public static int getUnstableTemp(ItemStack item) {
		return Heatable.getWorkTemp(item);
	}

	public static ItemStack getItem(ItemStack item) 
	{
		return Heatable.getItem(item);
	}

	public static void setTemp(ItemStack item, int heat) {
		NBTTagCompound nbt = getNBT(item);

		nbt.setInteger(Heatable.NBT_CurrentTemp, heat);
	}
	public static void setWorkTemp(ItemStack item, int heat) {
		NBTTagCompound nbt = getNBT(item);
		MFLogUtil.logDebug("Set Workable Temp: " + heat);
		nbt.setInteger(Heatable.NBT_WorkableTemp, heat);
	}
	public static void setUnstableTemp(ItemStack item, int heat) {
		NBTTagCompound nbt = getNBT(item);
		MFLogUtil.logDebug("Set Unstable Temp: " + heat);
		nbt.setInteger(Heatable.NBT_UnstableTemp, heat);
	}

	public static ItemStack createHotItem(ItemStack item) {
		return createHotItem(item, false);
	}
	public static ItemStack createHotItem(ItemStack item, int temp)
	{
		ItemStack hot = createHotItem(item, true);
		setTemp(hot, temp);
		
		return hot;
	}
	public static ItemStack createHotItem(ItemStack item, boolean ignoreStats)
	{
		Heatable stats = Heatable.loadStats(item);
		if(stats != null)
		{
			ItemStack out = new ItemStack(ComponentListMF.hotItem, item.stackSize);
			NBTTagCompound nbt = getNBT(out);
	
			nbt.setInteger(Heatable.NBT_ItemID, Item.getIdFromItem(item.getItem()));
			nbt.setInteger(Heatable.NBT_SubID, item.getItemDamage());
			nbt.setBoolean(Heatable.NBT_ShouldDisplay, true);
			setWorkTemp(out, stats.minTemperature);
			setUnstableTemp(out, stats.unstableTemperature);
	
			return out;
		}
		else if(ignoreStats)
		{
			ItemStack out = new ItemStack(ComponentListMF.hotItem, item.stackSize);
			NBTTagCompound nbt = getNBT(out);
	
			nbt.setInteger(Heatable.NBT_ItemID, Item.getIdFromItem(item.getItem()));
			nbt.setInteger(Heatable.NBT_SubID, item.getItemDamage());
			nbt.setBoolean(Heatable.NBT_ShouldDisplay, false);
			setWorkTemp(out, 0);
			setUnstableTemp(out, 0);
	
			return out;
		}
		return item;
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) 
	{
		String name = "";

		ItemStack item = getItem(stack);
		if (item != null)
			name = item.getItem().getItemStackDisplayName(item);
		return StatCollector.translateToLocalFormatted("prefix.hotitem.name", name);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		ItemStack item = getItem(stack);
		if (item != null)
			return item.getItem().getRarity(item);

		return EnumRarity.COMMON;
	}

	public static boolean showTemp(ItemStack stack) {
		if (stack == null)
			return false;

		NBTTagCompound nbt = getNBT(stack);

		if (nbt == null)
			return false;

		if (nbt.hasKey(Heatable.NBT_ShouldDisplay)) {
			return nbt.getBoolean(Heatable.NBT_ShouldDisplay);
		}
		return false;
	}

	private static NBTTagCompound getNBT(ItemStack item) {
		if (!item.hasTagCompound())
			item.setTagCompound(new NBTTagCompound());
		return item.getTagCompound();
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
		ItemStack item = getItem(stack);

		if (item != null) {
			item.getItem().addInformation(item, player, list, b);
		} else
			super.addInformation(stack, player, list, b);

		NBTTagCompound nbt = getNBT(stack);
		if (nbt.hasKey(Heatable.NBT_ShouldDisplay)) {
			if (nbt.getBoolean(Heatable.NBT_ShouldDisplay)) {
				list.add(getHeatString(stack));
				if (!getWorkString(item, stack).equals(""))
					list.add(getWorkString(item, stack));
			}
		}
	}

	private String getHeatString(ItemStack item) {
		int heat = getTemp(item);
		String unit = "*C";
		return heat + unit;
	}

	private String getWorkString(ItemStack heated, ItemStack item) {
		byte stage = Heatable.getHeatableStage(item);
		switch (stage) {
			case 1:
				return EnumChatFormatting.YELLOW + StatCollector.translateToLocal("state.workable");
			case 2:
				return EnumChatFormatting.RED + StatCollector.translateToLocal("state.unstable");
		}
		return "";
	}

//	public IIcon getIcon(ItemStack stack, int renderPass) {
//		ItemStack item = getItem(stack);
//
//		if (item != null) {
//			return item.getItem().getIcon(item, renderPass);
//		}
//		return Blocks.fire.getBlockTextureFromSide(2);
//	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	{
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

		if (movingobjectposition == null) {
			return item;
		} else {
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				BlockPos pos = movingobjectposition.getBlockPos();

				if (!world.canMineBlockBody(player, pos)) {
					return item;
				}

				if (!player.canPlayerEdit(pos, movingobjectposition.sideHit, item)) {
					return item;
				}

				if (isWaterSource(world, pos)) {
					player.playSound("random.splash", 1F, 1F);
					player.playSound("random.fizz", 2F, 0.5F);

					for (int a = 0; a < 5; a++) {
						world.spawnParticle(EnumParticleTypes.SMOKE_LARGE,pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F, 0, 0.065F, 0);
					}

					ItemStack drop = getItem(item).copy();
					drop.stackSize = item.stackSize;
					if (drop != null) {
						item.stackSize = 0;

						if (item.stackSize <= 0) {
							return drop.copy();
						}
					}
				}
			}

			return item;
		}
	}

	private boolean isWaterSource(World world, BlockPos pos) 
	{
		if (world.getBlockState(pos).getBlock().getMaterial() == Material.water)
		{
			return true;
		}
		if (isCauldron(world, pos)) {
			return true;
		}
		return false;
	}

	public static boolean renderDynamicHotIngotRendering = true;
	public int getColorFromItemStack(ItemStack item, int renderPass)
	{
		if (renderPass > 1 || !renderDynamicHotIngotRendering) 
		{
			return Color.WHITE.getRGB();
		}
		NBTTagCompound nbt = getNBT(item);
		int heat = getTemp(item);
		int maxHeat = Heatable.forgeMaximumMetalHeat;
		double heatPer = (double) heat / (double) maxHeat * 100D;

		int red = getRedOnHeat(heatPer);
		int green = getGreenOnHeat(heatPer);
		int blue = getBlueOnHeat(heatPer);

		if (heat > 0) {
			return GuiHelper.getColourForRGB(red, green, blue);
		}

		return Color.WHITE.getRGB();
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	private int getRedOnHeat(double percent) {
		return 255;
	}

	private int getGreenOnHeat(double percent) {
		if (percent > 100)
			percent = 100;
		if (percent < 0)
			percent = 0;

		if (percent <= 55) {
			return (int) (255 - ((255 / 55) * percent));
		} else {
			return (int) ((255 / 55) * (percent - 55));
		}
	}

	private int getBlueOnHeat(double percent) {
		if (percent > 100)
			percent = 100;
		if (percent < 0)
			percent = 0;

		if (percent <= 55) {
			return (int) (255 - ((255 / 55) * percent));
		}
		return 0;
	}

	public boolean isCauldron(World world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.cauldron && world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)) > 0;
	}

	@Override
	public boolean isHot(ItemStack item) {
		return true;
	}

	@Override
	public boolean isCoolable(ItemStack item) {
		return true;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item parItem, CreativeTabs parTab, 
          List parListSubItems)
    {
        parListSubItems.add(new ItemStack(this, 1));
     }
}
