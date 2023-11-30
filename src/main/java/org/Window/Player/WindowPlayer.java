package org.Window.Player;

import org.Player.Player;
import org.Window.Game.WindowBedWarsStats;
import org.Window.Game.WindowSkyBlockStats;
import org.Window.Game.WindowSkyWarsStats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Map;

public class WindowPlayer extends JFrame {

    private JTextField SearchPlayer;
    private JButton bedWarsButton;
    private JButton skyBlockButton;
    private JButton skyWarsButton;
    private JButton searchButton;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel globalStatsPanel;
    private JPanel currentModeStatsPanel;
    private JLabel currentModeStatisticsLabel;

    public WindowPlayer() {
        skyWarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModeStatisticsLabel.setText("SkyWars Statistics");
                setCurrentModeStatsPanel(new WindowSkyWarsStats().getMainPanel());
            }
        });
        bedWarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModeStatisticsLabel.setText("BedWars Statistics");
                setCurrentModeStatsPanel(new WindowBedWarsStats().getMainPanel());
            }
        });
        skyBlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModeStatisticsLabel.setText("SkyBlock Statistics");
                setCurrentModeStatsPanel(new WindowSkyBlockStats().getMainPanel());
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String search = SearchPlayer.getText();
                    if(search.isEmpty())
                        JOptionPane.showMessageDialog(null,
                                "Please enter a player's name.",
                                "No name entered",
                                JOptionPane.ERROR_MESSAGE);

                    Player player = new Player(search);
                    displayGlobalStats(player);
                    //We'll have to display the other stats
                }
                catch(NullPointerException exception) {
                    exception.printStackTrace();
                    System.out.println("Error trying to do a research in \"searchButton.addActionListener\".");
                }
            }
        });
        SearchPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SearchPlayer.getText().equals("Search a player's name here"))
                    SearchPlayer.setText(null);
            }
        });
    }

    public void displayGlobalStats(Player player) {
        if(globalStatsPanel.getComponentCount() != 0){
            globalStatsPanel.removeAll();
        }
        Map<String, String> globalStats = player.getAllStatistics();
        try{
            for(Map.Entry<String, String> stat : globalStats.entrySet()){
                if(!stat.getKey().equals("skin")) {
                    JLabel lab = new JLabel(stat.getKey() + ": " + stat.getValue());
                    lab.setFont(new Font("Calibri", Font.PLAIN, 18));
                    globalStatsPanel.add(lab);
                }
            }
            URL skinUrl = new URL(globalStats.get("skin"));
            //System.out.println(skinUrl);
            //ImageIcon skinIcon = new ImageIcon(skinUrl);
            //JLabel skin = new JLabel(skinIcon);
            //globalStatsPanel.add(skin);
            globalStatsPanel.revalidate();
            globalStatsPanel.repaint();
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
    public void setGlobalStatsPanel(JPanel panel) {
        globalStatsPanel.setLayout(new BoxLayout(globalStatsPanel, BoxLayout.Y_AXIS));
        globalStatsPanel.removeAll();
        globalStatsPanel.add(panel);
        globalStatsPanel.revalidate();
        globalStatsPanel.repaint();
    }
    public void setCurrentModeStatsPanel(JPanel panel) {
        currentModeStatsPanel.setLayout(new BoxLayout(currentModeStatsPanel, BoxLayout.Y_AXIS));
        currentModeStatsPanel.removeAll();
        currentModeStatsPanel.add(panel);
        currentModeStatsPanel.revalidate();
        currentModeStatsPanel.repaint();
    }
    public JPanel getMainPanel() {return mainPanel;}
}
