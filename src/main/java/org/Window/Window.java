package org.Window;

import org.DataBase.Database;
import org.Player.Player;
import org.FriendList.FriendList;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class Window extends JFrame {

    private JButton quitButton;
    private JPanel mainPanel;
    private JButton compare2PlayersButton;
    private JButton onePlayerButton;
    private JPanel panelLeft;
    private JScrollPane friendListPanel;
    private JTextField searchAPlayerHereTextField;
    private JButton bedWarsButton;
    private DefaultListModel<String> friendListModel;
    private JList<String> friendList;
    private JPanel globalStatsPanel;
    private JButton addNewPlayerButton;
    private JPanel panelRight;
    private JButton skyWarsButton;
    private JButton skyBlockButton;
    private JButton searchButton;
    private JPanel buttonsPanel;
    private JLabel globalStatsLabel;
    private JLabel currentModeLabel;
    private JPanel currentModeStatsPanel;
    FriendList friendPlayerList;
    Database dataBase;

    public Window() {
        setMinimumSize(new Dimension(1450, 950));
        setTitle("Hypixel Statistics");
        setSize(1450, 950);
        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (org.Config.ConfigReader.getApiKey().isEmpty()) {
            boolean apiKeyValid = false;

            while (!apiKeyValid) {
                String testUUID = "055db3693e1e4431a3204d586be92a37";

                try {
                    String newApiKey = JOptionPane.showInputDialog("Enter your API KEY to start the App");
                    boolean b = Player.fetchStatus(testUUID, newApiKey).getJSONObject("session").getBoolean("online");

                    if (b == true || b == false) {
                        apiKeyValid = true;
                        org.Config.ConfigReader.setApiKey(newApiKey);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid API Key. Please try again.");
                    }
                } catch (JSONException e) {

                }
            }
        }

        friendListModel = new DefaultListModel<>();
        this.dataBase = new Database();
        try {
            friendPlayerList = new FriendList();
            updateWindow();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        friendList.setModel(friendListModel);

        quitButton.setActionCommand("quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("quit"))
                    quit();
            }
        });

        addNewPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPlayer = JOptionPane.showInputDialog("Enter the new player's name:");
                if(newPlayer != null)
                {
                    if(friendPlayerList.getList().get(newPlayer) == null)
                        friendListModel.addElement(addPlayer(newPlayer));
                    else
                        JOptionPane.showMessageDialog(null,
                                "This Player already exists in the friend list!",
                                "Player already exists",
                                JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        compare2PlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWindowTwoPlayers();
            }
        });
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
                    String search = searchAPlayerHereTextField.getText();
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
                    System.out.println("Error trying to do a research in \"searchButton.addActionListener\".");
                }
            }
        });
        searchAPlayerHereTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(searchAPlayerHereTextField.getText().equals("Search a player's name here"))
                    searchAPlayerHereTextField.setText(null);
            }
        });
    }
    public void openWindowTwoPlayers() {
        WindowTwoPlayer windowTwoPlayer = new WindowTwoPlayer();
        setVisible(false);
        dispose();
    }

    public void displayGlobalStats(Player player) {
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
        catch(IllegalStateException | MalformedURLException e){
            JOptionPane.showMessageDialog(null,
                    "Error displaying the global Statistics of the player.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Can't display the global statistics of the researched player:\n");
            e.printStackTrace();
        }

    }

    public void quit() {
        if (JOptionPane.showConfirmDialog(null, "Do you want to quit ?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
            System.exit(0);
    }
    public String addPlayer(String name) {
        JSONObject jsonObjectStatus;
        String uuid;
        try {
            uuid = Player.fetchPlayer(name, org.Config.ConfigReader.getApiKey()).getJSONObject("player").getString("uuid");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "This player is Unknown",
                    "Unknown Player",
                    JOptionPane.ERROR_MESSAGE);
            return "";
        }

        jsonObjectStatus = Player.fetchStatus(uuid , org.Config.ConfigReader.getApiKey());
        boolean online = jsonObjectStatus.getJSONObject("session").getBoolean("online");
        String recentGame;

        if(online)
            recentGame = jsonObjectStatus.getJSONObject("session").getString("gameType");
        else
            recentGame = "";

        String element = (online ? "ONLINE - " : "OFFLINE - ") + name + (online ? " - " + recentGame : "");

        friendPlayerList.getList().putIfAbsent(name,uuid);
        dataBase.addFriendPlayerToDataBase(uuid,name);
        return element;
    }
    public String addPlayer(String name, String uuid) {
        JSONObject jsonObjectStatus;
        jsonObjectStatus = Player.fetchStatus(uuid , org.Config.ConfigReader.getApiKey());
        boolean online = jsonObjectStatus.getJSONObject("session").getBoolean("online");
        String recentGame;
        if(online)
            recentGame = jsonObjectStatus.getJSONObject("session").getString("gameType");
        else
            recentGame = "";

        String element = (online ? "ONLINE - " : "OFFLINE - ") + name + (online ? " - " + recentGame : "");
        return element;
    }

    public void updateWindow() {
        friendListModel.clear();
        Set<String> keys = friendPlayerList.getList().keySet();
        JSONObject jsonObjectStatus;
        boolean online;
        String recentGame;
        for (String key : keys) {
            jsonObjectStatus = Player.fetchStatus(friendPlayerList.getList().get(key) , org.Config.ConfigReader.getApiKey());
            online = jsonObjectStatus.getJSONObject("session").getBoolean("online");
            if(online)
                recentGame = jsonObjectStatus.getJSONObject("session").getString("gameType");
            else
                recentGame = "";
            friendListModel.addElement(addPlayer(key,friendPlayerList.getList().get(key)));
        }
    }
}