package me.Vark123.EpicRPG;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.Vark123.EpicRPG.Files.RpgFileSystem;
import me.Vark123.EpicRPG.Stats.ChangeStats;


public class RpgPlayer {
	
	private static File f;
	private static YamlConfiguration fYml;
	
	private Player p;
	
	private int Ochrona;
	private int obrazenia;
	private int finalsila;
	private int finalzrecznosc;
	private int finalwalka;
	private int finalmana;
	private int finalinteligencja;
	
	private int sila;
	private int zrecznosc;
	private int walka;
	private int mana;
	private int present_mana;
	private int inteligencja;
	private int krag;
	
	private int level;
	private double exp;
	private int nextLevel;
	
	private String wName;  //Nazwa broni
	private String proffesion;
	private String ranga;
	
	private int pn;
	
	private float pow; //Moc luku
	
	private boolean wyostrzoneZmysly;
	private boolean ognistaStrzala;
	private boolean zatrutaStrzala;
	private boolean precyzyjnyStrzal;
	private boolean lodowaStrzala;
	private boolean trans;
	private boolean szalBitewny;
	private boolean gruboskornosc;
	private boolean sfera;
	
	
	public RpgPlayer (Player p) {
		f = new File(RpgFileSystem.getUsersFolder(), p.getName().toLowerCase()+".yml");
		fYml = YamlConfiguration.loadConfiguration(f);
		
		this.p = p;
		this.sila = fYml.getInt("sila");
		this.zrecznosc = fYml.getInt("zrecznosc");
		this.walka = fYml.getInt("walka");
		this.mana = fYml.getInt("mana");
		this.present_mana = fYml.getInt("present_mana");
		this.inteligencja = fYml.getInt("inteligencja");
		this.krag = fYml.getInt("krag");
		
		this.proffesion = fYml.getString("proffesion");
		
		this.level = fYml.getInt("level");
		this.exp = fYml.getInt("exp");
		this.nextLevel = fYml.getInt("nextLevel");
		
		this.pn = fYml.getInt("PN");
		
		this.ranga = fYml.getString("ranga");
		
		if(p.getItemInHand().getItemMeta()==null) {
			wName = "pustka";
		}else {
			wName = p.getItemInHand().getItemMeta().getDisplayName();
		}
		
		this.wyostrzoneZmysly = false;
		this.ognistaStrzala = false;
		this.zatrutaStrzala = false;
		this.precyzyjnyStrzal = false;
		this.lodowaStrzala = false;
		this.trans = false;
		this.szalBitewny = false;
		this.gruboskornosc = false;
		this.sfera = false;
		
		ChangeStats.change(this);
	}
	
/***********************************************\
|												|
|					GETTERS						|
|					  AND						|
|					SETTERS						|
|												|
\***********************************************/	
	
	public void addXP(double xp) {
		this.exp+=xp;
	}
	
	public void addLevel(int lvl) {
		this.level += lvl;
	}
	
	public void setNextLevel(int xp) {
		this.nextLevel = xp;
	}
	
	public void addSila(int sila) {
		this.sila+=sila;
	}
	
	public void addZrecznosc(int zrecznosc) {
		this.zrecznosc+=zrecznosc;
	}
	
	public void addWalka(int walka) {
		this.walka+=walka;
	}
	
	public void addMana(int mana) {
		this.mana+=mana;
	}
	
	public void addPresentMana(int present_mana) {
		this.present_mana+=present_mana;
	}
	
	public void addPresentManaSmart(int present_mana) {
		if(present_mana+this.present_mana>this.finalmana) {
			this.present_mana = this.finalmana;
		}else {
			this.present_mana+=present_mana;
		}
	}
	
	public void removeresentMana(int present_mana) {
		this.present_mana-=present_mana;
	}
	
	public void addInteligencja(int inteligencja) {
		this.inteligencja+=inteligencja;
	}
	
	public void setProffesion(String prof) {
		this.proffesion = prof;
	}
	
	public void addPN(int pn) {
		this.pn += pn;
	}
	
