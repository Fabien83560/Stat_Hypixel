package org.Window.Game;

import org.Game.Skyblock.SkyblockProfiles;
import org.Game.Skyblock.SkyblockProfilesContainer;
import org.Player.Player;

import javax.swing.*;

public class WindowSkyBlockStats {
    private JPanel mainPanel;
    private JPanel globalPanel;
    private JPanel generalPanel;
    private JPanel skillPanel;
    private JPanel petsPanel;
    private JPanel miningPanel;
    private JPanel FishingPanel;
    private JPanel dungeonPanel;
    private JPanel slayerPanel;
    private JPanel crimsonIslePanel;
    private JPanel bestiaryPanel;
    private JPanel auctionsPanel;
    private JPanel otherPanel;
    private JPanel essencesPanel;
    private JLabel cuteNameLabel;
    private JLabel levelLabel;
    private JLabel firstJoinLabel;
    private JLabel purseLabel;
    private JLabel purseBankLabel;
    private JLabel magicalPowerLabel;
    private JLabel fairySoulLabel;

    public WindowSkyBlockStats() {

    }
    public WindowSkyBlockStats(SkyblockProfilesContainer profile) {
        cuteNameLabel.setText("Profile name : " + profile.getCuteName());
        levelLabel.setText("Level : " + profile.getLevel());
        firstJoinLabel.setText("Join : " + profile.getFirstJoin());
        purseLabel.setText("Purse : " + profile.getPurse());
        purseBankLabel.setText("Purse Bank : " + profile.getPurseBank());
        magicalPowerLabel.setText("Magical Power : " + profile.getMagicalPower());
        fairySoulLabel.setText("Fairy Souls Collected : " + profile.getFairySoulCollected());
    }
    public JPanel getMainPanel(){return mainPanel;}
}
