package me.Vark123.EpicRPG.Runes;

import java.util.HashSet;

import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class MalaBlyskawica extends Rune {

	public MalaBlyskawica(DynamicRune dr, Player p) {
		super(dr, p);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void castSpell() {
		Block b = p.getTargetBlock((HashSet<Byte>)null, 25);
		p.getWorld().strikeLightningEffect((p.getTargetBlock((HashSet<Byte>)null, 20)).getLocation());
		for(Entity e : b.getLocation().getChunk().getEntities()) {
			if(e.getLocation().distance(b.getLocation()) < 2.0 
					|| e.getLocation().add(0, 1, 0).distance(b.getLocation()) < 2.0
					|| e.getLocation().add(0, 1, 0).distance(b.getLocation()) < 2.0
					|| e.getLocation().add(0, 1, 0).distance(b.getLocation()) < 2.0) {
				if(!e.equals(p) && e instanceof LivingEntity) {
					((LivingEntity)e).damage(dr.getDamage(), p);
					e.getWorld().playSound(b.getLocation(), Sound.FIRE, 1, 1);
					break;
				}
			}
		}
	}

}
