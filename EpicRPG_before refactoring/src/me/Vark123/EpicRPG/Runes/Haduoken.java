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

public class Haduoken extends Rune {

	public Haduoken(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.SLIME_ATTACK, 1, 1);
		new BukkitRunnable() {
			double t = 0;
			Location loc = p.getLocation();
			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				t+=0.4;
				double x = t*vec.getX();
				double y = t*vec.getY()+1.5;
				double z = t*vec.getZ();
				loc.add(x, y, z);
				ParticleEffect.REDSTONE.display(loc,40,0.4F,0.4F,0.4F,0,30);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							loc.getWorld().playSound(loc, Sound.MAGMACUBE_JUMP, 10, 1);
							((LivingEntity)e).damage(dr.getDamage(), p);
							this.cancel();
						}
					}
				}
				loc.subtract(x, y, z);
				if(t>40) {
					this.cancel();
				}
				t+=0.4;
				x = t*vec.getX();
				y = t*vec.getY()+1.5;
				z = t*vec.getZ();
				loc.add(x, y, z);
				ParticleEffect.REDSTONE.display(loc,40,0.4F,0.4F,0.4F,0,30);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							loc.getWorld().playSound(loc, Sound.MAGMACUBE_JUMP, 10, 1);
							((LivingEntity)e).damage(dr.getDamage(), p);
							this.cancel();
						}
					}
				}
				loc.subtract(x, y, z);
				if(t>40) {
					this.cancel();
				}
				t+=0.4;
				x = t*vec.getX();
				y = t*vec.getY()+1.5;
				z = t*vec.getZ();
				loc.add(x, y, z);
				ParticleEffect.REDSTONE.display(loc,40,0.4F,0.4F,0.4F,0,30);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							loc.getWorld().playSound(loc, Sound.MAGMACUBE_JUMP, 10, 1);
							((LivingEntity)e).damage(dr.getDamage(), p);
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
