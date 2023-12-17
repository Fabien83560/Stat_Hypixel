package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Dungeon.Dungeon;
import org.Game.Skyblock.Stats.Dungeon.Floor;
import javax.swing.*;
import java.awt.*;

/**
 * This class sets all the interface of the Dungeon mode when Skyblock mode
 * is selected.
 */
public class WindowDungeon {

    /**
     * Main panel of the Dungeon mode in Skyblock.
     */
    private JPanel mainPanel;

    /**
     * Panel containing the statistics of each player's Dungeon
     * in Skyblock.
     */
    private JPanel dungeonPanel;

    /**
     * Panel containing all the global information
     * of the player in Dungeon mode in Skyblock.
     * Displayed above each dungeon statistics.
     */
    private JPanel globalPanel;

    /**
     * Title of the mode (Dungeon).
     */
    private JLabel titleLabel;

    /**
     * Value of the Mage experience of a player in Dungeon mode.
     */
    private JLabel mageLabel;

    /**
     * Value of the Archer experience of a player in Dungeon mode.
     */
    private JLabel archerLabel;

    /**
     * Value of the Tank experience of a player in Dungeon mode.
     */
    private JLabel tankLabel;

    /**
     * Value of the Berserk experience of a player in Dungeon mode.
     */
    private JLabel berserkLabel;

    /**
     * Value of the Healer experience of a player in Dungeon mode.
     */
    private JLabel healerLabel;

    /**
     * Value of the Catacomb level of a player in Dungeon mode.
     */
    private JLabel catacombLabel;

    /**
     * Constructor of the WindowDungeon class,
     * initializing all the data members in the
     * interface thanks to the Dungeon Object passed
     * as parameter.
     * @param dungeon A Dungeon Object.
     * @see Dungeon
     * @see WindowFloor
     */
    public WindowDungeon(Dungeon dungeon) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        if(dungeon != null) {
            catacombLabel.setText("Catacomb Exp : " + dungeon.getCatacomb());
            mageLabel.setText("Mage Exp : " + dungeon.getMage());
            archerLabel.setText("Archer Exp : " + dungeon.getArcher());
            tankLabel.setText("Tank Exp : " + dungeon.getTank());
            berserkLabel.setText("Berserk Exp : " + dungeon.getBerserk());
            healerLabel.setText("Healer Exp : " + dungeon.getHealer());

            if (dungeon.getFloorList() != null)
                for (Floor f : dungeon.getFloorList())
                    dungeonPanel.add(new WindowFloor(f).getMainPanel());
            else
                dungeonPanel.add(new JLabel("This player didn't do any Dungeon"));
        }
        else
        {
            catacombLabel.setText("Catacomb Level : 0");
            mageLabel.setText("Mage Exp : 0");
            archerLabel.setText("Archer Exp : 0");
            tankLabel.setText("Tank Exp : 0");
            berserkLabel.setText("Berserk Exp : 0");
            healerLabel.setText("Healer Exp : 0");
            dungeonPanel.add(new JLabel("This player didn't do any Dungeon"));
        }
    }

    /**
     * Gets the main panel of the Dungeon interface.
     * @return A JPanel Object.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
