package moreofeverything.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.tileentity.TileEntityVerbalSmeltery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerVerbalSmeltery extends Container {
	
	private TileEntityVerbalSmeltery verbalSmeltery;

	public int lastBurnTime;
	
	public int lastItemBurnTime;
	
	public int lastCookTime;
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
	
	public void addCraftingToCrafters(ICrafting icrafting)
	{
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.verbalSmeltery.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.verbalSmeltery.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.verbalSmeltery.currentItemBurnTime);

	}
	
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue)
	{
		if(slot == 0) this.verbalSmeltery.cookTime = newValue;
		if(slot == 1) this.verbalSmeltery.burnTime = newValue;
		if(slot == 2) this.verbalSmeltery.currentItemBurnTime = newValue;
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		return null;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.verbalSmeltery.isUseableByPlayer(entityplayer);
	}

}
