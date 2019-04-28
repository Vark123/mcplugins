package me.Vark123.EpicRPG.Stats;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.Vark123.EpicRPG.RpgPlayer;

public class CheckStats {
	
	private static List<String> stats;
	
	public static boolean check(RpgPlayer rpg, ItemStack item) {
		if(!item.getType().equals(Material.AIR) && item.getItemMeta().hasLore()) {
			stats = item.getItemMeta().getLore();
			for(String s : stats) {
				if(s.contains("§4- §8Sila: §c")) {
					s = s.replace("§4- §8Sila: §c", "");
					if(rpg.getFinalsila() < Integer.parseInt(s)) {
						return false;
					}
				}
				else if(s.contains("§4- §8Zrecznosc: §c")) {
					s = s.replace("§4- §8Zrecznosc: §c", "");
					if(rpg.getFinalzrecznosc() < Integer.parseInt(s)) {
						return false;
					}
				}
				else if(s.contains("§4- §8Mana: §c")) {
					s = s.replace("§4- §8Mana: §c", "");
					if(rpg.getFinalmana() < Integer.parseInt(s)) {
						return false;
					}
				}
				else if(s.contains("§4- §8Inteligencja: §c")) {
					s = s.replace("§4- §8Inteligencja: §c", "");
					if(rpg.getFinalinteligencja() < Integer.parseInt(s)) {
						return false;
					}
				}
				else if(s.contains("§4- §8Walka: §c")) {
					s = s.replace("§4- §8Walka: §c", "");
					if(rpg.getFinalwalka() < Integer.parseInt(s)) {
						return false;
					}
				}
				else if(s.contains("§4- §8Klasa: ")) {
					s = s.replace("§4- §8Klasa: ", "");
					if(!rpg.getProffesion().contains(s)) {
						return false;
					}
				}
				else if(s.contains("§4- §8Krag: §7")) {
					s = s.replace("§4- §8Krag: §7", "");
					if(rpg.getKrag() < Integer.parseInt(s)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static boolean isRune(ItemStack item) {
		Material m = item.getType();
		if(m.equals(Material.RECORD_10) 
				|| m.equals(Material.RECORD_11) 
				|| m.equals(Material.RECORD_12)
				|| m.equals(Material.RECORD_3)
				|| m.equals(Material.RECORD_4)
				|| m.equals(Material.RECORD_5)
				|| m.equals(Material.RECORD_6)
				|| m.equals(Material.RECORD_7)
				|| m.equals(Material.RECORD_8)
				|| m.equals(Material.RECORD_9)
				|| m.equals(Material.RECORD_10)
				|| m.equals(Material.GOLD_RECORD)
				|| m.equals(Material.GREEN_RECORD)) {
			return true;
		}else {
			return false;
		}
	}
}
