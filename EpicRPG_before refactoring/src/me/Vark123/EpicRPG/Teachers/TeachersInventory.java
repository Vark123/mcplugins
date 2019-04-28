package me.Vark123.EpicRPG.Teachers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Vark123.EpicRPG.RpgPlayer;

public class TeachersInventory {
	
	private RpgPlayer rpg;
	private Inventory teachInv;
	
	TeachersInventory(RpgPlayer rpg){
		this.rpg = rpg;
	}
	
	public Inventory openDiego() {
	
//		ItemStack pn = new ItemStack(Material.PAPER, 1);{
//			ItemMeta im = pn.getItemMeta();
//			im.setDisplayName("§2§lTwoje PN: §a" + RpgFileOperation.getPN(this.rpg));
//			pn.setItemMeta(im);
//		}
		
		teachInv = Bukkit.createInventory(null, 45, "§aDiego - nauczyciel");{
//			teachInv.setItem(0, pn);
			teachInv.setItem(6, sila1);
			teachInv.setItem(7, sila5);
			teachInv.setItem(15, zrecznosc1);
			teachInv.setItem(16, zrecznosc5);
			teachInv.setItem(24, walka1);
			teachInv.setItem(25, walka2);
			teachInv.setItem(33, mana1);
			teachInv.setItem(34, mana5);
			teachInv.setItem(42, inteligencja1);
			teachInv.setItem(43, inteligencja5);
		}
		
		return teachInv;
	}
	
	public Inventory openThor() {
		
		teachInv = Bukkit.createInventory(null, 9, "§6Thor - nauczyciel");{
			teachInv.setItem(7, walka1);
			teachInv.setItem(8, walka2);
		}
		
		return teachInv;
	}
	
	public Inventory openMagor() {
		
		teachInv = Bukkit.createInventory(null, 9, "§4Magor - nauczyciel");{
			teachInv.setItem(7, sila1);
			teachInv.setItem(8, sila5);
		}
		
		return teachInv;
	}
	
	public Inventory openDargoth() {
		
		teachInv = Bukkit.createInventory(null, 18, "§4§lDargoth - nauczyciel");{
			teachInv.setItem(7, mana1);
			teachInv.setItem(8, mana5);
			
			if(rpg.getKrag() != 0) {
				krag1.setDurability((short) 6);
			}
			teachInv.setItem(15, krag1);
			
			if(rpg.getKrag() != 1) {
				krag2.setDurability((short) 6);
			}
			teachInv.setItem(16, krag2);
			
			if(rpg.getKrag() != 2) {
				krag3.setDurability((short) 6);
			}
			teachInv.setItem(17, krag3);
			
		}
		
		return teachInv;
	}
	
	public Inventory openTavin() {
		
		teachInv = Bukkit.createInventory(null, 9, "§aTavin - nauczyciel");{
			teachInv.setItem(7, walka1);
			teachInv.setItem(8, walka2);
		}
		
		return teachInv;
	}
	
	public Inventory openRonin() {
		
		teachInv = Bukkit.createInventory(null, 18, "§2§lRonin - nauczyciel");{
			teachInv.setItem(7, mana1);
			teachInv.setItem(8, mana5);
			
			if(rpg.getKrag() != 0) {
				krag1.setDurability((short) 6);
			}
			teachInv.setItem(15, krag1);
			
			if(rpg.getKrag() != 1) {
				krag2.setDurability((short) 6);
			}
			teachInv.setItem(16, krag2);
			
			if(rpg.getKrag() != 2) {
				krag3.setDurability((short) 6);
			}
			teachInv.setItem(17, krag3);
			
		}
		
		return teachInv;
	}
	
	public Inventory openThorin() {
		
		teachInv = Bukkit.createInventory(null, 9, "§2Thorin - nauczyciel");{
			teachInv.setItem(7, zrecznosc1);
			teachInv.setItem(8, zrecznosc5);
		}
		
		return teachInv;
	}
	
	public Inventory openCanthar() {
		
		teachInv = Bukkit.createInventory(null, 18, "§c§lCanthar - nauczyciel");{
			teachInv.setItem(7, mana1);
			teachInv.setItem(8, mana5);
			teachInv.setItem(16, inteligencja1);
			teachInv.setItem(17, inteligencja5);
		}
		
		return teachInv;
	}
	
