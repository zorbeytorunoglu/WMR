package tr.thelegend.wminereset;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;
import tr.thelegend.wminereset.commands.WMRCmd;
import tr.thelegend.wminereset.configuration.Container;
import tr.thelegend.wminereset.configuration.Handler;
import tr.thelegend.wminereset.configuration.Resource;
import tr.thelegend.wminereset.listeners.MineBreak;
import tr.thelegend.wminereset.listeners.SetContent;
import tr.thelegend.wminereset.objects.Mine;
import tr.thelegend.wminereset.utils.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class WMR extends JavaPlugin {

    private Resource config;
    private Resource mine;
    private Handler handler;
    private Container container;
    private Util util;
    private ArrayList<Mine> mines=new ArrayList<>();
    private HashMap<String, Mine> editMode=new HashMap<>();

    public void onEnable() {

        config=new Resource(this,"config.yml");
        config.load();
        mine=new Resource(this,"mines.yml");
        mine.load();

        container=new Container(config);
        handler=new Handler(container);

        util=new Util(this);

        mines=loadMines();
        editMode=new HashMap<>();

        new SetContent(this);
        new MineBreak(this);
        new WMRCmd(this);
    }

    public void onDisable() {
        saveMines(mines);
    }

    public Handler getHandler() {
        return handler;
    }

    public ArrayList<Mine> getMines() {
        return mines;
    }

    public HashMap<String, Mine> getEditMode() { return editMode; }

    public Util getUtil() { return util; }

    private ArrayList<Mine> loadMines() {
        ArrayList<Mine> mineArrayList= new ArrayList<>();
        Set<String> set=mine.getKeys(false);
        if (set.isEmpty()) return mineArrayList;
        for (String s:set) {
            int delay=this.mine.getInt(s+".delay");
            HashMap<Location, Material> content=new HashMap<>();
            Set<String> locs=this.mine.getConfigurationSection(s+".content").getKeys(false);
            for (String s2:locs) {
                Location loc=this.mine.getLocation(s+".content."+s2+".location");
                Material mat=Material.valueOf(this.mine.getString(s+".content."+s2+".material"));
                content.put(loc,mat);
            }
            Mine ssmine=new Mine(s);
            ssmine.setContent(content);
            ssmine.setDelay(delay);
            mineArrayList.add(ssmine);
        }
        return mineArrayList;
    }

    private void saveMines(ArrayList<Mine> mines) {
        if (mines.isEmpty()) return;
        int id=0;
        for (Mine mine:mines) {
            this.mine.set(mine.getName()+".delay", mine.getDelay());
            if (mine.getContent().isEmpty()) continue;
            for (Location loc:mine.getContent().keySet()) {
                this.mine.set(mine.getName()+".content."+id+".location", loc);
                this.mine.set(mine.getName()+".content."+id+".material",mine.getContent().get(loc).toString());
                id++;
            }
        }
        this.mine.save();
    }

}
