package moreofeverything.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.items.tools.ItemOmniTool;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;

public class Unknowntool extends ItemOmniTool {

	public Unknowntool(int id, EnumToolMaterial material) {
		super(id, material);
		setUnlocalizedName(Names.unknown_unlocalizedName);
		setCreativeTab(moreofeverything.moreofeverythingTools);
		setMaxStackSize(1);


}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.unknown_unlocalizedName);
	}

}
