package me.Vark123.EpicRPG.RpgFight;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.slikey.effectlib.util.ParticleEffect;
import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;
import me.Vark123.EpicRPG.Stats.ChangeStats;
import me.Vark123.EpicRPG.Stats.CheckStats;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class RpgEntityDamageEvent implements Listener {
	
	private static double dmg;
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.MONITOR)
	public static void onDamage(EntityDamageByEntityEvent e) {
		boolean isCrit = false;
		if(!(e.getDamager() instanceof Player)) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				RpgPlayer rpg = Main.getListaRPG().get(p);
				if(rpg.hasSfera()) {
					((LivingEntity)e.getDamager()).damage(e.getDamage()*0.25);
					p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
				}
				if(rpg.hasGruboskornosc()) {
					e.setDamage(e.getDamage()*rpg.getKrag()*0.1);
				}
				dmg = (int)(e.getDamage()-(rpg.getOchrona()*0.25)+0.99);
				if(dmg < 1) {
					dmg = 1;
				}
			}else {
				dmg = e.getDamage();
			}
			e.setDamage(dmg);
		}
		if(e.getDamager() instanceof Arrow) {
			Arrow a = (Arrow) e.getDamager();
			if(a.getShooter() instanceof Player) {
				Player p = (Player) a.getShooter();
				RpgPlayer rpg = Main.getListaRPG().get(p);
				if(e.getEntity().equals(p)) {
					e.setCancelled(true);
					return;
				}
				if(!CheckStats.check(rpg, p.getItemInHand())) {
					p.sendMessage("§cNie mozesz uzywac tej broni");
					e.setCancelled(true);
				}
				if(!p.getItemInHand().getItemMeta().getDisplayName().equals(rpg.getwName())) {
					rpg.setwName(p.getItemInHand().getItemMeta().getDisplayName());
					ChangeStats.change(rpg);
				}
				if(RpgCriticalDamage.checkCrit(rpg)) {
					isCrit = true;
					dmg = (((2*rpg.getObrazenia() + 0.6*rpg.getFinalzrecznosc() + 0.4*rpg.getFinalsila() + 0.5*rpg.getFinalinteligencja())*RpgShootBowEvent.getPower())*RpgCriticalDamage.onAttack());
				}else {
					dmg = (((rpg.getObrazenia() + 0.3*rpg.getFinalzrecznosc() + 0.1*rpg.getFinalsila() + 0.25*rpg.getFinalinteligencja())*RpgShootBowEvent.getPower())*RpgCriticalDamage.onAttack());
				}
				if(rpg.hasWyostrzoneZmysly()) {
					dmg*=(4/3);
				}
				if(rpg.hasOgnistaStrzala()) {
					dmg*=1.5;
					rpg.setOgnistaStrzala(false);
					e.getEntity().setFireTicks(20*10);
					Location loc = rpg.getP().getLocation();
					Location loc2 = e.getEntity().getLocation();
					for(double y = 0.1;y<=2.2;y+=0.1) {
						for(double t = 0;t<=2*Math.PI;t+=(Math.PI/16)) {
							double x = Math.sin(t);
							double z = Math.cos(t);
							loc.add(x,y,z);
							loc2.add(x, y, z);
							ParticleEffect.FLAME.display(loc, 10, 0, 0, 0, 0, 1);
							ParticleEffect.FLAME.display(loc2, 10, 0, 0, 0, 0, 1);
							loc2.subtract(x, y, z);
							loc.subtract(x, y, z);
						}
					}
				}
				if(rpg.hasZatrutaStrzala()) {
					dmg*=1.5;
					rpg.setZatrutaStrzala(false);
					PotionEffect pe = new PotionEffect(PotionEffectType.POISON, 20*10, 4);
					((LivingEntity)e).addPotionEffect(pe);
					Location loc = rpg.getP().getLocation();
					Location loc2 = e.getEntity().getLocation();
					for(double y = 0.1;y<=2.2;y+=0.1) {
						for(double t = 0;t<=2*Math.PI;t+=(Math.PI/16)) {
							double x = Math.sin(t);
							double z = Math.cos(t);
							loc.add(x,y,z);
							loc2.add(x, y, z);
							ParticleEffect.SLIME.display(loc, 10, 0, 0, 0, 0, 1);
							ParticleEffect.SLIME.display(loc2, 10, 0, 0, 0, 0, 1);
							loc2.subtract(x, y, z);
							loc.subtract(x, y, z);
						}
					}
				}
				if(rpg.hasPrecyzyjnyStrzal()) {
					dmg*=2.5;
					rpg.setPrecyzyjnyStrzal(false);
				}
				if(rpg.hasLodowaStrzala()) {
					dmg*=1.9;
					rpg.setLodowaStrzala(false);
					PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 20*15, 2);
					((LivingEntity)e).addPotionEffect(pe);
					Location loc = rpg.getP().getLocation();
					Location loc2 = e.getEntity().getLocation();
					for(double y = 0.1;y<=2.2;y+=0.1) {
						for(double t = 0;t<=2*Math.PI;t+=(Math.PI/16)) {
							double x = Math.sin(t);
							double z = Math.cos(t);
							loc.add(x,y,z);
							loc2.add(x, y, z);
							ParticleEffect.SNOWBALL.display(loc, 10, 0, 0, 0, 0, 1);
							ParticleEffect.SNOWBALL.display(loc2, 10, 0, 0, 0, 0, 1);
							loc2.subtract(x, y, z);
							loc.subtract(x, y, z);
						}
					}
				}
				if(isCrit) {
					PacketPlayOutChat pc = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"§7[§4§lKRYTYK§7] §aZadales §c"+(int)dmg+" §aobrazen\",\"color\":\"white\"}"), (byte)2);
			        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(pc);
				}
			}
			e.setDamage(DamageModifier.BASE, dmg);
