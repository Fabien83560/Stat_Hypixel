package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Slayer;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * This class sets all the interface of the Slayer
 * mode when Skyblock mode is selected. Used only once
 * in the WindowSkyBlockStats class.
 * @see WindowSkyBlockStats
 */
public class WindowSlayer {

    /**
     * The main panel of the WindowSlayer class.
     */
    private JPanel mainPanel;

    /**
     * Total player's experience in Slayer mode in Skyblock.
     */
    private JLabel totalXpSlayerLabel;

    /**
     * Total experience of the player in the Zombie slayer mode.
     */
    private JLabel zombieExpLabel;

    /**
     * Total experience of the player in the Spider slayer mode.
     */
    private JLabel spiderExpLabel;

    /**
     * Total experience of the player in the Wolf slayer mode.
     */
    private JLabel wolfExpLabel;

    /**
     * Total experience of the player in the Enderman slayer mode.
     */
    private JLabel endermanExpLabel;

    /**
     * Total experience of the player in the Blaze slayer mode.
     */
    private JLabel blazeExpLabel;

    /**
     * Total experience of the player in the Vampire slayer mode.
     */
    private JLabel vampireExpLabel;

    /**
     * Number of Zombie bosses killed by the player in tier 1.
     */
    private JLabel tier1ZombieLabel;

    /**
     * Number of Zombie bosses killed by the player in tier 2.
     */
    private JLabel tier2ZombieLabel;

    /**
     * Number of Zombie bosses killed by the player in tier 3.
     */
    private JLabel tier3ZombieLabel;

    /**
     * Number of Zombie bosses killed by the player in tier 4.
     */
    private JLabel tier4ZombieLabel;

    /**
     * Number of Zombie bosses killed by the player in tier 5.
     */
    private JLabel tier5ZombieLabel;

    /**
     * Number of Spider bosses killed by the player in tier 1.
     */
    private JLabel tier1SpiderLabel;

    /**
     * Number of Spider bosses killed by the player in tier 2.
     */
    private JLabel tier2SpiderLabel;

    /**
     * Number of Spider bosses killed by the player in tier 3.
     */
    private JLabel tier3SpiderLabel;

    /**
     * Number of Spider bosses killed by the player in tier 4.
     */
    private JLabel tier4SpiderLabel;

    /**
     * Number of Spider bosses killed by the player in tier 5.
     */
    private JLabel tier5SpiderLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 1.
     */
    private JLabel tier1WolfLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 2.
     */
    private JLabel tier2WolfLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 3.
     */
    private JLabel tier3WolfLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 4.
     */
    private JLabel tier4WolfLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 5.
     */
    private JLabel tier5WolfLabel;

    /**
     * Number of Enderman bosses killed by the player in tier 1.
     */
    private JLabel tier1EndermanLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 2.
     */
    private JLabel tier2EndermanLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 3.
     */
    private JLabel tier3EndermanLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 4.
     */
    private JLabel tier4EndermanLabel;

    /**
     * Number of Wolf bosses killed by the player in tier 5.
     */
    private JLabel tier5EndermanLabel;

    /**
     * Number of Blaze bosses killed by the player in tier 1.
     */
    private JLabel tier1BlazeLabel;

    /**
     * Number of Blaze bosses killed by the player in tier 2.
     */
    private JLabel tier2BlazeLabel;

    /**
     * Number of Blaze bosses killed by the player in tier 3.
     */
    private JLabel tier3BlazeLabel;

    /**
     * Number of Blaze bosses killed by the player in tier 4.
     */
    private JLabel tier4BlazeLabel;

    /**
     * Number of Blaze bosses killed by the player in tier 5.
     */
    private JLabel tier5BlazeLabel;

    /**
     * Number of Vampire bosses killed by the player in tier 1.
     */
    private JLabel tier1VampireLabel;

    /**
     * Number of Vampire bosses killed by the player in tier 2.
     */
    private JLabel tier2VampireLabel;

