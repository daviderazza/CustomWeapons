package me.redyt008.customweapons.events;


import me.redyt008.customweapons.commands.WaterSword;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WaterBlock implements Listener {
    private final WaterSword waterSword = new WaterSword();


    @EventHandler
    public void onItemInHand(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction() == Action.LEFT_CLICK_BLOCK){
            player.sendMessage(ChatColor.YELLOW + "Left Click Block");
            if(waterSword.waterInHand(event.getPlayer())){
                player.sendMessage(ChatColor.GREEN + "Event Passed");
                PotionEffect potionEffect = new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 155);
                player.addPotionEffect(potionEffect);
                player.getWorld().spawnParticle(Particle.WATER_BUBBLE, player.getLocation(), 20);
            }
        }
    }
}

