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
import me.Vark123.EpicRPG.RpgPlayer;

public class Wyssanie extends Rune{

	public Wyssanie(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
		new BukkitRunnable() {
			double t = 0;
			Location loc = p.getLocation();
			Vector vec = loc.getDirection().normalize();
			@SuppressWarnings("deprecation")
			public void run() {
				t++;
				double x = vec.getX()*t;
				double y = vec.getY()*t+1.5;
				double z = vec.getZ()*t;
				loc.add(x,y,z);
				ParticleEffect.VILLAGER_ANGRY.display(loc,30,0,0,0,0,10);
				ParticleEffect.VILLAGER_ANGRY.display(loc,30,0.1F,0.1F,0.1F,0.23F,10);
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
				if(t>30) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}

	private void spellEffect(Entity e) {
		RpgPlayer rpg = Main.getListaRPG().get(p);
		p.playSound(p.getLocation(), Sound.CAT_HISS, 1, 0.9f);
		if(p.getMaxHealth() > (p.getHealth()+p.getMaxHealth()*0.05*rpg.getKrag())) {
			p.setHealth((int)(p.getHealth()+p.getMaxHealth()*0.05*rpg.getKrag()));
			p.sendMessage("§7[§6EpicRPG§7] §6Uleczyles sie w "+(10*rpg.getKrag())+"%");
		}else {
			p.setHealth(p.getMaxHealth());
			p.sendMessage("§7[§6EpicRPG§7] §6Uleczyles sie w pelni");
		}
		((LivingEntity)e).damage(dr.getDamage(), p);
		new BukkitRunnable() {
			double y = 0;
			Location loc = p.getLocation();
			Location loc2 = e.getLocation();
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				y+=0.1;
				for(double theta = 0;theta <= 2*Math.PI; theta=theta+(Math.PI/8)) {
					double x = y*Math.sin(theta);
					double z = y*Math.cos(theta);
					loc.add(x, y, z);
					loc2.add(x, y, z);
					ParticleEffect.VILLAGER_ANGRY.display(loc2,30,0,0,0,0,10);
					ParticleEffect.HEART.display(loc, 10, 0, 0, 0, 0, 1);
					loc2.subtract(x, y, z);
					loc.subtract(x, y, z);
				}
				if(y>=1.5) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 1);
	}
	
}
