package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Mining;
import javax.swing.*;
import java.awt.*;

/**
 * This class sets all the interface of the Mining
 * mode when Skyblock mode is selected. Used only once
 * in the WindowSkyBlockStats class.
 * @see WindowSkyBlockStats
 */
public class WindowMining {

    /**
     * Main panel of the WindowMining class.
     */
    private JPanel mainPanel;

    /**
     * Name of the mode (Mining).
     */
    private JLabel miningLabel;

    /**
     * Number of current Mithril Powder the player owns in
     * Mining mode in Skyblock mode.
     */
    private JLabel actualMithrilPowderLabel;

    /**
     * Number of current Gemstone Powder the player owns in
     * Mining mode in Skyblock mode.
     */
    private JLabel actualGemstonePowderLabel;

    /**
     * Number of Mithril Powder spent by the player in
     * Mining mode in Skyblock mode.
     */
    private JLabel spentMithrilPowderLabel;

    /**
     * Number of Gemstone Powder spent by the player in
     * Mining mode in Skyblock mode.
     */
    private JLabel spentGemstonePowderLabel;

    /**
     * Constructor of the WindowMining class, initializing
     * each data member through a Mining class instance
     * passed as a parameter.
     * @param mining A Mining instance of the current player
     *              used to initialize each of his statistics
     *               in Mining mode.
     * @see Mining
     */
    public WindowMining(Mining mining) {
        miningLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        if(mining != null) {
            actualMithrilPowderLabel.setText("Actual Mithril Powder : " + mining.getActualMithrilPowder());
            spentMithrilPowderLabel.setText("Spent Mithril Powder : " + mining.getSpentMithrilPower());
            actualGemstonePowderLabel.setText("Actual Gemstone Powder : " + mining.getActualGemstonePowder());
            spentGemstonePowderLabel.setText("Spent Gemstone Powder : " + mining.getSpentGemstonePower());
        }
        else {
            actualMithrilPowderLabel.setText("Actual Mithril Powder : 0");
            spentMithrilPowderLabel.setText("Spent Mithril Powder : 0");
            actualGemstonePowderLabel.setText("Actual Gemstone Powder : 0");
            spentGemstonePowderLabel.setText("Spent Gemstone Powder : 0");
        }
    }

    /**
     * Gets the main panel of the class.
     * @return A JPanel Object.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
