package me.redyt008.customweapons.events;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FireSwordAttackEvent implements Listener {

    @EventHandler
    public void PlayerAttackEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity entity = event.getEntity();
        EntityType damagerType = damager.getType();
        if (damagerType == EntityType.PLAYER) {
            Player player = (Player) damager;
            player.sendMessage("Event 1 passed");
            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                player.sendMessage("Event 2 passed");
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                    player.sendMessage("Event 3 passed");
                    if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "Lama Di Fuoco")){
                        player.sendMessage("Event 4 passed");
                        Location location = entity.getLocation();
                        World world = entity.getWorld();
                        PotionEffect potionEffect = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 155);
                        player.addPotionEffect(potionEffect);
                        world.getBlockAt(location).setType(Material.FIRE);
                        entity.getWorld().spawnParticle(Particle.LAVA, entity.getLocation(), 20);
                    }
                }
            }
        }
    }
}
