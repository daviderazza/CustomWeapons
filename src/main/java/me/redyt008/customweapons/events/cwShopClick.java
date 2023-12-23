package me.redyt008.customweapons.events;

import me.redyt008.customweapons.commands.cwShop;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class cwShopClick implements Listener {

    static  final cwShop cwshop = new cwShop();

    @EventHandler
    public void onClick(InventoryClickEvent event){

        if(event.getCurrentItem() == null){
            return;
        }
        Inventory inventory = event.getClickedInventory();
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Custom Weapons Shop")){
            event.setCancelled(true);
        }
    }
}