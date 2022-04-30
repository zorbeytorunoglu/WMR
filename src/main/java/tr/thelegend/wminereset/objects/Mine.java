package tr.thelegend.wminereset.objects;

import org.bukkit.Location;
import org.bukkit.Material;

import java.util.HashMap;

public class Mine {

    private final String name;
    private HashMap<Location, Material> content;
    private int delay;

    public Mine(String name) {
        super();
        this.name=name;
        this.content= new HashMap<>();
        this.delay=0;
    }

    public String getName() {
        return name;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay=delay;
    }

    public HashMap<Location, Material> getContent() {
        return content;
    }

    public void setContent(HashMap<Location, Material> content) {
        this.content = content;
    }

    public void reset() {
        if (content.isEmpty()) return;
        for (Location loc:content.keySet()) {
            loc.getBlock().setType(content.get(loc));
        }
    }

}
