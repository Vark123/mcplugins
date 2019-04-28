package me.Vark123.EpicRPG.Runes;

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

public class TchnienieSmierci extends Rune {

	public TchnienieSmierci(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.HORSE_ZOMBIE_DEATH, 1, 1);
		new BukkitRunnable() {
			double t = 0;
			Location loc = p.getLocation();
			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			public void run() {
				t+=0.7;
				double x = vec.getX()*t;
				double y = vec.getY()*t+1.5;
				double z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.SMOKE_LARGE.display(loc,30,0,0,0,0,10);
				ParticleEffect.SMOKE_LARGE.display(loc,30,0.6F,0.6F,0.6F,0,50);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.25 || e.getLocation().add(0, 1, 0).distance(loc) < 1.25) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							ParticleEffect.SMOKE_LARGE.display(loc,30,1F,1F,1F,0.4F,50);
							loc.getWorld().playSound(loc, Sound.HORSE_SKELETON_DEATH, 1, 1);
							((LivingEntity)e).damage(dr.getDamage(), p);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				if(t>60) {
					this.cancel();
				}
				t+=0.7;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.SMOKE_LARGE.display(loc,60,0,0,0,0,10);
				ParticleEffect.SMOKE_LARGE.display(loc,30,0.6F,0.6F,0.6F,0,50);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.25 || e.getLocation().add(0, 1, 0).distance(loc) < 1.25) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							ParticleEffect.SMOKE_LARGE.display(loc,30,1F,1F,1F,0.4F,50);
							loc.getWorld().playSound(loc, Sound.HORSE_SKELETON_DEATH, 1, 1);
							((LivingEntity)e).damage(dr.getDamage(), p);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				if(t>60) {
					this.cancel();
				}
				t+=0.7;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.SMOKE_LARGE.display(loc,60,0,0,0,0,10);
				ParticleEffect.SMOKE_LARGE.display(loc,30,0.6F,0.6F,0.6F,0,50);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.25 || e.getLocation().add(0, 1, 0).distance(loc) < 1.25) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							ParticleEffect.SMOKE_LARGE.display(loc,30,1F,1F,1F,0.4F,50);
							loc.getWorld().playSound(loc, Sound.HORSE_SKELETON_DEATH, 1, 1);
							((LivingEntity)e).damage(dr.getDamage(), p);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				if(t>60) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

	
	
}
