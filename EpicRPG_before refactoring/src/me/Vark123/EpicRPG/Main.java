package me.Vark123.EpicRPG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import de.slikey.effectlib.Effect;
import me.Vark123.EpicRPG.EntryExp.Exp40;
import me.Vark123.EpicRPG.Equipment.ChangeEq;
import me.Vark123.EpicRPG.Files.RpgFileOperation;
import me.Vark123.EpicRPG.Files.RpgFileSystem;
import me.Vark123.EpicRPG.Horses.RpgDeathPlayerHorse;
import me.Vark123.EpicRPG.Horses.RpgHorseCommand;
import me.Vark123.EpicRPG.Horses.RpgHorseEvents;
import me.Vark123.EpicRPG.Horses.RpgHorseInventory;
import me.Vark123.EpicRPG.RpgFight.RpgEntityDamageEvent;
import me.Vark123.EpicRPG.RpgFight.RpgEntityDeathEvent;
import me.Vark123.EpicRPG.RpgFight.RpgShootBowEvent;
import me.Vark123.EpicRPG.Runes.DynamicRune;
import me.Vark123.EpicRPG.Runes.ManaPotionEvent;
import me.Vark123.EpicRPG.Runes.RuneInteractEvent;
import me.Vark123.EpicRPG.Stats.StatsCommand;
import me.Vark123.EpicRPG.Teachers.PnTeachers;
import me.Vark123.EpicRPG.Teachers.Teachers;
import me.Vark123.EpicRPG.chat.RpgChat;
import me.Vark123.EpicRPG.chat.RpgChatCmd;

public class Main extends JavaPlugin implements Listener {

	private static Map<Player,ConcurrentHashMap<String,DynamicRune>> listaRun = new ConcurrentHashMap<Player,ConcurrentHashMap<String,DynamicRune>>();
	private static Map<Player,RpgPlayer> listaRPG = new ConcurrentHashMap<Player,RpgPlayer>();
	private static Map<Fireball,Effect> fireballs = new ConcurrentHashMap<Fireball,Effect>();
	private static Main instance;
	private ArrayList<String> lore = new ArrayList<String>();{
		lore.add("§c§lObrazenia: 5");
		lore.add("§b§lObrazenia: 50");
	}
	private ItemStack test = new ItemStack(Material.DIAMOND_SWORD); {
		ItemMeta testm = test.getItemMeta();
		testm.setDisplayName("§b§lFrostMourne");
		testm.setLore(lore);
		test.setItemMeta(testm);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§c§lZatrzymanie pluginu EpicRPG");
		List<Player> lista = (List<Player>) Bukkit.getServer().getOnlinePlayers();
		for(Player p : lista) {
			try {
				RpgFileOperation.saveStats(listaRPG.get(p));
			} catch (IOException e) {
				System.out.println("Blad podczas zapisu danych gracza: "+p.getName());
			}
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void onEnable() {
		instance = this;
		RpgFileSystem.checkFiles();
		Bukkit.getConsoleSender().sendMessage("§a§lUruchomienie pluginu EpicRPG");
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new RpgTpPapers(), this);
		Bukkit.getPluginManager().registerEvents(new RpgHorseEvents(), this);
		Bukkit.getPluginManager().registerEvents(new RpgHorseInventory(), this);
		Bukkit.getPluginManager().registerEvents(new RpgEntityDamageEvent(), this);
		Bukkit.getPluginManager().registerEvents(new RpgEntityDeathEvent(), this);
		Bukkit.getPluginManager().registerEvents(new RpgShootBowEvent(), this);
		Bukkit.getPluginManager().registerEvents(new RpgChat(), this);
		Bukkit.getPluginManager().registerEvents(new RpgPlayerJoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new RpgPlayerQuitEvent(), this);
		Bukkit.getPluginManager().registerEvents(new RpgPlayerKickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new ChangeEq(), this);
		Bukkit.getPluginManager().registerEvents(new PnTeachers(), this);
		Bukkit.getPluginManager().registerEvents(new Teachers(), this);
		Bukkit.getPluginManager().registerEvents(new Exp40(), this);
		Bukkit.getPluginManager().registerEvents(new RuneInteractEvent(), this);
		Bukkit.getPluginManager().registerEvents(new RpgDeathPlayerHorse(), this);
		Bukkit.getPluginManager().registerEvents(new RpgStackableItems(),this);
		Bukkit.getPluginManager().registerEvents(new ManaPotionEvent(), this);
		Bukkit.getPluginCommand("horse").setExecutor(new RpgHorseCommand());
		Bukkit.getPluginCommand("chat").setExecutor(new RpgChatCmd());
		Bukkit.getPluginCommand("chatclear").setExecutor(new RpgChatCmd());
		Bukkit.getPluginCommand("staty").setExecutor(new StatsCommand());
		Bukkit.getPluginCommand("level").setExecutor(new StatsCommand());
		Bukkit.getPluginCommand("epicrpg").setExecutor(new RpgPluginReloadCmd());
		
		List<Player> lista = (List<Player>) Bukkit.getServer().getOnlinePlayers();
		for(Player p : lista) {
			RpgPlayer rpg = new RpgPlayer(p);
			listaRPG.put(p,rpg);
		}
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				for(Player p : lista) {
					try {
						RpgFileOperation.saveStats(listaRPG.get(p));
					} catch (IOException e) {
						System.out.println("Blad podczas zapisu danych gracza: "+p.getName());
					}
				}
			}
			
		}, 20*60*60, 20*60*60);
	}
	
	public static Main getInst(){
		return instance;
	}
	
	public static Map<Player,ConcurrentHashMap<String,DynamicRune>> getListaRun(){
		return listaRun;
	}
	
	public static Map<Fireball,Effect> getFireballs(){
		return fireballs;
	}
	
	public static Map<Player,RpgPlayer> getListaRPG(){
		return listaRPG;
	}
}