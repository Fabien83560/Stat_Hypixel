package org.Window;

import org.DataBase.Database;
import org.Player.Player;
import org.FriendList.FriendList;
import org.Window.Player.WindowPlayer;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Set;

public class Window extends JFrame {

    private JButton quitButton;
    private JPanel mainPanel;
    private JButton compare2PlayersButton;
    private JButton onePlayerButton;
    private JPanel panelLeft;
    private JScrollPane friendListPanel;
    private DefaultListModel<String> friendListModel;
    private JList<String> friendList;
    private JButton addNewPlayerButton;
    private JPanel panelRight;
    FriendList friendPlayerList;
    Database dataBase;

    public Window(JPanel windowPlayer) {
        setMinimumSize(new Dimension(1450, 950));
        setTitle("Hypixel Statistics");
        setSize(1450, 950);
        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setPanelRight(windowPlayer);

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

        friendList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                try{
                    if(!e.getValueIsAdjusting()){
                        //Getting the name of the selected player to do a fetch with it afterward
                        String friendSelectedFullName = friendList.getSelectedValue();
                        String friendNameSelected = "";
                        int startName = friendSelectedFullName.indexOf("-") + 1;
                        //If there is the first dash in the name of the player in the friendList
                        if (startName != -1) {
                            int indiceDeuxiemeTiret = friendSelectedFullName.indexOf("-", startName + 1);
                            //If the player is ONLINE and plays a specific mod, there is a second dash to handle to get only the name
                            if (indiceDeuxiemeTiret != -1) {
                                //Extracting the name of the player
                                friendNameSelected = friendSelectedFullName.substring(startName + 1, indiceDeuxiemeTiret).trim();
                            }
                            else{
                                friendNameSelected = friendSelectedFullName.substring(startName + 1).trim();
                            }
                        }
                        if(JOptionPane.showConfirmDialog(null,
                                "Do you wish to display the statistics of " + friendNameSelected + " ?",
                                "Displaying statistics",
                                JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION){

                            System.out.println(friendNameSelected);
                        }

                    }
                }
                catch(IndexOutOfBoundsException exception){
                    exception.printStackTrace();
                }
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

        onePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPanelRight(windowPlayer);
            }
        });
    }
    public void openWindowTwoPlayers() {
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.removeAll();
        panelRight.add(new WindowPlayer().getMainPanel());
        panelRight.add(new WindowPlayer().getMainPanel());
        panelRight.revalidate();
        panelRight.repaint();
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

    public void setPanelRight(JPanel panel) {
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.removeAll();
        panelRight.add(panel);
        panelRight.revalidate();
        panelRight.repaint();
    }
}