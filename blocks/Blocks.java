package moreofeverything.blocks;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import moreofeverything.moreofeverything;
import moreofeverything.blocks.compressed.Verbalblock;
import moreofeverything.blocks.Verbalbrick;
import moreofeverything.gui.GuiHandler;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import moreofeverything.lib.config.ids;
import moreofeverything.tileentity.TileEntityVerbalSmeltery;

public class Blocks {
	/**
	 * This line of code below relates to VerbalSmeltery and all its sub classes.
	 */
	@Instance(ModInfo.ID)
	public static moreofeverything instance;
	
	public static final int guiIdVerbalsmeltery = 0;
	

		//Basic blocks
	public static Block verbalblock;
	public static Block verbalbrick;
		//Ore Blocks
	public static Block verbalore;
	
		//Special Block 
	public static Block verbalsmelteryIdle;
	public static Block verbalsmelteryActive;

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
		
		verbalsmelteryIdle = new Verbalsmeltery(ids.verbalsmelteryIdle_actual, false).setUnlocalizedName(Names.verbalsmelteryIdle_unlocalizedName).setHardness(3.5F);
		GameRegistry.registerBlock(verbalsmelteryIdle, Names.verbalsmelteryIdle_name);
		verbalsmelteryActive = new Verbalsmeltery(ids.verbalsmelteryActive_actual, true).setUnlocalizedName(Names.verbalsmelteryActive_unlocalizedName).setHardness(3.5F).setLightValue(0.9F);
		GameRegistry.registerBlock(verbalsmelteryActive, Names.verbalsmelteryActive_name);
		GameRegistry.registerTileEntity(TileEntityVerbalSmeltery.class, Names.Verbal_name);

		
	}

	public static void addNames() {
			//Basic block Name registration
		LanguageRegistry.addName(verbalblock, Names.Verbalblock_name);
		LanguageRegistry.addName(verbalbrick, Names.Verbalbrick_name);
			//Ore block Name registration
		LanguageRegistry.addName(verbalore, Names.Verbalore_name);
			//Special block Name registration
		LanguageRegistry.addName(verbalsmelteryIdle, Names.verbalsmelteryIdle_name);
		LanguageRegistry.addName(verbalsmelteryActive, Names.verbalsmelteryActive_name);
		//This is for the GuiHandler
		LanguageRegistry.instance().addStringLocalization("container.verbalSmeltery", "Verbal Smeltery");
		new GuiHandler();
	}
	
	public static void addHarvestLevel() {
			
		MinecraftForge.setBlockHarvestLevel(verbalblock, "pickaxe", 3); //wood=0, stone=1, iron=2 diamond=3
		MinecraftForge.setBlockHarvestLevel(verbalbrick, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(verbalore, "pickaxe", 3);
	}

}