    /**
     * Number of Vampire bosses killed by the player in tier 3.
     */
    private JLabel tier3VampireLabel;

    /**
     * Number of Vampire bosses killed by the player in tier 4.
     */
    private JLabel tier4VampireLabel;

    /**
     * Number of Vampire bosses killed by the player in tier 5.
     */
    private JLabel tier5VampireLabel;

    /**
     * Label containing the 'Slayer' title.
     */
    private JLabel titleLabel;

    /**
     * Constructor of the WindowSlayer class, displaying all
     * the statistics of a player in Slayer mode in the interface.
     * It uses two parameters, the first one being a Map of
     * 'String, Slayer' containing the name of the enemy, the value
     * being a Slayer instance containing all the experience and tiers
     * of each enemy in the Map. The second parameter is the total experience
     * the player earned in Slayer mode.
     * @param slayers A Map of 'String, Slayer' used to display the data of the
     *                Slayer mode of a player.
     * @param xp A String containing the total of experience of a player in
     *           Slayer mode.
     */
    public WindowSlayer(Map<String,Slayer> slayers, String xp) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        totalXpSlayerLabel.setText("Total Slayer Exp : " + xp);
        Slayer s = slayers.get("zombie");
        zombieExpLabel.setText("Exp : " + s.getExp());
        tier1ZombieLabel.setText("Tier 1 : " + s.getTier1());
        tier2ZombieLabel.setText("Tier 2 : " + s.getTier2());
        tier3ZombieLabel.setText("Tier 3 : " + s.getTier3());
        tier4ZombieLabel.setText("Tier 4 : " + s.getTier4());
        tier5ZombieLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("spider");
        spiderExpLabel.setText("Exp : " + s.getExp());
        tier1SpiderLabel.setText("Tier 1 : " + s.getTier1());
        tier2SpiderLabel.setText("Tier 2 : " + s.getTier2());
        tier3SpiderLabel.setText("Tier 3 : " + s.getTier3());
        tier4SpiderLabel.setText("Tier 4 : " + s.getTier4());
        tier5SpiderLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("wolf");
        wolfExpLabel.setText("Exp : " + s.getExp());
        tier1WolfLabel.setText("Tier 1 : " + s.getTier1());
        tier2WolfLabel.setText("Tier 2 : " + s.getTier2());
        tier3WolfLabel.setText("Tier 3 : " + s.getTier3());
        tier4WolfLabel.setText("Tier 4 : " + s.getTier4());
        tier5WolfLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("enderman");
        endermanExpLabel.setText("Exp : " + s.getExp());
        tier1EndermanLabel.setText("Tier 1 : " + s.getTier1());
        tier2EndermanLabel.setText("Tier 2 : " + s.getTier2());
        tier3EndermanLabel.setText("Tier 3 : " + s.getTier3());
        tier4EndermanLabel.setText("Tier 4 : " + s.getTier4());
        tier5EndermanLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("blaze");
        blazeExpLabel.setText("Exp : " + s.getExp());
        tier1BlazeLabel.setText("Tier 1 : " + s.getTier1());
        tier2BlazeLabel.setText("Tier 2 : " + s.getTier2());
        tier3BlazeLabel.setText("Tier 3 : " + s.getTier3());
        tier4BlazeLabel.setText("Tier 4 : " + s.getTier4());
        tier5BlazeLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("vampire");
        vampireExpLabel.setText("Exp : " + s.getExp());
        tier1VampireLabel.setText("Tier 1 : " + s.getTier1());
        tier2VampireLabel.setText("Tier 2 : " + s.getTier2());
        tier3VampireLabel.setText("Tier 3 : " + s.getTier3());
        tier4VampireLabel.setText("Tier 4 : " + s.getTier4());
        tier5VampireLabel.setText("Tier 5 : " + s.getTier5());
    }

    /**
     * Gets the main panel of the class.
     * @return A JPanel Object.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
