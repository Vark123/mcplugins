package me.Vark123.EpicRPG.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class RpgChat implements Listener{
	
	public static boolean chat = true;
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		RpgPlayer rpg = Main.getListaRPG().get(p);
		if(!chat) {
			if(e.getPlayer().hasPermission("rpg.chatoff")) {
				e.setFormat("§8[§2§lLVL " + rpg.getLevel() + "§8] [" + rpg.getProffesion() + "§8] §7%s: §r%s");
				return;
			}
			p.sendMessage("§6==========");
			p.sendMessage("§cChat jest wylaczony. Nie mozesz na nim pisac!");
			p.sendMessage("§6==========");
			e.setCancelled(true);;
		}
		e.setFormat("§8[§2§lLVL " + rpg.getLevel() + "§8][" + rpg.getRanga() + "§8][" + rpg.getProffesion() + "§8] §7%s: §r%s");
	}

}
