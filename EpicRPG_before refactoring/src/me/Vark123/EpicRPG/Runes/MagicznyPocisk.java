package me.Vark123.EpicRPG.Runes;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.slikey.effectlib.util.MathUtils;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.VectorUtils;
import me.Vark123.EpicRPG.Main;

public class MagicznyPocisk extends Rune {

	public MagicznyPocisk(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		new BukkitRunnable() {
			double t = 0;
			double theta = 0;
			Location loc = p.getLocation();
//			Vector vec = loc.getDirection().normalize();
			@Override
			public void run() {
				if(t==0) {
					loc.add(0, 1.5, 0);
				}
				t+=0.33;
				double x = Math.sin(theta);
				double y = 2*t;
				double z = -Math.sin(theta);
				theta = theta + Math.PI/16;
				Vector v = new Vector(x,y,z);
				VectorUtils.rotateAroundAxisX(v, (loc.getPitch() + 90) * MathUtils.degreesToRadians);
				VectorUtils.rotateAroundAxisZ(v, (loc.getPitch() - 45) * MathUtils.degreesToRadians);
	            VectorUtils.rotateAroundAxisY(v, -loc.getYaw() * MathUtils.degreesToRadians);
				loc.add(v);
				loc.getWorld().playSound(loc, Sound.LAVA_POP, 1, 1);
				ParticleEffect.REDSTONE.display(loc, Color.PURPLE, 30);
				for(Entity e:loc.getChunk().getEntities()) {
					if(e.getLocation().distance(loc) < 1.0 || e.getLocation().add(0, 1, 0).distance(loc) < 1.0) {
						if(!e.equals(p) && e instanceof LivingEntity) {
							loc.getWorld().playSound(loc, Sound.ENDERMAN_SCREAM, 1, 1);
							((LivingEntity)e).damage(dr.getDamage(), p);
							this.cancel();
						}
					}
				}
				loc.subtract(v);
				if(t>30) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

}
