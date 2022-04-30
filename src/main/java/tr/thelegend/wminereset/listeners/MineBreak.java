package tr.thelegend.wminereset.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
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

            if (e.getPlayer().hasPermission("wmr.setcontent")) {
                if (plugin.getUtil().inEditMode(e.getPlayer())) {
                    if (mine.getContent().containsKey(e.getBlock().getLocation())) {
                        mine.getContent().remove(e.getBlock().getLocation());
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_NO, 2F, 1F);
                        return;
                    }
                }
            }

            if (mine.getSoundString()!=null) {
                e.getPlayer().playSound(e.getPlayer().getLocation(), mine.getSound(), 2F, 1F);
            }

            if (mine.getEffectString()!=null) {
                e.getPlayer().playEffect(e.getBlock().getLocation(), mine.getEffect(), 1);
            }

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                e.getBlock().setType(mine.getContent().get(e.getBlock().getLocation()));
                if (mine.getRefillEffectString()!=null) e.getPlayer().playEffect(e.getBlock().getLocation(), mine.getRefillEffect(), 1);
            },20L*mine.getDelay());

        }

    }

}
