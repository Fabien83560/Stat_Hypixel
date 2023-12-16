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
        if(mining != null) {
            actualMithrilPowderLabel.setText("Actual Mithril Powder : " + mining.getActualMithrilPowder());
            spentMithrilPowderLabel.setText("Spent Mithril Powder : " + mining.getSpentMithrilPower());
            actualGemstonePowderLabel.setText("Actual Gemstone Powder : " + mining.getActualGemstonePowder());
            spentGemstonePowderLabel.setText("Spent Gemstone Powder : " + mining.getSpentGemstonePower());
        }
        else
        {
            actualMithrilPowderLabel.setText("Actual Mithril Powder : 0");
            spentMithrilPowderLabel.setText("Spent Mithril Powder : 0");
            actualGemstonePowderLabel.setText("Actual Gemstone Powder : 0");
            spentGemstonePowderLabel.setText("Spent Gemstone Powder : 0");
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
