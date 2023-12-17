package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Crimson.Crimson;
import org.Game.Skyblock.Stats.Crimson.Dojo;
import org.Game.Skyblock.Stats.Crimson.Kuudra;
import javax.swing.*;
import java.awt.*;

/**
 * This class sets all the interface of the entire Crimson
 * Isle mode when Skyblock mode is selected. It contains
 * the Crimson, Kuudra and Dojo modes.
 */
public class WindowCrimsonIsle {

    /**
     * Main panel of the Crimson Isle mode in Skyblock.
     */
    private JPanel mainPanel;

    /**
     * Value of the selected faction of the player in Crimson Isle mode.
     */
    private JLabel selectedFactionLabel;

    /**
     * Value of the mage reputation of the player in Crimson Isle mode.
     */
    private JLabel mageReputationLabel;

    /**
     * Value of the barbarian reputation of the player in Crimson Isle mode.
     */
    private JLabel barbarianReputationLabel;

    /**
     * Panel used to display the Kuudra statistics of the player in Skyblock mode.
     */
    private JPanel kuudraPanel;

    /**
     * Panel used to display the Dojo statistics of the player in Skyblock mode.
     */
    private JPanel dojoPanel;

    /**
     * Title of the Kuudra game mode.
     */
    private JLabel titleKuudra;

    /**
     * Title of the Dojo game mode.
     */
    private JLabel titleDojo;

    /**
     * Title of the Crimson Isle mode.
     */
    private JLabel titleCrimsonLabel;

    /**
     * Constructor of the WindowCrimsonIsle class
     * displaying the statistics of the player in the
     * interface, in Crimson Isle mode. It adds multiple
     * statistics in the respective panels, depending on
     * the statistics a player has.
     * @param crimson A Crimson Object
     * @see Crimson
     * @see WindowKuudra
     * @see WindowDojo
     */
    public WindowCrimsonIsle(Crimson crimson) {
        titleCrimsonLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        titleKuudra.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        titleDojo.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        if(crimson != null) {
            selectedFactionLabel.setText("Selected faction : " + crimson.getSelectedFaction());
            mageReputationLabel.setText("Mage Reputation : " + crimson.getMageReputation());
            barbarianReputationLabel.setText("Barbarian Reputation : " + crimson.getBarbarianReputation());
            if( !(crimson.getKuudraList().isEmpty()))
                for(Kuudra k : crimson.getKuudraList())
                    kuudraPanel.add(new WindowKuudra(k).getMainPanel());
            else
                kuudraPanel.add(new JLabel("This Player didn't do any Kuudra !"));

            if( !(crimson.getDojoList().isEmpty()))
                for(Dojo d : crimson.getDojoList())
                    dojoPanel.add(new WindowDojo(d).getMainPanel());
            else
                dojoPanel.add(new JLabel("This Player didn't do any Dojo !"));
        }
        else
        {
            selectedFactionLabel.setText("Selected faction : 0");
            mageReputationLabel.setText("Mage Reputation : 0");
            barbarianReputationLabel.setText("Barbarian Reputation : 0");
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
