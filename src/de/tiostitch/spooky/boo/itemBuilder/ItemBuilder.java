package de.tiostitch.spooky.boo.itemBuilder;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.tiostitch.spooky.boo.itemBuilder.items.Dinheiro_Do_Vip;
import de.tiostitch.spooky.boo.itemBuilder.items.Green_Candy;
import de.tiostitch.spooky.boo.itemBuilder.items.Items;
import de.tiostitch.spooky.boo.itemBuilder.items.Launch_Firework;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public final class ItemBuilder {

    public static ItemStack getItemByEnum(Items item) {
        ItemImpl myItem = null;
        switch (item) {
            case LAUNCH_FIREWORK:
                myItem = new Launch_Firework();
                break;
            case GREEN_CANDY:
                myItem = new Green_Candy();
                break;
            case DINHEIRO_DO_VIP:
                myItem = new Dinheiro_Do_Vip();
                break;
        }
        ItemStack iS = new ItemStack(myItem.getType(), 1, myItem.getData());

        if (iS.getType() != Material.SKULL_ITEM) {
            ItemMeta iM = iS.getItemMeta();
            iM.setDisplayName(myItem.getDisplayName());
            iM.setLore(myItem.getLore());

            iS.setItemMeta(iM);
            return iS;
        }

        return setSkullTexture(myItem);
    }

    private static ItemStack setSkullTexture(ItemImpl item) {
        ItemStack skull = new ItemStack(item.getType(), 1, item.getData());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setDisplayName(item.getDisplayName());

        GameProfile profile = new GameProfile(UUID.fromString("00000000-0000-0000-0000-000000000000"), null);
        profile.getProperties().put("textures", new Property("textures", item.getTexture()));

        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        meta.setLore(item.getLore());
        skull.setItemMeta(meta);
        return skull;
    }
}
