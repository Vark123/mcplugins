package me.Vark123.EpicRPG.Runes;

import java.util.Date;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DynamicRune {
	
	private String nazwa = "";
	private int damage = 0;
	private Date data = new Date();
	private long dataLong = 0;
	private int krag = 1;
	private int price = 0;
	private String klasa = "";
	private int czas = 0;
	private int obszar = 0;
	
	public DynamicRune(ItemStack item) {
		ItemMeta im = item.getItemMeta();
		nazwa = im.getDisplayName();
		for(String s : im.getLore()) {
			if(s.contains("%")) continue;
			if(s.contains("Obrazenia: ")) {
				damage = Integer.parseInt(s.replace("§4- §8Obrazenia: §7", ""));
				continue;
			}
			if(s.contains("Obrazenia na sekunde: ")) {
				damage = Integer.parseInt(s.replace("§4- §8Obrazenia na sekunde: §7", ""));
				continue;
			}
			if(s.contains("Krag: ")) {
				krag = Integer.parseInt(s.replace("§4- §8Krag: §7", ""));
				continue;
			}
			if(s.contains("Klasa: ")) {
				klasa = s.replace("§4- §8Klasa: ", "");
				continue;
			}
			if(s.contains("Koszt many: ")) {
				price = Integer.parseInt(s.replace("§4- §8Koszt many: §7", ""));
				continue;
			}
			if(s.contains("Obszar: ")) {
				obszar = Integer.parseInt(s.replace("§4- §8Obszar: §7", ""));
				continue;
			}
			if(s.contains("Czas trwania: ")) {
				czas = Integer.parseInt(s.replace("§4- §8Czas trwania: §7", "").replace(" sekund", ""));
				continue;
			}
			if(s.contains("Czas regeneracji: ")) {
				int t = Integer.parseInt(s.replace("§4- §8Czas regeneracji: §7", "").replace(" sekund", ""));
				data.setTime(data.getTime()+(t*1000));
				dataLong = (long)t;
			}
		}
	}

	public long getDataLong() {
		return dataLong;
	}

	public String getNazwa() {
		return nazwa;
	}

	public Date getData() {
		return data;
	}

	public int getPrice() {
		return price;
	}

	public int getCzas() {
		return czas;
	}

	public int getObszar() {
		return obszar;
	}

	public int getDamage() {
		return damage;
	}

	public int getKrag() {
		return krag;
	}

	public String getKlasa() {
		return klasa;
	}

}
