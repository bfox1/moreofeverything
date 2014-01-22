package moreofeverything.blocks;

import java.util.Random;

import moreofeverything.moreofeverything;
import moreofeverything.items.Items;
import moreofeverything.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class valeriumOre extends Block {

	public valeriumOre(int id) {
		super(id,  Material.rock);
		this.setUnlocalizedName(Names.valeriumore_name);
		this.setCreativeTab(moreofeverything.moreofeverything);
		this.setHardness(5.0F);
		this.setResistance(5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.5F);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Items.verbal.itemID;
	}

}
