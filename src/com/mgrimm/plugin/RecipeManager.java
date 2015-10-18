package com.mgrimm.plugin;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeManager {

	public static void registerRecipes(){
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = pick.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Diamond Hammer!");
		meta.setLore(lore);
		pick.setItemMeta(meta);
		ShapedRecipe srPick = new ShapedRecipe(pick);
		srPick.shape("ddd", " s ", " s ");
		srPick.setIngredient('d', Material.DIAMOND_BLOCK);
		srPick.setIngredient('s', Material.IRON_INGOT);
		Plugin.plugin.getServer().addRecipe(srPick);
	}
	
}
