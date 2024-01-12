package de.tiostitch.spooky.boo;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Main extends JavaPlugin {

    public Main instance;

    @Override
    public void onEnable() {

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerEvent(), this);
        Bukkit.getPluginCommand("spookyevent").setExecutor(new SpookyCMD());

        log("§b[SpookyBoo] §6Initialized with succefully!");
    }

    @Override
    public void onDisable() {
        log("§b[SpookyBoo] §6Ended with succefully!");
    }

    public void log(String message) {
        Bukkit.broadcastMessage(message);
    }
}
