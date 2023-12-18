package me.redyt008.customweapons.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WaterSword implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            ItemStack waterSword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta waterSwordMeta = waterSword.getItemMeta();
            waterSwordMeta.setDisplayName(ChatColor.RED + "Lama D'Acqua");
            List list = new ArrayList<String>();
            list.add(ChatColor.RED + "Questa è la leggendaria Lama d'Acqua");
            list.add(ChatColor.RED + "Click sinistro per ricevere i suoi effetti!");
            waterSwordMeta.setLore(list);
            waterSword.setItemMeta(waterSwordMeta);
            if(player.hasPermission("customweapons.watersword")){
                player.getInventory().addItem(waterSword);
            }else{
                player.sendMessage(ChatColor.RED + "Non hai accesso a quel comando");
            }
        }
        return true;
    }
    public boolean waterInHand(Player player) {
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        if(itemInMainHand.getItemMeta() != null){
            if(itemInMainHand.getItemMeta().getDisplayName() != null){
                return itemInMainHand.getItemMeta().getDisplayName().equals(ChatColor.RED + "Lama D'Acqua");
            }
            return false;
        }
        return false;
    }
}


