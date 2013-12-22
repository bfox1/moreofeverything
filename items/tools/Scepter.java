package moreofeverything.items.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreofeverything.moreofeverything;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Scepter extends Item {

	public Scepter(int id) {
		super(id);
		this.setCreativeTab(moreofeverything.moreofeverythingTools);
		setMaxStackSize(1);
		this.setUnlocalizedName(Names.Scepter_unlocalizedName);
		
		
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target){
		if(!target.worldObj.isRemote) {
			if(!(target instanceof EntityPlayer)) {
			target.motionY = 2.5;
			} else {
			player.addChatMessage("This Item only works on Mobs!");
			}
		
		
		}
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
			
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ Names.Scepter_unlocalizedName);
	}

}
