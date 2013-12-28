package moreofeverything.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);

		// To categories the configs
		final String BOOLEANS = config.CATEGORY_GENERAL
				+ config.CATEGORY_SPLITTER + "booleans";

		config.load();

		// BlocksConfig
		ids.verbalblock_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.Verbalblock_name, ids.verbalblock_defualt).getInt();
		
		ids.marbleblock_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.marbleblock_name, ids.marbleblock_default).getInt();

		ids.verbalbrick_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.Verbalbrick_name, ids.verbalbrick_default).getInt();
		
		ids.marblebrick_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.marblebrick_name, ids.marblebrick_default).getInt();
		
		ids.verbalBrickSlab_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.VerbalbrickSlab_name, ids.verbalBrickSlab_default).getInt();
		
		ids.verbalBrickDoubleSlab_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.VerbalbrickDoubleSlab_name, ids.verbalBrickDoubleSlab_default).getInt();
		
		ids.verbalBlockSlab_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.VerbalBlockSlab_name, ids.verbalBlockSlab_default).getInt();
		
		ids.verbalBlockDoubleSlab_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.VerbalBlockDoubleSlab_name, ids.verbalBlockDoubleSlab_default).getInt();

		ids.verbalore_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.Verbalore_name, ids.verbalore_default).getInt();
		
		ids.scikaleore_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.Scikaleore_name, ids.scikaleore_default).getInt();
		
		ids.scikaleoreglowing_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.Scikaleoreglowing_name, ids.scikaleoreglowing_default).getInt();
		
		ids.verbalsmelteryIdle_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.verbalsmelteryIdle_name, ids.verbalsmelteryIdle_default).getInt();
		
		ids.verbalsmelteryActive_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.verbalsmelteryActive_name, ids.verbalsmelteryActive_default).getInt();

		ids.verbalore_actual = config.getBlock(config.CATEGORY_BLOCK,
				Names.Verbalore_name, ids.verbalore_default).getInt();

		// ItemsConfig
		ids.verbal_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Verbal_name, ids.verbal_default).getInt() - 256;
		ids.infusedstick_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Infusedstick_name, ids.infusedstick_default).getInt() - 256;
		ids.infusedverbal_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Infusedverbal_name, ids.infusedverbal_default).getInt() - 256;
		
		ids.scikaleingot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Scikaleingot_name, ids.scikaleingot_default).getInt() - 256;
		
		ids.infusedingot_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Infusedingot_name, ids.infusedingot_default).getInt() - 256;
		
			//ItemsConfig for Tools
		ids.omnitool_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Omnitool_name, ids.omnitool_default).getInt() - 256;

		ids.Scepter_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Scepter_name, ids.Scepter_default).getInt() - 256;

		ids.verbalsword_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Verbalsword_name, ids.verbalsword_default).getInt() - 256;

		ids.verbalpickaxe_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Verbalpickaxe_name, ids.verbalpickaxe_default).getInt() - 256;

		ids.verbalaxe_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Verbalaxe_name, ids.verbalaxe_default).getInt() - 256;

		ids.verbalshovel_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Verbalshovel_name, ids.verbalshovel_default).getInt() - 256;

		ids.verbalhoe_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Verbalhoe_name, ids.verbalhoe_default).getInt() - 256;
		
		ids.scikaleblade_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Scikaleblade_name, ids.scikaleblade_default).getInt() - 256;
		
		ids.scikalepickaxe_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Scikalepickaxe_name, ids.scikalepickaxe_default).getInt() - 256;
		
		ids.scikaleaxe_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Scikaleaxe_name, ids.scikaleaxe_default).getInt() - 256;
		
		ids.scikaleshovel_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Scikaleshovel_name, ids.scikaleshovel_default).getInt() - 256;
		
		ids.scikalehoe_actual = config.getItem(config.CATEGORY_ITEM,
				Names.Scikalehoe_name, ids.scikalehoe_default).getInt() - 256;
		
		ids.unknown_actaul = config.getItem(config.CATEGORY_ITEM,
				Names.unknown_name, ids.unknown_default).getInt() - 256;

		// To add these Boolean values into the config
		Booleans.enableTool = config.get(BOOLEANS, Booleans.enableTool_name,
				Booleans.enableTool_default).getBoolean(
				Booleans.enableTool_default);

		Booleans.hardRecipe = config.get(BOOLEANS, Booleans.hardRecipe_name,
				Booleans.hardRecipe_default).getBoolean(
				Booleans.hardRecipe_default);
		config.save();

	}
	/*
	 * ids.MoeMetaItem_actual = config.getItem(config.CATEGORY_ITEM,
	 * Names.MoeMetaItem, ids.MoeMetaItem_default).getInt() - 256;
	 */

}
