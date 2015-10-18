package com.mgrimm.plugin;

import java.util.List;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class HammerListener implements Listener{

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Player p = event.getPlayer();
		if (p.getGameMode().equals(GameMode.CREATIVE)) return;
		Random r = new Random();
		if (!p.getItemInHand().getItemMeta().getLore().isEmpty()){
			for (int x = event.getBlock().getX() - 1; x < event.getBlock().getX() + 2; x++){
				for (int y = event.getBlock().getY() - 1; y < event.getBlock().getY() + 2; y++){
					for (int z = event.getBlock().getZ() - 1; z < event.getBlock().getZ() + 2; z++){
						if (p.getWorld().getBlockAt(x, y, z).getType() != Material.BEDROCK){
							List<String> lore = p.getItemInHand().getItemMeta().getLore();
							if (lore.size() > 1){
								for (String s: lore){
									if (s.contains("luck: ")){
										String[] ss = s.split(":");
										String last = ss[1].trim();
										int luck = Integer.valueOf(last);
										
									}
								}
							}
								p.getWorld().getBlockAt(x, y, z).breakNaturally();
						}
					}
				}
			}
		}
	}
	
}
