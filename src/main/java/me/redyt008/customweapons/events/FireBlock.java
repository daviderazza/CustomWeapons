package me.redyt008.customweapons.events;

import me.redyt008.customweapons.commands.FireSword;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FireBlock implements Listener {
    private final FireSword fireSword = new FireSword();


    @EventHandler
    public void onItemInHand(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction() == Action.LEFT_CLICK_BLOCK){
            player.sendMessage(ChatColor.YELLOW + "Left Click Block");
            if(fireSword.fireInHand(event.getPlayer())){
                player.sendMessage(ChatColor.GREEN + "Event Passed");
                PotionEffect potionEffect = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 155);
                player.addPotionEffect(potionEffect);
                player.getWorld().spawnParticle(Particle.LAVA, player.getLocation(), 20);
            }
        }
    }
}

