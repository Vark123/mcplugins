package me.Vark123.EpicRPG.Runes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;

public class BurzaOgnista extends Rune {

	private List<Entity> shooted;
	
	public BurzaOgnista(DynamicRune dr, Player p) {
		super(dr, p);
		shooted = new ArrayList<Entity>();
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
		new BukkitRunnable() {
			double t = 0;
			Location loc = p.getLocation();
			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			public void run() {
				t++;
				double x = vec.getX()*t;
				double y = vec.getY()*t+1.5;
				double z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.EXPLOSION_LARGE.display(loc,30,0,0,0,0,5);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 2.0 || e.getLocation().add(0, 1, 0).distance(loc) < 2.0 || e.getLocation().add(0, 1, 0).distance(loc) < 2.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							e.getWorld().playSound(loc, Sound.EXPLODE, 1, 1);
							e.setFireTicks(20*20);
							shooted.add(e);
							rangeSpell(e);
							this.cancel();
							break;
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				if(t>30) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

	private void rangeSpell(Entity e) {
		new BukkitRunnable() {
			double t = 0;
			Location loc = e.getLocation();
			Location check = e.getLocation();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				t+=0.5;
				for(double theta = 0;theta<=Math.PI*2;theta=theta+(Math.PI/8)) {
					double x = t*Math.sin(theta);
					double z = t*Math.cos(theta);
					loc.add(x,0.7,z);
					if(loc.distance(check)>dr.getObszar()) {
						this.cancel();
					}
					ParticleEffect.EXPLOSION_LARGE.display(loc,30,0,0,0,0,5);
					for(Entity entity:loc.getChunk().getEntities()) {
						if(entity.getLocation().distance(loc) < 0.75 || entity.getLocation().add(0, 1, 0).distance(loc) < 0.75 || entity.getLocation().add(0, 1, 0).distance(loc) < 0.75) {
							if(!entity.equals(p) && entity instanceof LivingEntity && !shooted.contains(entity) && entity.getLocation().distance(check) <= dr.getObszar()) {
								((LivingEntity)entity).damage(dr.getDamage(), p);
								entity.setFireTicks(20*20);
								shooted.add(entity);
							}
						}
					}
					loc.subtract(x,0.7,z);
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 5);
	}
	
}
