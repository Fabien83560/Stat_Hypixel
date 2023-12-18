package org.Window.Player;

import org.Player.Player;
import org.Window.Game.WindowBedWarsStats;
import org.Window.Game.SkyBlock.WindowSkyBlockStats;
import org.Window.Game.WindowSkyWarsStats;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

/**
 * The WindowPlayer class is used to display all
 * the different panels of the interface that are
 * related to a Player instance, like the global
 * statistics and the different modes statistics.
 * This class also creates the listeners to the
 * different mode buttons as well as the one for
 * the search bar and the text in the search bar
 * (to simply remove the text when the user clicks
 * on the search bar for the first time).
 * @see Player
 * @see WindowGlobalStats
 * @see WindowBedWarsStats
 * @see WindowSkyWarsStats
 * @see WindowSkyBlockStats
 */
public class WindowPlayer extends JFrame {

    /**
     * The search bar the user can use to find
     * a player and display his statistics.
     */
    private JTextField SearchPlayer;

    /**
     * The Bedwars button displayed in the
     * interface. When clicked, and if a player's
     * statistics are displayed, display his
     * Bedwars statistics.
     */
    private JButton bedWarsButton;

    /**
     * The Skyblock button displayed in the
     * interface. When clicked, and if a player's
     * statistics are displayed, display his
     * Skyblock statistics.
     */
    private JButton skyBlockButton;

    /**
     * The Skywars button displayed in the
     * interface. When clicked, and if a player's
     * statistics are displayed, display his
     * Skywars statistics.
     */
    private JButton skyWarsButton;

    /**
     * The research button displayed in the
     * interface. When clicked on, search the
     * player's name contained in the search
     * bar, if it is not empty, and displays his
     * statistics if the player exists.
     * @see #SearchPlayer
     */
    private JButton searchButton;

    /**
     * The main panel of the interface, always displayed. It contains
     * everything except the friend list, and the buttons
     * that are above and under that friend list.
     */
    private JPanel mainPanel;

    /**
     * The panel that contains the three
     * mode buttons: Bedwars, Skywars and Skyblock.
     */
    private JPanel buttonPanel;

    /**
     * The panel meant to contain all the global
     * statistics of a player. The 'mainPanel' panel
     * of the WindowGlobalStats class will be added to
     * this one.
     * @see WindowGlobalStats#mainPanel
     */
    private JPanel globalStatsPanel;

    /**
     * The panel that contains all the player's
     * statistics in a specific mode, Bedwars being
     * the default one displayed. This panel changes
     * depending on choices of the user.
     */
    private JPanel currentModeStatsPanel;

    /**
     * This label displays the name of the game mode
     * that is currently displayed in the interface,
     * if a player's statistics are shown. Otherwise,
     * this label isn't displayed.
     */
    private JLabel currentModeStatisticsLabel;

    /**
     * This Scroll Panel contains the information related to
     * the current mode statistics. It contains the
     * 'currentModeStatsPanel' JPanel.
     * @see WindowPlayer#currentModeStatsPanel
     */
    private JScrollPane currentModeScrollPane;

    /**
     * This panel contains all the different
     * profile buttons of a player in Skyblock mode.
     */
    private JPanel skyblockProfilesButtonPanel;

    /**
     * Instance of the WindowGlobalStats class. Used
     * to display the player's global statistics when
     * a player is searched by the user.
     * @see WindowGlobalStats
     * @see #setGlobalStatsPanel(JPanel)
     */
    private WindowGlobalStats windowGlobalStats;

    /**
     * Instance of the WindowBedWarsStats class. Used
     * to display the player's Bedwars statistics when
     * a player is searched by the user.
     * @see WindowBedWarsStats
     * @see #setCurrentModeStatsPanel(JPanel)
     */
    private WindowBedWarsStats windowBedWarsStats;

    /**
     * Instance of the WindowSkyWarsStats class. Used
     * to display the player's Skywars statistics when
     * a player is searched by the user.
     * @see WindowSkyWarsStats
     * @see #setCurrentModeStatsPanel(JPanel)
     */
    private WindowSkyWarsStats windowSkyWarsStats;

    /**
     * Instance of the WindowSkyBlockStats class. Used
     * to display the player's Skyblock statistics when
     * a player is searched by the user.
     * @see WindowSkyBlockStats
     * @see #setCurrentModeStatsPanel(JPanel)
     */
    private WindowSkyBlockStats windowSkyBlockStats;

