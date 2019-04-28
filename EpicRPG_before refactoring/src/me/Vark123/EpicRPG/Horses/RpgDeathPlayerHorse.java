package me.Vark123.EpicRPG.Horses;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class RpgDeathPlayerHorse implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(e.getEntity().isInsideVehicle()) {
			e.getEntity().getVehicle().remove();
		}
	}
	
}
