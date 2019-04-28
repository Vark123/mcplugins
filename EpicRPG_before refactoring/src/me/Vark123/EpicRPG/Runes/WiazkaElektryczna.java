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

public class WiazkaElektryczna extends Rune {

	public WiazkaElektryczna(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
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
				ParticleEffect.ENCHANTMENT_TABLE.display(loc,30,0,0,0,0,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							spellEffect(e);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				t+=0.75;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.ENCHANTMENT_TABLE.display(loc,60,0,0,0,0,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							spellEffect(e);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				t+=0.75;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.ENCHANTMENT_TABLE.display(loc,60,0,0,0,0,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							spellEffect(e);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				t+=0.75;
				x = vec.getX()*t;
				y = vec.getY()*t+1.5;
				z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.ENCHANTMENT_TABLE.display(loc,60,0,0,0,0,10);
//				loc.getWorld().playSound(loc, Sound.FIRE_IGNITE, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							spellEffect(e);
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
	
	private void spellEffect(Entity e) {
		new BukkitRunnable() {
			int t = 0;
			@Override
			public void run() {
				if(t>=dr.getCzas()) {
					this.cancel();
				}
				if(!e.isDead()) {
					Location loc = e.getLocation();
					loc.getWorld().strikeLightningEffect(loc);
					((LivingEntity)e).damage(dr.getDamage(), p);
				}
				t++;
			}
		}.runTaskTimer(Main.getInst(), 0, 20);
	}

}
