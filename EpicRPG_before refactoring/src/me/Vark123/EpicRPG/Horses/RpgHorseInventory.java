package me.Vark123.EpicRPG.Horses;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RpgHorseInventory implements Listener {
	
	@EventHandler
	public static void onHorseInv(InventoryClickEvent e) {
		if(e.getWhoClicked().getVehicle() != null) {
			if(e.getWhoClicked().getVehicle().getType().equals(EntityType.HORSE)) {
				e.setCancelled(true);
			}
		}
	}

}
