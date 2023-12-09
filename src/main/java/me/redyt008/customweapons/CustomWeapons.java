package me.redyt008.customweapons;

import jdk.javadoc.internal.tool.Main;
import me.redyt008.customweapons.commands.FireSword;
import me.redyt008.customweapons.commands.WaterSword;
import me.redyt008.customweapons.events.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomWeapons extends JavaPlugin {

    public static Main plugin;
    @Override
    public void onEnable() {
        System.out.println("CustomWeapons Online! Made by Davide Razza");
        //REGISTRAZIONE COMANDI
        this.getCommand("FireSword").setExecutor(new FireSword());
        this.getCommand("WaterSword").setExecutor(new WaterSword());
        //REGISTRAZIONE EVENTI
        getServer().getPluginManager().registerEvents(new FireAir(), this);
        getServer().getPluginManager().registerEvents(new TestEvent(), this);
        getServer().getPluginManager().registerEvents(new FireBlock(), this);
        getServer().getPluginManager().registerEvents(new WaterBlock(), this);
        getServer().getPluginManager().registerEvents(new WaterAir(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("CustomWeapons Offline! Made by Davide Razza");
    }
}
