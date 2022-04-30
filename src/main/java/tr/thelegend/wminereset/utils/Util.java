package tr.thelegend.wminereset.utils;

import org.apache.commons.lang.enums.EnumUtils;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import tr.thelegend.wminereset.WMR;
import tr.thelegend.wminereset.objects.Mine;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Util {

    private final WMR plugin;
    public Util(WMR plugin) {
        this.plugin=plugin;
    }

    public boolean mineExists(String mineName) {
        if (plugin.getMines().isEmpty()) return false;
        return plugin.getMines().stream().anyMatch(mine -> mine.getName().equals(mineName));
    }

    public Mine getMine(String mineName) {
        if (plugin.getMines().isEmpty()) return null;
        for (Mine mine:plugin.getMines()) {
            if (mine.getName().equals(mineName)) return mine;
        }
        return null;
    }

    public boolean inEditMode(Player player) {
        if (plugin.getEditMode().isEmpty()) return false;
        return plugin.getEditMode().containsKey(player.getName());
    }

    public boolean inEditMode(String playerName) {
        if (plugin.getEditMode().isEmpty()) return false;
        return plugin.getEditMode().containsKey(playerName);
    }

    public Mine getMine(Block block) {
        if (plugin.getMines().isEmpty()) return null;
        for (Mine mine:plugin.getMines()) {
            for (Location loc:mine.getContent().keySet()) {
                if (loc.equals(block.getLocation())) return mine;
            }
        }
        return null;
    }

    public Material getMaterial(Block block) {
        if (plugin.getMines().isEmpty()) return null;
        for (Mine mine:plugin.getMines()) {
            for (Location loc:mine.getContent().keySet()) {
                if (loc.equals(block.getLocation())) return mine.getContent().get(loc);
            }
        }
        return null;
    }

    public boolean isValidSound(final String sound) {
        return Arrays.stream(Sound.values())
                .map(Sound::name)
                .collect(Collectors.toSet())
                .contains(sound);
    }

    public boolean isValidEffect(final String effect) {
        return Arrays.stream(Effect.values())
                .map(Effect::name)
                .collect(Collectors.toSet())
                .contains(effect);
    }

    public boolean hasPermission(Mine mine, Player player) {
        if (mine.getPermission()==null) return true;
        return player.hasPermission(mine.getPermission());
    }

}
