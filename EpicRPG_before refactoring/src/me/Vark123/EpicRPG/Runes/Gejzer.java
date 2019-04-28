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

public class Gejzer extends Rune {

	public Gejzer(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.SWIM, 1, 1);
		new BukkitRunnable() {
			double t = 0;
			Location loc = p.getLocation();
			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				t+=0.4;
				double x = t*vec.getX();
				double y = t*vec.getY()+0.1;
				double z = t*vec.getZ();
				loc.add(x, y, z);
				ParticleEffect.CLOUD.display(loc,40,0,0,0,0,10);
				ParticleEffect.CLOUD.display(loc,40,0.2F,0.2F,0.2F,0.01F,40);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.25 || e.getLocation().add(0, 1, 0).distance(loc) < 1.25 || e.getLocation().add(0, 1, 0).distance(loc) < 1.25) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							zadajDmg(e);
							this.cancel();
							break;
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
	
	private void zadajDmg(Entity e) {
		new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				ParticleEffect.DRIP_WATER.display(e.getLocation(),40,0.75F,1.9F,0.75F,0.25F,100);
				ParticleEffect.DRIP_WATER.display(e.getLocation().add(0, 1.5, 0),40,0.75F,1.9F,0.75F,0.25F,100);
				e.getLocation().getWorld().playSound(e.getLocation(), Sound.SPLASH2, 10, 1);
				((LivingEntity)e).damage(dr.getDamage(), p);
			}
		}.runTaskLater(Main.getInst(), 40);
	}

}
