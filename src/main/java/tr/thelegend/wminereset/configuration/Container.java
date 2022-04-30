package tr.thelegend.wminereset.configuration;

import tr.thelegend.wminereset.utils.StringUtils;

public class Container {

    public final String noPerm;
    public final String onlyInGame;
    public final String createUsage;
    public final String deleteUsage;
    public final String setBlocksUsage;

    public Container(Resource file) {
        this.noPerm=StringUtils.hex(file.getString("messages.no-perm"));
        this.onlyInGame=StringUtils.hex(file.getString("messages.only-in-game"));
        this.createUsage=StringUtils.hex(file.getString("messages.create-usage"));
        this.deleteUsage=StringUtils.hex(file.getString("messages.delete-usage"));
        this.setBlocksUsage=StringUtils.hex(file.getString("messages.setblocks-usage"));
    }

}
