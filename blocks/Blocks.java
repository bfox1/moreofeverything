package moreofeverything.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import moreofeverything.blocks.compressed.Verbalblock;
import moreofeverything.blocks.Verbalbrick;
import moreofeverything.lib.config.Names;
import moreofeverything.lib.config.ids;

public class Blocks {
	
		//Basic blocks
	public static Block verbalblock;
	public static Block verbalbrick;
		//Ore Blocks
	public static Block verbalore;
	
		//Special Block 
	public static Block verbalfurnaceIdle;
	public static Block verbalfurnaceActive;

	public static void init() {
		
			//Basic block registration
		verbalblock = new Verbalblock(ids.verbalblock_actual);
		GameRegistry.registerBlock(verbalblock, Names.Verbalblock_name);
		
		verbalbrick = new Verbalbrick(ids.verbalbrick_actual);
		GameRegistry.registerBlock(verbalbrick, Names.Verbalbrick_name);
		
			//Ore block registration
		verbalore = new Verbalore(ids.verbalore_actual);
		GameRegistry.registerBlock(verbalore, Names.Verbalore_name);
		
			//Special block registration
		
		//verbalfurnaceIdle = new verbalfurnace(ids.verbalfurnaceIdle_actual, false).setUnlocalizedName(Names.verbalfurnaceIdle_unlocalizedName).setHardness(3.5F);
		//GameRegistry.registerBlock(verbalfurnaceIdle, Names.verbalfurnaceIdle_name);
		//verbalfurnaceActive = new verbalfurnace(ids.verbalfurnaceActive_actual, true).setUnlocalizedName(Names.verbalfurnaceActive_unlocalizedName).setHardness(3.5F).setLightValue(0.9F);
		//GameRegistry.registerBlock(verbalfurnaceActive, Names.verbalfurnaceActive_name);

		
	}

	public static void addNames() {
			//Basic block Name registration
		LanguageRegistry.addName(verbalblock, Names.Verbalblock_name);
		LanguageRegistry.addName(verbalbrick, Names.Verbalbrick_name);
			//Ore block Name registration
		LanguageRegistry.addName(verbalore, Names.Verbalore_name);
			//Special block Name registration
		//LanguageRegistry.addName(verbalfurnaceIdle, Names.verbalfurnaceIdle_name);
		//LanguageRegistry.addName(verbalfurnaceActive, Names.verbalfurnaceActive_name);
	}
	
	public static void addHarvestLevel() {
			
		MinecraftForge.setBlockHarvestLevel(verbalblock, "pickaxe", 3); //wood=0, stone=1, iron=2 diamond=3
		MinecraftForge.setBlockHarvestLevel(verbalbrick, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(verbalore, "pickaxe", 3);
	}

}