package me.Vark123.EpicRPG;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class RpgStackableItems implements Listener {
 
    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
    public void onInventoryClickEvent(InventoryClickEvent event) {
 
        ItemStack current = event.getCurrentItem();
        ItemStack cursor = event.getCursor();
 
        // We want to prevent the player from INCREASING a stack size
        if (current != null && cursor != null) {
 
            int maxAmount = 1;
 
            // They should be able to split "too large" stacks, or move them around.
            if (cursor.getAmount() == 0 || event.isRightClick()) {
                return;
            } else if (!isValid(current, cursor, maxAmount)) {
                // But never increase a stack above their personal limit
                event.setCancelled(true);
            }
        }
    }
 
    private boolean isValid(ItemStack current, ItemStack cursor, int maxAmount) {
 
        int total = current.getAmount() + cursor.getAmount();
 
        if (current.getType() == Material.COMPASS) {
            return total <= maxAmount;
        } else {
            return true;
        }
    }
}