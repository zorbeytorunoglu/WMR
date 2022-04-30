package tr.thelegend.wminereset.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import tr.thelegend.wminereset.WMR;
import tr.thelegend.wminereset.objects.Mine;

public class MineBreak implements Listener {

    private final WMR plugin;
    public MineBreak(WMR plugin) {
        this.plugin=plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onMineBreak(BlockBreakEvent e) {

        if (!e.getPlayer().hasPermission("wmr.mine")) return;

        Mine mine=plugin.getUtil().getMine(e.getBlock());

        if (mine!=null) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,
                    () -> e.getBlock().setType(mine.getContent().get(e.getBlock().getLocation())),20L*mine.getDelay());
        }

    }

}
