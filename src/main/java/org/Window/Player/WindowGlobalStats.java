package org.Window.Player;

import org.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Map;

public class WindowGlobalStats {
    private JPanel mainPanel;
    private JLabel skinLabel;
    private JPanel JPanelSkin;

    public WindowGlobalStats() {

    }
    public WindowGlobalStats(Player player) {
        if(mainPanel.getComponentCount() != 0){
            mainPanel.removeAll();
        }
        Map<String, String> globalStats = player.getAllStatistics();
        Box vbox = Box.createVerticalBox();
        try{
            for(Map.Entry<String, String> stat : globalStats.entrySet()){
                if(!stat.getKey().equals("skin")) {
                    JLabel lab = new JLabel(stat.getKey() + ": " + stat.getValue());
                    lab.setFont(new Font("Calibri", Font.PLAIN, 24));
                    vbox.add(lab);
                }
            }
            mainPanel.add(vbox);
            URL skinUrl = new URL(globalStats.get("skin"));
            ImageIcon skinIcon = new ImageIcon(skinUrl);
            skinLabel.setIcon(skinIcon);
            JPanelSkin = new JPanel(new BorderLayout());
            JPanelSkin.add(skinLabel);
            mainPanel.add(JPanelSkin);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,
                    "Error displaying the global Statistics of the player.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Can't display the global statistics of the researched player:\n");
            e.printStackTrace();
        }
    }
    public JPanel getMainPanel(){return mainPanel;}
}
