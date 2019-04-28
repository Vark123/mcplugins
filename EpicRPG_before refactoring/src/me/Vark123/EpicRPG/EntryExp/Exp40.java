package me.Vark123.EpicRPG.EntryExp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;

import me.Vark123.EpicRPG.Main;

public class Exp40 implements Listener{

	@EventHandler(priority=EventPriority.HIGHEST)
	public void onRegionEntry(RegionEnterEvent e) {
		if(e.getRegion().getId().equalsIgnoreCase("s40")) {
			if(Main.getListaRPG().get(e.getPlayer()).getLevel() < 40) {
				e.getPlayer().sendMessage("§b§lTyrael§7: Masz zbyt malo doswiadczenia. Nie moge Ciebie tutaj wpuscic, to zbyt niebezpieczne.");
				e.getPlayer().sendMessage("§7[§cAby tutaj wejsc, musisz posiadac przynajmniej §740 §cpoziom§7]");
				e.setCancelled(true);
				return;
			}
		}
	}
	
}
