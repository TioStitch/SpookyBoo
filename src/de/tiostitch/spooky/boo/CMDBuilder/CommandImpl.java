package de.tiostitch.spooky.boo.CMDBuilder;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public interface CommandImpl {

    String getCommandName();
    ArrayList<String> getCommandArgs();
    ArrayList<String> getCommandAliases();
    void executeAction(CommandSender sender, Command cmd, String label, String[] args);
}