	public Inventory openSoggoth() {
		
		teachInv = Bukkit.createInventory(null, 18, "§eSoggoth - nauczyciel");{
			teachInv.setItem(7, mana1);
			teachInv.setItem(8, mana5);
			teachInv.setItem(16, inteligencja1);
			teachInv.setItem(17, inteligencja5);
		}
		
		return teachInv;
	}
	
	public Inventory openKarrypto() {
		
		teachInv = Bukkit.createInventory(null, 27, "§8Karrypto - nauczyciel");{
			if(rpg.getKrag() != 0) {
				krag1.setDurability((short) 6);
			}
			teachInv.setItem(7, krag1);
			if(rpg.getKrag() != 3) {
				krag4.setDurability((short) 6);
			}
			teachInv.setItem(8, krag4);
			if(rpg.getKrag() != 1) {
				krag2.setDurability((short) 6);
			}
			teachInv.setItem(16, krag2);
			if(rpg.getKrag() != 4) {
				krag5.setDurability((short) 6);
			}
			teachInv.setItem(17, krag5);
			if(rpg.getKrag() != 2) {
				krag3.setDurability((short) 6);
			}
			teachInv.setItem(25, krag3);
			if(rpg.getKrag() != 5) {
				krag6.setDurability((short) 6);
			}
			teachInv.setItem(26, krag6);
		}
		
		return teachInv;
	}
	
	public Inventory openFrithjof() {
		
		teachInv = Bukkit.createInventory(null, 18, "§7Frithjof - nauczyciel");{
			teachInv.setItem(7, walka1);
			teachInv.setItem(8, walka2);
			teachInv.setItem(16, sila1);
			teachInv.setItem(17, sila5);
		}
		
		return teachInv;
	}
	
	public Inventory openUdar() {
		
		teachInv = Bukkit.createInventory(null, 18, "§8Udar - nauczyciel");{
			teachInv.setItem(7, mana1);
			teachInv.setItem(8, mana5);
			teachInv.setItem(16, zrecznosc1);
			teachInv.setItem(17, zrecznosc5);
		}
		
		return teachInv;
	}
	
	public Inventory openSaturas() {
		
		teachInv = Bukkit.createInventory(null, 18, "§1Saturas - nauczyciel");{
			teachInv.setItem(7, walka1);
			teachInv.setItem(8, walka2);
			teachInv.setItem(16, mana1);
			teachInv.setItem(17, mana5);
		}
		
		return teachInv;
	}
	
	public Inventory openCronos() {
		
		teachInv = Bukkit.createInventory(null, 27, "§b§lCronos - nauczyciel");{
			teachInv.setItem(7, inteligencja1);
			teachInv.setItem(8, inteligencja5);
			teachInv.setItem(16, mana1);
			teachInv.setItem(17, mana5);
			if(rpg.getKrag() != 0) {
				krag1.setDurability((short) 6);
			}
			teachInv.setItem(25, krag1);
			if(rpg.getKrag() != 1) {
				krag2.setDurability((short) 6);
			}
			teachInv.setItem(26, krag2);
		}
		
		return teachInv;
	}
	
	public Inventory openCarl() {
		
		teachInv = Bukkit.createInventory(null, 36, "§7§lCarl - nauczyciel");{
			teachInv.setItem(7, inteligencja1);
			teachInv.setItem(8, inteligencja5);
			teachInv.setItem(16, mana1);
			teachInv.setItem(17, mana5);
			if(rpg.getKrag() != 0) {
				krag1.setDurability((short) 6);
			}
			teachInv.setItem(25, krag1);
			if(rpg.getKrag() != 2) {
				krag3.setDurability((short) 6);
			}
			teachInv.setItem(26, krag3);
			if(rpg.getKrag() != 1) {
				krag2.setDurability((short) 6);
			}
			teachInv.setItem(34, krag2);
			if(rpg.getKrag() != 3) {
				krag4.setDurability((short) 6);
			}
			teachInv.setItem(35, krag4);
		}
		
		return teachInv;
	}
	
	public Inventory openJasuo() {
		
		teachInv = Bukkit.createInventory(null, 18, "§a§lJasuo - nauczyciel");{
			teachInv.setItem(7, walka1);
			teachInv.setItem(8, walka2);
			teachInv.setItem(16, sila1);
			teachInv.setItem(17, sila5);
		}
		
		return teachInv;
	}
	
