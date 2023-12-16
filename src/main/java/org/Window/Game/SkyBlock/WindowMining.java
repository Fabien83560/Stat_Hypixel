package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Mining;

import javax.swing.*;
import java.awt.*;

public class WindowMining {
    private JPanel mainPanel;
    private JLabel miningLabel;
    private JLabel actualMithrilPowderLabel;
    private JLabel actualGemstonePowderLabel;
    private JLabel spentMithrilPowderLabel;
    private JLabel spentGemstonePowderLabel;

    public WindowMining(Mining mining) {
        miningLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        actualMithrilPowderLabel.setText("Actual Mithril Powder : " + mining.getActualMithrilPowder());
        spentMithrilPowderLabel.setText("Spent Mithril Powder : " + mining.getSpentMithrilPower());
        actualGemstonePowderLabel.setText("Actual Gemstone Powder : " + mining.getActualGemstonePowder());
        spentGemstonePowderLabel.setText("Spent Gemstone Powder : " + mining.getSpentGemstonePower());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
