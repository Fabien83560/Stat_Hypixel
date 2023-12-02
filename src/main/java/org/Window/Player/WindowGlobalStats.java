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
                JLabel lab = new JLabel();
                if(!stat.getKey().equals("skin")) {
                    switch(stat.getKey()){
                        case "lastLogin":
                            lab.setText("Last Login: " + stat.getValue());
                            break;
                        case "firstLogin":
                            lab.setText("First Login: " + stat.getValue());
                            break;
                        case "displayname":
                            lab.setText("Name: " + stat.getValue());
                            break;
                        case "newPackageRank":
                            lab.setText("Rank: " + stat.getValue());
                            break;
                        case "hypixelLevel":
                            lab.setText("Hypixel Level: " + stat.getValue());
                            break;
                        case "uuid":
                            lab.setText("Id: " + stat.getValue());
                            break;
                        case "guildName":
                            lab.setText("Guild Name: " + stat.getValue());
                            break;
                        default:
                            break;
                    }
                    lab.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
                    vbox.add(lab);
                }
            }
            URL skinUrl = new URL(globalStats.get("skin"));
            ImageIcon skinIcon = new ImageIcon(skinUrl);
            skinLabel.setIcon(skinIcon);
            JPanelSkin = new JPanel(new BorderLayout());
            JPanelSkin.add(skinLabel);
            mainPanel.add(JPanelSkin);
            mainPanel.add(vbox);
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
