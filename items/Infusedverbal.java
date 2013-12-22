package moreofeverything.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class Infusedverbal extends Item {

	public Infusedverbal(int id) {
		super(id);
		this.setCreativeTab(moreofeverything.moreofeverything);
		setMaxStackSize(64);
		this.setUnlocalizedName(Names.Infusedverbal_unlocalizedName);

	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Infusedverbal_unlocalizedName);
	}
	
	
}
