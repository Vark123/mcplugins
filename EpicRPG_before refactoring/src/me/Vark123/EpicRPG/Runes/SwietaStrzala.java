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

public class SwietaStrzala extends Rune {

	public SwietaStrzala(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
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
				ParticleEffect.FIREWORKS_SPARK.display(loc,30,0,0,0,0,10);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							((LivingEntity)e).damage(dr.getDamage(), p);
							e.getWorld().playSound(loc, Sound.FIRE, 1, 1);
							this.cancel();
						}
					}
				}
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					this.cancel();
				}
				loc.subtract(x, y, z);
				if(t>40) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
		
	}

}
