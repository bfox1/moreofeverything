package moreofeverything.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class Verbalbrick extends Block {
	public Verbalbrick(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Names.Verbalbrick_unlocalizedName);
		this.setCreativeTab(moreofeverything.moreofeverything);
		this.setHardness(2F);
		this.setResistance(15F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.5F);
	}

	/**
	 * These are ONLY for use for Multiple Icons
	 */

	@Override
	@SideOnly(Side.CLIENT)
	// This is the constant that allows for Single Icon.
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Verbalbrick_unlocalizedName);
	}

}