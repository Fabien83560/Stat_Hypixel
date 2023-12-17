package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Crimson.Kuudra;
import javax.swing.*;

/**
 * This class sets all the interface of the Kuudra
 * statistics when Skyblock mode is selected. Used
 * in the WindowCrimsonIsle class along the Dojo
 * statistics.
 * @see Kuudra
 * @see WindowCrimsonIsle
 * @see org.Game.Skyblock.Stats.Crimson.Dojo
 */
public class WindowKuudra {

    /**
     * Main panel of the class.
     */
    private JPanel mainPanel;

    /**
     * Each tier name of the Kuudra statistics
     * (basic, hot, burning...)
     */
    private JLabel nameLabel;

    /**
     * Total kills done by the player in each
     * tier of the Kuudra mode.
     */
    private JLabel kuudraKillLabel;

    /**
     * The value of the highest wave done by
     * the player in each tier of the Kuudra mode.
     */
    private JLabel highestWaveLabel;

    /**
     * Constructor of the WindowKuudra class,
     * initializing each data member through a
     * Kuudra class instance passed as a
     * parameter.
     * @param kuudra A Kuudra class instance
     *               used to initialize every
     *               member of the class in the
     *               interface.
     * @see Kuudra
     */
    public WindowKuudra(Kuudra kuudra) {
        nameLabel.setText("Tier : " + kuudra.getName());
        kuudraKillLabel.setText("Kills : " + kuudra.getKuudraKill());
        highestWaveLabel.setText("Highest Wave : " + kuudra.getHighestWave());
    }

    /**
     * Gets the main panel of the class.
     * @return A JPanel Object.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
