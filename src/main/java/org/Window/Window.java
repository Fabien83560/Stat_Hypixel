package org.Window;

import org.DataBase.Database;
import org.Player.Player;
import org.PlayerList.PlayerList;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class Window extends JFrame {

    private JButton quitButton;
    private JPanel mainPanel;
    private JButton compare2PlayersButton;
    private JButton onePlayerButton;
    private JPanel panelLeft;
    private JScrollPane panelRight;
    private JScrollPane friendListPanel;
    private JTextField searchAPlayerHereTextField;
    private JButton TODOButton;
    private JButton bedWarsButton;
    private JButton skyWarsButton;
    private JButton TODOButton1;
    private JButton TODOButton2;
    private DefaultListModel<String> friendListModel;
    private JList<String> friendList;
    private JLabel globalStatsLabel;
    private JScrollPane globalStatsPanel;
    private JLabel selectedModeLabel;
    private JScrollPane selectedModePanel;
    private JButton addNewPlayerButton;
    PlayerList playerList;
    Database dataBase;

    public Window() {
        setMinimumSize(new Dimension(800, 600));
        setTitle("Hypixel Statistics");
        setSize(1400, 1000);
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
            playerList = new PlayerList();
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
                if(playerList.getList().get(newPlayer) == null) {
                    friendListModel.addElement(addPlayer(newPlayer));
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "This Player already exists in the friend list!",
                            "Player already exists",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void quit() {
        if (JOptionPane.showConfirmDialog(null,
                "Do you want to quit ?",
                "Quit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
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

        playerList.getList().putIfAbsent(name,uuid);

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
        Set<String> keys = playerList.getList().keySet();
        JSONObject jsonObjectStatus;
        boolean online;
        String recentGame;
        for (String key : keys) {
            jsonObjectStatus = Player.fetchStatus(playerList.getList().get(key) , org.Config.ConfigReader.getApiKey());
            online = jsonObjectStatus.getJSONObject("session").getBoolean("online");
            if(online)
                recentGame = jsonObjectStatus.getJSONObject("session").getString("gameType");
            else
                recentGame = "";
            friendListModel.addElement(addPlayer(key,playerList.getList().get(key)));
        }
    }
}