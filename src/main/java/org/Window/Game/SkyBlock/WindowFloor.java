package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Dungeon.Floor;
import javax.swing.*;

/**
 * This class sets all the interface of the different floors
 * of a Dungeon when Skyblock mode is selected, from the
 * Floor 0 of the Catacombs to the Floor 7 of the Master
 * Catacombs. If the player didn't play any Dungeons, shows
 * a message in the dungeonPanel JPanel of the WindowDungeon
 * class.
 * @see WindowDungeon
 */
public class WindowFloor {

    /**
     * Main panel of the WindowFloor class.
     */
    private JPanel mainPanel;

    /**
     * Name of each floor of a Dungeon (Floor_0, Floor_1...)
     */
    private JLabel nameLabel;

    /**
     * Name of each floor's mode (Catacombs or Master Catacombs).
     */
    private JLabel modeLabel;

    /**
     * Time played in each floor of the Dungeon.
     */
    private JLabel timePlayedLabel;

    /**
     * Number of tiers that have been completed by the player in each floor.
     */
    private JLabel tierCompletionsLabel;

    /**
     * The fastest time the player did to complete a floor.
     */
    private JLabel fastedTimeLabel;

    /**
     * The best score of the player in each floor.
     */
    private JLabel bestScoreLabel;

    /**
     * Total number of mobs killed by the player in each floor.
     */
    private JLabel mobKillLabel;

    /**
     * Total value of HP healed by the player in each floor.
     */
    private JLabel mostHealingLabel;

    /**
     * Fastest time to complete S run in each floor.
     */
    private JLabel fastedSLabel;

    /**
     * Fastest time to complete SPlus run in each floor.
     */
    private JLabel fastedSPlusLabel;

    /**
     * Constructor of the WindowFloor class, initializing
     * each data member through a Floor class instance
     * passed as a parameter.
     * @param floor A Floor instance of the current player
     *              used to initialize each of his floors
     *              statistics in a dungeon.
     * @see Floor
     * @see WindowDungeon
     * @see org.Game.Skyblock.Stats.Dungeon.Dungeon
     */
    public WindowFloor(Floor floor) {
        nameLabel.setText(floor.getName());
        modeLabel.setText(floor.getMode());
        timePlayedLabel.setText("Time Played : " + floor.getTimePlayed());
        tierCompletionsLabel.setText("Tier Completions : " + floor.getTierCompletions());
        fastedTimeLabel.setText("Fastest Time : " + floor.getFastedTime());
        bestScoreLabel.setText("Best Score : " + floor.getBestScore());
        mobKillLabel.setText("Mobs Kills : " + floor.getMobKill());
        mostHealingLabel.setText("Most Healing : " + floor.getMostHealing());
        fastedSLabel.setText("Fastest S Run : " + floor.getFastedS());
        fastedSPlusLabel.setText("Fastest S+ Run : " + floor.getFastedSPlus());
    }

    /**
     * Gets the main panel of the class.
     * @return A JPanel Object.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
