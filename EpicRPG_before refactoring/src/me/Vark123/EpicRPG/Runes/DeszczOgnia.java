package me.Vark123.EpicRPG.Runes;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldBorder;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldBorder.EnumWorldBorderAction;
import net.minecraft.server.v1_8_R3.WorldBorder;

public class DeszczOgnia extends Rune{
	
	public DeszczOgnia(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@Override
	public void castSpell() {
		Location loc = p.getLocation();
		p.playSound(loc, Sound.PORTAL_TRAVEL, 10, 1);
		worldBorder();
		new BukkitRunnable() {
			double t = 0;
			@Override
			public void run() {
				t++;
				double x = loc.getX()+Math.random()*2*dr.getObszar()-dr.getObszar();
				double z = loc.getZ()+Math.random()*2*dr.getObszar()-dr.getObszar();
				Location target = new Location(loc.getWorld(), x, loc.getY(), z);
				spellEffect(target.clone());
				if(t>15) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.getInst(), 0, 10);
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
				ParticleEffect.EXPLOSION_HUGE.display(target, 100, 0, 0, 0, 0, 1);
				ParticleEffect.FLAME.display(target, 100, 2F, 2F, 2F, 0.25F, 50);
				ParticleEffect.CLOUD.display(target, 100, 0.75F, 0.75F, 0.75F, 0.1F, 30);
				if(!target.getBlock().getType().equals(Material.AIR)) {
					for(Entity entity:target.getChunk().getEntities()) {
						if(entity.getLocation().distance(target) < 3.5 || entity.getLocation().add(0, 1, 0).distance(target) < 3.5 || entity.getLocation().add(0, 1, 0).distance(target) < 3.5) {
							if(!entity.equals(p) && entity instanceof LivingEntity) {
								((LivingEntity)entity).damage(dr.getDamage(), p);
								((LivingEntity)entity).setFireTicks(20*30);
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
	
	private void worldBorder() {
		List<Entity> lista = p.getNearbyEntities(dr.getObszar(), dr.getObszar(), dr.getObszar());
		lista.add(p);
		WorldBorder wb = new WorldBorder();
		for(Entity e:lista) {
			if(e instanceof Player) {
				Player p2 = (Player)e;
				wb.setCenter(p2.getLocation().getX()+10_000, p2.getLocation().getZ()+10_000);
				wb.setSize(1);
				PacketPlayOutWorldBorder border = new PacketPlayOutWorldBorder(wb, EnumWorldBorderAction.INITIALIZE);
				((CraftPlayer)p2).getHandle().playerConnection.sendPacket(border);
				new BukkitRunnable() {
					
					@Override
					public void run() {
						WorldBorder ww = new WorldBorder();
						ww.setSize(30_000_000);
						ww.setCenter(p2.getLocation().getX(), p2.getLocation().getZ());
						PacketPlayOutWorldBorder border = new PacketPlayOutWorldBorder(ww, EnumWorldBorderAction.INITIALIZE);
						((CraftPlayer)p2).getHandle().playerConnection.sendPacket(border);
					}
				}.runTaskLater(Main.getInst(), 20*15);
			}
		}
	}

}