	public void removePN(int pn) {
		this.pn -= pn;
	}
	
	public void setRanga(String ranga) {
		this.ranga = ranga;
	}
	
	public void addKrag(int krag) {
		this.krag += krag;
	}
	
	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public int getOchrona() {
		return Ochrona;
	}

	public void setOchrona(int Ochrona) {
		this.Ochrona = Ochrona;
	}

	public int getFinalsila() {
		return finalsila;
	}

	public void setFinalsila(int finalsila) {
		this.finalsila = finalsila;
	}

	public int getFinalzrecznosc() {
		return finalzrecznosc;
	}

	public void setFinalzrecznosc(int finalzrecznosc) {
		this.finalzrecznosc = finalzrecznosc;
	}

	public int getFinalwalka() {
		return finalwalka;
	}

	public void setFinalwalka(int finalwalka) {
		this.finalwalka = finalwalka;
	}

	public int getFinalmana() {
		return finalmana;
	}

	public void setFinalmana(int finalmana) {
		this.finalmana = finalmana;
	}

	public int getFinalinteligencja() {
		return finalinteligencja;
	}

	public void setFinalinteligencja(int finalinteligencja) {
		this.finalinteligencja = finalinteligencja;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public float getPow() {
		return pow;
	}

	public void setPow(float pow) {
		this.pow = pow;
	}

	public int getObrazenia() {
		return obrazenia;
	}

	public void setObrazenia(int obrazenia) {
		this.obrazenia = obrazenia;
	}

	public int getSila() {
		return sila;
	}

	public int getZrecznosc() {
		return zrecznosc;
	}

	public int getWalka() {
		return walka;
	}

	public int getMana() {
		return mana;
	}

	public int getPresent_mana() {
		return present_mana;
	}

	public int getInteligencja() {
		return inteligencja;
	}

	public int getLevel() {
		return level;
	}

	public double getExp() {
		return exp;
	}

	public int getNextLevel() {
		return nextLevel;
	}

	public String getProffesion() {
		return proffesion;
	}
	
	public String getRanga() {
		return ranga;
	}
	
	public int getPN() {
		return pn;
	}
	
	public int getKrag() {
		return krag;
	}

	public boolean hasWyostrzoneZmysly() {
		return wyostrzoneZmysly;
	}

	public void setWyostrzoneZmysly(boolean wyostrzoneZmysly) {
		this.wyostrzoneZmysly = wyostrzoneZmysly;
	}

	public boolean hasOgnistaStrzala() {
		return ognistaStrzala;
	}

	public void setOgnistaStrzala(boolean ognistaStrzala) {
		this.ognistaStrzala = ognistaStrzala;
	}

	public boolean hasZatrutaStrzala() {
		return zatrutaStrzala;
	}

	public void setZatrutaStrzala(boolean zatrutaStrzala) {
		this.zatrutaStrzala = zatrutaStrzala;
	}

	public boolean hasTrans() {
		return trans;
	}

	public void setTrans(boolean trans) {
		this.trans = trans;
	}

	public boolean hasSfera() {
		return sfera;
	}

	public void setSfera(boolean sfera) {
		this.sfera = sfera;
	}

	public boolean hasSzalBitewny() {
		return szalBitewny;
	}

	public void setSzalBitewny(boolean szalBitewny) {
		this.szalBitewny = szalBitewny;
	}

	public boolean hasGruboskornosc() {
		return gruboskornosc;
	}

	public void setGruboskornosc(boolean gruboskornosc) {
		this.gruboskornosc = gruboskornosc;
	}

	public boolean hasPrecyzyjnyStrzal() {
		return precyzyjnyStrzal;
	}

	public void setPrecyzyjnyStrzal(boolean precyzyjnyStrzal) {
		this.precyzyjnyStrzal = precyzyjnyStrzal;
	}

	public boolean hasLodowaStrzala() {
		return lodowaStrzala;
	}

	public void setLodowaStrzala(boolean lodowaStrzala) {
		this.lodowaStrzala = lodowaStrzala;
	}
	
}
