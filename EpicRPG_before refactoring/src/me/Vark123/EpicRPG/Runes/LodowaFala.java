package me.Vark123.EpicRPG.Runes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;

public class LodowaFala extends Rune {

	private List<Entity> shooted;
	
	public LodowaFala(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		shooted = new ArrayList<Entity>();
		p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, -10);
		PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 20*10, 1);
		new BukkitRunnable() {
			Location loc = p.getLocation();
			Location check = p.getLocation();
			double t = 0;
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				t+=0.25;
				for(double theta = 0; theta <= (Math.PI*2); theta = theta + (Math.PI/16)) {
					double x = t*Math.sin(theta);
					double z = t*Math.cos(theta);
					loc.add(x, 0.25, z);
					if(loc.distance(check)>dr.getObszar()) {
						this.cancel();
					}
					ParticleEffect.SNOWBALL.display(loc,30,0.2F,0.2F,0.2F,0,10);
					ParticleEffect.CLOUD.display(loc,30,0.2F,0.2F,0.2F,0,10);
					loc.add(0,0.25,0);
					ParticleEffect.SNOWBALL.display(loc,30,0.2F,0.2F,0.2F,0,10);
					ParticleEffect.CLOUD.display(loc,30,0.2F,0.2F,0.2F,0,10);
					loc.add(0,0.25,0);
					ParticleEffect.SNOWBALL.display(loc,30,0.2F,0.2F,0.2F,0,10);
					ParticleEffect.CLOUD.display(loc,30,0.2F,0.2F,0.2F,0,10);
					loc.add(0,0.25,0);
					ParticleEffect.SNOWBALL.display(loc,30,0.2F,0.2F,0.2F,0,10);
					ParticleEffect.CLOUD.display(loc,30,0.2F,0.2F,0.2F,0,10);
					loc.add(0,0.25,0);
					ParticleEffect.SNOWBALL.display(loc,30,0.2F,0.2F,0.2F,0,10);
					ParticleEffect.CLOUD.display(loc,30,0.2F,0.2F,0.2F,0,10);
					loc.add(0,0.25,0);
					ParticleEffect.SNOWBALL.display(loc,30,0.2F,0.2F,0.2F,0,10);
					ParticleEffect.CLOUD.display(loc,30,0.2F,0.2F,0.2F,0,10);
					for(Entity entity:loc.getChunk().getEntities()) {
						if(entity.getLocation().distance(loc) < 0.75 || entity.getLocation().add(0, 1, 0).distance(loc) < 0.75 || entity.getLocation().add(0, 1, 0).distance(loc) < 0.75) {
							if(!entity.equals(p) && entity instanceof LivingEntity && !shooted.contains(entity) && entity.getLocation().distance(check) <= dr.getObszar()) {
								((LivingEntity)entity).damage(dr.getDamage(), p);
								((LivingEntity)entity).addPotionEffect(pe);
								entity.getLocation().getWorld().playSound(entity.getLocation(), Sound.FIZZ, 1, 1);
								shooted.add(entity);
							}
						}
					}
					loc.subtract(x,1.5,z);
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

}
