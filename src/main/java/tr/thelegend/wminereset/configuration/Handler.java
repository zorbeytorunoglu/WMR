package tr.thelegend.wminereset.configuration;

import tr.thelegend.wminereset.utils.StringUtils;

import java.util.ArrayList;

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
    public String getSetBlocksUsage() { return container.setBlocksUsage; }
    public String getMineAlreadyExists() { return container.mineAlreadyExists; }
    public String getInvalidMineName() { return container.invalidMineName; }
    public ArrayList<String> getAfterCreation() { ArrayList<String> mgs = new ArrayList<>(); for (String s : container.afterCreation) { mgs.add(StringUtils.hex(s)); } return mgs; }
    public String getMineNotFound() { return container.mineNotFound; }
    public String getSetDelayUsage() { return container.setDelayUsage; }
    public String getInvalidNumber() {return container.invalidNumber;}
    public String getMineDelaySet() {return container.mineDelaySet;}
    public String getEnteredEditMode() {return container.enteredEditMode;}
    public String getQuitEditMode() {return container.quitEditMode;}
    public String getNoBlockPlaced() { return container.noBlockPlaced; }
    public String getBlocksSaved() { return container.blocksSaved; }
}
