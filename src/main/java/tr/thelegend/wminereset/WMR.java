package tr.thelegend.wminereset;

import org.bukkit.plugin.java.JavaPlugin;
import tr.thelegend.wminereset.configuration.Container;
import tr.thelegend.wminereset.configuration.Handler;
import tr.thelegend.wminereset.configuration.Resource;

public class WMR extends JavaPlugin {

    public Resource config;
    public Handler handler;
    public Container container;

    public void onEnable() {

        config=new Resource(this,"config.yml");
        config.load();

        container=new Container(config);
        handler=new Handler(container);

    }

    public void onDisable() {

    }

    public Handler getHandler() {
        return handler;
    }

}
