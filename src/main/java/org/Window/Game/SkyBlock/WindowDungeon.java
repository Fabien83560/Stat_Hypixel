package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Dungeon.Dungeon;
import org.Game.Skyblock.Stats.Dungeon.Floor;

import javax.swing.*;
import java.awt.*;

public class WindowDungeon {
    private JPanel mainPanel;
    private JPanel dungeonPanel;
    private JPanel globalPanel;
    private JLabel titleLabel;
    private JLabel mageLabel;
    private JLabel archerLabel;
    private JLabel tankLabel;
    private JLabel berserkLabel;
    private JLabel healerLabel;
    private JLabel catacombLabel;

    public WindowDungeon(Dungeon dungeon) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        if(dungeon != null) {
            catacombLabel.setText("Catacomb Level : " + dungeon.getCatacomb());
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

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
