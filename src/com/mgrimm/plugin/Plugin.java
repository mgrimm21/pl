package com.mgrimm.plugin;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin{
	
	
	static Plugin plugin;
	
	
	@Override
	public void onEnable() {
		new CountListener(this);
		this.getConfig().addDefault("zombiekills", 0);
		this.getConfig().addDefault("creeperkills", 0);
		this.getConfig().addDefault("skeletonkills", 0);
		this.getConfig().options().copyDefaults(true);
		saveConfig();
		Plugin.plugin = this;
		getServer().getPluginManager().registerEvents(new HammerListener(), this);
		RecipeManager.registerRecipes();
		getLogger().info("Loaded");
	}
	
	@Override
	public void onDisable() {
		saveConfig();
		getLogger().info("Unloaded");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("spawn")){
			Player p = (Player)sender;
			p.teleport(p.getWorld().getSpawnLocation());
		}
		
		if (label.equalsIgnoreCase("eternaldark")){
			if (args[0].equalsIgnoreCase("save")){
				saveConfig();
			}
		}
		
		return true;
	}
	
}
