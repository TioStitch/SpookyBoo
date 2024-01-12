package de.tiostitch.spooky.boo.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class PlayerUtils {

    public static void sendForAllExcept(Player player, String message) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (players != player) {
                players.sendMessage(message);
            }
        }
    }
}
