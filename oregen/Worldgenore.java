package moreofeverything.oregen;

import java.util.Random;

import moreofeverything.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class Worldgenore implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
			//Switch is here to define which world is what.
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}

	}
		//Constant of worlds
	private void generateNether(World world, Random random, int x, int y) {

	}

	private void generateEnd(World world, Random random, int x, int y) {
			//Adds ore. if you want to add stone generation, use same as below, except increase x and y to 64


	}

	private void generateSurface(World world, Random random, int x, int y) {
		
		this.addOreSpawn(Blocks.verbalore, world, random, x, y, 16, 16,
				4 + random.nextInt(5), 15, 4, 40);
		this.addOreSpawn(Blocks.scikaleore, world, random, x, y, 16, 16,
				4 + random.nextInt(5), 15, 4, 25);

	}

	public void addOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		for (int y = 0; y < chancesToSpawn; y++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block.blockID, maxVeinSize)).generate(world,
					random, posX, posY, posZ);
		}
	}

}
