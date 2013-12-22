package moreofeverything.blocks.compressed;

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

public class Verbalblock extends Block {
	public Verbalblock(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Names.Verbalblock_unlocalizedName);
		this.setCreativeTab(moreofeverything.moreofeverything);
		this.setHardness(2F);
		this.setResistance(15F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.5F);
	}

	/**
	 * These are ONLY for use for Multiple Icons
	 */
	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.Verbalblock_unlocalizedName);}
	/**
	 * This is the constant that allows for Single Icon.
	 * 	public void registerIcons(IconRegister icon) {blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.Verbalblock_unlocalizedName);}
	 */
	/**
	public void registerIcons(IconRegister icon) {
		topIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Verbalblock_unlocalizedName + "_top");
		bottomIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Verbalblock_unlocalizedName + "_bottom");
		sideIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Verbalblock_unlocalizedName + "_side");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(side == 0) {
			return bottomIcon;
		} else if(side == 1) {
			return topIcon;
		} else {
			return sideIcon;
		}
	}
	*/
}