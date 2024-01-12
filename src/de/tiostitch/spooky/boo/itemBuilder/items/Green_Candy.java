package de.tiostitch.spooky.boo.itemBuilder.items;

import de.tiostitch.spooky.boo.itemBuilder.ItemImpl;
import org.bukkit.Material;

import java.util.ArrayList;

public final class Green_Candy implements ItemImpl {
    @Override
    public Material getType() {
        return Material.SKULL_ITEM;
    }

    @Override
    public String getDisplayName() {
        return "§aGreen Candy";
    }

    @Override
    public String getTexture() {
        return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzY3MDk5NTQ1MGJkYjcxMDlmYTViZmU2ZDEzZmVlZGUzMjRmNDM5NWZjOTAwOTAwMGM4MGVlNTU0ZmFmYTYzNyJ9fX0=";
    }

    @Override
    public short getDurability() {
        return 0;
    }

    @Override
    public byte getData() {
        return 3;
    }

    @Override
    public ArrayList<String> getLore() {
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Candy can be used to trade with");
        lore.add("§7the Fear Mongerer during the");
        lore.add("§6Spooky Festival§7!");
        lore.add("");
        lore.add("§a§lUNCOMMON");
        return lore;
    }
}
