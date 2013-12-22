package moreofeverything.items.tools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemOmniTool extends ItemTool {

	public static final Block[] blocksEffectiveAgainst = { Block.cobblestone,
			Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone,
			Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.ice,
			Block.netherrack, Block.oreLapis, Block.blockLapis,
			Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
			Block.railDetector, Block.railPowered, Block.railActivator,
			Block.planks, Block.bookShelf, Block.wood, Block.chest,
			Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin,
			Block.pumpkinLantern, Block.grass, Block.dirt, Block.sand,
			Block.gravel, Block.snow, Block.blockSnow, Block.blockClay,
			Block.tilledField, Block.slowSand, Block.mycelium };

	public ItemOmniTool(int id, EnumToolMaterial material) {

		super(id, 8F, material, blocksEffectiveAgainst);

	}

	/**
	 * Returns the strength of the stack against a given block. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	@Override
	public float getStrVsBlock(ItemStack itemstack, Block block) {
		return block != null
				&& (block.blockMaterial == Material.wood
						|| block.blockMaterial == Material.plants
						|| block.blockMaterial == Material.vine
						|| block.blockMaterial == Material.iron
						|| block.blockMaterial == Material.anvil || block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial
				: super.getStrVsBlock(itemstack, block);
	}

	public boolean canHarvestBlock(Block par1Block, ItemStack itemStack) {
		return this.canHarvestBlock(par1Block);
	}

	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	public boolean canHarvestBlock(Block par1Block) {
		return true;
	}

}
