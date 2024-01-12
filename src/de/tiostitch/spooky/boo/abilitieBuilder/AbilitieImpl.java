package de.tiostitch.spooky.boo.abilitieBuilder;

import org.bukkit.event.player.PlayerInteractEvent;

public interface AbilitieImpl {
    String getItemUsedName();
    String getAbilitieName();
    short getManaCost();

    void getRightClickAction(PlayerInteractEvent event);
    void getLeftClickAction(PlayerInteractEvent event);
    void getRightShiftClickAction(PlayerInteractEvent event);
    void getLeftShiftClickAction(PlayerInteractEvent event);
}
