package minefantasy.mf2.mechanics.worldGen;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;

import java.util.Random;

import minefantasy.mf2.MineFantasyII;
import minefantasy.mf2.block.list.BlockListMF;
import minefantasy.mf2.config.ConfigWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraftforge.event.terraingen.TerrainGen;

public class WorldGenPlants 
{
	public static void generate(Random seed, int chunkX, int chunkZ, World world) 
	{
		BiomeGenBase biome = world.getBiomeGenForCoords(chunkX*16, chunkZ*16);
		if(isBiomeInConstraint(biome, ConfigWorldGen.berryMinTemp, ConfigWorldGen.berryMaxTemp, ConfigWorldGen.berryMinRain, ConfigWorldGen.berryMaxRain))
		{
			generatePlant(seed, chunkX, chunkZ, world, BlockListMF.berryBush, 0, ConfigWorldGen.berryRarity);
		}
	}
	public static boolean isBiomeInConstraint(BiomeGenBase biome, float tempMin, float tempMax, float rainMin, float rainMax)
	{
		if(biome != null)
		{
			return biome.temperature >= tempMin && biome.temperature < tempMax && biome.rainfall >= rainMin && biome.rainfall < rainMax;
		}
		return false;
	}
	
	private static void generatePlant(Random seed, int chunkX, int chunkZ, World world, Block plant, int meta, float chance) 
	{
		boolean doGen = world.getWorldInfo().getTerrainType() != WorldType.FLAT;
		if (doGen && seed.nextFloat() < chance)
        {
            int j = chunkX*16 + seed.nextInt(16);
            int k = chunkZ*16 + seed.nextInt(16);
            int l = world.getTopSolidOrLiquidBlock(j, k);
            (new WorldGenBush(BlockListMF.berryBush, 0)).generate(world, seed, j, l, k);
		}
	}
	
	private static void generateOreWithNeighbour(Random seed, int chunkX, int chunkZ, World world, Block ore, Block bed, Material neighbour, int size, int frequencyMin, int frequencyMax, float rarity, int layerMin, int layerMax) 
	{
		int frequency = MathHelper.getRandomIntegerInRange(seed, frequencyMin, frequencyMax);
		if(seed.nextFloat() < rarity)
		{
			for(int count = 0; count < frequency; count ++)
			{
				int x = chunkX*16 + seed.nextInt(16);
				int y = MathHelper.getRandomIntegerInRange(seed, layerMin, layerMax);
				int z = chunkZ*16 + seed.nextInt(16);
				
				if(isNeibourNear(world, x, y, z, neighbour))
				{
					if((new WorldGenMinableMF(ore, size, bed)).generate(world, seed, x, y, z))
					{
					}
				}
			}
		}
	}
	private static void generateOreWithNeighbour(Random seed, int chunkX, int chunkZ, World world, Block ore, Block bed, Block neighbour, int size, int frequencyMin, int frequencyMax, float rarity, int layerMin, int layerMax) 
	{
		int frequency = MathHelper.getRandomIntegerInRange(seed, frequencyMin, frequencyMax);
		if(seed.nextFloat() < rarity)
		{
			for(int count = 0; count < frequency; count ++)
			{
				int x = chunkX*16 + seed.nextInt(16);
				int y = MathHelper.getRandomIntegerInRange(seed, layerMin, layerMax);
				int z = chunkZ*16 + seed.nextInt(16);
				
				if(isNeibourNear(world, x, y, z, neighbour))
				{
					if((new WorldGenMinableMF(ore, size, bed)).generate(world, seed, x, y, z))
					{
					}
				}
			}
		}
	}
	private static boolean isNeibourNear(World world, int x, int y, int z, Block neighbour) 
	{
		return world.getBlock(x-1, y, z) == neighbour
			|| world.getBlock(+1, y, z) == neighbour
			|| world.getBlock(x, y-1, z) == neighbour
			|| world.getBlock(x, y+1, z) == neighbour
			|| world.getBlock(x, y, z-1) == neighbour
			|| world.getBlock(x, y, z+1) == neighbour;
	}
	private static boolean isNeibourNear(World world, int x, int y, int z, Material neighbour) 
	{
		return world.getBlock(x-1, y, z).getMaterial() == neighbour
			|| world.getBlock(+1, y, z).getMaterial() == neighbour
			|| world.getBlock(x, y-1, z).getMaterial() == neighbour
			|| world.getBlock(x, y+1, z).getMaterial() == neighbour
			|| world.getBlock(x, y, z-1).getMaterial() == neighbour
			|| world.getBlock(x, y, z+1).getMaterial() == neighbour;
	}
}
