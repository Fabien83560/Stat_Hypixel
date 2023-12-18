package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Pet;
import javax.swing.*;
import java.awt.*;

/**
 * This class sets all the interface of a player's pet
 * when Skyblock mode is selected. Used only once
 * in the WindowPets class that contains all the
 * pets of the player (multiple instances of this class).
 * @see WindowPets
 */
public class WindowPet {

    /**
     * Main panel of the WindowPet class.
     */
    private JPanel mainPanel;

    /**
     * Type of pet (Pig, Horse...)
     */
    private JLabel typeLabel;

    /**
     * Experience value of that said pet.
     */
    private JLabel expLabel;

    /**
     * Rarity of the pet (Legendary, Epic...)
     */
    private JLabel tierLabel;

    /**
     * Number of candies used on that pet.
     */
    private JLabel candyUsedLabel;

    /**
     * Constructor of the Pet class, initializing
     * each data member through a Pet class instance
     * passed as a parameter.
     * @param pet A Pet instance of the current player
     *            used to initialize each of his pet
     *            statistics.
     * @see Pet
     * @see WindowPets
     */
    public WindowPet(Pet pet) {
        typeLabel.setText(pet.getType());
        expLabel.setText("Exp : " + pet.getExp());
        tierLabel.setText(pet.getTier());
        candyUsedLabel.setText("Candy Used : " + pet.getCandyUsed());

        final String tier = pet.getTier();
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
        }
    }

    /**
     * Gets the main panel of the class
     * @return A JPanel Object.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
