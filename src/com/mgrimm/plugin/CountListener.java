package com.mgrimm.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class CountListener implements Listener{

	Plugin plugin;
	
	public CountListener(Plugin plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		String uuid = p.getUniqueId().toString();
		if (!plugin.getConfig().contains("balance." + uuid)){
			plugin.getConfig().set("balance." + uuid, 10000);
			plugin.saveConfig();
		}
		if (!plugin.getConfig().contains("kills." + uuid)){
			
			plugin.getConfig().set("kills." + uuid + ".zombie", 0);
			plugin.getConfig().set("kills." + uuid + ".creeper", 0);
			plugin.getConfig().set("kills." + uuid + ".skeleton", 0);
			plugin.saveConfig();
		}
	}
	
	@EventHandler
	public void onZombieKill(EntityDeathEvent event){
		
		Entity dead = event.getEntity();
		Entity killer = event.getEntity().getKiller();
		
		if (killer instanceof Player){
			
			Player p = (Player)killer;
			if (dead instanceof Zombie){
			int playerzkillcount = plugin.getConfig().getInt("kills." + p.getUniqueId().toString() + ".zombie");
			int totalzkillcount = plugin.getConfig().getInt("zombiekills");
			totalzkillcount++;
			playerzkillcount++;
			if (totalzkillcount % 100 == 0){
				Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Total Zombie Kills: " + totalzkillcount);
			}
			p.sendMessage(ChatColor.GOLD + "Your Zombie Kills: " + playerzkillcount);
			plugin.getConfig().set("zombiekills", totalzkillcount);
			plugin.getConfig().set("kills." + p.getUniqueId().toString() + ".zombie", playerzkillcount);
			}
			if (dead instanceof Skeleton){
				int playerzkillcount = plugin.getConfig().getInt("kills." + p.getUniqueId().toString() + ".skeleton");
				int totalzkillcount = plugin.getConfig().getInt("skeletonkills");
				totalzkillcount++;
				playerzkillcount++;
				if (totalzkillcount % 100 == 0){
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Total Skeleton Kills: " + totalzkillcount);
				}
				p.sendMessage(ChatColor.GOLD + "Your Skeleton Kills: " + playerzkillcount);
				plugin.getConfig().set("skeletonkills", totalzkillcount);
				plugin.getConfig().set("kills." + p.getUniqueId().toString() + ".skeleton", playerzkillcount);
				
			}
			if (dead instanceof Creeper){
				int playerzkillcount = plugin.getConfig().getInt("kills." + p.getUniqueId().toString() + ".creeper");
				int totalzkillcount = plugin.getConfig().getInt("creeperkills");
				totalzkillcount++;
				playerzkillcount++;
				if (totalzkillcount % 100 == 0){
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Total Creeper Kills: " + totalzkillcount);
				}
				p.sendMessage(ChatColor.GOLD + "Your Creeper Kills: " + playerzkillcount);
				plugin.getConfig().set("creeperkills", totalzkillcount);
				plugin.getConfig().set("kills." + p.getUniqueId().toString() + ".creeper", playerzkillcount);
			}
		}
		
	}
	
}
