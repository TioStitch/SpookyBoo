package de.tiostitch.spooky.boo.abilitieBuilder.abilities;

import de.tiostitch.spooky.boo.Main;
import de.tiostitch.spooky.boo.abilitieBuilder.AbilitieImpl;
import de.tiostitch.spooky.boo.itemBuilder.ItemBuilder;
import de.tiostitch.spooky.boo.itemBuilder.ItemImpl;
import de.tiostitch.spooky.boo.itemBuilder.items.Items;
import de.tiostitch.spooky.boo.utilities.PlayerUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftBat;
import org.bukkit.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public final class BatFirework implements AbilitieImpl {

    private static final WeakHashMap<String, Long> cooldown = new WeakHashMap<>();
    private static final WeakHashMap<String, ArrayList<Entity>> batEntities = new WeakHashMap<>();

    @Override
    public String getItemUsedName() {
        return "Bat Firework";
    }

    @Override
    public String getAbilitieName() {
        return "Bat Firework";
    }

    @Override
    public short getManaCost() {
        return 0;
    }

    @Override
    public void getRightClickAction(PlayerInteractEvent event) {
        Player player = event.getPlayer();


        player.sendMessage("§eYou launched a §9Bat Firework§e! It's dropping candies for everyone!");
        PlayerUtils.sendForAllExcept(player, ChatColor.GRAY + player.getName() + " §eLaunched a Bat Firework in the Village. It's dropping candies for everyone!");

        event.setCancelled(true);

        ArrayList<Entity> entities = new ArrayList<>();
        Location loc = event.getClickedBlock().getLocation();

        Firework firework = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        final double y = firework.getLocation().getY();

        loc = loc.add(0, (y+15), 0);
        for (int i = 0; i <= 5; i++) {
            final CraftBat craftBat = (CraftBat) loc.getWorld().spawnEntity(loc, EntityType.BAT);
            craftBat.setCustomName("§6Bat Piñata §a5§f/§a5§c♥");
            craftBat.setCustomNameVisible(true);
            craftBat.setMetadata(player.getName(), new FixedMetadataValue(Main.getPlugin(Main.class), 0));
            entities.add(craftBat);
        }
        batEntities.put(player.getName(), entities);

        Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> {
            entities.forEach(Entity::remove);
        }, 30 * 60);

        final Location finalLoc = loc;
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), () -> {
            for (Entity entity : entities) {

                Location entityLoc = entity.getLocation();
                entityLoc.getWorld().dropItemNaturally(entityLoc, ItemBuilder.getItemByEnum(Items.GREEN_CANDY));

                if (entity.getLocation().distance(finalLoc) >= 15) {
                    entity.teleport(finalLoc);
                }
            }
        }, 5 * 60, 5 * 60);
    }

    @Override
    public void getLeftClickAction(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!batEntities.containsKey(player.getName())) {
            player.sendMessage("§b[SpookyBoo] §6You don't have bats in Event!");
            return;
        }

        ArrayList<Entity> entities = batEntities.get(player.getName());

        player.sendMessage("§b[SpookyBoo] §6Bat's removed by Event!");
        entities.forEach(Entity::remove);
    }

    @Override
    public void getRightShiftClickAction(PlayerInteractEvent event) {

    }

    @Override
    public void getLeftShiftClickAction(PlayerInteractEvent event) {

    }
}
