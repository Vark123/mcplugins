package me.Vark123.EpicRPG.Files;

import java.io.File;

import org.bukkit.entity.Player;

import me.Vark123.EpicRPG.Main;

public class RpgFileSystem {

	private static File users = new File(Main.getInst().getDataFolder(), "users");
	private static File quests = new File(Main.getInst().getDataFolder(), "quests");
	private static File pquests = new File(Main.getInst().getDataFolder(), "pquests");
	private static File phorses = new File(Main.getInst().getDataFolder(), "phorses");
	
	public static void checkFiles() {
		if(!Main.getInst().getDataFolder().exists()) {
			Main.getInst().getDataFolder().mkdir();
		}
		if(!new File(Main.getInst().getDataFolder(), "config.yml").exists()) {
			Main.getInst().saveDefaultConfig();
		}
		if(!users.exists()) {
			users.mkdir();
		}
		if(!quests.exists()) {
			quests.mkdir();
		}
		if(!pquests.exists()) {
			pquests.mkdir();
		}
		if(!phorses.exists()) {
			phorses.mkdir();
		}
	}
	
	public static File getPFile(Player p) {
		File f = new File(users, p.getName().toLowerCase() + ".yml");
		if(!f.exists()) {
			return null;
		}
		return f;
	}
	
	public static File getPQFile(Player p) {
		File f = new File(pquests, p.getName().toLowerCase() + "quest.yml");
		if(!f.exists()) {
			return null;
		}
		return f;
	}
	
	public static File getPHorseFile(Player p) {
		File f = new File(phorses, p.getName().toLowerCase() + "horse.yml");
		if(!f.exists()) {
			return null;
		}
		return f;
	}
	
	public static File getUsersFolder() {
		return users;
	}
	
	public static File getQuestsFolder() {
		return quests;
	}
	
	public static File getPlayerQuestsFolder() {
		return pquests;
	}
	
	public static File getPlayerHorsesFolder() {
		return phorses;
	}
	
}
