package moreofeverything.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VerbalBlockSlab extends BlockHalfSlab
{

	public VerbalBlockSlab(int id, boolean isDoubleSlab)
	{
		super(id, isDoubleSlab, Material.iron);
		useNeighborBrightness[this.blockID] = true;
		if(isDoubleSlab)
		{
			this.setUnlocalizedName(Names.VerbalBlockDoubleSlab_unlocalizedName);
		}
		else
		{
			this.setUnlocalizedName(Names.VerbalBlockSlab_unlocalizedName);
			this.setCreativeTab(moreofeverything.moreofeverything);
		}
		this.setHardness(2F);
		this.setResistance(15F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setLightValue(0.5F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	// This is the constant that allows for Single Icon.
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Verbalblock_unlocalizedName);
	}
	
	public int idDropped(int id, Random rand, int meta)
	{
		return Blocks.verbalBlockSingleSlab.blockID;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving player) 
	{
		if (world.getBlockId(x, y - 1, z) == Blocks.verbalBlockSingleSlab.blockID) 
		{
			world.setBlock(x, y, z, 0);
			world.setBlock(x, y - 1, z, Blocks.verbalBlockDoubleSlab.blockID);
		}
		if (world.getBlockId(x, y + 1, z) == Blocks.verbalBlockSingleSlab.blockID) 
		{
			world.setBlock(x, y, z, 0);
			world.setBlock(x, y + 1, z, Blocks.verbalBlockDoubleSlab.blockID);
		}
	}
	
	public static boolean isBlockSingleSlab(int id)
	{
		return id == Blocks.verbalBlockSingleSlab.blockID;
	}
	
	public int idPicked(World world, int x, int y, int z)
	{
		return isBlockSingleSlab(this.blockID) ? 
				this.blockID : (this.blockID == Blocks.verbalBlockDoubleSlab.blockID ? 
				Blocks.verbalBlockSingleSlab.blockID : Blocks.verbalBlockSingleSlab.blockID);
	}
	
	protected ItemStack createStackedBlock(int id) 
	{
		return new ItemStack(Blocks.verbalBlockSingleSlab, 2, id & 7);
	}

	@Override
	public String getFullSlabName(int id)
	{
		if(id < 0)
		{
			id = 0;
		}
		return super.getUnlocalizedName();
	}

}
