package moreofeverything.gui;

import moreofeverything.tileentity.TileEntityVerbalSmeltery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(
				moreofeverything.blocks.Blocks.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case moreofeverything.blocks.Blocks.guiIdVerbalsmeltery:
				if(entity instanceof TileEntityVerbalSmeltery){
					//return new ContainerVerbalSmeltery(player.inventory, (TileEntityVerbalSmeltery) entity);
				}
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case moreofeverything.blocks.Blocks.guiIdVerbalsmeltery:
				if(entity instanceof TileEntityVerbalSmeltery){
					return new GuiVerbalSmeltery(player.inventory, (TileEntityVerbalSmeltery) entity);
				}
			}
		}
		
		return null;
	}

}
