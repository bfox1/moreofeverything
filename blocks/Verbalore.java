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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Verbalore extends Block {
	public Verbalore(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Names.Verbalore_unlocalizedName);
		this.setCreativeTab(moreofeverything.moreofeverything);
		this.setHardness(4.0F);
		this.setResistance(5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.5F);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Items.verbal.itemID;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 1 + par1Random.nextInt(3);
	}

	// public int idDropped(int metadata, Random random, int fortune) {
	// return Items.verbal.itemID;
	// }

	@Override
	@SideOnly(Side.CLIENT)
	// This is the constant that allows for Single Icon.
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Verbalore_unlocalizedName);

	}
}
