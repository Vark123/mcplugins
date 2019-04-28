package me.Vark123.EpicRPG.Runes;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class OgnistaStrzalaLcz extends Rune {

	public OgnistaStrzalaLcz(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		RpgPlayer rpg = Main.getListaRPG().get(p);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
		rpg.setOgnistaStrzala(true);
		p.sendMessage("§7[§6EpicRPG§7] §aUzyles runy "+dr.getNazwa());
	}

}
