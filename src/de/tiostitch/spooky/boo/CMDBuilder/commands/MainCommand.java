package de.tiostitch.spooky.boo.CMDBuilder.commands;

import de.tiostitch.spooky.boo.CMDBuilder.CommandImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public final class MainCommand implements CommandImpl {
    @Override
    public String getCommandName() {
        return "give";
    }

    @Override
    public ArrayList<String> getCommandArgs() {
        final ArrayList<String> args = new ArrayList<>();
        args.add("give");
        return args;
    }

    @Override
    public ArrayList<String> getCommandAliases() {
        final ArrayList<String> aliases = new ArrayList<>();
        aliases.add("spookyEvents");
        aliases.add("spookyE");
        aliases.add("SE");
        return aliases;
    }


    @Override
    public void executeAction(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return;
        }
    }

}
