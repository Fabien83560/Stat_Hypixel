package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Pet;

import javax.swing.*;
import java.awt.*;

public class WindowPet {
    private JPanel mainPanel;
    private JLabel typeLabel;
    private JLabel expLabel;
    private JLabel tierLabel;
    private JLabel candyUsedLabel;

    public WindowPet(Pet pet) {
        typeLabel.setText(pet.getType());
        expLabel.setText("Exp : " + pet.getExp());
        tierLabel.setText(pet.getTier());
        candyUsedLabel.setText("Candy Used : " + pet.getCandyUsed());

        String tier = pet.getTier();
        switch (tier) {
            case "COMMON":
                mainPanel.setBackground(Color.decode("#FFFFFF")); // White
                break;
            case "UNCOMMON":
                mainPanel.setBackground(Color.decode("#8FDB8F")); // Light Green
                break;
            case "RARE":
                mainPanel.setBackground(Color.decode("#0000FF")); // Dark Blue
                break;
            case "EPIC":
                mainPanel.setBackground(Color.decode("#800080")); // Purple
                break;
            case "LEGENDARY":
                mainPanel.setBackground(Color.decode("#FFA500")); // Orange
                break;
            case "MYTHIC":
                mainPanel.setBackground(Color.decode("#FF69B4")); // Pink
                break;
        };
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
