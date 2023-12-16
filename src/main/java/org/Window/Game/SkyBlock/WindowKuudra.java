package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Crimson.Kuudra;

import javax.swing.*;

public class WindowKuudra {
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel kuudraKillLabel;
    private JLabel highestWaveLabel;

    public WindowKuudra(Kuudra kuudra) {
        nameLabel.setText("Tier : " + kuudra.getName());
        kuudraKillLabel.setText("Kills : " + kuudra.getKuudraKill());
        highestWaveLabel.setText("Highest Wave : " + kuudra.getHighestWave());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
