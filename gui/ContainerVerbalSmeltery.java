package moreofeverything.gui;

import moreofeverything.tileentity.TileEntityVerbalSmeltery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

public class ContainerVerbalSmeltery extends Container {
	
	private TileEntityVerbalSmeltery verbalSmeltery;

	public ContainerVerbalSmeltery(InventoryPlayer inventory, TileEntityVerbalSmeltery entity) {
		this.verbalSmeltery = entity;
		
		this.addSlotToContainer(new Slot(entity, 0, 56, 17));
		this.addSlotToContainer(new Slot(entity, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, entity, 2, 116, 35));
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8+j*18, 84 + i*18));
			}
		}
		
		for(int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

}
