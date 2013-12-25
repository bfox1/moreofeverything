package moreofeverything.lib.config;

import moreofeverything.blocks.Blocks;
import moreofeverything.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {
		/**
		 * This all adds the recipe for Items and blocks.
		 */
		// Block recipes
		GameRegistry.addRecipe(new ItemStack(Blocks.verbalblock, 1),
				new Object[] { "DDD", "DDD", "DDD", 'D', Items.verbal });

		CraftingManager.getInstance().addRecipe(
				new ItemStack(Blocks.verbalbrick, 4), "DD", "DD", 'D',
				Blocks.verbalblock

		);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.verbalblock, 1),
				new ItemStack(Blocks.verbalbrick, 1));
		// Item recipes

		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.Infusedverbal, 4), "GVG", "VDV", "GVG",
				'V', Items.verbal, 'G', Item.glowstone, 'D', Item.diamond

		);

		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.Infusedstick, 2), "GIG", "ISI", "GIG", 'S',
				Item.stick, 'G', Item.glowstone, 'I', Items.Infusedverbal
				

		);
		// Scepter
		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.scepter, 1), " D ", " S ", " S ", 'D',
				Items.verbal, 'S', Item.stick);
		// VerbalSword
		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.verbalsword, 1), " D ", " D ", " S ", 'D',
				Items.Infusedingot, 'S', Items.Infusedstick);
		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.verbalpickaxe, 1), "DDD", " S ", " S ",
				'D', Items.Infusedingot, 'S', Items.Infusedstick

		);

		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.verbalaxe, 1), "DD ", "DS ", " S ", 'D',
				Items.Infusedingot, 'S', Items.Infusedstick);


		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.verbalshovel, 1), " D ", " S ", " S ", 'D',
				Items.Infusedingot, 'S', Items.Infusedstick);

		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.verbalhoe, 1), "DD ", " S ", " S ", 'D',
				Items.Infusedingot, 'S', Items.Infusedstick);
		
		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.Scikaleblade, 1), " D ", " D ", " S ", 'D',
				Items.Scikaleingot, 'S', Items.Infusedstick);
		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.Scikalepickaxe, 1), "DDD", " S ", " S ",
				'D', Items.Scikaleingot, 'S', Items.Infusedstick

		);

		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.Scikaleaxe, 1), "DD ", "DS ", " S ", 'D',
				Items.Scikaleingot, 'S', Items.Infusedstick);


		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.Scikaleshovel, 1), " D ", " S ", " S ", 'D',
				Items.Scikaleingot, 'S', Items.Infusedstick);

		CraftingManager.getInstance().addRecipe(
				new ItemStack(Items.Scikalehoe, 1), "DD ", " S ", " S ", 'D',
				Items.Scikaleingot, 'S', Items.Infusedstick);

		// Verbal from Verbalblock
		GameRegistry.addShapelessRecipe(new ItemStack(Items.verbal, 9),
				new ItemStack(Blocks.verbalblock, 1));
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.unknown, 1),
			"PTV",
			"ASB",
			"QSN",
			'P', Items.verbalpickaxe,
			'T', Items.Scikaleblade,
			'V', Items.Scikalepickaxe,
			'A', Items.verbalaxe,
			'S', Items.Infusedstick,
			'B', Items.Scikaleaxe,
			'Q', Items.verbalshovel,
			'N', Items.Scikaleshovel
				
				);

		if (Booleans.hardRecipe) {
			CraftingManager.getInstance().addRecipe(
					new ItemStack(Items.Omnitool, 1), " C ", "DSF", " S ", 'S',
					Items.Infusedstick, 'D', Items.verbalpickaxe, 'C',
					Items.verbalshovel, 'F', Items.verbalaxe);
		} else {
			CraftingManager.getInstance().addRecipe(
					new ItemStack(Items.Omnitool, 1), " D ", "DSD", " S ", 'S',
					Items.Infusedstick, 'D', Items.Infusedverbal);

		}

	}
	public static void addSmeltingRecipes(){
		GameRegistry.addSmelting(Items.Infusedverbal.itemID, new ItemStack(Items.Infusedingot), 5F);
		
		GameRegistry.addSmelting(Blocks.scikaleore.blockID, new ItemStack(Items.Scikaleingot), 5F);
	}
}
