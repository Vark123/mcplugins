package me.Vark123.EpicRPG.Stats;

import java.io.IOException;
import java.util.List;

import me.Vark123.EpicRPG.RpgPlayer;

public class ReStats {

	private static int pn;
	
	public static int sprawdz(RpgPlayer rpg, List<String> lore, int dodaj) throws IOException {
		for(String s : lore) {
			if(s.contains("§2Koszt: §a")) {
				s = s.replace("§2Koszt: §a", "").replace(" §2punktow nauki", "");
				pn = Integer.parseInt(s);
			}
		}
		if(rpg.getPN() - pn < 0) {
			rpg.getP().sendMessage("§cMasz za malo punktow nauki!");
			return 0;
		}
		rpg.removePN(pn);
		return dodaj;
	}
	
}
