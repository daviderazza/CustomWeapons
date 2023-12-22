package me.redyt008.customweapons.events;

import me.redyt008.customweapons.commands.WaterSword;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WaterSwordAttackEvent implements Listener {

    private final WaterSword waterSword = new WaterSword();
    @EventHandler
    public void PlayerAttackEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity entity = event.getEntity();
        EntityType damagerType = damager.getType();
        if (damagerType == EntityType.PLAYER) {
            Player player = (Player) damager;
            player.sendMessage("Event 1 passed");
            if(player.getInventory().getItemInMainHand().getItemMeta() != null) {
                player.sendMessage("Event 2 passed");
                if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
                    player.sendMessage("Event 3 passed");
                    if(waterSword.waterInHand(player)){
                        player.sendMessage("Event 4 passed");
                        Location location = entity.getLocation();
                        World world = entity.getWorld();
                        PotionEffect potionEffect = new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 155);
                        player.addPotionEffect(potionEffect);
                        entity.getWorld().spawnParticle(Particle.WATER_SPLASH, entity.getLocation(), 40);
                    }
                }
            }
        }
    }
}