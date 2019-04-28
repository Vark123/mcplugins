package me.Vark123.EpicRPG.Files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import me.Vark123.EpicRPG.RpgPlayer;

public class RpgFileOperation {
	
	private static File f;
	private static YamlConfiguration fYml;
	
	public static void saveStats(RpgPlayer rpg) throws IOException {
		f = new File(RpgFileSystem.getUsersFolder(), rpg.getP().getName().toLowerCase()+".yml");
		fYml = YamlConfiguration.loadConfiguration(f);
		fYml.set("ranga", rpg.getRanga());
		fYml.set("PN", rpg.getPN());
		fYml.set("proffesion", rpg.getProffesion());
		fYml.set("level", rpg.getLevel());
		fYml.set("exp", rpg.getExp());
		fYml.set("nextLevel", rpg.getNextLevel());
		fYml.set("sila", rpg.getSila());
		fYml.set("zrecznosc", rpg.getZrecznosc());
		fYml.set("walka", rpg.getWalka());
		fYml.set("mana", rpg.getMana());
		fYml.set("present_mana", rpg.getPresent_mana());
		fYml.set("inteligencja", rpg.getInteligencja());
		fYml.set("krag", rpg.getKrag());
		fYml.save(f);
	}

	public static String getUuid(RpgPlayer rpg) {
		f = new File(RpgFileSystem.getUsersFolder(), rpg.getP().getName().toLowerCase()+".yml");
		fYml = YamlConfiguration.loadConfiguration(f);
		return fYml.getString("UUID");
	}

	public static String getNick(RpgPlayer rpg) {
		f = new File(RpgFileSystem.getUsersFolder(), rpg.getP().getName().toLowerCase()+".yml");
		fYml = YamlConfiguration.loadConfiguration(f);
		return fYml.getString("nick");
	}
	
}
