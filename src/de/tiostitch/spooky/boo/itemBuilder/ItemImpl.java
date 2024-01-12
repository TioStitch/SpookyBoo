package de.tiostitch.spooky.boo.itemBuilder;

import org.bukkit.Material;

import java.util.ArrayList;

public interface ItemImpl {
    Material getType();
    String getDisplayName();
    String getTexture();
    short getDurability();
    byte getData();
    ArrayList<String> getLore();
}
