package me.Vark123.EpicRPG.RpgFight;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class RpgShootBowEvent implements Listener {
	
	private static double power;
	
	@EventHandler
	public static void bow(EntityShootBowEvent e) {
		if(e.getEntity() instanceof Player) {
			power = e.getForce();
		}
	}
	
	public static float getPower() {
		return (float) power;
	}

}
