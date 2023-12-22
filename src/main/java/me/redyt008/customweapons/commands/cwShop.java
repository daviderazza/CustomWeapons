package me.redyt008.customweapons.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class cwShop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.RED + "Custom Weapons Shop");
            ItemStack firesword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta fireswordmeta = firesword.getItemMeta();
            fireswordmeta.setDisplayName(ChatColor.RED + "FireSword");
            List list = new ArrayList<String>();
            list.add("Lama di Fuoco");
            list.add("Prezzo: 15.000");
            fireswordmeta.setLore(list);
            firesword.setItemMeta(fireswordmeta);
            inventory.setItem(11, firesword);

            ItemStack watersword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta waterswordmeta = watersword.getItemMeta();
            waterswordmeta.setDisplayName(ChatColor.AQUA + "WaterSword");
            List list1 = new ArrayList<String>();
            list1.add(ChatColor.AQUA + "Lama D'Acqua");
            list1.add(ChatColor.AQUA + "Prezzo: 45.000");
            waterswordmeta.setLore(list1);
            watersword.setItemMeta(waterswordmeta);
            inventory.setItem(15, watersword);
            if(player.hasPermission("customweapons.cwshop")){
                player.openInventory(inventory);
            }else{
                player.sendMessage(ChatColor.RED + "Non hai accesso a quel comando");
            }
        }
        return true;
    }
}
