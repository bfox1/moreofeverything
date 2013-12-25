package moreofeverything.blocks;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.common.MinecraftForge;
import moreofeverything.blocks.compressed.Verbalblock;
import moreofeverything.blocks.Verbalbrick;
import moreofeverything.gui.GuiHandler;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.config.Names;
import moreofeverything.lib.config.ids;
import moreofeverything.moreofeverything;
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
	
		//Half-slabs
	public static Block verbalBrickSingleSlab;
	public static Block verbalBrickDoubleSlab;
	
	public static Block verbalBlockSingleSlab;
	public static Block verbalBlockDoubleSlab;
	
		//Ore Blocks
	public static Block verbalore;
	public static Block scikaleore;
	public static Block scikaleoreglowing;
	
		//Special Block 
	public static Block verbalsmelteryIdle;
	public static Block verbalsmelteryActive;
	
	public static void init() {
		
			//Basic block registration
		verbalblock = new Verbalblock(ids.verbalblock_actual);
		GameRegistry.registerBlock(verbalblock, Names.Verbalblock_name);
		
		verbalbrick = new Verbalbrick(ids.verbalbrick_actual);
		GameRegistry.registerBlock(verbalbrick, Names.Verbalbrick_name);
		
			//Half-slab Block registration
		verbalBrickSingleSlab = new VerbalBrickSlab(ids.verbalBrickSlab_actual, false);
		GameRegistry.registerBlock(verbalBrickSingleSlab, Names.VerbalbrickSlab_name);
		
		verbalBrickDoubleSlab = new VerbalBrickSlab(ids.verbalBrickDoubleSlab_actual, true);
		GameRegistry.registerBlock(verbalBrickDoubleSlab, Names.VerbalbrickDoubleSlab_name);
		
		verbalBlockSingleSlab = new VerbalBlockSlab(ids.verbalBlockSlab_actual, false);
		GameRegistry.registerBlock(verbalBlockSingleSlab, Names.VerbalBlockSlab_name);
		
		verbalBlockDoubleSlab = new VerbalBlockSlab(ids.verbalBlockDoubleSlab_actual, true);
		GameRegistry.registerBlock(verbalBlockDoubleSlab, Names.VerbalBlockDoubleSlab_name);
		
			//Ore block registration
		verbalore = new Verbalore(ids.verbalore_actual);
		GameRegistry.registerBlock(verbalore, Names.Verbalore_name);
		
		scikaleore = new Scikaleore(ids.scikaleore_actual, false).setCreativeTab(moreofeverything.moreofeverything);;
		GameRegistry.registerBlock(scikaleore, Names.Scikaleore_name);
		
		scikaleoreglowing = new Scikaleore(ids.scikaleoreglowing_actual, true).setLightValue(0.7F);
		GameRegistry.registerBlock(scikaleoreglowing, Names.Scikaleoreglowing_name);
		
			//Special block registration
		
		verbalsmelteryIdle = new Verbalsmeltery(ids.verbalsmelteryIdle_actual, false).setUnlocalizedName(Names.verbalsmelteryIdle_unlocalizedName).setHardness(3.5F);
		GameRegistry.registerBlock(verbalsmelteryIdle, Names.verbalsmelteryIdle_name);
		verbalsmelteryActive = new Verbalsmeltery(ids.verbalsmelteryActive_actual, true).setUnlocalizedName(Names.verbalsmelteryActive_unlocalizedName).setHardness(3.5F).setLightValue(0.9F);
		GameRegistry.registerBlock(verbalsmelteryActive, Names.verbalsmelteryActive_name);
		GameRegistry.registerTileEntity(TileEntityVerbalSmeltery.class, Names.verbalsmelteryIdle_name);

		
	}

	public static void addNames() {
			//Basic block Name registration
		LanguageRegistry.addName(verbalblock, Names.Verbalblock_name);
		LanguageRegistry.addName(verbalbrick, Names.Verbalbrick_name);
			//Half-slab Name registration
		LanguageRegistry.addName(verbalBrickSingleSlab, Names.VerbalbrickSlab_name);
		LanguageRegistry.addName(verbalBrickDoubleSlab, Names.VerbalbrickDoubleSlab_name);
		
		LanguageRegistry.addName(verbalBlockSingleSlab, Names.VerbalBlockSlab_name);
		LanguageRegistry.addName(verbalBlockDoubleSlab, Names.VerbalBlockDoubleSlab_name);
			//Ore block Name registration
		LanguageRegistry.addName(verbalore, Names.Verbalore_name);
		LanguageRegistry.addName(scikaleore, Names.Scikaleore_name);
		LanguageRegistry.addName(scikaleoreglowing, Names.Scikaleoreglowing_name);
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
		MinecraftForge.setBlockHarvestLevel(verbalBrickSingleSlab, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(verbalBrickDoubleSlab, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(verbalBlockSingleSlab, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(verbalBlockDoubleSlab, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(verbalore, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(scikaleore, "Scikalepickaxe", 4);
	}
	
	public static void postInit(FMLPostInitializationEvent event)
	{
		Item.itemsList[verbalBrickSingleSlab.blockID] = (new ItemSlab(
				verbalBrickSingleSlab.blockID - 256, ((BlockHalfSlab) verbalBrickSingleSlab),
				((BlockHalfSlab) verbalBrickDoubleSlab), false));
		Item.itemsList[verbalBlockSingleSlab.blockID] = (new ItemSlab(
				verbalBlockSingleSlab.blockID - 256, ((BlockHalfSlab) verbalBlockSingleSlab),
				((BlockHalfSlab) verbalBlockDoubleSlab), false));
	}

}