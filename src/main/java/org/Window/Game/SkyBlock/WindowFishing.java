package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Fishing.Fishing;
import org.Game.Skyblock.Stats.Fishing.TrophyFish;
import javax.swing.*;
import java.awt.*;

/**
 * This class sets all the interface of the Fishing mode when Skyblock mode
 * is selected.
 */
public class WindowFishing {

    /**
     * Main panel of the Fishing mode in Skyblock.
     */
    private JPanel mainPanel;

    /**
     * Panel containing all the global information
     * of the player in Fishing mode in Skyblock.
     * Displayed above each Fishing statistics.
     */
    private JPanel globalPanel;

    /**
     * Title of the mode (Fishing).
     */
    private JLabel titleLabel;

    /**
     * Number of items fished by the player in Fishing mode in Skyblock.
     */
    private JLabel itemsFishedLabel;

    /**
     * Number of treasures fished by the player in Fishing mode in Skyblock.
     */
    private JLabel treasuresFishedLabel;

    /**
     * Number of large treasures fished by the player in Fishing mode in Skyblock.
     */
    private JLabel largeTreasuresFishedLabel;

    /**
     * Total number of trophies fished by the player in Fishing mode in Skyblock.
     */
    private JLabel totalTrophyFishedLabel;

    /**
     * Panel containing a specific number of WindowTrophyFish
     * class instances, each one containing specific statistics about a
     * Trophy Fish (name, bronze trophies, silver trophies...).
     */
    private JPanel trophyFishPanel;

    /**
     * Constructor of the WindowFishing class, initializing all
     * the data members through a Fishing instance passed as
     * parameter.
     * @param fishing A Fishing instance of the current player
     *                used to initialize his statistics in
     *                Fishing Mode.
     * @see Fishing
     * @see WindowTrophyFish
     */
    public WindowFishing(Fishing fishing) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        if(fishing != null) {
            itemsFishedLabel.setText("Items Fished : " + fishing.getItemsFished());
            treasuresFishedLabel.setText("Treasures Fished : " + fishing.getTreasuresFished());
            largeTreasuresFishedLabel.setText("Large Treasures Fished : " + fishing.getLargeTreasuresFished());
            totalTrophyFishedLabel.setText("Total TrophyFish Fished : " + fishing.getTotalTrophyFish());

            if(fishing.getTrophyFishList() != null)
                for(TrophyFish t : fishing.getTrophyFishList())
                    trophyFishPanel.add(new WindowTrophyFish(t).getMainPanel());
            else
                trophyFishPanel.add(new JLabel("This Player didn't fish any Trophy Fish !"));
        }
        else
        {
            itemsFishedLabel.setText("Items Fished : 0");
            treasuresFishedLabel.setText("Treasures Fished : 0");
            largeTreasuresFishedLabel.setText("Large Treasures Fished : 0");
            totalTrophyFishedLabel.setText("Total TrophyFish Fished : 0");
            trophyFishPanel.add(new JLabel("This Player didn't fish any Trophy Fish !"));
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
