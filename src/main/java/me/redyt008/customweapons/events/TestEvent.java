package me.redyt008.customweapons.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TestEvent implements Listener {

    @EventHandler
    public void onItemInHand(PlayerInteractEvent event){

        Player player = event.getPlayer();
        ItemStack itemStack = new ItemStack(Material.IRON_AXE);
        if(player.getInventory().getItemInMainHand().equals(itemStack)){
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 155);
            player.addPotionEffect(potionEffect);
        }
    }
}
