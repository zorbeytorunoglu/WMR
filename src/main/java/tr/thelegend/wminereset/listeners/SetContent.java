package tr.thelegend.wminereset.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import tr.thelegend.wminereset.WMR;
import tr.thelegend.wminereset.objects.Mine;

import java.util.ArrayList;
import java.util.HashMap;

public class SetContent implements Listener {

    private final WMR plugin;
    public SetContent(WMR plugin) {
        this.plugin=plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    private HashMap<String, ArrayList<Block>> placedblocks= new HashMap<>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (!e.getPlayer().hasPermission("wmr.setcontent")) return;
        if (!plugin.getUtil().inEditMode(e.getPlayer())) return;

        ArrayList<Block> blocklist;
        if (placedblocks.get(e.getPlayer().getName())!=null) {
            placedblocks.get(e.getPlayer().getName()).add(e.getBlockPlaced());
        } else {
            blocklist=new ArrayList<>();
            blocklist.add(e.getBlockPlaced());
            placedblocks.put(e.getPlayer().getName(),blocklist);
        }

        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);

    }

    @EventHandler
    public void onDone(AsyncPlayerChatEvent e) {
        if (!placedblocks.containsKey(e.getPlayer().getName())) return;
        if (e.getMessage().equalsIgnoreCase("done")) {
            if (placedblocks.isEmpty()) {
                e.getPlayer().sendMessage(plugin.getHandler().getNoBlockPlaced());
            } else {
                Mine mine=plugin.getEditMode().get(e.getPlayer().getName());
                ArrayList<Block> blocks=placedblocks.get(e.getPlayer().getName());
                HashMap<Location, Material> content=new HashMap<>();
                for (Block block:blocks) {
                    content.put(block.getLocation(),block.getType());
                    mine.setContent(content);
                }
                e.getPlayer().sendMessage(plugin.getHandler().getBlocksSaved().replace("%mine%", mine.getName()));
            }
            e.setCancelled(true);
            plugin.getEditMode().remove(e.getPlayer().getName());
            placedblocks.remove(e.getPlayer().getName());
        }
    }

}
