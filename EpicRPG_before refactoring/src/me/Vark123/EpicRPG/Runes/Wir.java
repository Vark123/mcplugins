package me.Vark123.EpicRPG.Runes;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;

public class Wir extends Rune {

	public Wir(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
		new BukkitRunnable() {
			double t = 1;
			Location loc = p.getLocation();
			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				t+=0.6;
				double x = vec.getX()*t;
				double y = vec.getY()*t+1.5;
				double z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,30,0.3F,0.3F,0.3F,0.1F,20);
				ParticleEffect.CLOUD.display(loc,30,0,0,0,0,2);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							zadajDamage(e);
							e.getWorld().playSound(loc, Sound.ENDERDRAGON_WINGS, 1, 1);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				t+=0.6;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,30,0.3F,0.3F,0.3F,0.1F,20);
				ParticleEffect.CLOUD.display(loc,30,0,0,0,0,2);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							zadajDamage(e);
							e.getWorld().playSound(loc, Sound.ENDERDRAGON_WINGS, 1, 1);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				t+=0.6;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,30,0.3F,0.3F,0.3F,0.1F,20);
				ParticleEffect.CLOUD.display(loc,30,0,0,0,0,2);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							zadajDamage(e);
							e.getWorld().playSound(loc, Sound.ENDERDRAGON_WINGS, 1, 1);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				t+=0.6;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,30,0.3F,0.3F,0.3F,0.1F,20);
				ParticleEffect.CLOUD.display(loc,30,0,0,0,0,2);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							zadajDamage(e);
							e.getWorld().playSound(loc, Sound.ENDERDRAGON_WINGS, 1, 1);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				t+=0.6;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CLOUD.display(loc,30,0.3F,0.3F,0.3F,0.1F,20);
				ParticleEffect.CLOUD.display(loc,30,0,0,0,0,2);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							zadajDamage(e);
							e.getWorld().playSound(loc, Sound.ENDERDRAGON_WINGS, 1, 1);
							this.cancel();
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
	
	private void zadajDamage(Entity e) {
		((LivingEntity)e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*dr.getCzas(), 10));
		new BukkitRunnable() {
			int t = 0;
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				if(t>=dr.getCzas()) {
					this.cancel();
				}
				if(!e.isDead()) {
					ParticleEffect.CLOUD.display(e.getLocation().add(0, 0.7, 0),30,0.7F,0.7F,0.7F,0.15F,50);
					((LivingEntity)e).damage(dr.getDamage(),p);
				}
				t++;
			}
		}.runTaskTimer(Main.getInst(), 0, 20);
	}

}