//			else {
//				if(e.getEntity() instanceof Player) {
//					Player p = (Player) e.getEntity();
//					RpgPlayer rpg = Main.getRpgPlayer(p);
//					dmg = (e.getDamage()-rpg.getOchrona());
//					if(dmg < 0) {
//						dmg = 2;
//					}
//					Bukkit.broadcastMessage("test5 " + dmg);
//					Bukkit.broadcastMessage("test5 " + e.getDamage());
//				}else {
//					dmg = e.getDamage();
//				}
//			}
		}
		else if(e.getDamager() instanceof Player) {
			if(e.getCause().equals(DamageCause.ENTITY_ATTACK)) {
				Player p = (Player) e.getDamager();
				RpgPlayer rpg = Main.getListaRPG().get(p);
				if(!CheckStats.check(rpg, p.getItemInHand())) {
					p.sendMessage("§cNie mozesz uzywac tej broni");
					e.setCancelled(true);
				}
				if(p.getItemInHand().getItemMeta() == null) {
					rpg.setwName("pustka");
					ChangeStats.change(rpg);
				}
				else if(p.getItemInHand().getItemMeta().getDisplayName() != null) {
					if (!p.getItemInHand().getItemMeta().getDisplayName().equals(rpg.getwName())) {
						rpg.setwName(p.getItemInHand().getItemMeta().getDisplayName());
						ChangeStats.change(rpg);
					}
				}
				if(!CheckStats.isRune(p.getItemInHand())) {
					if(RpgCriticalDamage.checkCrit(rpg)) {
						isCrit = true;
						dmg = ((2*rpg.getObrazenia() + 0.4*rpg.getFinalzrecznosc() + 0.6*rpg.getFinalsila() + rpg.getFinalinteligencja())*RpgCriticalDamage.onAttack());
					}else {
						dmg = ((rpg.getObrazenia() + 0.1*rpg.getFinalzrecznosc() + 0.3*rpg.getFinalsila() + 0.5*rpg.getFinalinteligencja())*RpgCriticalDamage.onAttack());
					}
				}else {
					if(RpgCriticalDamage.checkCrit(rpg)) {
						isCrit = true;
						dmg = 2*e.getDamage()+2*rpg.getFinalinteligencja();
					}else {
						dmg = e.getDamage()+rpg.getFinalinteligencja();
					}
				}
				if(rpg.hasTrans()) {
					dmg*=1.5;
				}
				if(rpg.hasSzalBitewny()) {
					dmg*=2;
				}
				if(isCrit) {
					PacketPlayOutChat pc = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"§7[§4§lKRYTYK§7] §aZadales §c"+(int)dmg+" §aobrazen\",\"color\":\"white\"}"), (byte)2);
					((CraftPlayer)p).getHandle().playerConnection.sendPacket(pc);
				}
			}
			if(e.getCause().equals(DamageCause.CUSTOM)) {
				Player p = (Player) e.getDamager();
				p.sendMessage("przechodzi");
				RpgPlayer rpg = Main.getListaRPG().get(p);
				if(RpgCriticalDamage.checkCrit(rpg)) {
					dmg = ((2*rpg.getObrazenia() + 0.75*rpg.getFinalinteligencja())*RpgCriticalDamage.onAttack());
					p.sendMessage("§7[§cZadales §4§l"+(int)dmg+" §cobrazen§7]");
				}else {
					dmg = ((rpg.getObrazenia() + 0.25*rpg.getFinalinteligencja())*RpgCriticalDamage.onAttack());
				}
			}
			e.setDamage(DamageModifier.BASE, dmg);
		}
	}
	
}