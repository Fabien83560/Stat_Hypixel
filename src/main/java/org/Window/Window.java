package org.Window;

import org.Application.App;
import org.Config.Config;
import org.DataBase.Database;
import org.Player.Player;
import org.FriendList.FriendList;
import org.Window.Player.WindowPlayer;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Set;

/**
 * The Window class creates the user interface to display
 * everything properly, such as the buttons, the friend list,
 * the statistics... Other Window classes contained in the
 * 'Window' package are added to that main Window in order
 * to display the proper elements at the right time. This
 * class all alone will only display the panel on the left,
 * that contains the buttons to compare two players, quit,
 * display the statistics as well as the friend list. The
 * constructor uses the WindowPlayer class to display, in
 * the Window instance, the right panel containing the
 * search bar, all the statistics and the mode buttons.
 */
public class Window extends JFrame {

    /**
     * Button to quit the application.
     */
    private JButton quitButton;

    /**
     * Main panel of the application. This panel
     * contains all other elements of the interface.
     */
    private JPanel mainPanel;

    /**
     * Button to compare two players' statistics.
     */
    private JButton compare2PlayersButton;

    /**
     * Button to display only one player's
     * statistics. Useful only when the button
     * above is used.
     * @see #compare2PlayersButton
     */
    private JButton onePlayerButton;

    /**
     * Panel that contains the friend list and
     * all the buttons located above and under that
     * friend list.
     */
    private JPanel panelLeft;

    /**
     * Panel that contains the friend list.
     * This panel is scrollable only if the number
     * of player's displayed in the friend list is
     * too large to fit in the interface.
     * @see #friendList
     */
    private JScrollPane friendListPanel;

    /**
     * This is a model that the JList of String
     * 'friendList' uses. This is used to display
     * the friend list in the interface, since a
     * JList Object can't be displayed in an interface.
     * @see #friendList
     */
    private DefaultListModel<String> friendListModel;

    /**
     * The list to which will be added the player's information
     * when the user adds him to his friend list. It contains
     * elements that have the following pattern:
     * <br>OFFLINE/ONLINE - Player Name - Current Mode(if ONLINE)
     */
    private JList<String> friendList;

    /**
     * Button to add a player into the friend list
     * of the user.
     */
    private JButton addNewPlayerButton;

    /**
     * Panel that is meant to contain all the elements
     * that aren't in the 'panelLeft' panel, such as
     * the search bar, the global statistics and mode
     * statistics panels and the mode buttons.
     */
    private JPanel panelRight;

    /**
     * Button to remove a player from the friend list
     * of the user. Only works when a player in the
     * friend list is selected, otherwise shows a dialog
     * to the user.
     */
    private JButton removePlayerButton;

    /**
     * Button to display all the statistics of a
     * player that is in the friend list. Only works
     * when a player in the friend list is selected,
     * otherwise shows a dialog to the user.
     */
    private JButton displayPlayerStatisticsButton;

    /**
     * The FriendList table of the DataBase. Updated
     * when a player is added or removed from the friend
     * list.
     */
    FriendList friendPlayerList;

    /**
     * Constructor of the Window class. It uses the main
     * panel of a WindowPlayer instance that displays the
     * statistics, the search bar and the buttons of the modes
     * in the interface.
     * The constructor sets up all the action listeners of each
     * button in order for them to work properly when clicked on.
     * Though, loading everything, especially the friend list on
     * the right when filled in thanks to the database, is long,
     * that means loading the interface entirely can take time.
     * It is represented by the cursor of the mouse that is
     * changed when something loads.
     * @param windowPlayer A JPanel Object representing the
     *                     main panel of the WindowPlayer class.
     */
    public Window(JPanel windowPlayer) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        setMinimumSize(new Dimension(1450, 950));
        setTitle("Hypixel Statistics");
        setSize(1450, 950);
        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setPanelRight(windowPlayer);

        testAPIkey();

