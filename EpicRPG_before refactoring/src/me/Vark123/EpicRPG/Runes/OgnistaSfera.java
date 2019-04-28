package me.Vark123.EpicRPG.Runes;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
//import org.bukkit.util.Vector;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class OgnistaSfera extends Rune{

	public OgnistaSfera(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
		RpgPlayer rpg = Main.getListaRPG().get(p);
		rpg.setSfera(true);
		new BukkitRunnable() {
			int licznik = 0;
			double theta = 0;
//			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				Location loc = p.getLocation();
				Location loc2 = p.getLocation();
//				Vector v1 = loc.getDirection().normalize();
				theta = 0;
				licznik++;
				for(double y = 0;y<= 2.5; y+=0.1) {
					theta = theta+(Math.PI/8);
					double x = Math.cos(theta);
					double z = Math.sin(theta);
					double x2 = Math.sin(theta);
					double z2 = Math.cos(theta);
					loc.add(x, y, z);
					loc2.add(x2, y, z2);
					ParticleEffect.FLAME.display(loc, 10, 0, 0, 0, 0, 1);
					ParticleEffect.FLAME.display(loc2, 10, 0, 0, 0, 0, 1);
					loc2.subtract(x2, y, z2);
					loc.subtract(x,y,z);
				}
				if(licznik>=20*dr.getCzas()) {
					rpg.setSfera(false);
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

}