	public Inventory openXardas() {
		
		teachInv = Bukkit.createInventory(null, 27, "§8Xardas - nauczyciel");{
			teachInv.setItem(7, inteligencja1);
			teachInv.setItem(8, inteligencja5);
			if(rpg.getKrag() != 0) {
				krag1.setDurability((short) 6);
			}
			teachInv.setItem(16, krag1);
			if(rpg.getKrag() != 2) {
				krag3.setDurability((short) 6);
			}
			teachInv.setItem(17, krag3);
			if(rpg.getKrag() != 1) {
				krag2.setDurability((short) 6);
			}
			teachInv.setItem(25, krag2);
			if(rpg.getKrag() != 3) {
				krag4.setDurability((short) 6);
			}
			teachInv.setItem(26, krag4);
		}
		
		return teachInv;
	}
	
	public Inventory openHassan() {
		
		teachInv = Bukkit.createInventory(null, 9, "§eHassan - nauczyciel");{
			teachInv.setItem(7, zrecznosc1);
			teachInv.setItem(8, zrecznosc5);
		}
		
		return teachInv;
	}
	
	public Inventory openReg() {
		
		teachInv = Bukkit.createInventory(null, 9, "§4Reg - nauczyciel");{
			teachInv.setItem(7, walka1);
			teachInv.setItem(8, walka2);
		}
		
		return teachInv;
	}
	
	public Inventory openOlivier() {
		
		teachInv = Bukkit.createInventory(null, 18, "§4Olivier - nauczyciel");{
			teachInv.setItem(7, walka1);
			teachInv.setItem(8, walka2);
			teachInv.setItem(16, sila1);
			teachInv.setItem(17, sila5);
		}
		
		return teachInv;
	}
	
	public Inventory openTyrael() {
		
		teachInv = Bukkit.createInventory(null, 36, "§b§lTyrael - nauczyciel");{
			teachInv.setItem(7, inteligencja1);
			teachInv.setItem(8, inteligencja5);
			teachInv.setItem(16, mana1);
			teachInv.setItem(17, mana5);
			teachInv.setItem(25, zrecznosc1);
			teachInv.setItem(26, zrecznosc5);
			teachInv.setItem(34, walka1);
			teachInv.setItem(35, walka2);
		}
		
		return teachInv;
	}
	
	public Inventory openNers() {
		
		teachInv = Bukkit.createInventory(null, 9, "§e§lNers - nauczyciel");{
			teachInv.setItem(7, walka1);
			teachInv.setItem(8, walka2);
		}
		
		return teachInv;
	}
	
	public Inventory openNars() {
		
		teachInv = Bukkit.createInventory(null, 9, "§4Nars - nauczyciel");{
			teachInv.setItem(7, sila1);
			teachInv.setItem(8, sila5);
		}
		
		return teachInv;
	}
	
	public Inventory openCobryn() {
		
		teachInv = Bukkit.createInventory(null, 27, "§7Cobryn - nauczyciel");{
			teachInv.setItem(7, inteligencja1);
			teachInv.setItem(8, inteligencja5);
			teachInv.setItem(16, zrecznosc1);
			teachInv.setItem(17, zrecznosc5);
			teachInv.setItem(25, walka1);
			teachInv.setItem(26, walka2);
		}
		
		return teachInv;
	}
	
	/***************************\
	|							|
	|			Itemy			|
	| 						   	|
	\***************************/
	
