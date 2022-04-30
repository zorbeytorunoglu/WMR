package tr.thelegend.wminereset.configuration;

public class Handler {

    private final Container container;

    public Handler(Container container) {
        this.container=container;
    }

    public String getNoPerm() {
        return container.noPerm;
    }

    public String getOnlyInGame() {
        return container.onlyInGame;
    }

    public String getCreateUsage() {
        return container.createUsage;
    }

    public String getDeleteUsage() {
        return container.deleteUsage;
    }

    public String getSetBlocksUsage() {
        return container.setBlocksUsage;
    }

}
