package org.Window;

import org.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
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

    public WindowPlayer() {
        skyWarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bedWarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        skyBlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
    public JPanel getMainPanel() {return mainPanel;}
}
