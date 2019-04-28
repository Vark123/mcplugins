package me.Vark123.EpicRPG.Runes;

import org.bukkit.Location;
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

public class PiachWOczy extends Rune{

	public PiachWOczy(DynamicRune dr, Player p) {
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
				t+=0.25;
				double x = vec.getX()*t;
				double y = vec.getY()*t+0.1;
				double z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.CRIT.display(loc,30,0,0,0,0,10);
				ParticleEffect.CRIT.display(loc,30,0.75F,0.75F,0.75F,0.4F,50);
				loc.getWorld().playSound(loc, Sound.STEP_SAND, 1, 1);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							loc.getWorld().playSound(loc, Sound.FIZZ, 10, 1);
							PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 20*dr.getCzas(), 3);
							PotionEffect pe2 = new PotionEffect(PotionEffectType.BLINDNESS, 20*dr.getCzas(), 3);
							((LivingEntity)e).addPotionEffect(pe);
							((LivingEntity)e).addPotionEffect(pe2);
							this.cancel();
						}
					}
				}
				loc.subtract(x, y, z);
				if(t>10) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

}
