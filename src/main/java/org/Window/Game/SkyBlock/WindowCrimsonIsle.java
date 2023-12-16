package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Crimson.Crimson;
import org.Game.Skyblock.Stats.Crimson.Dojo;
import org.Game.Skyblock.Stats.Crimson.Kuudra;

import javax.swing.*;
import java.awt.*;

public class WindowCrimsonIsle {
    private JPanel mainPanel;
    private JLabel selectedFactionLabel;
    private JLabel mageReputationLabel;
    private JLabel barbarianReputationLabel;
    private JPanel kuudraPanel;
    private JPanel dojoPanel;
    private JLabel titleKuudra;
    private JLabel titleDojo;
    private JLabel titleCrimsonLabel;

    public WindowCrimsonIsle(Crimson crimson) {
        titleCrimsonLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        titleKuudra.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        titleDojo.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        if(crimson != null) {
            selectedFactionLabel.setText("Selected faction : " + crimson.getSelectedFaction());
            mageReputationLabel.setText("Mage Réputation : " + crimson.getMageReputation());
            barbarianReputationLabel.setText("Barbarian Réputation : " + crimson.getBarbarianReputation());
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
            mageReputationLabel.setText("Mage Réputation : 0");
            barbarianReputationLabel.setText("Barbarian Réputation : 0");
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
