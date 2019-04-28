package me.Vark123.EpicRPG.Runes;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class SzalBitewny extends Rune{

	public SzalBitewny(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		RpgPlayer rpg = Main.getListaRPG().get(p);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
		rpg.setSzalBitewny(true);
		p.sendMessage("§7[§6EpicRPG§7] §aUzyles runy "+dr.getNazwa());
		new BukkitRunnable(){

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				p.sendMessage("§7[§6EpicRPG§7] §aEfekt dzialania runy "+dr.getNazwa()+" skonczyl sie");
				p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
				rpg.setSzalBitewny(false);
				Location loc = p.getLocation();
				for(double y = 0.1;y<=2.2;y+=0.1) {
					for(double t = 0;t<=2*Math.PI;t+=(Math.PI/16)) {
						double x = Math.sin(t);
						double z = Math.cos(t);
						loc.add(x,y,z);
						ParticleEffect.REDSTONE.display(loc, 10, 0, 0, 0, 0, 1);
						loc.subtract(x, y, z);
					}
				}
			}
			
		}.runTaskLater(Main.getInst(), 20*dr.getCzas());
	}
	
}
