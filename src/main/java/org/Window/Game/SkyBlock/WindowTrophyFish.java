package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Fishing.TrophyFish;
import javax.swing.*;

/**
 * This class sets in the interface all the statistics
 * associated to a specific Trophy Fish of a player.
 * It is only used once in the WindowFishing class, the
 * latter displaying all the Trophies the player owns, and
 * their statistics. WindowFishing is simply displaying
 * an instance of this class several times in its panel.
 * @see WindowFishing
 */
public class WindowTrophyFish {

    /**
     * The main panel of the WindowTrophyFish interface.
     */
    private JPanel mainPanel;

    /**
     * The name of the current Trophy Fish of the player.
     */
    private JLabel nameLabel;

    /**
     * Number of bronze current Trophy Fish the players owns in Fishing Mode.
     */
    private JLabel bronzeLabel;

    /**
     * Number of silver current Trophy Fish the players owns in Fishing Mode.
     */
    private JLabel silverLabel;

    /**
     * Number of gold current Trophy Fish the players owns in Fishing Mode.
     */
    private JLabel goldLabel;

    /**
     * Number of diamond current Trophy Fish the players owns in Fishing Mode.
     */
    private JLabel diamondLabel;

    /**
     * Constructor of the WindowTrophyFish class, initializing
     * the data members to display those in the interface through
     * a 'TrophyFish' class instance passed as a parameter.
     * @param trophyFish A TrophyFish instance used to get the
     *                   statistics of the current trophy, and display
     *                   those accordingly.
     * @see TrophyFish
     */
    public WindowTrophyFish(TrophyFish trophyFish) {
        nameLabel.setText(trophyFish.getName());
        bronzeLabel.setText("Bronze : " + trophyFish.getBronze());
        silverLabel.setText("Silver : " + trophyFish.getSilver());
        goldLabel.setText("Gold : " + trophyFish.getGold());
        diamondLabel.setText("Diamond : " + trophyFish.getDiamond());
    }

    /**
     * Gets the main panel of the class.
     * @return A JPanel Object.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
