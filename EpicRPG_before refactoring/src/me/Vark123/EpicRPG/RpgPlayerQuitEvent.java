package me.Vark123.EpicRPG;

import java.io.IOException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.Vark123.EpicRPG.Files.RpgFileOperation;

public class RpgPlayerQuitEvent implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) throws IOException {
		if(Main.getListaRPG().containsKey(e.getPlayer())) {
			RpgFileOperation.saveStats(Main.getListaRPG().get(e.getPlayer()));
			Main.getListaRPG().remove(e.getPlayer());
		}
	}
	
}
