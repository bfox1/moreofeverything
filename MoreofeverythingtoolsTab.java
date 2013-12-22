package moreofeverything;

import moreofeverything.items.Items;
import net.minecraft.creativetab.CreativeTabs;

public class MoreofeverythingtoolsTab extends CreativeTabs {

	public MoreofeverythingtoolsTab(int id, String name) {
		super(id, name);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Items.Omnitool.itemID;
		
	}
	
	

}

