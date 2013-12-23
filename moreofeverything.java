package moreofeverything;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import moreofeverything.oregen.Worldgenore;
import moreofeverything.proxies.CommonProxy;
import moreofeverything.items.Items;
import moreofeverything.blocks.Blocks;
import moreofeverything.lib.LogHelper;
import moreofeverything.lib.ModInfo;
import moreofeverything.lib.MoreofeverythingTab;
import moreofeverything.lib.config.ConfigHandler;
import moreofeverything.lib.config.Recipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * This is below is linked to modID. Basic requirements.
 * 
 */
//This is my comment
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = { ModInfo.CHANNEL }, clientSideRequired = true, serverSideRequired = true)
public class moreofeverything {

	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = ModInfo.PROXY_LOCATION
			+ ".CommonProxy")
	public static CommonProxy proxy;
	

	public moreofeverything() {
		// TODO Auto-generated constructor stub
	}

	public static CreativeTabs moreofeverything = new MoreofeverythingTab(
			CreativeTabs.getNextID(), ModInfo.NAME);
	
	public static CreativeTabs moreofeverythingTools = new MoreofeverythingtoolsTab(
			CreativeTabs.getNextID(), ModInfo.CREATIVETOOL);

	/**
	 * 
	 * This is pre-load
	 */
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		LogHelper.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		// Adds Sounds and renders to minecraft
		proxy.initRenderers();
		proxy.initSounds();
		LogHelper.log(Level.INFO, "Preparing Blocks, Items, Recipes");
		// Loads items details BEFORE statup.
		Items.init();
		Blocks.init();
		Recipes.init();
		LogHelper.log(Level.INFO, "Blocks, Items, Recipes have been loaded");

	}

	// This happens DURING the startup
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup." + ModInfo.NAME, "en_US", ModInfo.NAME);
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup." + ModInfo.CREATIVETOOL, "en_US", ModInfo.CREATIVETOOL);
		// This log will log in Console of when stuff takes place.
		LogHelper.log(Level.INFO, "Adding Names of Blocks, Items");
		Items.addNames();
		Blocks.addNames();
		Blocks.addHarvestLevel();
		LogHelper.log(Level.INFO, "Names of Items, Blocks added");
		//Oregeneration.regWorld();
		GameRegistry.registerWorldGenerator(new Worldgenore());



	}

	// And as of this happens AFTER the startup
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}

}