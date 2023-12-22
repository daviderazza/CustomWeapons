package me.redyt008.customweapons.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class cwShopClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){

        if(event.getCurrentItem() == null){
            return;
        }
        Inventory inventory = event.getClickedInventory();
        InventoryView inventoryView = (InventoryView) inventory;
        if(inventoryView.getTitle().equalsIgnoreCase("ChatColor.RED + \"Custom Weapons Shop\"")){
            event.setCancelled(true);
        }
    }
}
