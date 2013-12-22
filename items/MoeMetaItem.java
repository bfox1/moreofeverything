package moreofeverything.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class MoeMetaItem extends Item {
	
	public MoeMetaItem(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		//If it has subtypes as in meta value, add this
		setHasSubtypes(true);
		
	}
		//This is telling it that it has more than 1 value
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return Names.MoeMetaItm_unlocalizedName[itemstack.getItemDamage()];
	}
	
	@SideOnly(Side.CLIENT)
	public static Icon[] icons;
		//This is giving the icons of the 3 meta data items
	private static final String[] ICON = {
		"MoeMeta1",
		"MoeMeta2",
		"MoeMeta3"
	};
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return icons[damage];
	}
		
		//This is doing calcualations for the datas
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		icons = new Icon[ICON.length];
		
		for(int i =0; i < icons.length; i++) {
			icons[i] = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + ICON[i]);
		}
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < icons.length; i++) {
			ItemStack itemstack = new ItemStack(id, 1, i);
			list.add(itemstack);
		}
	}

}
