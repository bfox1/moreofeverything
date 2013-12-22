package moreofeverything.items;

import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.util.Icon;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import moreofeverything.lib.MoreofeverythingTab;

public class Verbal extends Item {
	/**
	 * 
	 * This is to add the Item into Minecraft.
	 */
	public Verbal(int id) {
		super(id);
		this.setCreativeTab(moreofeverything.moreofeverything);
		setMaxStackSize(64);
		this.setUnlocalizedName(Names.Verbal_unlocalizedName);

	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Verbal_unlocalizedName);
	}
	
	
}