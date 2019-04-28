package me.Vark123.EpicRPG.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RpgChatCmd implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("chat")) {
			if(!(sender instanceof Player)) {
				if(args.length > 0) {
					if(args[0].equalsIgnoreCase("on")) {
						RpgChat.chat = true;
						sender.sendMessage("§aWlaczyles Chat");
						return true;
					}
					else if(args[0].equalsIgnoreCase("off")) {
						RpgChat.chat = false;
						sender.sendMessage("§aWylaczyles Chat");
						return true;
					}else {
						sender.sendMessage("§cPoprawne uzycie komendy to: /chat <on/off>");
						return false;
					}
				}else {
					RpgChat.chat = !RpgChat.chat;
					sender.sendMessage(RpgChat.chat == true ? "§aWlaczyles Chat":"§aWylaczyles Chat");
					return true;
				}
			}
			Player p = (Player) sender;
			if(!p.hasPermission("rpg.chatonoff")) {
				p.sendMessage("§cNie masz uprawnien do tej komendy");
				return false;
			}
				if(args.length > 0) {
					if(args[0].equalsIgnoreCase("on")) {
						RpgChat.chat = true;
						sender.sendMessage("§aWlaczyles Chat");
						return true;
					}
					else if(args[0].equalsIgnoreCase("off")) {
						RpgChat.chat = false;
						sender.sendMessage("§aWylaczyles Chat");
						return true;
					}else {
						sender.sendMessage("§cPoprawne uzycie komendy to: /chat <on/off>");
						return false;
					}
				}else {
					RpgChat.chat = !RpgChat.chat;
					sender.sendMessage(RpgChat.chat == true ? "§aWlaczyles Chat":"§aWylaczyles Chat");
					return true;
				}
		}
		if(cmd.getName().equalsIgnoreCase("chatclear")) {
			if(sender instanceof Player){
					Player p = (Player)sender;
				if(!p.hasPermission("rpg.chatclear")) {
					p.sendMessage("§cNie masz uprawnien do tej komendy");
					return false;
				}
				for(int i = 0; i < 100; i++) {
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage("§6Chat zostal wyczoszczony przez §4§l" + p.getName());
				return true;
			}else {
				for(int i = 0; i < 100; i++) {
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage("§6Chat zostal wyczoszczony przez §4§lconsole");
				return true;
			}
		}
		return false;
	}

}
