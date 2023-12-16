package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Fishing.Fishing;
import org.Game.Skyblock.Stats.Fishing.TrophyFish;

import javax.swing.*;
import java.awt.*;

public class WindowFishing {
    private JPanel mainPanel;
    private JPanel globalPanel;
    private JLabel titleLabel;
    private JLabel itemsFishedLabel;
    private JLabel treasuresFishedLabel;
    private JLabel largeTreasuresFishedLabel;
    private JLabel totalTrophyFishedLabel;
    private JPanel trophyFishPanel;

    public WindowFishing(Fishing fishing) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        itemsFishedLabel.setText("Items Fished : " + fishing.getItemsFished());
        treasuresFishedLabel.setText("Treasures Fished : " + fishing.getTreasuresFished());
        largeTreasuresFishedLabel.setText("Large Treasures Fished : " + fishing.getLargeTreasuresFished());
        totalTrophyFishedLabel.setText("Total TrophyFish Fished : " + fishing.getTotalTrophyFish());

        if( !(fishing.getTrophyFishList().isEmpty()))
            for(TrophyFish t : fishing.getTrophyFishList())
                trophyFishPanel.add(new WindowTrophyFish(t).getMainPanel());
        else
            trophyFishPanel.add(new JLabel("This Player didn't fish any Trophy Fish !"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
