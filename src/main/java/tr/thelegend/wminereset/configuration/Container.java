package tr.thelegend.wminereset.configuration;

import tr.thelegend.wminereset.utils.StringUtils;

import java.util.List;

public class Container {

    public final String noPerm;
    public final String onlyInGame;
    public final String createUsage;
    public final String deleteUsage;
    public final String setBlocksUsage;
    public final String mineAlreadyExists;
    public final String invalidMineName;
    public final List<String> afterCreation;
    public final String mineNotFound;
    public final String setDelayUsage;
    public final String invalidNumber;
    public final String mineDelaySet;
    public final String enteredEditMode;
    public final String quitEditMode;
    public final String noBlockPlaced;
    public final String blocksSaved;
    public final String invalidSound;
    public final String soundSet;
    public final String invalidEffect;
    public final String effectSet;
    public final String setEffectUsage;
    public final String setSoundUsage;
    public final String setContentUsage;

    public Container(Resource file) {

        this.noPerm=StringUtils.hex(file.getString("messages.no-perm"));
        this.onlyInGame=StringUtils.hex(file.getString("messages.only-in-game"));
        this.createUsage=StringUtils.hex(file.getString("messages.create-usage"));
        this.deleteUsage=StringUtils.hex(file.getString("messages.delete-usage"));
        this.setBlocksUsage=StringUtils.hex(file.getString("messages.setblocks-usage"));
        this.mineAlreadyExists=StringUtils.hex(file.getString("messages.mine-already-exists"));
        this.invalidMineName=StringUtils.hex(file.getString("messages.invalid-mine-name"));
        this.afterCreation=file.getStringList("messages.after-creation");
        this.mineNotFound=StringUtils.hex(file.getString("messages.mine-not-found"));
        this.setDelayUsage=StringUtils.hex(file.getString("messages.set-delay-usage"));
        this.invalidNumber=StringUtils.hex(file.getString("messages.invalid-number"));
        this.mineDelaySet=StringUtils.hex(file.getString("messages.mine-delay-set"));
        this.enteredEditMode=StringUtils.hex(file.getString("messages.entered-edit-mode"));
        this.quitEditMode=StringUtils.hex(file.getString("messages.quit-edit-mode"));
        this.noBlockPlaced=StringUtils.hex(file.getString("messages.noblockplaced"));
        this.blocksSaved=StringUtils.hex(file.getString("messages.blocks-saved"));
        this.invalidSound=StringUtils.hex(file.getString("messages.invalid-sound"));
        this.soundSet=StringUtils.hex(file.getString("messages.sound-set"));
        this.invalidEffect=StringUtils.hex(file.getString("messages.invalid-effect"));
        this.effectSet=StringUtils.hex(file.getString("messages.effect-set"));
        this.setEffectUsage=StringUtils.hex(file.getString("messages.set-effect-usage"));
        this.setSoundUsage=StringUtils.hex(file.getString("messages.set-sound-usage"));
        this.setContentUsage=StringUtils.hex(file.getString("messages.set-content-usage"));

    }
}
