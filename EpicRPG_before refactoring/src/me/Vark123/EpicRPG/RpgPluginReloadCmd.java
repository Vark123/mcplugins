package me.Vark123.EpicRPG;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RpgPluginReloadCmd implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("epicrpg")) {
			if(args.length != 0) {
				if(args[0].equalsIgnoreCase("reload")) {
					if(sender instanceof Player) {
						if(!((Player)sender).hasPermission("EpicRPG.reload")) {
							sender.sendMessage("§cNie masz uprawnien do uzycia tej komendy");
							return false;
						}
					}
					Main.getInst().reloadConfig();
				    Main.getInst().saveConfig();
				    sender.sendMessage("§aEpicRPG was reloaded");
				    return true;
				}
			}
		}
		return false;
	}

}
