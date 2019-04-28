package me.Vark123.EpicRPG.Runes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;

public class Meteor extends Rune {
	
	private List<Entity> shooted;

	public Meteor(DynamicRune dr, Player p) {
		super(dr, p);
		shooted = new ArrayList<Entity>();
	}

	@Override
	public void castSpell() {
		Location loc = p.getTargetBlock((Set<Material>)null, 40).getLocation();
		loc.add(0, 30, 0);
		new BukkitRunnable() {
			double t = 30;
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				double y = t;
				loc.add(0, y, 0);
				loc.getWorld().playSound(loc, Sound.EXPLODE, 1, 1);
				ParticleEffect.EXPLOSION_HUGE.display(loc, 100, 0, 0, 0, 0, 1);
				ParticleEffect.CLOUD.display(loc, 100, 0.75F, 0.75F, 0.75F, 0.1F, 30);
				if(!loc.getBlock().getType().equals(Material.AIR)) {
					spellEffect(loc.clone());
					this.cancel();
				}
				loc.subtract(0, y, 0);
				t--;
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}
	
	private void spellEffect(Location loc) {
		Location check = loc.clone();
		new BukkitRunnable() {
			double t = 0;
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				t++;
				for(double theta = 0; theta <= (Math.PI*2); theta = theta + (Math.PI/16)) {
					double x = t*Math.sin(theta);
					double z = t*Math.cos(theta);
					loc.add(x, 1, z);
					loc.getWorld().playSound(loc, Sound.EXPLODE, 10, 1);
					if(loc.distance(check)>dr.getObszar()) {
						this.cancel();
					}
					ParticleEffect.EXPLOSION_LARGE.display(loc,30,0,0,0,0,2);
					for(Entity entity:loc.getChunk().getEntities()) {
						if(entity.getLocation().distance(loc) < 0.75 || entity.getLocation().add(0, 1, 0).distance(loc) < 0.75 || entity.getLocation().add(0, 1, 0).distance(loc) < 0.75) {
							if(!entity.equals(p) && entity instanceof LivingEntity && !shooted.contains(entity) && entity.getLocation().distance(check) <= dr.getObszar()) {
								((LivingEntity)entity).damage(dr.getDamage(), p);
								shooted.add(entity);
							}
						}
					}
					loc.subtract(x,1,z);
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 2);
	}

}
