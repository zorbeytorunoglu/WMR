package tr.thelegend.wminereset.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tr.thelegend.wminereset.WMR;

public class WMRCmd implements CommandExecutor {

    private final WMR plugin;

    public WMRCmd(WMR plugin) {
        this.plugin=plugin;
        plugin.getCommand("wmr").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("wmr")) {

            if (args[0].equalsIgnoreCase("create")) {
                if (commandSender.hasPermission("wmr.create")) {
                    commandSender.sendMessage();
                }
            }

        }

        return false;
    }
}
