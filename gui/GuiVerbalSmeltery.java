package moreofeverything.gui;

import moreofeverything.tileentity.TileEntityVerbalSmeltery;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.I18n;

public class GuiVerbalSmeltery extends GuiContainer{
	
	public static final ResourceLocation texture = new ResourceLocation(moreofeverything.lib.ModInfo.ID, "textures/gui/verbal_smeltery.png");
	
	public TileEntityVerbalSmeltery verbalSmeltery;

	public GuiVerbalSmeltery(InventoryPlayer inventoryPlayer, TileEntityVerbalSmeltery entity) {
		super(new ContainerVerbalSmeltery(inventoryPlayer, entity));
		
		this.verbalSmeltery = entity;
		
		this.xSize = 176;
		this.ySize = 166;

	}

	
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.verbalSmeltery.isInvNameLocalized() ? this.verbalSmeltery.getInvName() : I18n.getString(this.verbalSmeltery.getInvName());
		
		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
		this.fontRenderer.drawString(I18n.getString("container"), 0, this.ySize - 96 + 2, 4);
		
	}
	
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		
	}

}
