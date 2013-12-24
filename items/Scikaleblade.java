package moreofeverything.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class Scikaleblade extends ItemSword {

	public Scikaleblade(int id, EnumToolMaterial toolmaterial) {
		super(id, toolmaterial);
		this.setCreativeTab(moreofeverything.moreofeverythingTools);
		setMaxStackSize(1);
		this.setUnlocalizedName(Names.Scikaleblade_unlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Scikaleblade_unlocalizedName);

}

}
