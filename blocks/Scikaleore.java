package moreofeverything.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.items.Items;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class Scikaleore extends Block {

	public Scikaleore(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Names.Scikaleore_unlocalizedName);
		this.setCreativeTab(moreofeverything.moreofeverything);
		this.setHardness(2F);
		this.setResistance(5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.1F);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Blocks.scikaleore.blockID;
	}



	// public int idDropped(int metadata, Random random, int fortune) {
	// return Items.verbal.itemID;
	// }

	@Override
	@SideOnly(Side.CLIENT)
	// This is the constant that allows for Single Icon.
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Scikaleore_unlocalizedName);

	}

}
