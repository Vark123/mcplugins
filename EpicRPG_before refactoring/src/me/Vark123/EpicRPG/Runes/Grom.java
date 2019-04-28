package me.Vark123.EpicRPG.Runes;

import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;

public class Grom extends Rune {

	public Grom(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		Location loc = p.getLocation();
		p.playSound(loc, Sound.AMBIENCE_THUNDER, 10, 1);
		new BukkitRunnable() {
			double t = 0;
			@Override
			public void run() {
				t++;
				double x = loc.getX()+Math.random()*2*dr.getObszar()-dr.getObszar();
				double z = loc.getZ()+Math.random()*2*dr.getObszar()-dr.getObszar();
				Location target = new Location(loc.getWorld(), x, loc.getY(), z);
				spellEffect(target.clone());
				if(t>50) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 5);
		new BukkitRunnable() {
			double t = 0;
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				if(t>=20) {
					this.cancel();
				}
				t+=0.1;
				Collection<Entity> lista = loc.getWorld().getNearbyEntities(loc, dr.getObszar(), dr.getObszar(), dr.getObszar());
				for(Entity e : lista) {
					ParticleEffect.SNOWBALL.display(e.getLocation().add(0, 1.5, 0),30,0.3F,0.3F,0.3F,0.1F,7);
					ParticleEffect.FIREWORKS_SPARK.display(e.getLocation().add(0, 1.5, 0),30,0.3F,0.3F,0.3F,0.1F,7);
					ParticleEffect.CLOUD.display(e.getLocation().add(0, 1.5, 0),30,0.3F,0.3F,0.3F,0.1F,7);
				}
				
			}
		}.runTaskTimer(Main.getInst(), 0, 2);
	}

	private void spellEffect(Location target) {
		target.add(0, 30, 0);
		new BukkitRunnable() {
			double t = 30;
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				double y = t;
				target.add(0, y, 0);
				ParticleEffect.SNOWBALL.display(target, 100, 0.75F, 0.75F, 0.75F, 0.1F, 30);
				ParticleEffect.CLOUD.display(target, 100, 0.75F, 0.75F, 0.75F, 0.1F, 50);
				if(!target.getBlock().getType().equals(Material.AIR)) {
					for(Entity entity:target.getChunk().getEntities()) {
						if(entity.getLocation().distance(target) < 1.5 || entity.getLocation().add(0, 1, 0).distance(target) < 1.5 || entity.getLocation().add(0, 1, 0).distance(target) < 1.5) {
							if(!entity.equals(p) && entity instanceof LivingEntity) {
								((LivingEntity)entity).damage(dr.getDamage(), p);
								PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 20*15, 2);
								((LivingEntity)entity).addPotionEffect(pe);
								this.cancel();
							}
						}
					}
				}
				target.subtract(0, y, 0);
				t--;
				y = t;
				target.add(0, y, 0);
				ParticleEffect.SNOWBALL.display(target, 100, 0.75F, 0.75F, 0.75F, 0.1F, 30);
				ParticleEffect.CLOUD.display(target, 100, 0.75F, 0.75F, 0.75F, 0.1F, 50);
				if(!target.getBlock().getType().equals(Material.AIR)) {
					for(Entity entity:target.getChunk().getEntities()) {
						if(entity.getLocation().distance(target) < 1.5 || entity.getLocation().add(0, 1, 0).distance(target) < 1.5 || entity.getLocation().add(0, 1, 0).distance(target) < 1.5) {
							if(!entity.equals(p) && entity instanceof LivingEntity) {
								((LivingEntity)entity).damage(dr.getDamage(), p);
								PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 20*15, 2);
								((LivingEntity)entity).addPotionEffect(pe);
								this.cancel();
							}
						}
					}
				}
				target.subtract(0, y, 0);
				t--;
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}
	
}
