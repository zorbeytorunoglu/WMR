package tr.thelegend.wminereset.commands;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tr.thelegend.wminereset.WMR;
import tr.thelegend.wminereset.objects.Mine;
import tr.thelegend.wminereset.utils.StringUtils;

public class WMRCmd implements CommandExecutor {

    private final WMR plugin;

    public WMRCmd(WMR plugin) {
        this.plugin=plugin;
        plugin.getCommand("wmr").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("wmr")) {

            if (args.length==0) {
                if (!commandSender.hasPermission("wmr.commands")) {
                    commandSender.sendMessage(plugin.getHandler().getNoPerm());
                    return false;
                }

                for (String s:plugin.getHandler().getCommands()) {
                    commandSender.sendMessage(s);
                }

                return true;

            }

            if (args[0].equalsIgnoreCase("create")) {
                if (!commandSender.hasPermission("wmr.create")) {
                    commandSender.sendMessage(plugin.getHandler().getNoPerm());
                    return false;
                }

                if (args.length!=2) {
                    commandSender.sendMessage(plugin.getHandler().getCreateUsage());
                    return false;
                }

                String mineName=args[1];

                if (!StringUtils.isAlphanumeric(mineName)) {
                    commandSender.sendMessage(plugin.getHandler().getInvalidMineName());
                    return false;
                }

                if (plugin.getUtil().mineExists(mineName)) {
                    commandSender.sendMessage(plugin.getHandler().getMineAlreadyExists());
                    return false;
                }

                plugin.getMines().add(new Mine(mineName));

                for (String s:plugin.getHandler().getAfterCreation()) {
                    commandSender.sendMessage(s.replace("%mine%", mineName));
                }

                return true;

            }

            if (args[0].equalsIgnoreCase("setdelay")) {
                if (!commandSender.hasPermission("wmr.setdelay")) {
                    commandSender.sendMessage(plugin.getHandler().getNoPerm());
                    return false;
                }

                if (args.length!=3) {
                    commandSender.sendMessage(plugin.getHandler().getSetDelayUsage());
                    return false;
                }

                String mineName=args[1];

                if (!plugin.getUtil().mineExists(mineName)) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                if (!StringUtils.isNumeric(args[2])) {
                    commandSender.sendMessage(plugin.getHandler().getInvalidNumber());
                    return false;
                }

                Mine mine=plugin.getUtil().getMine(mineName);

                if (mine==null) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                mine.setDelay(Integer.parseInt(args[2]));

                commandSender.sendMessage(plugin.getHandler().getMineDelaySet().replace("%delay%", args[2])
                        .replace("%mine%", mine.getName()));

                return true;

            }

            if (args[0].equalsIgnoreCase("setsound")) {
                if (!commandSender.hasPermission("wmr.setsound")) {
                    commandSender.sendMessage(plugin.getHandler().getNoPerm());
                    return false;
                }

                if (args.length!=3) {
                    commandSender.sendMessage(plugin.getHandler().getSetDelayUsage());
                    return false;
                }

                String mineName=args[1];

                if (!plugin.getUtil().mineExists(mineName)) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                if (!plugin.getUtil().isValidSound(args[2])) {
                    commandSender.sendMessage(plugin.getHandler().getInvalidSound());
                    return false;
                }

                Mine mine=plugin.getUtil().getMine(mineName);

                if (mine==null) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                mine.setSoundString(args[2]);
                mine.setSound(Sound.valueOf(args[2]));

                commandSender.sendMessage(plugin.getHandler().getSoundSet().replace("%sound%", args[2])
                        .replace("%mine%", mine.getName()));

                return true;
            }

            if (args[0].equalsIgnoreCase("setbreakeffect")) {
                if (!commandSender.hasPermission("wmr.setbreakeffect")) {
                    commandSender.sendMessage(plugin.getHandler().getNoPerm());
                    return false;
                }

                if (args.length!=3) {
                    commandSender.sendMessage(plugin.getHandler().getSetDelayUsage());
                    return false;
                }

                String mineName=args[1];

                if (!plugin.getUtil().mineExists(mineName)) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                if (!plugin.getUtil().isValidEffect(args[2])) {
                    commandSender.sendMessage(plugin.getHandler().getInvalidEffect());
                    return false;
                }

                Mine mine=plugin.getUtil().getMine(mineName);

                if (mine==null) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                mine.setEffectString(args[2]);
                mine.setEffect(Effect.valueOf(args[2]));

                commandSender.sendMessage(plugin.getHandler().getEffectSet().replace("%effect%", args[2])
                        .replace("%mine%", mine.getName()));

                return true;
            }

            if (args[0].equalsIgnoreCase("setrefilleffect")) {
                if (!commandSender.hasPermission("wmr.setrefilleffect")) {
                    commandSender.sendMessage(plugin.getHandler().getNoPerm());
                    return false;
                }

                if (args.length!=3) {
                    commandSender.sendMessage(plugin.getHandler().getSetRefillEffectUsage());
                    return false;
                }

                String mineName=args[1];

                if (!plugin.getUtil().mineExists(mineName)) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                if (!plugin.getUtil().isValidEffect(args[2])) {
                    commandSender.sendMessage(plugin.getHandler().getInvalidEffect());
                    return false;
                }

                Mine mine=plugin.getUtil().getMine(mineName);

                if (mine==null) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                mine.setRefillEffectString(args[2]);
                mine.setRefillEffect(Effect.valueOf(args[2]));

                commandSender.sendMessage(plugin.getHandler().getRefillEffectSet().replace("%effect%", args[2])
                        .replace("%mine%", mine.getName()));

                return true;
            }

            if (args[0].equalsIgnoreCase("setcontent")) {

                if (!commandSender.hasPermission("wmr.setcontent")) {
                    commandSender.sendMessage(plugin.getHandler().getNoPerm());
                    return false;
                }
                if (!(commandSender instanceof Player)) {
                    commandSender.sendMessage(plugin.getHandler().getOnlyInGame());
                    return false;
                }

                if (args.length!=2) {
                    commandSender.sendMessage(plugin.getHandler().getSetContentUsage());
                    return false;
                }

                String mineName=args[1];

                Mine mine=plugin.getUtil().getMine(mineName);

                if (mine==null) {
                    commandSender.sendMessage(plugin.getHandler().getMineNotFound());
                    return false;
                }

                Player player=(Player)commandSender;

                if (plugin.getUtil().inEditMode(player.getName())) {
                    player.sendMessage(plugin.getHandler().getQuitEditMode());
                    plugin.getEditMode().remove(player.getName());
                    return false;
                }

                plugin.getEditMode().put(player.getName(), mine);

                player.sendMessage(plugin.getHandler().getEnteredEditMode());

                return true;

            }

        }

        return false;
    }
}
