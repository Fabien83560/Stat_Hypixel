package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Pet;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WindowPets {
    private JPanel mainPanel;
    private JPanel petsListPanel;
    private JPanel globalPanel;
    private JLabel titleLabel;
    private JScrollPane scrollPane;

    public WindowPets(List<Pet> petList) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        if (!(petList.isEmpty())) {
            for (Pet p : petList) {
                petsListPanel.add(new WindowPet(p).getMainPanel());
            }
        }
        else {
            petsListPanel.add(new JLabel("This Player didn't have any Pets !"));
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
