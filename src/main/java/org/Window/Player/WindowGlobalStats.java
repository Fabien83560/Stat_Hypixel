package org.Window.Player;

import org.Player.Player;
import org.Window.Game.WindowBedWarsStats;
import org.Window.Game.SkyBlock.WindowSkyBlockStats;
import org.Window.Game.WindowSkyWarsStats;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * The WindowGlobalStats class is meant to
 * display all the global statistics of a player
 * (Player class). It has a JPanel 'mainPanel' used
 * to display all the global statistics of a player,
 * but also another JPanel that uses a JLabel to
 * display the skin of the player.
 * @see Player
 */
public class WindowGlobalStats {

    /**
     * The panel that is added to the globalStatsPanel
     * from the WindowPlayer class. It contains the
     * global statistics of a player as well as his skin.
     * @see WindowPlayer#globalStatsPanel
     */
    private JPanel mainPanel;

    /**
     * This JLabel contains the image of the skin the player
     * uses in Hypixel.
     */
    private JLabel skinLabel;

    /**
     * This panel contains the JLabel above in order to
     * display the skin properly.
     * @see #skinLabel
     */
    private JPanel JPanelSkin;

    /**
     * Default constructor of the
     * WindowGlobalStats class. Does
     * nothing into it.
     */
    public WindowGlobalStats() {}

    /**
     * Constructor of the WindowGlobalStats class
     * that uses a Player instance as a parameter
     * to display his global statistics, such as his
     * first and last login, his name, his Hypixel level...
     * If one of those statistics is null, displays 'N/A'.
     * @param player The player to display the global statistics of.
     * @see Player#getAllStatistics()
     */
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
                            Timestamp timestamp = new Timestamp(Long.parseLong(stat.getValue()));
                            Date date = new Date(timestamp.getTime());
                            lab.setText("Last Login: " + (date.getDate() < 10 ? "0" + date.getDate() : date.getDate()) + "/" +
                                                         (date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1)  + "/" +
                                                         (date.getYear() + 1900));
                            break;
                        case "firstLogin":
                            Timestamp timestamp2 = new Timestamp(Long.parseLong(stat.getValue()));
                            Date date2 = new Date(timestamp2.getTime());
                            lab.setText("First Login: " + (date2.getDate() < 10 ? "0" + date2.getDate() : date2.getDate()) + "/" +
                                                          (date2.getMonth() + 1 < 10 ? "0" + (date2.getMonth() + 1) : date2.getMonth() + 1) + "/" +
                                                          (date2.getYear() + 1900));
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
                    "Can't display the global Statistics of the player.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Can't display the global statistics of the researched player:\n");
            e.printStackTrace();
        }
    }

    /**
     * Gets the main panel of the global statistics of a player.
     * @return The main panel of the global statistics.
     * @see WindowBedWarsStats#getMainPanel()
     * @see WindowSkyWarsStats#getMainPanel()
     * @see WindowSkyBlockStats#getMainPanel()
     */
    public JPanel getMainPanel(){return mainPanel;}
}
