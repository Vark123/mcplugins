package me.Vark123.EpicRPG.Runes;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class Gruboskornosc extends Rune {

	public Gruboskornosc(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
		RpgPlayer rpg = Main.getListaRPG().get(p);
		rpg.setGruboskornosc(true);
		new BukkitRunnable() {
			int licznik = 0;
//			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				Location loc = p.getLocation();
				licznik++;
				loc.add(0, 1.5, 0);
				ParticleEffect.VILLAGER_HAPPY.display(loc, 10, 0.7F, 0.7F, 0.7F, 0, 20);
				loc.subtract(0, 1.5, 0);
				if(licznik>=20*dr.getCzas()) {
					rpg.setGruboskornosc(false);
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

	
	
}
