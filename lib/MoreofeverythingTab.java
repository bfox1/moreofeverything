package moreofeverything.lib;

import moreofeverything.items.Items;
import net.minecraft.creativetab.CreativeTabs;

public class MoreofeverythingTab extends CreativeTabs {

	public MoreofeverythingTab(int id, String name) {
		super(id, name);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Items.verbal.itemID;
		
	}
	
	

}
