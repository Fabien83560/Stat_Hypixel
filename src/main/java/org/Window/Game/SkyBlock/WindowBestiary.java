package org.Window.Game.SkyBlock;

import javax.swing.*;
import java.awt.*;

/**
 * This class sets all the interface of the Bestiary mode when Skyblock mode
 * is selected.
 */
public class WindowBestiary {

    /**
     * Main panel of the interface.
     */
    private JPanel mainPanel;

    /**
     * Title of the mode (Bestiary).
     */
    private JLabel titleLabel;

    /**
     * Milestone value displayed in the interface.
     */
    private JLabel milestoneLabel;

    /**
     * Milestone Unlocked tiers value displayed in the interface.
     */
    private JLabel milestoneUnlockTiersLabel;

    /**
     * Constructor of the interface for the Bestiary mode in Skyblock mode.
     * @param milestone The value of the milestone of the player in Skyblock.
     * @param milestoneUnlockTiers The value of the milestone unlocked tiers
     *                             of the player in Skyblock.
     */
    public WindowBestiary(String milestone, String milestoneUnlockTiers) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        milestoneLabel.setText("Milestone : " + milestone);
        milestoneUnlockTiersLabel.setText("Milestone Unlock Tiers : " + milestoneUnlockTiers);
    }

    /**
     * Gets the main panel of the Bestiary mode interface.
     * @return A JPanel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