    /**
     * This boolean is true if a player's statistics
     * are displayed, and false otherwise. It is used
     * for the three mode buttons in order to display
     * a dialog telling the user to search a player
     * to be able to use these buttons only then.
     */
    private boolean isPlayerDisplayed = false;

    /**
     * Constructor of the WindowPlayer class. It creates
     * an instance of the WindowGlobalStats class and listeners
     * to each button in the right panel. The panel is then
     * displayed through the setGlobalStatsPanel method.
     * @see WindowGlobalStats
     * @see WindowPlayer#setGlobalStatsPanel(JPanel)
     */
    public WindowPlayer() {
        windowGlobalStats = new WindowGlobalStats();
        setGlobalStatsPanel(windowGlobalStats.getMainPanel());
        skyblockProfilesButtonPanel.setVisible(false);

        /**
        * This listener is called when the user clicks on the
        * 'SkyWars' button. It replaces the previous mode panel
        * with the main panel (empty) of the windowSkyWarsStats data
        * member and changes the title of the current mode with
        * 'SkyWars Statistics'. If no player was searched in the
        * search bar, shows a popup to the user asking him to enter
        * a player's name in order to change the mode panel that is displayed.
        * @see WindowSkyWarsStats
        * @see WindowSkyWarsStats#getMainPanel()
        */
        skyWarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skyblockProfilesButtonPanel.setVisible(false);
                if(isPlayerDisplayed) {
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

        /**
        * This listener is called when the user clicks on the
        * 'BedWars' button. It replaces the previous mode panel
        * with the main panel (empty) of the windowBedWarsStats data
        * member and changes the title of the current mode with
        * 'BedWars Statistics'. If no player was searched in the
        * search bar, shows a popup to the user asking him to enter
        * a player's name in order to change the mode panel that is displayed.
        * @see WindowBedWarsStats
        * @see WindowBedWarsStats#getMainPanel()
        */
        bedWarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skyblockProfilesButtonPanel.setVisible(false);
                if(isPlayerDisplayed) {
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

        /**
        * This listener is called when the user clicks on the
        * 'SkyBlock' button. It replaces the previous mode panel
        * with the main panel (empty) of the windowSkyBlockStats data
        * member and changes the title of the current mode with
        * 'SkyBlock Statistics'. If no player was searched in the
        * search bar, shows a popup to the user asking him to enter
        * a player's name in order to change the mode panel that is displayed.
        * @see WindowSkyBlockStats
        * @see WindowSkyBlockStats#getMainPanel()
        */
        skyBlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPlayerDisplayed) {
                    skyblockProfilesButtonPanel.setVisible(true);
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

        /**
        * This listener is called when the user clicks on the
        * 'Search' button to search a player whose name has been
        * written in the search bar. If that search bar is empty,
        * shows a popup to the user telling him to enter a player's
        * name. If the search bar isn't empty, then tries to find the
        * player and to display his statistics. If the player doesn't
        * exist, shows the dialog of Window.addPlayer(String) saying that
        * this player is unknown, and shows that the application couldn't
        * display the global statistics of the searched player.
        * @see Player
        * @see WindowPlayer#displayAllStats(Player)
        * @see org.Window.Window#addPlayer(String)
        */
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
                    else{
                        globalStatsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        currentModeStatsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        SearchPlayer.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        Player player = new Player(search);
                        globalStatsPanel.setCursor(Cursor.getDefaultCursor());
                        currentModeStatsPanel.setCursor(Cursor.getDefaultCursor());
                        searchButton.setCursor(Cursor.getDefaultCursor());
                        SearchPlayer.setCursor(Cursor.getDefaultCursor());
                        if(player != null)
                            displayAllStats(player);
                    }
                }
                catch(NullPointerException exception) {
                    exception.printStackTrace();
                    System.out.println("Error trying to do a research in \"searchButton.addActionListener\".");
                    globalStatsPanel.setCursor(Cursor.getDefaultCursor());
                    currentModeStatsPanel.setCursor(Cursor.getDefaultCursor());
                    searchButton.setCursor(Cursor.getDefaultCursor());
                    SearchPlayer.setCursor(Cursor.getDefaultCursor());
                }
            }
        });

        /**
        * This listener is called when the user does a double click on the search bar.
        * It simply removes the text written in that search bar in order to make things
        * easier for the user when wanting to look up another player for example.
        * @see MouseEvent#getClickCount()
        * @see JTextField#setText(String)
        */
        SearchPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2)
                    SearchPlayer.setText(null);
            }
        });
    }

    /**
     * This method sets a new panel in the global statistics panel
     * when the application starts and when a player is
     * looked up by the user. The layout of the globalStatsPanel
     * is set to a BoxLayout with an Y_AXIS axis.
     * @param panel A JPanel Object representing the panel to
     *              add to the globalStatsPanel panel. This parameter
     *              represents the global statistics that will be
     *              displayed in the window to the user.
     * @see WindowPlayer#setCurrentModeStatsPanel(JPanel)
     */
    public void setGlobalStatsPanel(JPanel panel) {
        globalStatsPanel.setLayout(new BoxLayout(globalStatsPanel, BoxLayout.Y_AXIS));
        globalStatsPanel.removeAll();
        globalStatsPanel.add(panel);
        globalStatsPanel.revalidate();
        globalStatsPanel.repaint();
    }

    /**
     * This method sets a new panel in the current mode statistics panel
     * when the application starts and when a player is
     * looked up by the user. The layout of the currentModeStatsPanel
     * is set to a BoxLayout with an Y_AXIS axis.
     * @param panel A JPanel Object representing the panel to
     *              add to the currentModeStatsPanel panel. This parameter
     *              represents the statistics of the current mode that will be
     *              displayed in the window to the user.
     * @see WindowPlayer#setGlobalStatsPanel(JPanel)
     */
    public void setCurrentModeStatsPanel(JPanel panel) {
        currentModeStatsPanel.setLayout(new BoxLayout(currentModeStatsPanel, BoxLayout.Y_AXIS));
        currentModeStatsPanel.removeAll();
        currentModeStatsPanel.add(panel);
        currentModeStatsPanel.revalidate();
        currentModeStatsPanel.repaint();
    }

    /**
     * Gets the main panel of that class, which is the panel
     * that contains:
     * <ul>
     *     <li>The search bar</li>
     *     <li>The search button</li>
     *     <li>The different mode buttons</li>
     *     <li>Both panels for the global statistics and
     *         the current mode statistics</li>
     *     <li>The labels of those panels</li>
     * </ul>
     * @return The mainPanel data member of the class.
     * @see WindowGlobalStats#getMainPanel()
     * @see WindowBedWarsStats#getMainPanel()
     * @see WindowSkyWarsStats#getMainPanel()
     * @see WindowSkyBlockStats#getMainPanel()
     */
    public JPanel getMainPanel() {return mainPanel;}

    /**
     * This method displays all the statistics of the searched
     * player, which includes:
     * <ul>
     *     <li>The global statistics</li>
     *     <li>The BedWars statistics</li>
     *     <li>The SkyWars statistics</li>
     *     <li>The SkyBlock statistics</li>
     * </ul>
     * This method displays the BedWars statistics
     * by default, as well as the label of its panel,
     * which is 'BedWars Statistics'.
     * @param player The player whose statistics are
     *               all displayed.
     * @see WindowGlobalStats
     * @see WindowBedWarsStats
     * @see WindowSkyWarsStats
     * @see WindowSkyBlockStats
     * @see WindowPlayer#setGlobalStatsPanel(JPanel)
     * @see WindowGlobalStats#getMainPanel()
     * @see WindowPlayer#setCurrentModeStatsPanel(JPanel)
     * @see WindowBedWarsStats#getMainPanel()
     */
    public void displayAllStats(Player player){
        windowGlobalStats = new WindowGlobalStats(player);
        windowSkyWarsStats = new WindowSkyWarsStats(player);
        windowBedWarsStats = new WindowBedWarsStats(player);

        for (Map.Entry<String, String> entry : player.getGames().getSkyblock().getProfilesNames() .entrySet()) {
            String key = entry.getKey();
            String name = entry.getValue();
            windowSkyBlockStats = new WindowSkyBlockStats(player.getGames().getSkyblock().getProfile(key));
            JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    windowSkyBlockStats = new WindowSkyBlockStats(player.getGames().getSkyblock().getProfile(key));
                    setCurrentModeStatsPanel(windowSkyBlockStats.getMainPanel());
                }
            });
            skyblockProfilesButtonPanel.add(button);
        }
        setGlobalStatsPanel(windowGlobalStats.getMainPanel());
        currentModeStatisticsLabel.setText("BedWars Statistics");
        setCurrentModeStatsPanel(windowBedWarsStats.getMainPanel());
        isPlayerDisplayed = true;
    }
}
