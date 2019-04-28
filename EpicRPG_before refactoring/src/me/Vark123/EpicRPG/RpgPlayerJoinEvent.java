package me.Vark123.EpicRPG;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.Vark123.EpicRPG.Files.RpgFileSystem;
import me.Vark123.EpicRPG.Stats.ChangeStats;

public class RpgPlayerJoinEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws IOException {
		File f;
		YamlConfiguration fYml;
		
		if(RpgFileSystem.getPFile(e.getPlayer()) == null) {
			f = new File(RpgFileSystem.getUsersFolder(), e.getPlayer().getName().toLowerCase()+".yml");
			f.createNewFile();
			fYml = YamlConfiguration.loadConfiguration(f);
			fYml.set("nick", e.getPlayer().getName().toLowerCase());
			fYml.set("UUID", e.getPlayer().getUniqueId().toString());
			fYml.set("ranga", "§2Gracz");
			fYml.set("PN", 10);
			fYml.set("proffesion", "§aobywatel");
			fYml.set("level", 1);
			fYml.set("exp", 0);
			fYml.set("nextLevel", 500);
			fYml.set("sila", 0);
			fYml.set("zrecznosc", 0);
			fYml.set("walka", 0);
			fYml.set("mana", 0);
			fYml.set("present_mana", 0);
			fYml.set("inteligencja", 0);
			fYml.set("krag", 0);
			fYml.save(f);
		}
		if(RpgFileSystem.getPQFile(e.getPlayer()) == null) {
				f = new File(RpgFileSystem.getPlayerQuestsFolder(), e.getPlayer().getName().toLowerCase()+"quests.yml");
				f.createNewFile();
				fYml = YamlConfiguration.loadConfiguration(f);
				fYml.set("nick", e.getPlayer().getName().toLowerCase());
				fYml.set("UUID", e.getPlayer().getUniqueId().toString());
				fYml.set("QuestsDone", null);
				fYml.set("QuestsTake", null);
				fYml.set("Teachers", null);
				fYml.save(f);
		}
		if(RpgFileSystem.getPHorseFile(e.getPlayer()) == null) {
			f = new File(RpgFileSystem.getPlayerHorsesFolder(), e.getPlayer().getName().toLowerCase()+"horse.yml");
			f.createNewFile();
			fYml = YamlConfiguration.loadConfiguration(f);
			fYml.set("nick", e.getPlayer().getName().toLowerCase());
			fYml.set("UUID", e.getPlayer().getUniqueId().toString());
			fYml.set("Kon.name", "brak");
			fYml.save(f);
		}
		RpgPlayer rpg = new RpgPlayer(e.getPlayer());
		ChangeStats.change(rpg);
		Main.getListaRPG().put(e.getPlayer(),rpg);
//		e.getPlayer().setHealthScale(40);
		Bukkit.getScheduler().runTaskLater(Main.getInst(), new BukkitRunnable() {
			
			@Override
			public void run() {
				e.getPlayer().setHealth(e.getPlayer().getMaxHealth());
				e.getPlayer().setFoodLevel(20);
				
			}
		}, 20);
	}

}
