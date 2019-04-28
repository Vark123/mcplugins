package me.Vark123.EpicRPG;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class RpgTpPapers implements Listener {
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand() == null) {
				return;
			}
			if(e.getPlayer().getItemInHand().getType().equals(Material.PAPER)) {
				ItemStack item = e.getPlayer().getItemInHand();
				if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().contains("Zwoj teleportacji")) {
					if(item.getItemMeta().getDisplayName().contains("sanktuarium")) {
						World w = Bukkit.getWorld("Mapa106");
						e.getPlayer().teleport(w.getSpawnLocation());
						if(e.getPlayer().getItemInHand().getAmount() != 1) {
							e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount()-1);
							return;
						}
						e.getPlayer().getInventory().remove(e.getPlayer().getItemInHand());
						e.getPlayer().updateInventory();
					}
				}
			}
		}
	}
}