        friendListModel = new DefaultListModel<>();
        try {
            friendPlayerList = new FriendList();
            updateWindow();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        friendList.setModel(friendListModel);
        setCursor(Cursor.getDefaultCursor());
        quitButton.setActionCommand("quit");

        /**
         * This listener is called when the 'Quit' button
         * is clicked. It asks the user if he really wants
         * to quit the application.
         */
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("quit"))
                    quit();
            }
        });

        /**
         * This listener is called when the user clicks on the
         * button to add a player to his friend list, prompting
         * him to enter that player's name. If the player already
         * is in the list, shows a dialog to the user.
         */
        addNewPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPlayer = JOptionPane.showInputDialog("Enter the new player's name:");
                if(newPlayer != null)
                {
                    if(friendPlayerList.getList().get(newPlayer) == null) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        friendListModel.addElement(addPlayer(newPlayer));
                        setCursor(Cursor.getDefaultCursor());
                    }
                    else
                        JOptionPane.showMessageDialog(null,
                                "This Player already exists in your Friend list!",
                                "Player already exists",
                                JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * This listener is called when the user wants to compare
         * two player statistics by clicking on the 'Compare 2 players
         * stats' button.
         */
        compare2PlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWindowTwoPlayers();
            }
        });

        /**
         * This listener is called when the user clicks on
         * 'Look up one player stats' button. It sets back
         * the panel on the right that is the one displayed
         * when launching the application.
         */
        onePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPanelRight(windowPlayer);
            }
        });

        /**
         * This listener is called when the user clicks on
         * 'Display the statistics' button. This button is
         * meant to be clicked when a player in the friend
         * list is selected. If not, shows a dialog to the
         * user, telling him to select a player to display
         * the statistics of. Otherwise, gets the name of
         * the player using the 'substring' method on the
         * text of the player selected in the friend list,
         * and asks the user if he wants to display the
         * statistics of that said player. If the user
         * answers 'Yes', the statistics are displayed,
         * otherwise, does nothing.
         */
        displayPlayerStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(friendList.getSelectedValue() == null){
                        JOptionPane.showMessageDialog(null,
                                "Please select a player to display the statistics of.",
                                "Select a player", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(!friendList.getValueIsAdjusting()){
                        //Getting the name of the selected player to do a fetch with it afterward
                        String friendSelectedFullName = friendList.getSelectedValue();
                        String friendNameSelected = "";
                        int startName = friendSelectedFullName.indexOf("-") + 1;
                        //If there is the first dash in the name of the player in the friendList
                        if (startName != -1) {
                            int endName = friendSelectedFullName.indexOf("-", startName + 1);
                            //If the player is ONLINE and plays a specific mod, there is a second dash to handle to get only the name
                            if (endName != -1) {
                                //Extracting the name of the player
                                friendNameSelected = friendSelectedFullName.substring(startName + 1, endName).trim();
                            }
                            else{
                                friendNameSelected = friendSelectedFullName.substring(startName + 1).trim();
                            }
                        }
                        if(JOptionPane.showConfirmDialog(null,
                                "Do you wish to display the statistics of " + friendNameSelected + " ?",
                                "Displaying statistics",
                                JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION){

                            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            Player player = new Player(friendNameSelected);
                            WindowPlayer windowPlayer = new WindowPlayer();
                            windowPlayer.displayAllStats(player);
                            setPanelRight(windowPlayer.getMainPanel());
                            setCursor(Cursor.getDefaultCursor());
                        }
                    }
                }
                catch(IndexOutOfBoundsException exception){
                    exception.printStackTrace();
                }
            }
        });

        /**
         * This listener is called when the user clicks on
         * 'Remove a player' button. The user has to select
         * a player from his friend list to be able to delete
         * him, otherwise a popup appears, telling him to select
         * a player to remove. Then, if the user answers 'Yes' to
         * remove the selected player, the latter is removed from the
         * list and from the 'FriendList' table of the database.
         * Otherwise, does nothing.
         */
        removePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(friendList.getSelectedValue() == null){
                        JOptionPane.showMessageDialog(null,
                                "Please select a player to delete from your Friend List.",
                                "Select a player", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        String friendSelectedFullName = friendList.getSelectedValue();
                        String friendNameSelected = "";
                        int startName = friendSelectedFullName.indexOf("-") + 1;
                        //If there is the first dash in the name of the player in the friendList
                        if (startName != -1) {
                            int endName = friendSelectedFullName.indexOf("-", startName + 1);
                            //If the player is ONLINE and plays a specific mod, there is a second dash to handle to get only the name
                            if (endName != -1) {
                                //Extracting the name of the player
                                friendNameSelected = friendSelectedFullName.substring(startName + 1, endName).trim();
                            }
                            else{
                                friendNameSelected = friendSelectedFullName.substring(startName + 1).trim();
                            }
                        }
                        if(JOptionPane.showConfirmDialog(null,
                                "Do you really want to delete " + friendNameSelected + " from your Friend List?",
                                "Delete " + friendNameSelected,
                                JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION){
                            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            Database database = new Database();
                            friendPlayerList.removePlayer(friendNameSelected);
                            friendListModel.removeElementAt(friendList.getSelectedIndex());
                            friendList.revalidate();
                            friendList.repaint();
                            database.removeFriendPlayerFromDataBase(friendNameSelected);
                            setCursor(Cursor.getDefaultCursor());
                        }
                    }
                }
                catch(Exception exception){
                    System.out.println("Error trying to remove a player from the Friend List:");
                    exception.printStackTrace();
                }
            }
        });
    }

    /**
     * This method is called when the user clicks on the button
     * 'Compare 2 players stats'. It sets up 2 different panels,
     * one on top and one at the bottom in order to research 2
     * different players to compare them.
     */
    public void openWindowTwoPlayers() {
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.removeAll();
        panelRight.add(new WindowPlayer().getMainPanel());
        panelRight.add(new WindowPlayer().getMainPanel());
        panelRight.revalidate();
        panelRight.repaint();
    }

    /**
     * This method is called when the user clicks on the 'Quit' button.
     * Is simply asks the user if he wants to quit through a JOptionPane.
     * If the user clicks on Yes, the application is closed.
     */
    public void quit() {
        if (JOptionPane.showConfirmDialog(null, "Do you want to quit ?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    /**
     * This method is called when the user clicks on the
     * 'Add new player' button. It asks the user to enter
     * the name of the player to add to the friend list,
     * and if he exists, adds him into it and into the
     * database, otherwise, says that the player is unknown.
     * @param name A String representing the name of the player
     *             to add to the friend list.
     * @return A String containing: the status of the player added
     *         in the list (ONLINE/OFFLINE), his name and, if he
     *         is online, the mode he is playing. If the player
     *         isn't found, return an empty String.
     */
    public String addPlayer(String name) {
        JSONObject jsonObjectStatus;
        String uuid;
        try {
            uuid = Player.fetchPlayer(name, App.getInstance().getConfig().getApikey()).getJSONObject("player").getString("uuid");
            friendPlayerList.addPlayer(name, uuid);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "This player is Unknown",
                    "Unknown Player",
                    JOptionPane.ERROR_MESSAGE);
            return "";
        }

        jsonObjectStatus = Player.fetchStatus(uuid , App.getInstance().getConfig().getApikey());
        boolean online = jsonObjectStatus.getJSONObject("session").getBoolean("online");
        String recentGame;

        if(online)
            recentGame = jsonObjectStatus.getJSONObject("session").getString("gameType");
        else
            recentGame = "";

        String element = (online ? "ONLINE - " : "OFFLINE - ") + name + (online ? " - " + recentGame : "");

        friendPlayerList.getList().putIfAbsent(name,uuid);
        App.getInstance().getDataBase().addFriendPlayerToDataBase(uuid,name);
        return element;
    }

    /**
     * Same method than 'addPlayer(String name)' but this one
     * uses the uuid of the player as well. This method is meant
     * to update the interface when a player is added to the
     * friend list. It is called in the 'updateWindow() method.
     * @param name A String representing the name of the player
     *             to add in the list (when updating it)
     * @param uuid A String representing the uuid of that player.
     * @return A String containing the status of the player, his name
     *         and, if online, the mode he is playing.
     * @see Window#addPlayer(String, String)
     */
    public String addPlayer(String name, String uuid) {
        JSONObject jsonObjectStatus;
        jsonObjectStatus = Player.fetchStatus(uuid , App.getInstance().getConfig().getApikey());
        boolean online = jsonObjectStatus.getJSONObject("session").getBoolean("online");
        String recentGame;
        if(online)
            recentGame = jsonObjectStatus.getJSONObject("session").getString("gameType");
        else
            recentGame = "";

        String element = (online ? "ONLINE - " : "OFFLINE - ") + name + (online ? " - " + recentGame : "");
        return element;
    }

    /**
     * This method updates the interface when a player
     * is added to the friend list. It clears the friend
     * list, then adds everything back once, plus the new player
     * that was added.
     */
    public void updateWindow() {
        friendListModel.clear();
        Set<String> keys = friendPlayerList.getList().keySet();
        JSONObject jsonObjectStatus;
        boolean online;
        String recentGame;
        for (String key : keys) {
            jsonObjectStatus = Player.fetchStatus(friendPlayerList.getList().get(key) , App.getInstance().getConfig().getApikey());
            online = jsonObjectStatus.getJSONObject("session").getBoolean("online");
            if(online)
                recentGame = jsonObjectStatus.getJSONObject("session").getString("gameType");
            else
                recentGame = "";
            friendListModel.addElement(addPlayer(key,friendPlayerList.getList().get(key)));
        }
    }

    /**
     * This method sets the panel on the right, that contains
     * the search bar, the statistics and the mode buttons.
     * Called when the application starts, when the 'Compare 2
     * players stats' button is clicked, and when the 'Look up
     * one player stats' is clicked.
     * @param panel The JPanel that is sets up on the right,
     *              depending on the action that has been done.
     */
    public void setPanelRight(JPanel panel) {
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.removeAll();
        panelRight.add(panel);
        panelRight.revalidate();
        panelRight.repaint();
    }

    /**
     * Tries to do a fetch in the API. If it doesn't work, that means the API
     * key is outdated and needs to be changed. If the API Key is empty, asks
     * the user to fill it in. Otherwise, starts the application normally.
     */
    public void testAPIkey() {
        String testUUID = "055db3693e1e4431a3204d586be92a37";
        boolean apiKeyValid = false;
        while (!apiKeyValid) {
            try {
                String newApiKey = JOptionPane.showInputDialog("Enter your API KEY to start the App");
                boolean b = Player.fetchStatus(testUUID, newApiKey).getJSONObject("session").getBoolean("online");

                if (b == true || b == false) {
                    apiKeyValid = true;
                    App.getInstance().getConfig().setApikey(newApiKey);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid API Key. Please try again.");
                }
            } catch (JSONException e) {

            }
        }
    }
}