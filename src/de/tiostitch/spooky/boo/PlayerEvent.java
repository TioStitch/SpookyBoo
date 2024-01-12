package de.tiostitch.spooky.boo;

import de.tiostitch.spooky.boo.abilitieBuilder.AbilitieBuilder;
import de.tiostitch.spooky.boo.abilitieBuilder.AbilitieImpl;
import de.tiostitch.spooky.boo.abilitieBuilder.abilities.Abilities;
import de.tiostitch.spooky.boo.itemBuilder.ItemBuilder;
import de.tiostitch.spooky.boo.itemBuilder.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public final class PlayerEvent
        implements Listener {

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("§b[SpookyBoo] §6Welcome to the server!");
    }

    @EventHandler
    void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        for (World world : Bukkit.getWorlds()) {
            world.getEntities().stream()
                    .filter(entity -> entity.hasMetadata(player.getName()))
                    .forEach(Entity::remove);
        }
    }

    @EventHandler
    void onSend(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (message.contains("giveFirework")) {
            player.getInventory().addItem(ItemBuilder.getItemByEnum(Items.LAUNCH_FIREWORK));
        }
    }

    @EventHandler
    void onEventClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        Abilities abilities = null;
        for (Abilities abCheck : Abilities.values()) {
            AbilitieImpl abWork = AbilitieBuilder.getAbilitie(abCheck);
            assert abWork != null;
            if (checkDisplay(player, abWork.getItemUsedName())) {
                abilities = abCheck;
                break;
            }
        }

        assert abilities != null;
        AbilitieImpl abWork = AbilitieBuilder.getAbilitie(abilities);
        switch (event.getAction()) {
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
                assert abWork != null;
                abWork.getRightClickAction(event);
                break;
            case LEFT_CLICK_AIR:
            case LEFT_CLICK_BLOCK:
                assert abWork != null;
                abWork.getLeftClickAction(event);
                break;
        }
    }

    private boolean checkDisplay(Player player, String displayName) {
        ItemStack item = player.getItemInHand();return item.getType() != null && item.hasItemMeta()
                && item.getItemMeta().hasDisplayName()
                && item.getItemMeta().getDisplayName().contains(displayName);
    }
}
