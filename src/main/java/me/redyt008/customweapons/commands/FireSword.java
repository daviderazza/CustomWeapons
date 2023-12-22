package me.redyt008.customweapons.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FireSword implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            ItemStack fireSword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta fireSwordMeta = fireSword.getItemMeta();
            fireSwordMeta.setDisplayName(ChatColor.RED + "Lama Di Fuoco");
            List list = new ArrayList<String>();
            list.add(ChatColor.RED + "Questa è la leggendaria Lama di Fuoco");
            list.add(ChatColor.RED + "Click sinistro per ricevere i suoi effetti!");
            fireSwordMeta.setLore(list);
            fireSword.setItemMeta(fireSwordMeta);
            if(player.hasPermission("customweapons.firesword")){
                player.getInventory().addItem(fireSword);
            }else{
                player.sendMessage(ChatColor.RED + "Non hai accesso a quel comando");
            }
        }
        return true;
    }

    public boolean fireInHand(Player player) {
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        if(itemInMainHand.getItemMeta() != null){
            if(itemInMainHand.getItemMeta().getDisplayName() != null){
                return itemInMainHand.getItemMeta().getDisplayName().equals(ChatColor.RED + "Lama Di Fuoco");
            }
            return false;
        }
        return false;
    }
}
