package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Fishing.TrophyFish;

import javax.swing.*;

public class WindowTrophyFish {
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel bronzeLabel;
    private JLabel silverLabel;
    private JLabel goldLabel;
    private JLabel diamondLabel;

    public WindowTrophyFish(TrophyFish trophyFish) {
        nameLabel.setText(trophyFish.getName());
        bronzeLabel.setText("Bronze : " + trophyFish.getBronze());
        silverLabel.setText("Silver : " + trophyFish.getSilver());
        goldLabel.setText("Gold : " + trophyFish.getGold());
        diamondLabel.setText("Diamond : " + trophyFish.getDiamond());
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
