package org.Window.Game.SkyBlock;

import org.Game.Skyblock.SkyblockProfilesContainer;
import javax.swing.*;
import java.awt.*;

/**
 * This class displays all the statistics of a player
 * in Skyblock mode.
 * @see WindowSkill
 * @see WindowPets
 * @see WindowMining
 * @see WindowFishing
 * @see WindowDungeon
 * @see WindowCrimsonIsle
 * @see WindowSlayer
 * @see WindowBestiary
 */
public class WindowSkyBlockStats {

    /**
     * Main panel of the WindowSkyBlockStats class.
     */
    private JPanel mainPanel;

    /**
     * Panel containing the three global statistics of a player
     * in Skyblock mode (Profile name, Level and the
     * date the player joined that profile).
     */
    private JPanel globalPanel;

    /**
     * Panel containing the four general statistics of a player
     * in Skyblock mode (Purse, Bank Purse, Magical Power and Fairy
     * Souls collected).
     *
     */
    private JPanel generalPanel;

    /**
     * Panel containing all the Skill statistics of a player.
     * @see WindowSkill
     * @see org.Game.Skyblock.Stats.Skills
     */
    private JPanel skillPanel;

    /**
     * Panel containing all the Pets statistics of a player.
     * @see WindowPets
     * @see WindowPet
     * @see org.Game.Skyblock.Stats.Pet
     */
    private JPanel petsPanel;

    /**
     * Panel containing all the Mining statistics of a player.
     * @see WindowMining
     * @see org.Game.Skyblock.Stats.Mining
     */
    private JPanel miningPanel;

    /**
     * Panel containing all the Fishing statistics of a player.
     * @see WindowFishing
     * @see org.Game.Skyblock.Stats.Fishing.Fishing
     */
    private JPanel fishingPanel;

    /**
     * Panel containing all the Dungeon statistics of a player.
     * @see WindowDungeon
     * @see org.Game.Skyblock.Stats.Dungeon.Dungeon
     */
    private JPanel dungeonPanel;

    /**
     * Panel containing all the Slayer statistics of a player.
     * @see WindowSlayer
     * @see org.Game.Skyblock.Stats.Slayer
     */
    private JPanel slayerPanel;

    /**
     * Panel containing all the Crimson Isle statistics of a player.
     * @see WindowCrimsonIsle
     * @see WindowKuudra
     * @see WindowDojo
     * @see org.Game.Skyblock.Stats.Crimson.Crimson
     * @see org.Game.Skyblock.Stats.Crimson.Kuudra
     * @see org.Game.Skyblock.Stats.Crimson.Dojo
     */
    private JPanel crimsonIslePanel;

    /**
     * Panel containing all the Bestiary statistics of a player.
     * @see WindowBestiary
     */
    private JPanel bestiaryPanel;

    /**
     * Panel containing all the Auctions statistics of a player.
     * @see WindowSkyBlockStats#WindowSkyBlockStats(SkyblockProfilesContainer)
     * @see SkyblockProfilesContainer
     */
    private JPanel auctionsPanel;

    /**
     * Panel containing all the other statistics of a player.
     * @see WindowSkyBlockStats#WindowSkyBlockStats(SkyblockProfilesContainer)
     * @see SkyblockProfilesContainer
     */
    private JPanel otherPanel;

    /**
     * Panel containing all the other statistics of a player.
     * @see WindowSkyBlockStats#WindowSkyBlockStats(SkyblockProfilesContainer)
     * @see SkyblockProfilesContainer
     */
    private JPanel essencesPanel;

    /**
     * Name of the current Profile in Skyblock (Mango,
     * Peach...).
     */
    private JLabel cuteNameLabel;

    /**
     * Name of the current Profile level in Skyblock.
     */
    private JLabel levelLabel;

    /**
     * Date the player joined the associated profile in Skyblock.
     */
    private JLabel firstJoinLabel;

    /**
     * Value of the player's purse in the associated profile in Skyblock.
     */
    private JLabel purseLabel;

