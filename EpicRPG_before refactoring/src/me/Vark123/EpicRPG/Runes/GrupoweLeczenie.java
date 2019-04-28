package me.Vark123.EpicRPG.Runes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class GrupoweLeczenie extends Rune {
	
	List<Player> players;

	public GrupoweLeczenie(DynamicRune dr, Player p) {
		super(dr, p);
		players = new ArrayList<Player>();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1, 1);
		List<Entity> entities = p.getNearbyEntities(dr.getObszar(), dr.getObszar(), dr.getObszar());
		entities.add(p);
		Location loc = p.getLocation();
		loc.add(0,0.1,0);
		for(double t = 0;t<dr.getObszar();t+=0.25) {
			for(double theta = 0; theta <= 2*Math.PI; theta = theta + (Math.PI/32)) {
				double x = t*Math.sin(theta);
				double z = t*Math.cos(theta);
				loc.add(x, 0, z);
				ParticleEffect.HEART.display(loc, 10, 0, 0, 0, 0, 1);
				loc.subtract(x, 0, z);
			}
		}
		for(Entity e : entities) {
			if(e instanceof Player && !players.contains(e)) {
				Player pl = (Player)e;
				players.add(pl);
				RpgPlayer rpg = Main.getListaRPG().get(pl);
				if(pl.getMaxHealth() > (pl.getHealth()+pl.getMaxHealth()*0.1*rpg.getKrag())) {
					pl.setHealth((int)(pl.getHealth()+p.getMaxHealth()*0.1*rpg.getKrag()));
					pl.sendMessage("§7[§6EpicRPG§7] §6Uleczyles sie w "+(10*rpg.getKrag())+"%");
				}else {
					pl.setHealth(p.getMaxHealth());
					pl.sendMessage("§7[§6EpicRPG§7] §6Uleczyles sie w pelni");
				}
				new BukkitRunnable() {
					double t = 0;
					Location loc = p.getLocation();
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
	}

}
