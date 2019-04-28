package me.Vark123.EpicRPG.Stats;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.Vark123.EpicRPG.RpgPlayer;

public class ChangeStats {
	
	private static List<String> stats;
	
	public static void change(RpgPlayer rpg) {
		rpg.setFinalinteligencja(rpg.getInteligencja());
		rpg.setFinalsila(rpg.getSila());
		rpg.setFinalzrecznosc(rpg.getZrecznosc());
		rpg.setFinalmana(rpg.getMana());
		rpg.setFinalwalka(rpg.getWalka());
		rpg.setOchrona(0);
		rpg.setObrazenia(0);
		Player p = rpg.getP();
		
		//Sprawdzanie he³mu
		
		if((p.getEquipment().getHelmet() != null) && (p.getEquipment().getHelmet().getItemMeta().hasLore())) {
			stats = p.getEquipment().getHelmet().getItemMeta().getLore();
			for(String s : stats) {
				if(s.contains("§4- §8Ochrona:")) {
					s = s.replace("§4- §8Ochrona: §7", "");
					rpg.setOchrona(rpg.getOchrona()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7+")) {
					s = s.replace("§4- §8Sila: §7+", "");
					rpg.setFinalsila(rpg.getFinalsila()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7+")) {
					s = s.replace("§4- §8Zrecznosc: §7+", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7+")) {
					s = s.replace("§4- §8Mana: §7+", "");
					rpg.setFinalmana(rpg.getFinalmana()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7+")) {
					s = s.replace("§4- §8Inteligencja: §7+", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7+")) {
					s = s.replace("§4- §8Walka: §7+", "");
					rpg.setFinalwalka(rpg.getFinalwalka()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7-")) {
					s = s.replace("§4- §8Sila: §7-", "");
					rpg.setFinalsila(rpg.getFinalsila()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7-")) {
					s = s.replace("§4- §8Zrecznosc: §7-", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7-")) {
					s = s.replace("§4- §8Mana: §7-", "");
					rpg.setFinalmana(rpg.getFinalmana()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7-")) {
					s = s.replace("§4- §8Inteligencja: §7-", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7-")) {
					s = s.replace("§4- §8Walka: §7-", "");
					rpg.setFinalwalka(rpg.getFinalwalka()-Integer.parseInt(s));
				}
			}
		}
		
		
		//Sprawdzanie zbroi
		
		
		if((p.getEquipment().getChestplate() != null) && (p.getEquipment().getChestplate().getItemMeta().hasLore())) {
			stats = p.getEquipment().getChestplate().getItemMeta().getLore();
			for(String s : stats) {
				if(s.contains("§4- §8Ochrona:")) {
					s = s.replace("§4- §8Ochrona: §7", "");
					rpg.setOchrona(rpg.getOchrona()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7+")) {
					s = s.replace("§4- §8Sila: §7+", "");
					rpg.setFinalsila(rpg.getFinalsila()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7+")) {
					s = s.replace("§4- §8Zrecznosc: §7+", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7+")) {
					s = s.replace("§4- §8Mana: §7+", "");
					rpg.setFinalmana(rpg.getFinalmana()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7+")) {
					s = s.replace("§4- §8Inteligencja: §7+", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7+")) {
					s = s.replace("§4- §8Walka: §7+", "");
					rpg.setFinalwalka(rpg.getFinalwalka()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7-")) {
					s = s.replace("§4- §8Sila: §7-", "");
					rpg.setFinalsila(rpg.getFinalsila()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7-")) {
					s = s.replace("§4- §8Zrecznosc: §7-", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7-")) {
					s = s.replace("§4- §8Mana: §7-", "");
					rpg.setFinalmana(rpg.getFinalmana()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7-")) {
					s = s.replace("§4- §8Inteligencja: §7-", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7-")) {
					s = s.replace("§4- §8Walka: §7-", "");
					rpg.setFinalwalka(rpg.getFinalwalka()-Integer.parseInt(s));
				}
			}
		}
		
		
		//Sprawdzanie nogawic
		
		
		if((p.getEquipment().getLeggings() != null) && (p.getEquipment().getLeggings().getItemMeta().hasLore())) {
			stats = p.getEquipment().getLeggings().getItemMeta().getLore();
			for(String s : stats) {
				if(s.contains("§4- §8Ochrona:")) {
					s = s.replace("§4- §8Ochrona: §7", "");
					rpg.setOchrona(rpg.getOchrona()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7+")) {
					s = s.replace("§4- §8Sila: §7+", "");
					rpg.setFinalsila(rpg.getFinalsila()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7+")) {
					s = s.replace("§4- §8Zrecznosc: §7+", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7+")) {
					s = s.replace("§4- §8Mana: §7+", "");
					rpg.setFinalmana(rpg.getFinalmana()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7+")) {
					s = s.replace("§4- §8Inteligencja: §7+", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7+")) {
					s = s.replace("§4- §8Walka: §7+", "");
					rpg.setFinalwalka(rpg.getFinalwalka()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7-")) {
					s = s.replace("§4- §8Sila: §7-", "");
					rpg.setFinalsila(rpg.getFinalsila()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7-")) {
					s = s.replace("§4- §8Zrecznosc: §7-", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7-")) {
					s = s.replace("§4- §8Mana: §7-", "");
					rpg.setFinalmana(rpg.getFinalmana()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7-")) {
					s = s.replace("§4- §8Inteligencja: §7-", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7-")) {
					s = s.replace("§4- §8Walka: §7-", "");
					rpg.setFinalwalka(rpg.getFinalwalka()-Integer.parseInt(s));
				}
			}
		}
		
		
		//Sprawdzanie butów
		
		
		if((p.getEquipment().getBoots() != null) && (p.getEquipment().getBoots().getItemMeta().hasLore())) {
			stats = p.getEquipment().getBoots().getItemMeta().getLore();
			for(String s : stats) {
				if(s.contains("§4- §8Ochrona:")) {
					s = s.replace("§4- §8Ochrona: §7", "");
					rpg.setOchrona(rpg.getOchrona()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7+")) {
					s = s.replace("§4- §8Sila: §7+", "");
					rpg.setFinalsila(rpg.getFinalsila()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7+")) {
					s = s.replace("§4- §8Zrecznosc: §7+", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7+")) {
					s = s.replace("§4- §8Mana: §7+", "");
					rpg.setFinalmana(rpg.getFinalmana()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7+")) {
					s = s.replace("§4- §8Inteligencja: §7+", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7+")) {
					s = s.replace("§4- §8Walka: §7+", "");
					rpg.setFinalwalka(rpg.getFinalwalka()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7-")) {
					s = s.replace("§4- §8Sila: §7-", "");
					rpg.setFinalsila(rpg.getFinalsila()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7-")) {
					s = s.replace("§4- §8Zrecznosc: §7-", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7-")) {
					s = s.replace("§4- §8Mana: §7-", "");
					rpg.setFinalmana(rpg.getFinalmana()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7-")) {
					s = s.replace("§4- §8Inteligencja: §7-", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7-")) {
					s = s.replace("§4- §8Walka: §7-", "");
					rpg.setFinalwalka(rpg.getFinalwalka()-Integer.parseInt(s));
				}
			}
		}	
		
		//Sprawdzanie statystyk broni
		
		if(!(p.getItemInHand().getType().equals(Material.AIR)) && p.getItemInHand().getItemMeta().hasLore()) {
			stats = p.getItemInHand().getItemMeta().getLore();
			for(String s : stats) {
				if(!CheckStats.check(rpg, p.getItemInHand())) {
					break;
				}
				if(s.contains("§4- §8Obrazenia:")) {
					s = s.replace("§4- §8Obrazenia: §7", "");
					rpg.setObrazenia(Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7+")) {
					s = s.replace("§4- §8Sila: §7+", "");
					rpg.setFinalsila(rpg.getFinalsila()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7+")) {
					s = s.replace("§4- §8Zrecznosc: §7+", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7+")) {
					s = s.replace("§4- §8Mana: §7+", "");
					rpg.setFinalmana(rpg.getFinalmana()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7+")) {
					s = s.replace("§4- §8Inteligencja: §7+", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7+")) {
					s = s.replace("§4- §8Walka: §7+", "");
					rpg.setFinalwalka(rpg.getFinalwalka()+Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Sila: §7-")) {
					s = s.replace("§4- §8Sila: §7-", "");
					rpg.setFinalsila(rpg.getFinalsila()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Zrecznosc: §7-")) {
					s = s.replace("§4- §8Zrecznosc: §7-", "");
					rpg.setFinalzrecznosc(rpg.getFinalzrecznosc()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Mana: §7-")) {
					s = s.replace("§4- §8Mana: §7-", "");
					rpg.setFinalmana(rpg.getFinalmana()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Inteligencja: §7-")) {
					s = s.replace("§4- §8Inteligencja: §7-", "");
					rpg.setFinalinteligencja(rpg.getFinalinteligencja()-Integer.parseInt(s));
				}
				else if(s.contains("§4- §8Walka: §7-")) {
					s = s.replace("§4- §8Walka: §7-", "");
					rpg.setFinalwalka(rpg.getFinalwalka()-Integer.parseInt(s));
				}
			}
		}
	}
}
