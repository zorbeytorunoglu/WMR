package tr.thelegend.wminereset.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import tr.thelegend.wminereset.WMR;
import tr.thelegend.wminereset.objects.Mine;

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

}
