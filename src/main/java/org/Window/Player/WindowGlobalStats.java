package org.Window.Player;

import org.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Map;

public class WindowGlobalStats {
    private JPanel mainPanel;
    public WindowGlobalStats() {

    }
    public WindowGlobalStats(Player player) {
        if(mainPanel.getComponentCount() != 0){
            mainPanel.removeAll();
        }
        Map<String, String> globalStats = player.getAllStatistics();
        try{
            for(Map.Entry<String, String> stat : globalStats.entrySet()){
                if(!stat.getKey().equals("skin")) {
                    JLabel lab = new JLabel(stat.getKey() + ": " + stat.getValue());
                    lab.setFont(new Font("Calibri", Font.PLAIN, 18));
                    mainPanel.add(lab);
                }
            }
            //URL skinUrl = new URL(globalStats.get("skin"));
            //System.out.println(skinUrl);
            //ImageIcon skinIcon = new ImageIcon(skinUrl);
            //JLabel skin = new JLabel(skinIcon);
            //mainPanel.add(skin);
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
