package de.tiostitch.spooky.boo;

import de.tiostitch.spooky.boo.itemBuilder.ItemBuilder;
import de.tiostitch.spooky.boo.itemBuilder.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpookyCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§4WARN §cOnly players execute this!");
            return false;
        }

        if (!sender.isOp()) {
            sender.sendMessage("§4WARN §cOnly ADMINS have permission to use this!");
            return false;
        }

        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            helpBuilder(sender);
            return false;
        }

        if (args[0].equalsIgnoreCase("itemlist")) {
            itemListBuilder(sender);
            return false;
        }

        if (args[0].equalsIgnoreCase("give")) {
            if (args.length == 1 || args.length == 2) {
                sender.sendMessage("§4WARN §c/se give <item-name> <player> <amount>");
                return false;
            }

            Items item = null;
            for (Items ciItems : Items.values()) {
                if (ciItems.name().equals(args[1])) {
                    item = ciItems;
                    break;
                }
            }

            if (item == null) {
                sender.sendMessage("§4WARN §cYou selected a invalid item!");
                return false;
            }

            Player player = Bukkit.getPlayer(args[2]);
            if (player == null) {
                sender.sendMessage("§4WARN §cYou selected a offline or invalid player!");
                return false;
            }

            try {
                int amount = Integer.parseInt(args[3]);

                ItemStack is = ItemBuilder.getItemByEnum(item);
                is.setAmount(amount);
                player.getInventory().addItem(is);
            } catch(NumberFormatException e) {
                sender.sendMessage("§4WARN §cYou provided a wrong number format!");
                return false;
            }
        }

        return false;
    }

    private void helpBuilder(CommandSender sender) {
        sender.sendMessage(" §b§lSPOOKY FESTIVAL");
        sender.sendMessage("§eSystem Commands:");
        sender.sendMessage("");
        sender.sendMessage(" §e/se help");
        sender.sendMessage(" §e/se give <item-name> <player> <amount>");
        sender.sendMessage(" §e/se itemlist");
        sender.sendMessage("");
    }

    private void itemListBuilder(CommandSender sender) {
        sender.sendMessage(" §b§lSPOOKY FESTIVAL");
        sender.sendMessage("§eSystem Commands:");
        sender.sendMessage("");

        int contador = 0;
        while (contador <= Items.values().length - 1) {
            sender.sendMessage("§9" + Items.values()[contador].name());
            contador++;
        }

        sender.sendMessage("");
    }
}
