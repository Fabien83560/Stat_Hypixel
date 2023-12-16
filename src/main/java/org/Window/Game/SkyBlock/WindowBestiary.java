package org.Window.Game.SkyBlock;

import javax.swing.*;
import java.awt.*;

public class WindowBestiary {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel milestoneLabel;
    private JLabel milestoneUnlockTiersLabel;

    public WindowBestiary(String milestone, String milestoneUnlockTiers) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        milestoneLabel.setText("Milestone : " + milestone);
        milestoneUnlockTiersLabel.setText("Milestone Unlock Tiers : " + milestoneUnlockTiers);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
