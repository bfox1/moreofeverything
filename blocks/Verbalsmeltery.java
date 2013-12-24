package moreofeverything.blocks;

import java.util.Random;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import moreofeverything.lib.config.ids;
import moreofeverything.tileentity.TileEntityVerbalSmeltery;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Verbalsmeltery extends BlockContainer {

	private final boolean isActive;

	@SideOnly(Side.CLIENT)
	private Icon iconFront;

	public Verbalsmeltery(int id, boolean isActive) {
		super(id, Material.rock);

		this.isActive = isActive;

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase()
				+ ":" + "Verbal_furnace_side");
		this.iconFront = iconRegister.registerIcon(ModInfo.ID.toLowerCase()
				+ ":" + (this.isActive ? "Verbal_furnace_front" : "Verbal_furnace_front"));
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata){
		return side == metadata ?  this.iconFront : this.blockIcon;
	}
	
	public int idDropped(int par1, Random random, int par3){
		return Blocks.verbalsmelteryIdle.blockID;
	}
	
	public void onBlockAdded(World world,int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
		
	}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if(!world.isRemote){
			int l = world.getBlockId(x, y, z - 1);
			int il = world.getBlockId(x, y, z + 1);
			int jl = world.getBlockId(x - 1, y, z);
			int kl = world.getBlockId(x + 1, y, z);
			
		byte b0 = 3;
		
			if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[il]){
				b0 = 3;
			}
			if(Block.opaqueCubeLookup[il] && !Block.opaqueCubeLookup[l]){
				b0 = 2;
			}
			if(Block.opaqueCubeLookup[kl] && !Block.opaqueCubeLookup[jl]){
				b0 = 5;
			}
			if(Block.opaqueCubeLookup[jl] && !Block.opaqueCubeLookup[kl]){
				b0 = 4;
			}
			
		
		world.setBlockMetadataWithNotify(x, y, z, b0, 2);
	}
	}
	public boolean onBlockActivate(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, moreofeverything.blocks.Blocks.instance, moreofeverything.blocks.Blocks.guiIdVerbalsmeltery, world, x, y, z);
		}
		
		return true;
	}
	public TileEntity createNewTileEntity(World world){
		return new TileEntityVerbalSmeltery();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack){
		int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(l == 0){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if(l == 1){
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
			
		}
		
		if(l == 2){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
			
		}
		
		if(l == 3){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
			
		}
		if(itemstack.hasDisplayName()) {
			((TileEntityVerbalSmeltery)world.getBlockTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
		}
		
	}

	public static void updateVerbalSmelteryBlockState(boolean b, World worldObj,
			int xCoord, int yCoord, int zCoord) {
		// TODO Auto-generated method stub
		
	}
}
	

