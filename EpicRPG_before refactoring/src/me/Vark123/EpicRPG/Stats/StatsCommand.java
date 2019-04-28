package me.Vark123.EpicRPG.Stats;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;
import me.Vark123.EpicRPG.Files.RpgFileOperation;

public class StatsCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("staty")) {
			RpgPlayer rpg = Main.getListaRPG().get((Player)sender);
			if(args.length != 0) {
				if(args[0].equalsIgnoreCase("sprawdz")) {
					ChangeStats.change(rpg);
				}
				else if (rpg.getP().hasPermission("EpicRPG.Sprawdz")){
					OfflinePlayer op;
					try {
						op = Bukkit.getOfflinePlayer(args[0]);
					}catch(Exception e) {
						return false;
					}
					if(op.isOnline()) {
						Player p = (Player) op;
						rpg = Main.getListaRPG().get(p);
					}
					else {
						sender.sendMessage("§cNie mozesz sprawdzic statystyk gracza, ktory jest offline");
						return false;
					}
				}
			}
//			ChangeStats.change(p);
			sender.sendMessage("§6§l========================= ");
			sender.sendMessage("§2Statystyki gracza §a" + RpgFileOperation.getNick(rpg) + "§2:");
			sender.sendMessage("§2Poziom: §a" + rpg.getLevel());
			sender.sendMessage("§a" + rpg.getExp() +" §7xp/§a"+ rpg.getNextLevel() +" §7xp");
			sender.sendMessage("§2Punkty nauki: §a" + rpg.getPN());
			sender.sendMessage("§2Obrazenia §a" + rpg.getObrazenia());
			sender.sendMessage("§2Obrona §a" + rpg.getOchrona());
			sender.sendMessage("§2Sila: §a" + rpg.getSila() + "§7/§a" + rpg.getFinalsila());
			sender.sendMessage("§2Zrecznosc: §a" + rpg.getZrecznosc() + "§7/§a" + rpg.getFinalzrecznosc());
			sender.sendMessage("§2Walka: §a" + rpg.getWalka() + "%§7/§a" + rpg.getFinalwalka()+"%");
			sender.sendMessage("§2Krag: §a" + rpg.getKrag());
			sender.sendMessage("§2Mana: §a"+rpg.getPresent_mana()+" §7/§2(§a" + rpg.getMana() + "§7/§a" + rpg.getFinalmana()+"§2)");
			sender.sendMessage("§2Inteligencja: §a" + rpg.getInteligencja() + "§7/§a" + rpg.getFinalinteligencja());
			sender.sendMessage("§6§l========================= ");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("level")) {
			RpgPlayer rpg = Main.getListaRPG().get((Player)sender);
			if(args.length != 0) {
				if (rpg.getP().hasPermission("EpicRPG.Sprawdz")){
					OfflinePlayer op;
					try {
						op = Bukkit.getOfflinePlayer(args[0]);
					}catch(Exception e) {
						return false;
					}
					if(op.isOnline()) {
						Player p = (Player) op;
						rpg = Main.getListaRPG().get(p);
					}
					else {
						sender.sendMessage("§cNie mozesz sprawdzic statystyk gracza, ktory jest offline");
						return false;
					}
				}
			}
			
			sender.sendMessage("§2Poziom: §a" + rpg.getLevel());
			sender.sendMessage("§7[§a" + rpg.getExp() +" xp§7/§a"+ rpg.getNextLevel() +" xp§7]");
			
		}
		return false;
	}

}
