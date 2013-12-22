package moreofeverything.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;

public class Omnitool extends ItemOmniTool {

	public Omnitool(int id, EnumToolMaterial material) {
		super(id, material);
		setUnlocalizedName(Names.Omnitool_unlocalizedName);
		setCreativeTab(moreofeverything.moreofeverythingTools);
		setMaxStackSize(1);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Omnitool_unlocalizedName);
	}

}
