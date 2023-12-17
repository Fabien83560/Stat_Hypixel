package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Crimson.Dojo;
import javax.swing.*;

/**
 * This class sets all the interface of the Dojo mode when Skyblock mode
 * is selected.
 */
public class WindowDojo {

    /**
     * Main panel of the Dojo mode in Skyblock.
     */
    private JPanel mainPanel;

    /**
     * Name of each player's Dojo.
     */
    private JLabel nameLabel;

    /**
     * Points value of each player's Dojo.
     */
    private JLabel pointsLabel;

    /**
     * Rank value of each player's Dojo.
     */
    private JLabel rankLabel;

    /**
     * Time spent by the player in each of his Dojos.
     */
    private JLabel timeLabel;

    /**
     * Constructor of the WindowDojo class displaying,
     * in the dojoPanel of the WindowCrimsonIsle class,
     * multiple other panels, each one containing an
     * instance of this class. This class displays
     * the main statistics of a player in a Dojo passed
     * as a parameter.
     * @param dojo A Dojo Object to display the statistics
     *             of.
     * @see Dojo
     * @see WindowCrimsonIsle
     * @see WindowCrimsonIsle#dojoPanel
     */
    public WindowDojo(Dojo dojo) {
        nameLabel.setText(dojo.getName());
        pointsLabel.setText("Points : " + dojo.getPoints());
        rankLabel.setText("Rank : " + dojo.getRank());
        timeLabel.setText("Time : " + dojo.getTime() + " sec");
    }

    /**
     * Gets the main panel of the class.
     * @return A JPanel.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
