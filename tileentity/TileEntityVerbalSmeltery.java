package moreofeverything.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import moreofeverything.blocks.Verbalsmeltery;
import moreofeverything.items.Items;
import moreofeverything.lib.config.ids;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVerbalSmeltery extends TileEntity implements ISidedInventory {

		private String localizedName;
		
		private static final int[] slots_top = new int[]{0};
		private static final int[] slots_bottom = new int[]{2};
		private static final int[] slots_sides = new int[]{1};
		
		private ItemStack[] slots = new ItemStack[3];
		
		public int smelterySpeed = 50;
		
		
			//Time left for smeltery to burn for
		public int burnTime;
			// TIme start time for this fuel
		public int currentItemBurnTime;
			//How long time left before cooked
		public int cookTime;
		
		public int getSizeInventory(){
			return this.slots.length;
		}
	
		
		public String getInvName(){
			return this.isInvNameLocalized() ? this.localizedName : "container.verbalSmeltery";
		}
		
		public boolean isInvNameLocalized(){
			return this.localizedName != null && this.localizedName.length() > 0;
		}
		
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
		
	}

	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	public ItemStack decrStackSize(int i, int j) {
		if(this.slots[i] != null)
		{
			ItemStack itemstack;
				if(this.slots[i].stackSize <= j)
				{
					itemstack = this.slots[i];
					
					this.slots[i] = null;
					
					return itemstack;
				}else{
					itemstack = this.slots[i].splitStack(j);
				}
		}
		return null;
	}

	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	public void setInventorySlotContents(int i, ItemStack itemstack) {
		
	}

	public int getInventoryStackLimit() {
		return 0;
	}

	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return false;
	}

	public void openChest() {
		
	}

	public void closeChest() {
		
	}
	public void updateEntity()
	{
	boolean flag = false;
	boolean flag1 = false;
	
		if(this.burnTime > 0)
		{
			this.burnTime--;
		}
		if(!this.worldObj.isRemote)
		{
			//Probably call canSmelt() on the item being passed in to this method.
			if(this.burnTime == 0 && this.canSmelt())
			{
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				
				
				
				if(this.burnTime > 0)
				{
					flag1 = true;
					if(this.slots[1] != null)
					{
						this.slots[1].stackSize--;
						
						if(this.slots[1].stackSize == 0)
						{
							this.slots[1] = this.slots[1].getItem().getContainerItemStack(this.slots[1]);
						}
					}
				}
				if(this.isBurning() && this.canSmelt())
				{
					this.cookTime++;
					if(this.cookTime == this.smelterySpeed)
					{
						this.cookTime = 0;
						this.smeltItem();
						flag1 = true;
					}
				}
				else
				{
					this.cookTime = 0;
				}
				if(flag != this.burnTime > 0)
				{
					Verbalsmeltery.updateVerbalSmelteryBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
				}
			}
		}
	}
	
	public void smeltItem()
	{
		if(this.canSmelt())
		{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(this.slots[2] == null)
			{
				this.slots[2] = itemstack.copy();
			}else if(this.slots[2].isItemEqual(itemstack))
			{
				this.slots[2].stackSize += itemstack.stackSize;
			}
			
			this.slots[0].stackSize--;
			
			if(this.slots[0].stackSize <= 0)
			{
				this.slots[0] = null;
			}
		}
	}
	
	public boolean isBurning()
	{
		return cookTime > 0;
	}
	
	private boolean canSmelt()
	{
		if(this.slots[0] == null)
		{
			return false;
		}else{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(itemstack == null) return false;
			if(this.slots[2] == null) return true;
			if(!this.slots[2].isItemEqual(itemstack)) return false;
			
			int result = this.slots[2].stackSize + itemstack.stackSize;
			
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}
	
	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			
			int i = itemstack.getItem().itemID;
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.blocksList[i] != null){
				Block block = Block.blocksList[i];
				
				if(block == Block.woodSingleSlab){
					return 160;
				}
				if(block.blockMaterial == Material.wood){
					return 300;
				}
				if(block == Block.coalBlock){
					return 16000;
				}
			}
			
			if(item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
			if(item instanceof ItemTool && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
			if(item instanceof ItemTool && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;


			if(i == Item.stick.itemID) return 100;
			if(i == Item.coal.itemID) return 1600;
			if(i == Item.bucketLava.itemID) return 20000; 
			if(i == Block.sapling.blockID) return 100;
			if(i == Item.blazeRod.itemID) return 2400;
				//Want own fuel
			if(i == Items.Infusedverbal.itemID) return 3200;


			return GameRegistry.getFuelValue(itemstack);
		}
	}
	
	public static boolean isItemFuel(ItemStack itemstack) {
		return getItemBurnTime(itemstack) > 0 && itemstack.itemID == Items.Infusedstick.itemID;
	}

	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 2 ? false : (i == 1 ? isItemFuel(itemstack) : true);
	}

	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_sides);
	}

	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
		//return this.isItemValidForSlot(i,  itemstack) && itemstack.itemID == Items.Infusedstick.itemID;
	}

	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.itemID == Item.bucketEmpty.itemID;
	}

}
