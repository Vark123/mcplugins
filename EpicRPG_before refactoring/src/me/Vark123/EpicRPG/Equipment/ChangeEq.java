package me.Vark123.EpicRPG.Equipment;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.Stats.ChangeStats;
import me.Vark123.EpicRPG.Stats.CheckStats;

public class ChangeEq implements Listener {
	
	@EventHandler
	public void test(InventoryClickEvent e) {
		
		if(e.getClickedInventory() != null && e.getClickedInventory().getType().equals(InventoryType.PLAYER)) {
			if(e.getAction().equals(InventoryAction.PLACE_ALL)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
					if(CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getCursor())) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
					((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
					e.setCancelled(true);
				}
			}
			
			else if (e.getAction().equals(InventoryAction.SWAP_WITH_CURSOR)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
					if(CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getCursor())) {
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
						e.setCancelled(true);
					}
					((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
					e.setCancelled(true);
				}
			}

			else if(e.getAction().equals(InventoryAction.PICKUP_ALL)) {
				if(e.getSlotType().equals(SlotType.ARMOR)) {
					new BukkitRunnable() {
						
						@Override
						public void run() {
							ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
							
						}
					}.runTaskLater(Main.getInst(), 1);
					return;
				}
			}
			else if(e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
				if(e.getWhoClicked().getGameMode().equals(GameMode.SURVIVAL)) {
					if(e.isShiftClick()) {
						if(e.getSlot() != 36 && e.getSlot() != 37 && e.getSlot() != 38 && e.getSlot() != 39) {
							if(e.getCurrentItem().getType().equals(Material.CHAINMAIL_BOOTS) || 
									e.getCurrentItem().getType().equals(Material.DIAMOND_BOOTS) || 
									e.getCurrentItem().getType().equals(Material.GOLD_BOOTS) || 
									e.getCurrentItem().getType().equals(Material.IRON_BOOTS) ||
									e.getCurrentItem().getType().equals(Material.LEATHER_BOOTS)) {
								if(e.getWhoClicked().getInventory().getBoots() == null) {
									if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getCurrentItem())) {
										((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
										e.setCancelled(true);
									}
									new BukkitRunnable() {
										
										@Override
										public void run() {
											ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
											
										}
									}.runTaskLater(Main.getInst(), 1);
									return;
								}
							}
							else if(e.getCurrentItem().getType().equals(Material.CHAINMAIL_LEGGINGS) || 
									e.getCurrentItem().getType().equals(Material.DIAMOND_LEGGINGS) || 
									e.getCurrentItem().getType().equals(Material.GOLD_LEGGINGS) || 
									e.getCurrentItem().getType().equals(Material.IRON_LEGGINGS) ||
									e.getCurrentItem().getType().equals(Material.LEATHER_LEGGINGS)) {
								if(e.getWhoClicked().getInventory().getLeggings() == null) {
									if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getCurrentItem())) {
										((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
										e.setCancelled(true);
									}
									new BukkitRunnable() {
										
										@Override
										public void run() {
											ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
											
										}
									}.runTaskLater(Main.getInst(), 1);
									return;
								}
							}
							else if(e.getCurrentItem().getType().equals(Material.CHAINMAIL_CHESTPLATE) || 
									e.getCurrentItem().getType().equals(Material.DIAMOND_CHESTPLATE) || 
									e.getCurrentItem().getType().equals(Material.GOLD_CHESTPLATE) || 
									e.getCurrentItem().getType().equals(Material.IRON_CHESTPLATE) ||
									e.getCurrentItem().getType().equals(Material.LEATHER_CHESTPLATE)) {
								if(e.getWhoClicked().getInventory().getChestplate() == null) {
									if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getCurrentItem())) {
										((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
										e.setCancelled(true);
									}
									new BukkitRunnable() {
										
										@Override
										public void run() {
											ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
											
										}
									}.runTaskLater(Main.getInst(), 1);
									return;
								}
							}
							else if(e.getCurrentItem().getType().equals(Material.CHAINMAIL_HELMET) || 
									e.getCurrentItem().getType().equals(Material.DIAMOND_HELMET) || 
									e.getCurrentItem().getType().equals(Material.GOLD_HELMET) || 
									e.getCurrentItem().getType().equals(Material.IRON_HELMET) ||
									e.getCurrentItem().getType().equals(Material.LEATHER_HELMET)) {
								if(e.getWhoClicked().getInventory().getHelmet() == null) {
									if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getCurrentItem())) {
										((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
										e.setCancelled(true);
									}
									new BukkitRunnable() {
										
										@Override
										public void run() {
											ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
											
										}
									}.runTaskLater(Main.getInst(), 1);
									return;
								}
							}
						}
						else if (e.getSlot() == 36 || e.getSlot() == 37 || e.getSlot() == 38 || e.getSlot() == 39) {
							new BukkitRunnable() {
								
								@Override
								public void run() {
									ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
									
								}
							}.runTaskLater(Main.getInst(), 1);
							return;
						}
					}
				}
				else if(e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
					if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getCurrentItem())) {
						((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
						e.setCancelled(true);
					}
					new BukkitRunnable() {
						
						@Override
						public void run() {
							ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
							
						}
					}.runTaskLater(Main.getInst(), 1);
					return;
				}
			}
		}
		
	}
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		
		if(e.getPlayer().getItemInHand().getType().equals(Material.AIR)) {
			return;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getItem().getType().equals(Material.CHAINMAIL_BOOTS) || 
					e.getItem().getType().equals(Material.DIAMOND_BOOTS) || 
					e.getItem().getType().equals(Material.GOLD_BOOTS) || 
					e.getItem().getType().equals(Material.IRON_BOOTS) ||
					e.getItem().getType().equals(Material.LEATHER_BOOTS) ||
					e.getItem().getType().equals(Material.CHAINMAIL_LEGGINGS) || 
					e.getItem().getType().equals(Material.DIAMOND_LEGGINGS) || 
					e.getItem().getType().equals(Material.GOLD_LEGGINGS) || 
					e.getItem().getType().equals(Material.IRON_LEGGINGS) ||
					e.getItem().getType().equals(Material.LEATHER_LEGGINGS) ||
					e.getItem().getType().equals(Material.CHAINMAIL_HELMET) || 
					e.getItem().getType().equals(Material.DIAMOND_HELMET) || 
					e.getItem().getType().equals(Material.GOLD_HELMET) || 
					e.getItem().getType().equals(Material.IRON_HELMET) ||
					e.getItem().getType().equals(Material.LEATHER_HELMET) ||
					e.getItem().getType().equals(Material.CHAINMAIL_CHESTPLATE) || 
					e.getItem().getType().equals(Material.DIAMOND_CHESTPLATE) || 
					e.getItem().getType().equals(Material.GOLD_CHESTPLATE) || 
					e.getItem().getType().equals(Material.IRON_CHESTPLATE) ||
					e.getItem().getType().equals(Material.LEATHER_CHESTPLATE)) {
				e.getPlayer().updateInventory();
				if(e.getItem().getType().equals(Material.CHAINMAIL_BOOTS) || 
						e.getItem().getType().equals(Material.DIAMOND_BOOTS) || 
						e.getItem().getType().equals(Material.GOLD_BOOTS) || 
						e.getItem().getType().equals(Material.IRON_BOOTS) ||
						e.getItem().getType().equals(Material.LEATHER_BOOTS)) {
					if(e.getPlayer().getInventory().getBoots() == null) {
						if(!CheckStats.check(Main.getListaRPG().get(e.getPlayer()), e.getItem())) {
							e.getPlayer().sendMessage("§cNie mozesz tego na siebie zalozyc!");
							e.setCancelled(true);
							return;
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getPlayer()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
				}
				else if(e.getItem().getType().equals(Material.CHAINMAIL_LEGGINGS) || 
						e.getItem().getType().equals(Material.DIAMOND_LEGGINGS) || 
						e.getItem().getType().equals(Material.GOLD_LEGGINGS) || 
						e.getItem().getType().equals(Material.IRON_LEGGINGS) ||
						e.getItem().getType().equals(Material.LEATHER_LEGGINGS)) {
					if(e.getPlayer().getInventory().getLeggings() == null) {
						if(!CheckStats.check(Main.getListaRPG().get(e.getPlayer()), e.getItem())) {
							e.getPlayer().sendMessage("§cNie mozesz tego na siebie zalozyc!");
							e.setCancelled(true);
							return;
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getPlayer()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
				}
				else if(e.getItem().getType().equals(Material.CHAINMAIL_CHESTPLATE) || 
						e.getItem().getType().equals(Material.DIAMOND_CHESTPLATE) || 
						e.getItem().getType().equals(Material.GOLD_CHESTPLATE) || 
						e.getItem().getType().equals(Material.IRON_CHESTPLATE) ||
						e.getItem().getType().equals(Material.LEATHER_CHESTPLATE)) {
					if(e.getPlayer().getInventory().getChestplate() == null) {
						if(!CheckStats.check(Main.getListaRPG().get(e.getPlayer()), e.getItem())) {
							e.getPlayer().sendMessage("§cNie mozesz tego na siebie zalozyc!");
							e.setCancelled(true);
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getPlayer()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
				}
				else if(e.getItem().getType().equals(Material.CHAINMAIL_HELMET) || 
						e.getItem().getType().equals(Material.DIAMOND_HELMET) || 
						e.getItem().getType().equals(Material.GOLD_HELMET) || 
						e.getItem().getType().equals(Material.IRON_HELMET) ||
						e.getItem().getType().equals(Material.LEATHER_HELMET)) {
					if(e.getPlayer().getInventory().getHelmet() == null) {
						if(!CheckStats.check(Main.getListaRPG().get(e.getPlayer()), e.getItem())) {
							e.getPlayer().sendMessage("§cNie mozesz tego na siebie zalozyc!");
							e.setCancelled(true);
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getPlayer()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void test(InventoryDragEvent e) {
		
		int slot = Integer.parseInt(e.getRawSlots().toString().replace("[", "").replace("]", ""));
		
		if(e.getInventory().getType().equals(InventoryType.CRAFTING)) {
			if(slot==8) {
				if(e.getOldCursor().getType().equals(Material.CHAINMAIL_BOOTS) || 
						e.getOldCursor().getType().equals(Material.DIAMOND_BOOTS) || 
						e.getOldCursor().getType().equals(Material.GOLD_BOOTS) || 
						e.getOldCursor().getType().equals(Material.IRON_BOOTS) ||
						e.getOldCursor().getType().equals(Material.LEATHER_BOOTS)) {
					if(e.getWhoClicked().getInventory().getBoots() == null) {
						if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getOldCursor())) {
							((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
							e.setCancelled(true);
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
				}
			}
			else if(slot==7) {
				if(e.getOldCursor().getType().equals(Material.CHAINMAIL_LEGGINGS) || 
						e.getOldCursor().getType().equals(Material.DIAMOND_LEGGINGS) || 
						e.getOldCursor().getType().equals(Material.GOLD_LEGGINGS) || 
						e.getOldCursor().getType().equals(Material.IRON_LEGGINGS) ||
						e.getOldCursor().getType().equals(Material.LEATHER_LEGGINGS)) {
					if(e.getWhoClicked().getInventory().getLeggings() == null) {
						if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getOldCursor())) {
							((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
							e.setCancelled(true);
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
				}
			}
			else if(slot==6) {
				if(e.getOldCursor().getType().equals(Material.CHAINMAIL_CHESTPLATE) || 
						e.getOldCursor().getType().equals(Material.DIAMOND_CHESTPLATE) || 
						e.getOldCursor().getType().equals(Material.GOLD_CHESTPLATE) || 
						e.getOldCursor().getType().equals(Material.IRON_CHESTPLATE) ||
						e.getOldCursor().getType().equals(Material.LEATHER_CHESTPLATE)) {
					if(e.getWhoClicked().getInventory().getChestplate() == null) {
						if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getOldCursor())) {
							((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
							e.setCancelled(true);
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
				}
			}
			else if(slot==5) {
				if(e.getOldCursor().getType().equals(Material.CHAINMAIL_HELMET) || 
						e.getOldCursor().getType().equals(Material.DIAMOND_HELMET) || 
						e.getOldCursor().getType().equals(Material.GOLD_HELMET) || 
						e.getOldCursor().getType().equals(Material.IRON_HELMET) ||
						e.getOldCursor().getType().equals(Material.LEATHER_HELMET)) {
					if(e.getWhoClicked().getInventory().getHelmet() == null) {
						if(!CheckStats.check(Main.getListaRPG().get(e.getWhoClicked()), e.getOldCursor())) {
							((Player)e.getWhoClicked()).sendMessage("§cNie mozesz tego na siebie zalozyc!");
							e.setCancelled(true);
						}
						new BukkitRunnable() {
							
							@Override
							public void run() {
								ChangeStats.change(Main.getListaRPG().get(e.getWhoClicked()));
								
							}
						}.runTaskLater(Main.getInst(), 1);
						return;
					}
				}
			}
		}
	}
}