	ItemStack sila1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 13);{
		ItemMeta im = sila1.getItemMeta();
		im.setDisplayName("§4§lSila: §c+1");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a2 §2punktow nauki");
		}
		
		im.setLore(lore);
		sila1.setItemMeta(im);
	}
	
	ItemStack sila5 = new ItemStack(Material.STAINED_CLAY, 5, (byte) 13);{
		ItemMeta im = sila5.getItemMeta();
		im.setDisplayName("§4§lSila: §c+5");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a10 §2punktow nauki");
		}
		
		im.setLore(lore);
		sila5.setItemMeta(im);
	}
	
	ItemStack zrecznosc1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 13);{
		ItemMeta im = zrecznosc1.getItemMeta();
		im.setDisplayName("§4§lZrecznosc: §c+1");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a2 §2punktow nauki");
		}
		
		im.setLore(lore);
		zrecznosc1.setItemMeta(im);
	}
	
	ItemStack zrecznosc5 = new ItemStack(Material.STAINED_CLAY, 5, (byte) 13);{
		ItemMeta im = zrecznosc5.getItemMeta();
		im.setDisplayName("§4§lZrecznosc: §c+5");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a10 §2punktow nauki");
		}
		
		im.setLore(lore);
		zrecznosc5.setItemMeta(im);
	}
	
	ItemStack walka1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 13);{
		ItemMeta im = walka1.getItemMeta();
		im.setDisplayName("§4§lWalka: §c+1");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a5 §2punktow nauki");
		}
		
		im.setLore(lore);
		walka1.setItemMeta(im);
	}
	
	ItemStack walka2 = new ItemStack(Material.STAINED_CLAY, 2, (byte) 13);{
		ItemMeta im = walka2.getItemMeta();
		im.setDisplayName("§4§lWalka: §c+2");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a10 §2punktow nauki");
		}
		
		im.setLore(lore);
		walka2.setItemMeta(im);
	}
	
	ItemStack mana1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 13);{
		ItemMeta im = mana1.getItemMeta();
		im.setDisplayName("§4§lMana: §c+1");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a1 §2punktow nauki");
		}
		
		im.setLore(lore);
		mana1.setItemMeta(im);
	}
	
	ItemStack mana5 = new ItemStack(Material.STAINED_CLAY, 5, (byte) 13);{
		ItemMeta im = mana5.getItemMeta();
		im.setDisplayName("§4§lMana: §c+5");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a5 §2punktow nauki");
		}
		
		im.setLore(lore);
		mana5.setItemMeta(im);
	}
	
	ItemStack inteligencja1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 13);{
		ItemMeta im = inteligencja1.getItemMeta();
		im.setDisplayName("§4§lInteligencja: §c+1");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a2 §2punktow nauki");
		}
		
		im.setLore(lore);
		inteligencja1.setItemMeta(im);
	}
	
	ItemStack inteligencja5 = new ItemStack(Material.STAINED_CLAY, 5, (byte) 13);{
		ItemMeta im = inteligencja5.getItemMeta();
		im.setDisplayName("§4§lInteligencja: §c+5");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a10 §2punktow nauki");
		}
		
		im.setLore(lore);
		inteligencja5.setItemMeta(im);
	}
	
	ItemStack krag1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 13);{
		ItemMeta im = krag1.getItemMeta();
		im.setDisplayName("§4§lKrag: §cI");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a10 §2punktow nauki");
		}
		
		im.setLore(lore);
		krag1.setItemMeta(im);
	}
	
	ItemStack krag2 = new ItemStack(Material.STAINED_CLAY, 2, (byte) 13);{
		ItemMeta im = krag2.getItemMeta();
		im.setDisplayName("§4§lKrag: §cII");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a15 §2punktow nauki");
		}
		
		im.setLore(lore);
		krag2.setItemMeta(im);
	}
	
	ItemStack krag3 = new ItemStack(Material.STAINED_CLAY, 3, (byte) 13);{
		ItemMeta im = krag3.getItemMeta();
		im.setDisplayName("§4§lKrag: §cIII");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a20 §2punktow nauki");
		}
		
		im.setLore(lore);
		krag3.setItemMeta(im);
	}
	
	ItemStack krag4 = new ItemStack(Material.STAINED_CLAY, 4, (byte) 13);{
		ItemMeta im = krag4.getItemMeta();
		im.setDisplayName("§4§lKrag: §cIV");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a25 §2punktow nauki");
		}
		
		im.setLore(lore);
		krag4.setItemMeta(im);
	}
	
	ItemStack krag5 = new ItemStack(Material.STAINED_CLAY, 5, (byte) 13);{
		ItemMeta im = krag5.getItemMeta();
		im.setDisplayName("§4§lKrag: §cV");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a30 §2punktow nauki");
		}
		
		im.setLore(lore);
		krag5.setItemMeta(im);
	}
	
	ItemStack krag6 = new ItemStack(Material.STAINED_CLAY, 6, (byte) 13);{
		ItemMeta im = krag6.getItemMeta();
		im.setDisplayName("§4§lKrag: §cVI");
		
		List<String> lore = new ArrayList<String>();{
			lore.add("§2Koszt: §a35 §2punktow nauki");
		}
		
		im.setLore(lore);
		krag6.setItemMeta(im);
	}
	
}
