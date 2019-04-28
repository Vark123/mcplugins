package me.Vark123.EpicRPG.Runes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;

public class UderzenieBurzy extends Rune {

	private List<Entity> shooted;
	
	public UderzenieBurzy(DynamicRune dr, Player p) {
		super(dr, p);
		shooted = new ArrayList<Entity>();
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
				ParticleEffect.CLOUD.display(loc,30,1F,1F,1F,0.3F,50);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 3.0 || e.getLocation().add(0, 1, 0).distance(loc) < 3.0 || e.getLocation().add(0, 1, 0).distance(loc) < 3.0) {
						if(!e.equals(p) && e instanceof LivingEntity && !shooted.contains(e)) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
							shooted.add(e);
							e.setVelocity(new Vector(vec.getX()*5,2,vec.getZ()*5));
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
				ParticleEffect.CLOUD.display(loc,30,1F,1F,1F,0.3F,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 3.0 || e.getLocation().add(0, 1, 0).distance(loc) < 3.0 || e.getLocation().add(0, 1, 0).distance(loc) < 3.0) {
						if(!e.equals(p) && e instanceof LivingEntity && !shooted.contains(e)) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
							shooted.add(e);
							e.setVelocity(new Vector(vec.getX()*5,2,vec.getZ()*5));
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
				ParticleEffect.CLOUD.display(loc,30,1F,1F,1F,0.3F,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 3.0 || e.getLocation().add(0, 1, 0).distance(loc) < 3.0 || e.getLocation().add(0, 1, 0).distance(loc) < 3.0) {
						if(!e.equals(p) && e instanceof LivingEntity && !shooted.contains(e)) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
							shooted.add(e);
							e.setVelocity(new Vector(vec.getX()*5,2,vec.getZ()*5));
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
				ParticleEffect.CLOUD.display(loc,30,1F,1F,1F,0.3F,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 3.0 || e.getLocation().add(0, 1, 0).distance(loc) < 3.0 || e.getLocation().add(0, 1, 0).distance(loc) < 3.0) {
						if(!e.equals(p) && e instanceof LivingEntity && !shooted.contains(e)) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
							shooted.add(e);
							e.setVelocity(new Vector(vec.getX()*5,2,vec.getZ()*5));
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
