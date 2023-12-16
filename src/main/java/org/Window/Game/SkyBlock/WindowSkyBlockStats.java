package org.Window.Game.SkyBlock;

import org.Game.Skyblock.SkyblockProfilesContainer;

import javax.swing.*;
import java.awt.*;

public class WindowSkyBlockStats {
    private JPanel mainPanel;
    private JPanel globalPanel;
    private JPanel generalPanel;
    private JPanel skillPanel;
    private JPanel petsPanel;
    private JPanel miningPanel;
    private JPanel fishingPanel;
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
    private JLabel titleOtherLabel;
    private JLabel totalMobsKillsLabel;
    private JLabel totalDeathsLabel;
    private JLabel giftsGivenLabel;
    private JLabel totalCandyLabel;
    private JLabel purpleCandyLabel;
    private JLabel greenCandyLabel;
    private JLabel giftsReceivedLabel;

    public WindowSkyBlockStats(SkyblockProfilesContainer profile) {
        cuteNameLabel.setText("Profile name : " + profile.getCuteName());
        levelLabel.setText("Level : " + profile.getLevel());
        firstJoinLabel.setText("Join : " + profile.getFirstJoin());
        purseLabel.setText("Purse : " + profile.getPurse());
        purseBankLabel.setText("Purse Bank : " + profile.getPurseBank());
        magicalPowerLabel.setText("Magical Power : " + profile.getMagicalPower());
        fairySoulLabel.setText("Fairy Souls Collected : " + profile.getFairySoulCollected());

        setSkillPanel(new WindowSkill(profile.getSkills()).getMainPanel());
        setPetsPanel(new WindowPets(profile.getPetList()).getMainPanel());
        setMiningPanel(new WindowMining(profile.getMining()).getMainPanel());
        setFishingPanel(new WindowFishing(profile.getFishing()).getMainPanel());
        setDungeonPanel(new WindowDungeon(profile.getDungeon()).getMainPanel());
        setSlayerPanel(new WindowSlayer(profile.getSlayerList(),profile.getTotalXpSlayer()).getMainPanel());
        setCrimsonIslePanel(new WindowCrimsonIsle(profile.getCrimson()).getMainPanel());
        setBestiaryPanel(new WindowBestiary(profile.getMilestone(),profile.getMilestoneUnlockTiers()).getMainPanel());

        titleOtherLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        totalMobsKillsLabel.setText("Total Mobs Kills : " + profile.getTotalMobKill());
        totalDeathsLabel.setText("Total Deaths : " + profile.getTotalDeaths());
        giftsGivenLabel.setText("Gifts Given : " + profile.getGiftGiven());
        giftsReceivedLabel.setText("Gifts Received : " + profile.getGiftReceived());
        totalCandyLabel.setText("Total Candy : " + profile.getTotalCandy());
        greenCandyLabel.setText("Green Candy : " + profile.getGreenCandy());
        purpleCandyLabel.setText("Purple candy : " + profile.getPurpleCandy());
    }

    public void setSkillPanel(JPanel panel) {
        skillPanel.setLayout(new BoxLayout(skillPanel, BoxLayout.Y_AXIS));
        skillPanel.removeAll();
        skillPanel.add(panel);
        skillPanel.revalidate();
        skillPanel.repaint();
    }

    public void setPetsPanel(JPanel panel) {
        petsPanel.setLayout(new BoxLayout(petsPanel, BoxLayout.Y_AXIS));
        petsPanel.removeAll();
        petsPanel.add(panel);
        petsPanel.revalidate();
        petsPanel.repaint();
    }

    public void setMiningPanel(JPanel panel) {
        miningPanel.setLayout(new BoxLayout(miningPanel, BoxLayout.Y_AXIS));
        miningPanel.removeAll();
        miningPanel.add(panel);
        miningPanel.revalidate();
        miningPanel.repaint();
    }

    public void setFishingPanel(JPanel panel) {
        fishingPanel.setLayout(new BoxLayout(fishingPanel, BoxLayout.Y_AXIS));
        fishingPanel.removeAll();
        fishingPanel.add(panel);
        fishingPanel.revalidate();
        fishingPanel.repaint();
    }

    public void setDungeonPanel(JPanel panel) {
        dungeonPanel.setLayout(new BoxLayout(dungeonPanel, BoxLayout.Y_AXIS));
        dungeonPanel.removeAll();
        dungeonPanel.add(panel);
        dungeonPanel.revalidate();
        dungeonPanel.repaint();
    }

    public void setSlayerPanel(JPanel panel) {
        slayerPanel.setLayout(new BoxLayout(slayerPanel, BoxLayout.Y_AXIS));
        slayerPanel.removeAll();
        slayerPanel.add(panel);
        slayerPanel.revalidate();
        slayerPanel.repaint();
    }

    public void setCrimsonIslePanel(JPanel panel) {
        crimsonIslePanel.setLayout(new BoxLayout(crimsonIslePanel, BoxLayout.Y_AXIS));
        crimsonIslePanel.removeAll();
        crimsonIslePanel.add(panel);
        crimsonIslePanel.revalidate();
        crimsonIslePanel.repaint();
    }

    public void setBestiaryPanel(JPanel panel) {
        bestiaryPanel.setLayout(new BoxLayout(bestiaryPanel, BoxLayout.Y_AXIS));
        bestiaryPanel.removeAll();
        bestiaryPanel.add(panel);
        bestiaryPanel.revalidate();
        bestiaryPanel.repaint();
    }
    public JPanel getMainPanel(){return mainPanel;}
}
