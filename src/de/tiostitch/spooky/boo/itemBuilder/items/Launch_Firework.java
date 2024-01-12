package de.tiostitch.spooky.boo.itemBuilder.items;

import de.tiostitch.spooky.boo.itemBuilder.ItemImpl;
import org.bukkit.Material;

import java.util.ArrayList;

public final class Launch_Firework implements ItemImpl {


    @Override
    public Material getType() {
        return Material.FIREWORK;
    }

    @Override
    public String getDisplayName() {
        return "§9Bat Firework";
    }

    @Override
    public String getTexture() {
        return "";
    }

    @Override
    public short getDurability() {
        return 0;
    }

    @Override
    public byte getData() {
        return 0;
    }

    @Override
    public ArrayList<String> getLore() {
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Explodes into several Bat");
        lore.add("§7Piñatas, each dropping a bunch");
        lore.add("§7of candies. Only usable in the");
        lore.add("§bVillage§7.");
        lore.add("");
        lore.add("§8Cooldown: §a30s");
        lore.add("");
        lore.add("§8§oBat Piñata drops do not");
        lore.add("§8§ocount towards leaderboard");
        lore.add("§8§oprogress!");
        lore.add("");
        lore.add("§9§lRARE");
        return lore;
    }
}
