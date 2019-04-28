package me.Vark123.EpicRPG.Horses;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;

import me.Vark123.EpicRPG.Files.RpgFileSystem;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.GenericAttributes;

public class RpgHorseEvents implements Listener {
	
	private static File f;
	private static YamlConfiguration fYml;
//	private List<Block> Listb = new ArrayList<Block>();
//	private Block block;
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e) throws IOException {
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Material m = e.getPlayer().getLocation().getBlock().getType();
			if(m.equals(Material.STATIONARY_WATER) || m.equals(Material.WATER)) {
				Block block = e.getClickedBlock();
				if(block.getType().equals(Material.DIRT) || block.getType().equals(Material.WATER)) {
					Boat boat = (Boat) p.getWorld().spawn(p.getLocation(), Boat.class);
					boat.setPassenger(p);
					return;
				}
			}
		}
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Block block = e.getClickedBlock();
			if(block.getType().equals(Material.RAILS)) {
				Location l = new Location(block.getWorld(), block.getLocation().getX(), block.getLocation().getY(), block.getLocation().getZ(), block.getLocation().getYaw(), block.getLocation().getPitch());
				Minecart minecart = (Minecart) p.getWorld().spawn(l, Minecart.class);
				minecart.setPassenger(p);
				minecart.setVelocity(p.getVelocity());
				return;
			}
		}
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || 
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getItem() == null) {
				return;
			}
			if(e.getItem().getType().equals(Material.CARROT_STICK)) {
				ItemStack item = e.getItem();
				if(item.getItemMeta().hasDisplayName() &&
					item.getItemMeta().getDisplayName().contains("Kon")) {
					p.getInventory().removeItem(item);
					p.updateInventory();
					Horse horse = (Horse) p.getWorld().spawn(p.getLocation(), Horse.class);
					horse.setAdult();
					horse.setVariant(Variant.HORSE);
					horse.setTamed(true);
					horse.setOwner(p);
					horse.setPassenger(p);
					horse.setCustomName("§7Kon " + p.getName());
					horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
					if(item.getItemMeta().getDisplayName().contains("Podstawowy")) {
						horse.setColor(Color.BROWN);
						horse.setMaxHealth(15);
						horse.setHealth(15);
						horse.setStyle(Style.BLACK_DOTS);
						((EntityLiving)((CraftEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.3);
					}
					if(item.getItemMeta().getDisplayName().contains("Zelazny")) {
						horse.setColor(Color.BLACK);
						horse.setMaxHealth(20);
						horse.setHealth(20);
						horse.setStyle(Style.WHITEFIELD);
						horse.getInventory().setArmor(new ItemStack(Material.IRON_BARDING));
						((EntityLiving)((CraftEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.4);
					}
					if(item.getItemMeta().getDisplayName().contains("Zloty")) {
						horse.setColor(Color.CREAMY);
						horse.setMaxHealth(25);
						horse.setHealth(25);
						horse.setStyle(Style.NONE);
						horse.getInventory().setArmor(new ItemStack(Material.GOLD_BARDING));
						((EntityLiving)((CraftEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.5);
					}
					if(item.getItemMeta().getDisplayName().contains("Diamentowy")) {
						horse.setColor(Color.WHITE);
						horse.setMaxHealth(30);
						horse.setHealth(30);
						horse.setStyle(Style.NONE);
						horse.getInventory().setArmor(new ItemStack(Material.DIAMOND_BARDING));
						((EntityLiving)((CraftEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.6);
					}
					if(item.getItemMeta().getDisplayName().contains("Zombie")) {
						horse.setColor(Color.BROWN);
						horse.setMaxHealth(40);
						horse.setHealth(40);
						horse.setStyle(Style.BLACK_DOTS);
						horse.setVariant(Variant.UNDEAD_HORSE);
						((EntityLiving)((CraftEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.7);
					}
					if(item.getItemMeta().getDisplayName().contains("Szkielet")) {
						horse.setColor(Color.BROWN);
						horse.setMaxHealth(50);
						horse.setHealth(50);	
						horse.setStyle(Style.BLACK_DOTS);
						horse.setVariant(Variant.SKELETON_HORSE);
						((EntityLiving)((CraftEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.8);
					}
					f = new File(RpgFileSystem.getPlayerHorsesFolder(), p.getName().toLowerCase()+"horse.yml");
					fYml = YamlConfiguration.loadConfiguration(f);
					fYml.set("Kon.name", horse.getCustomName().toString());
					fYml.set("Kon.color", horse.getColor().toString());
					fYml.set("Kon.health", horse.getMaxHealth());
					fYml.set("Kon.style", horse.getStyle().toString());
					fYml.set("Kon.variant", horse.getVariant().toString());
					fYml.set("Kon.speed", ((EntityLiving)((CraftEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue());
					fYml.set("Kon.armor", horse.getInventory().getArmor() != null ? horse.getInventory().getArmor().getType().toString():"brak");
					fYml.save(f);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerDismount(VehicleExitEvent e) {
		if(e.getExited() instanceof Player) {
			Player p = (Player)e.getExited();
			if(e.getVehicle() instanceof Horse) {
				Horse horse = (Horse) e.getVehicle();
				if(horse.getCustomName() != null) {
					if(horse.getCustomName().equalsIgnoreCase("§7Kon "+p.getName())) {
						horse.remove();
						return;
					}
				}
			}else if(e.getVehicle() instanceof Boat) {
				Boat boat = (Boat) e.getVehicle();
				boat.remove();
				return;
			}else if(e.getVehicle() instanceof Minecart) {
				Minecart minecart = (Minecart) e.getVehicle();
				minecart.remove();
				return;
			}
		}
	}

}
