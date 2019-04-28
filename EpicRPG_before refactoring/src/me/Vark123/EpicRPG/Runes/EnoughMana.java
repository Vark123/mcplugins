package me.Vark123.EpicRPG.Runes;

import org.bukkit.entity.Player;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class EnoughMana {

	public static boolean hasMana(DynamicRune dr, Player p) {
		RpgPlayer rpg = Main.getListaRPG().get(p);
		if(rpg.getPresent_mana()>=dr.getPrice()) {
			return true;
		}
		p.sendMessage("§7[§6EpicRPG§7] §cMasz za malo many by uzyc tego czaru!");
		return false;
	}
	
	public static void spendMana(DynamicRune dr, Player p) {
		Main.getListaRPG().get(p).removeresentMana(dr.getPrice());
	}
	
}
