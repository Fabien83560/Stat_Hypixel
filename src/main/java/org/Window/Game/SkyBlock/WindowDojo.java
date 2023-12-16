package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Crimson.Dojo;

import javax.swing.*;

public class WindowDojo {
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel pointsLabel;
    private JLabel rankLabel;
    private JLabel timeLabel;

    public WindowDojo(Dojo dojo) {
        nameLabel.setText(dojo.getName());
        pointsLabel.setText("Points : " + dojo.getPoints());
        rankLabel.setText("Rank : " + dojo.getRank());
        timeLabel.setText("Time : " + dojo.getTime() + " sec");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
