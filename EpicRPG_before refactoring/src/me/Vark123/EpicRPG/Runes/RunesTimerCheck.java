package me.Vark123.EpicRPG.Runes;

import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.entity.Player;

import me.Vark123.EpicRPG.Main;

public class RunesTimerCheck {
	private static ConcurrentHashMap<String, DynamicRune> runy;
	public static boolean TimeLeft(DynamicRune dr, Player p) {
		if(!Main.getListaRun().containsKey(p)) {
			runy = new ConcurrentHashMap<String,DynamicRune>();
			Main.getListaRun().put(p, runy);
			return true;
		}else if(Main.getListaRun().get(p).containsKey(dr.getNazwa())) {
			DynamicRune dr2 = Main.getListaRun().get(p).get(dr.getNazwa());
			if((dr.getData().getTime()-dr2.getData().getTime())/1000<dr.getDataLong()) {
				p.sendMessage("§7[§6EpicRPG§7] §cRuny "+dr.getNazwa()+" §cbedziesz mogl uzyc za §7"+(dr.getDataLong()-(float)((dr.getData().getTime()-dr2.getData().getTime()))/1000)+" §csekund");
				return false;
			}else {
				return true;
			}
		}else {
			return true;
		}
	}
	
	public static void newTime(DynamicRune dr, Player p) {
		Main.getListaRun().get(p).put(dr.getNazwa(), dr);
	}

}
