package me.Vark123.EpicRPG.Runes;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;

public class UderzenieWiatru extends Rune {

	public UderzenieWiatru(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
		new BukkitRunnable() {
			double t = 0;
			Location loc = p.getLocation();
			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			public void run() {
				t+=0.75;
				double x = vec.getX()*t;
				double y = vec.getY()*t+1.5;
				double z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,30,0,0,0,0,10);
				ParticleEffect.CLOUD.display(loc,30,0.33F,0.33F,0.33F,0.15F,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
							e.setVelocity(new Vector(vec.getX()*3,1,vec.getZ()*3));
							this.cancel();
						}
					}
				}
				loc.subtract(x, y, z);
				if(t>40) {
					this.cancel();
				}
				t+=0.75;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,60,0,0,0,0,10);
				ParticleEffect.CLOUD.display(loc,30,0.33F,0.33F,0.33F,0.15F,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
							e.setVelocity(new Vector(vec.getX()*3,1,vec.getZ()*3));
							this.cancel();
						}
					}
				}
				loc.subtract(x, y, z);
				if(t>40) {
					this.cancel();
				}
				t+=0.75;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,60,0,0,0,0,10);
				ParticleEffect.CLOUD.display(loc,30,0.33F,0.33F,0.33F,0.15F,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
							e.setVelocity(new Vector(vec.getX()*3,1,vec.getZ()*3));
							this.cancel();
						}
					}
				}
				loc.subtract(x, y, z);
				if(t>40) {
					this.cancel();
				}
				t+=0.75;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,60,0,0,0,0,10);
				ParticleEffect.CLOUD.display(loc,30,0.33F,0.33F,0.33F,0.15F,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
							e.setVelocity(new Vector(vec.getX()*3,1,vec.getZ()*3));
							this.cancel();
						}
					}
				}
				loc.subtract(x, y, z);
				if(t>40) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

}
