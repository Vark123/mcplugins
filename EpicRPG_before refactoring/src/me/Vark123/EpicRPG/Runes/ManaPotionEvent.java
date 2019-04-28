package me.Vark123.EpicRPG.Runes;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class ManaPotionEvent implements Listener {
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onDrinkMana(PlayerItemConsumeEvent e) {
		if(e.getItem().getType().equals(Material.POTION)) {
			if(e.getItem().getItemMeta().getDisplayName().contains("many")) {
				List<String> lore = e.getItem().getItemMeta().getLore();
				int mana;
				for(String s : lore) {
					if(s.contains("Przywrocona mana")) {
						mana = Integer.parseInt(s.replace("§4- §3Przywrocona mana: §7", ""));
						RpgPlayer rp = Main.getListaRPG().get(e.getPlayer());
						rp.addPresentManaSmart(mana);
						e.getPlayer().sendMessage("§7[§6EpicRPG§7] §2Obecny stan many: §a"+rp.getPresent_mana()+"§2/§a"+rp.getFinalmana());
						break;
					}
				}
			}
		}
	}

}
