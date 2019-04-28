package me.Vark123.EpicRPG.Runes;

import java.util.Random;

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

public class UkazanieSmierci extends Rune {

	public UkazanieSmierci(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.FUSE, 1, 1);
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
							spellEffect(e);
							this.cancel();
							break;
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
							spellEffect(e);
							this.cancel();
							break;
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
							spellEffect(e);
							this.cancel();
							break;
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
	
	
	@SuppressWarnings("deprecation")
	private void spellEffect(Entity e) {
		if(isHit()) {
			ParticleEffect.SMOKE_LARGE.display(e.getLocation(),30,1F,1F,1F,0.4F,100);
			e.getLocation().getWorld().playSound(e.getLocation(), Sound.HORSE_SKELETON_DEATH, 10, 1);
			((LivingEntity)e).damage(((LivingEntity)e).getMaxHealth(), p);
		}else {
			ParticleEffect.VILLAGER_HAPPY.display(e.getLocation(),30,1F,1F,1F,0.4F,100);
			e.getLocation().getWorld().playSound(e.getLocation(), Sound.VILLAGER_YES, 10, 1);
		}
	}
	
	private boolean isHit() {
		Random rand = new Random();
		int los1 = rand.nextInt(100);
		int los2;
		do {
			los2 = rand.nextInt(100);
		}while(los2!=los1);
		int hit = rand.nextInt(100);
		if(hit == los1 || hit == los2) {
			return true;
		}
		return false;
	}

}
