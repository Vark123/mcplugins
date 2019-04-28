package me.Vark123.EpicRPG.Horses;

import java.io.File;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.inventory.ItemStack;

import me.Vark123.EpicRPG.Files.RpgFileSystem;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.GenericAttributes;

public class RpgHorseCommand implements CommandExecutor {

	private static File f;
	private static YamlConfiguration fYml;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("horse")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§cTylko gracz moze uzyc tej komendy");
				return false;
			}
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§2Poprawne uzycie komendy /horse:");
				p.sendMessage("§a- /horse call - przywoluje twojego wierzchowca");
				return false;
			}
			if(args[0].equalsIgnoreCase("call")) {
				f = new File(RpgFileSystem.getPlayerHorsesFolder(), p.getName().toLowerCase()+"horse.yml");
				fYml = YamlConfiguration.loadConfiguration(f);
				if(fYml.getString("Kon.name").equalsIgnoreCase("brak")) {
					p.sendMessage("§cNie posiadasz wierzchowca");
					return false;
				}
				Horse horse = (Horse) p.getWorld().spawn(p.getLocation(), Horse.class);
				horse.setAdult();
				horse.setVariant(Variant.valueOf(fYml.getString("Kon.variant")));
				horse.setTamed(true);
				horse.setOwner(p);
				horse.setPassenger(p);
				horse.setCustomName("§7Kon " + p.getName());
				horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
				horse.setColor(Color.valueOf(fYml.getString("Kon.color")));
				horse.setMaxHealth(fYml.getInt("Kon.health"));
				horse.setHealth(fYml.getInt("Kon.health"));
				horse.setStyle(Style.valueOf(fYml.getString("Kon.style")));
				if(!fYml.getString("Kon.armor").equalsIgnoreCase("brak")) {
					horse.getInventory().setArmor(new ItemStack(Material.valueOf(fYml.getString("Kon.armor"))));
				}
				((EntityLiving)((CraftEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(fYml.getDouble("Kon.speed"));
			}
		}
		return false;
	}

}
