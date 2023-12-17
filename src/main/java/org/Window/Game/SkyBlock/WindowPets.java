package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Pet;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class sets the interface that contains
 * all the player's pets. Used only once in the
 * WindowSkyBlockStats class.
 * @see Pet
 * @see WindowPet
 * @see WindowSkyBlockStats
 */
public class WindowPets {

    /**
     * Main panel of the WindowPets class.
     */
    private JPanel mainPanel;

    /**
     * Panel containing all the 'Pet' class instances,
     * which means, all the player's pets.
     */
    private JPanel petsListPanel;

    /**
     * Panel containing the title of the statistics.
     */
    private JPanel globalPanel;

    /**
     * Title of the statistics (Pets).
     */
    private JLabel titleLabel;

    /**
     * Scroll Panel that can scroll horizontally
     * to see all the player's pets that are in the
     * 'petsListPanel'.
     * @see WindowPets#petsListPanel
     */
    private JScrollPane scrollPane;

    /**
     * Constructor of the Pets class, displaying all
     * the player's pets through a List of 'Pet' class instance
     * passed as a parameter.
     * @param petList A List of 'Pet' class instances of the player
     *                used to display each of his pets' statistics.
     * @see Pet
     * @see WindowPet
     */
    public WindowPets(List<Pet> petList) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        if (petList != null) {
            for (Pet p : petList) {
                petsListPanel.add(new WindowPet(p).getMainPanel());
            }
        }
        else {
            petsListPanel.add(new JLabel("This Player didn't have any Pets !"));
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
