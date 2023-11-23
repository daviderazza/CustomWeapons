package me.redyt008.customweapons.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FireSword implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            ItemStack fireSword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta fireSwordMeta = fireSword.getItemMeta();
            fireSwordMeta.setDisplayName("Lama Di Fuoco");
            List list = new ArrayList<String>();
            list.add("Questa e' la leggendaria lama di fuoco");
            list.add("Tienila in mano per ricevere i suoi effetti!");
            fireSwordMeta.setLore(list);
            fireSword.setItemMeta(fireSwordMeta);
            player.getInventory().addItem(fireSword);
        }
        return true;
    }

    public boolean fireInHand(Player player) {
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        if(itemInMainHand.getItemMeta() != null){
            if(itemInMainHand.getItemMeta().getDisplayName() != null){
                return itemInMainHand.getItemMeta().getDisplayName().equals("Lama Di Fuoco");
            }
            return false;
        }
        return false;
    }
}
