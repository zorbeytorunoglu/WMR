package tr.thelegend.wminereset.objects;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;

import java.util.HashMap;

public class Mine {

    private final String name;
    private HashMap<Location, Material> content;
    private int delay;
    private String soundString=null;
    private Sound sound;
    private Effect effect;
    private String effectString=null;

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

    public void setSoundString(String soundString) {
        this.soundString=soundString;
    }

    public String getSoundString() {
        return soundString;
    }

    public void setSound(Sound sound) {
        this.sound=sound;
    }

    public Sound getSound() {
        return sound;
    }

    public void setEffect(Effect effect) {
        this.effect=effect;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffectString(String effectString) {
        this.effectString=effectString;
    }

    public String getEffectString() {
        return effectString;
    }

    public void reset() {
        if (content.isEmpty()) return;
        for (Location loc:content.keySet()) {
            loc.getBlock().setType(content.get(loc));
        }
    }

}
