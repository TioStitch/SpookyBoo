package de.tiostitch.spooky.boo.itemBuilder.items;

import de.tiostitch.spooky.boo.itemBuilder.ItemImpl;
import org.bukkit.Material;

import java.util.ArrayList;

public final class Dinheiro_Do_Vip implements ItemImpl {
    @Override
    public Material getType() {
        return Material.SKULL_ITEM;
    }

    @Override
    public String getDisplayName() {
        return "§bDinheiro do VIP";
    }

    @Override
    public String getTexture() {
        return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQwMDVlYmJmOTgxN2Q2OTI4ZGU4YmM1ZjdkMWMzODkyNzYwMjBhYzg3NjQ3ZDI4YWI4Zjk5ZWIzOWZmZGU3NiJ9fX0=";
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
        lore.add("§7O dinheiro do vip pode ser usado");
        lore.add("§7para a §6gasolina §7e §6felicidade");
        lore.add("§7do poderoso §6Murilo_Revex§7.");
        lore.add("");
        lore.add("§6§lMURILION");
        return lore;
    }
}
