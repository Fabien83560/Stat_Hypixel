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
        catacombLabel.setText("Catacomb Level : " + dungeon.getCatacomb());
        mageLabel.setText("Mage Exp : " + dungeon.getMage());
        archerLabel.setText("Archer Exp : " + dungeon.getArcher());
        tankLabel.setText("Tank Exp : " + dungeon.getTank());
        berserkLabel.setText("Berserk Exp : " + dungeon.getBerserk());
        healerLabel.setText("Healer Exp : " + dungeon.getHealer());

        if( !(dungeon.getFloorList().isEmpty()))
            for(Floor f : dungeon.getFloorList())
                dungeonPanel.add(new WindowFloor(f).getMainPanel());
        else
            dungeonPanel.add(new JLabel("This player didn't do any Dungeon"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
