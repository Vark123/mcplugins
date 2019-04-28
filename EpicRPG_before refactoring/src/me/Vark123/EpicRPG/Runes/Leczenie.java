package me.Vark123.EpicRPG.Runes;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
//import org.bukkit.util.Vector;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class Leczenie extends Rune{

	public Leczenie(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		RpgPlayer rpg = Main.getListaRPG().get(p);
		if(p.getMaxHealth() > (p.getHealth()+p.getMaxHealth()*0.1*rpg.getKrag())) {
			p.setHealth((int)(p.getHealth()+p.getMaxHealth()*0.1*rpg.getKrag()));
			p.sendMessage("§7[§6EpicRPG§7] §6Uleczyles sie w "+(10*rpg.getKrag())+"%");
		}else {
			p.setHealth(p.getMaxHealth());
			p.sendMessage("§7[§6EpicRPG§7] §6Uleczyles sie w pelni");
		}
		new BukkitRunnable() {
			double t = 0;
			Location loc = p.getLocation();
//			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				t+=0.1;
				for(double theta = 0;theta <= 2*Math.PI; theta=theta+(Math.PI/8)) {
					double x = t*Math.sin(theta);
					double y = t;
					double z = t*Math.cos(theta);
					loc.add(x, y, z);
					ParticleEffect.HEART.display(loc, 10, 0, 0, 0, 0, 1);
					loc.subtract(x,y,z);
				}
				if(t>=1) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
		
	}

}
