package moreofeverything.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import moreofeverything.items.tools.Omnitool;
import moreofeverything.items.tools.Scepter;
import moreofeverything.items.tools.Scikaleaxe;
import moreofeverything.items.tools.Scikaleblade;
import moreofeverything.items.tools.Scikalehoe;
import moreofeverything.items.tools.Scikalepickaxe;
import moreofeverything.items.tools.Scikaleshovel;
import moreofeverything.items.tools.Verbalaxe;
import moreofeverything.items.tools.Verbalhoe;
import moreofeverything.items.tools.Verbalpickaxe;
import moreofeverything.items.tools.Verbalshovel;
import moreofeverything.items.tools.Verbalsword;
import moreofeverything.lib.config.Booleans;
import moreofeverything.lib.config.Names;
import moreofeverything.lib.config.ids;
import cpw.mods.fml.common.registry.LanguageRegistry;
import moreofeverything.items.tools.Enumtoolmofe;

public class Items {
		//Items
	public static Item verbal;
	public static Item Infusedverbal;
	public static Item Infusedstick;
	public static Item Infusedingot;
	public static Item Scikaleingot;
		//Materials
	public static EnumToolMaterial toolMaterialVoid;
		//Tools
	public static Item Omnitool;
	public static Item scepter;
	public static Item verbalsword;
	public static Item verbalpickaxe;
	public static Item verbalaxe;
	public static Item verbalshovel;
	public static Item verbalhoe;
	
	public static Item Scikaleblade;
	public static Item Scikalepickaxe;
	public static Item Scikaleaxe;
	public static Item Scikaleshovel;
	public static Item Scikalehoe;
	
	


	/**
	 * This adds the Item to the mod. Hooks into moreofeverything
	 */
	public static void init() {
			//Items
		verbal = new Verbal(ids.verbal_actual);
		Infusedverbal = new Infusedverbal(ids.infusedverbal_actual);
		Infusedstick = new Infusedstick(ids.infusedstick_actual);
		Infusedingot = new Infusedingot(ids.infusedingot_actual);
		Scikaleingot = new Scikaleingot(ids.scikaleingot_actual);

		
			//LEAVE COMMENT BELOW ALONE	
		/*
		 * meta = new MoeMetaItem(ids.MoeMetaItem_actual);
		 */
		
			//Tools
		scepter = new Scepter(ids.Scepter_actual);
		verbalsword = new Verbalsword(ids.verbalsword_actual, Enumtoolmofe.toolMaterialVerbal);
		verbalpickaxe = new Verbalpickaxe(ids.verbalpickaxe_actual, Enumtoolmofe.toolMaterialVerbal);
		verbalaxe = new Verbalaxe(ids.verbalaxe_actual, Enumtoolmofe.toolMaterialVerbal);
		verbalshovel = new Verbalshovel(ids.verbalshovel_actual, Enumtoolmofe.toolMaterialVerbal);
		verbalhoe = new Verbalhoe(ids.verbalhoe_actual, Enumtoolmofe.toolMaterialVerbal);
		
		Scikaleblade = new Scikaleblade(ids.scikaleblade_actual, Enumtoolmofe.toolMaterialScikale);
		Scikalepickaxe = new Scikalepickaxe(ids.scikalepickaxe_actual, Enumtoolmofe.toolMaterialScikale);
		Scikaleaxe = new Scikaleaxe(ids.scikaleaxe_actual, Enumtoolmofe.toolMaterialScikale);
		Scikaleshovel= new Scikaleshovel(ids.scikaleshovel_actual, Enumtoolmofe.toolMaterialScikale);
		Scikalehoe = new Scikalehoe(ids.scikalehoe_actual, Enumtoolmofe.toolMaterialScikale);
		
		if (Booleans.enableTool) {
			Omnitool = new Omnitool(ids.omnitool_actual,
					Enumtoolmofe.toolMaterialVerbal);
		}
		

		
	}

	// This adds the name of the item which hooks into Names.
	public static void addNames() {
			//Items
		LanguageRegistry.addName(verbal, Names.Verbal_name);
		LanguageRegistry.addName(Infusedverbal, Names.Infusedverbal_name);
		LanguageRegistry.addName(Infusedstick, Names.Infusedstick_name);
		LanguageRegistry.addName(Infusedingot, Names.Infusedingot_name);
		LanguageRegistry.addName(Scikaleingot, Names.Scikaleingot_name);
			//Tools
		LanguageRegistry.addName(scepter, Names.Scepter_name);
		LanguageRegistry.addName(verbalsword, Names.Verbalsword_name);
		LanguageRegistry.addName(verbalpickaxe, Names.Verbalpickaxe_name);
		LanguageRegistry.addName(verbalaxe, Names.Verbalaxe_name);
		LanguageRegistry.addName(verbalshovel, Names.Verbalshovel_name);
		LanguageRegistry.addName(verbalhoe, Names.Verbalhoe_name);
		if (Booleans.enableTool) {
			LanguageRegistry.addName(Omnitool, Names.Omnitool_name);
		}
		//DO NOT TOUCH THE COMMENT BELOW
		/**
		for (int i = 0; i < Names.MoeMetaItem_name.length; i++) {
			LanguageRegistry.addName(new ItemStack(meta, 1, i),
					Names.MoeMetaItem_name[i]);
		}
		*/
	}
}