    /**
     * Value of the player's bank purse in the associated profile in Skyblock.
     */
    private JLabel purseBankLabel;

    /**
     * Value of the player's magical power in the associated profile in Skyblock.
     */
    private JLabel magicalPowerLabel;

    /**
     * Value of the player's collected fairy souls in the associated profile in Skyblock.
     */
    private JLabel fairySoulLabel;

    /**
     * Label containing the 'Other' title.
     */
    private JLabel titleOtherLabel;

    /**
     * Label containing the total number of Mobs killed by the player
     * in the associated profile in Skyblock.
     */
    private JLabel totalMobsKillsLabel;

    /**
     * Label containing the total number of the player's deaths
     * in the associated profile in Skyblock.
     */
    private JLabel totalDeathsLabel;

    /**
     * Label containing the total number of gifts given by the player
     * in the associated profile in Skyblock.
     */
    private JLabel giftsGivenLabel;

    /**
     * Label containing the total number of candies the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel totalCandyLabel;

    /**
     * Label containing the total number of purple candies the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel purpleCandyLabel;

    /**
     * Label containing the total number of green candies the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel greenCandyLabel;

    /**
     * Label containing the total number of gifts the player received
     * in the associated profile in Skyblock.
     */
    private JLabel giftsReceivedLabel;

    /**
     * Total number of Wither essence the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel witherLabel;

    /**
     * Total number of Dragons essence the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel dragonLabel;

    /**
     * Total number of Spider essence the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel spiderLabel;

    /**
     * Total number of Undead essence the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel undeadLabel;

    /**
     * Total number of Diamond essence the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel diamondLabel;

    /**
     * Total number of Ice essence the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel iceLabel;

    /**
     * Total number of Gold essence the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel goldLabel;

    /**
     * Total number of Crimson essence the player owns
     * in the associated profile in Skyblock.
     */
    private JLabel crimsonLabel;

    /**
     * Constructor of the WindowSkyBlockStats class, initializing
     * all the statistics of a player in Skyblock mode through a
     * 'SkyblockProfilesContainer' class instance passed as a
     * parameter.
     * @param profile A SkyblockProfilesContainer instance
     *                containing all the necessary statistics
     *                of a player to display those in the interface.
     * @see SkyblockProfilesContainer
     * @see WindowSkill
     * @see WindowPets
     * @see WindowMining
     * @see WindowFishing
     * @see WindowDungeon
     * @see WindowSlayer
     * @see WindowCrimsonIsle
     * @see WindowBestiary
     * @see WindowSkyBlockStats#setSkillPanel(JPanel)
     * @see WindowSkyBlockStats#setPetsPanel(JPanel)
     * @see WindowSkyBlockStats#setMiningPanel(JPanel)
     * @see WindowSkyBlockStats#setFishingPanel(JPanel)
     * @see WindowSkyBlockStats#setDungeonPanel(JPanel)
     * @see WindowSkyBlockStats#setSlayerPanel(JPanel)
     * @see WindowSkyBlockStats#setCrimsonIslePanel(JPanel)
     * @see WindowSkyBlockStats#setBestiaryPanel(JPanel)
     */
    public WindowSkyBlockStats(SkyblockProfilesContainer profile) {
        cuteNameLabel.setText("Profile name : " + profile.getCuteName());
        levelLabel.setText("Level : " + profile.getLevel());
        firstJoinLabel.setText("Joined : " + profile.getFirstJoin());
        purseLabel.setText("Purse : " + profile.getPurse());
        purseBankLabel.setText("Bank Purse : " + profile.getPurseBank());
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

        witherLabel.setText("Wither : " + profile.getEssenceList().get("WITHER"));
        dragonLabel.setText("Dragon : " + profile.getEssenceList().get("DRAGON"));
        spiderLabel.setText("Spider : " + profile.getEssenceList().get("SPIDER"));
        undeadLabel.setText("Undead : " + profile.getEssenceList().get("UNDEAD"));
        diamondLabel.setText("Diamond : " + profile.getEssenceList().get("DIAMOND"));
        iceLabel.setText("Ice : " + profile.getEssenceList().get("ICE"));
        goldLabel.setText("Gold : " + profile.getEssenceList().get("GOLD"));
        crimsonLabel.setText("Crimson : " + profile.getEssenceList().get("CRIMSON"));
    }

