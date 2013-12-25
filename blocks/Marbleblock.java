package moreofeverything.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class Marbleblock extends Block {

	public Marbleblock(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Names.marbleblock_unlocalizedName);
		this.setCreativeTab(moreofeverything.moreofeverything);
		this.setHardness(2F);
		this.setResistance(15F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.5F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.marbleblock_unlocalizedName);}
	

	}


