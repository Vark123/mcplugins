package me.Vark123.EpicRPG.Teachers;

import java.io.IOException;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;
import me.Vark123.EpicRPG.Stats.ChangeStats;
import me.Vark123.EpicRPG.Stats.ReStats;

public class PnTeachers implements Listener{
	
	private List<String> lore;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onTeach(InventoryClickEvent e) throws IOException {
		
		if(e.getClickedInventory() != null && e.getInventory().getName().contains("nauczyciel")) {
			
			if(e.getWhoClicked() instanceof Player) {
				
				Player p = (Player) e.getWhoClicked();
				RpgPlayer rpg = Main.getListaRPG().get(p);
				
				if(e.getCurrentItem().getType().equals(Material.STAINED_CLAY)) {
					
					if(e.getCurrentItem().getData().getData() == (byte) 14) {
						
						p.sendMessage("§cJeszcze nie wykonales mojego zadania, a juz chcesz sie ode mnie uczyc");
						e.setCancelled(true);
						
					}
					
					if(e.getCurrentItem().getData().getData() == (byte) 6) {
						
						p.sendMessage("§cTego kregu magii nie mozesz sie nauczyc");
						e.setCancelled(true);
						
					}
					
					else if (e.getCurrentItem().getData().getData() == (byte) 13) {
						if(!e.getCurrentItem().getItemMeta().hasLore()) {
							e.setCancelled(true);
							return;
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lSila: §c+1")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addSila(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lSila: §c+5")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addSila(ReStats.sprawdz(rpg, lore, 5));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lZrecznosc: §c+1")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addZrecznosc(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lZrecznosc: §c+5")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addZrecznosc(ReStats.sprawdz(rpg, lore, 5));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lWalka: §c+1")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addWalka(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lWalka: §c+2")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addWalka(ReStats.sprawdz(rpg, lore, 2));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lMana: §c+1")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addMana(ReStats.sprawdz(rpg, lore, 1));
							rpg.addPresentMana(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lMana: §c+5")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addMana(ReStats.sprawdz(rpg, lore, 5));
							rpg.addPresentMana(ReStats.sprawdz(rpg, lore, 5));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lInteligencja: §c+1")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addInteligencja(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lInteligencja: §c+5")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addInteligencja(ReStats.sprawdz(rpg, lore, 5));
							ChangeStats.change(rpg);
							p.updateInventory();
							e.setCancelled(true);
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lKrag: §cI")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addKrag(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							e.setCancelled(true);
							p.closeInventory();
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lKrag: §cII")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addKrag(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							e.setCancelled(true);
							p.closeInventory();
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lKrag: §cIII")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addKrag(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							e.setCancelled(true);
							p.closeInventory();
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lKrag: §cIV")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addKrag(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							e.setCancelled(true);
							p.closeInventory();
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lKrag: §cV")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addKrag(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							e.setCancelled(true);
							p.closeInventory();
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lKrag: §cVI")) {
							lore = e.getCurrentItem().getItemMeta().getLore();
							rpg.addKrag(ReStats.sprawdz(rpg, lore, 1));
							ChangeStats.change(rpg);
							e.setCancelled(true);
							p.closeInventory();
						}
						
					}
				
				}
				
				if(e.getCurrentItem().getType().equals(Material.PAPER)) {
					e.setCancelled(true);
					return;
				}
				
			}
		
		}
	
	}

}