    /**
     * Sets the Skill panel in the interface.
     * @param panel A JPanel Object.
     */
    public void setSkillPanel(JPanel panel) {
        skillPanel.setLayout(new BoxLayout(skillPanel, BoxLayout.Y_AXIS));
        skillPanel.removeAll();
        skillPanel.add(panel);
        skillPanel.revalidate();
        skillPanel.repaint();
    }

    /**
     * Sets the Pets panel in the interface.
     * @param panel A JPanel Object.
     */
    public void setPetsPanel(JPanel panel) {
        petsPanel.setLayout(new BoxLayout(petsPanel, BoxLayout.Y_AXIS));
        petsPanel.removeAll();
        petsPanel.add(panel);
        petsPanel.revalidate();
        petsPanel.repaint();
    }

    /**
     * Sets the Mining panel in the interface.
     * @param panel A JPanel Object.
     */
    public void setMiningPanel(JPanel panel) {
        miningPanel.setLayout(new BoxLayout(miningPanel, BoxLayout.Y_AXIS));
        miningPanel.removeAll();
        miningPanel.add(panel);
        miningPanel.revalidate();
        miningPanel.repaint();
    }

    /**
     * Sets the Fishing panel in the interface.
     * @param panel A JPanel Object.
     */
    public void setFishingPanel(JPanel panel) {
        fishingPanel.setLayout(new BoxLayout(fishingPanel, BoxLayout.Y_AXIS));
        fishingPanel.removeAll();
        fishingPanel.add(panel);
        fishingPanel.revalidate();
        fishingPanel.repaint();
    }

    /**
     * Sets the Dungeon panel in the interface.
     * @param panel A JPanel Object.
     */
    public void setDungeonPanel(JPanel panel) {
        dungeonPanel.setLayout(new BoxLayout(dungeonPanel, BoxLayout.Y_AXIS));
        dungeonPanel.removeAll();
        dungeonPanel.add(panel);
        dungeonPanel.revalidate();
        dungeonPanel.repaint();
    }

    /**
     * Sets the Slayer panel in the interface.
     * @param panel A JPanel Object.
     */
    public void setSlayerPanel(JPanel panel) {
        slayerPanel.setLayout(new BoxLayout(slayerPanel, BoxLayout.Y_AXIS));
        slayerPanel.removeAll();
        slayerPanel.add(panel);
        slayerPanel.revalidate();
        slayerPanel.repaint();
    }

    /**
     * Sets the Crimson Isle panel in the interface.
     * @param panel A JPanel Object.
     */
    public void setCrimsonIslePanel(JPanel panel) {
        crimsonIslePanel.setLayout(new BoxLayout(crimsonIslePanel, BoxLayout.Y_AXIS));
        crimsonIslePanel.removeAll();
        crimsonIslePanel.add(panel);
        crimsonIslePanel.revalidate();
        crimsonIslePanel.repaint();
    }

    /**
     * Sets the Bestiary panel in the interface.
     * @param panel A JPanel Object.
     */
    public void setBestiaryPanel(JPanel panel) {
        bestiaryPanel.setLayout(new BoxLayout(bestiaryPanel, BoxLayout.Y_AXIS));
        bestiaryPanel.removeAll();
        bestiaryPanel.add(panel);
        bestiaryPanel.revalidate();
        bestiaryPanel.repaint();
    }

    /**
     * Gets the main panel of the Skyblock mode.
     * @return A JPanel Object.
     */
    public JPanel getMainPanel(){return mainPanel;}
}
