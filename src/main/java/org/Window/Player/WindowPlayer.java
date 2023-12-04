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
    private WindowGlobalStats windowGlobalStats;
    private WindowBedWarsStats windowBedWarsStats;
    private WindowSkyWarsStats windowSkyWarsStats;
    private WindowSkyBlockStats windowSkyBlockStats;
    private boolean playerStorage;

    public WindowPlayer() {
        windowGlobalStats = new WindowGlobalStats();
        playerStorage = false;
        setGlobalStatsPanel(windowGlobalStats.getMainPanel());
        skyWarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerStorage) {
                    setCurrentModeStatsPanel(windowSkyWarsStats.getMainPanel());
                    currentModeStatisticsLabel.setText("SkyWars Statistics");
                }
                else
                    JOptionPane.showMessageDialog(null,
                            "Please enter a player's name.",
                            "No name entered",
                            JOptionPane.ERROR_MESSAGE);
            }
        });
        bedWarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerStorage) {
                    setCurrentModeStatsPanel(windowBedWarsStats.getMainPanel());
                    currentModeStatisticsLabel.setText("BedWars Statistics");
                }
                else
                    JOptionPane.showMessageDialog(null,
                            "Please enter a player's name.",
                            "No name entered",
                            JOptionPane.ERROR_MESSAGE);
            }
        });
        skyBlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerStorage) {
                    setCurrentModeStatsPanel(windowSkyBlockStats.getMainPanel());
                    currentModeStatisticsLabel.setText("SkyBlock Statistics");
                }
                else
                    JOptionPane.showMessageDialog(null,
                            "Please enter a player's name.",
                            "No name entered",
                            JOptionPane.ERROR_MESSAGE);
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
                    if(player != null)
                        displayAllStats(player);
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

    public void displayAllStats(Player player){
        playerStorage = true;
        windowGlobalStats = new WindowGlobalStats(player);
        windowSkyWarsStats = new WindowSkyWarsStats(player);
        windowBedWarsStats = new WindowBedWarsStats(player);
        windowSkyBlockStats = new WindowSkyBlockStats(player);
        setGlobalStatsPanel(windowGlobalStats.getMainPanel());
        currentModeStatisticsLabel.setText("BedWars Statistics");
        setCurrentModeStatsPanel(windowBedWarsStats.getMainPanel());
    }
}
