package org.Window.Game;

import org.Game.GamesContainer;
import org.Game.Skywars.Skywars;
import org.Player.Player;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

/**
 * The WindowSkyWarsStats class does the exact
 * same thing than the WindowBedWarsStats class,
 * Only the statistics of the player passed as a
 * parameter of the constructor change.
 * @see WindowBedWarsStats
 */
public class WindowSkyWarsStats {

    /**
     * The main panel of the WindowSkyWarsStats class.
     * Displayed when the user wants to see the player's
     * Skywars statistics.
     */
    private JPanel mainPanel;

    /**
     * The table that contains all the specific statistics
     * of the player in Skywars mode.
     */
    private JTable statisticsTable;

    /**
     * Constructor of the WindowSkyWarsStats class.
     * It uses a Player instance as a parameter to
     * get the Skywars statistics of that said player.
     * It then will display the table of all the statistics,
     * as well as the global ones right above that table.
     * @param player A Player Object to get the Skywars
     *               statistics of.
     * @see WindowBedWarsStats
     * @see NonEditableTableModel
     * @see Player#getGames()
     * @see GamesContainer#getSkywars()
     * @see Skywars#getModes()
     * @see org.Game.Skywars.SkywarsModeContainer#getStatistics(String)
     * @see #setStatisticsTable(JTable)
     */
    public WindowSkyWarsStats(Player player) {
        if(player.getGames().getSkywars() != null)
        {
            String[] columns = {"","Solo Normal", "Solo Insane", "Team Normal", "Team Insane"};
            String[] rows = {"","Kills", "Deaths", "Ratio K / D", "", "Wins", "Losses", "Ratio W / L"};
            String[] modesList = {"solo_normal", "solo_insane", "team_normal", "team_insane"};
            String[] statsList = {"", "kills", "deaths","", "", "wins", "losses", "", ""};

            DefaultTableModel model = new NonEditableTableModel(columns, rows.length);
            Skywars skywars = player.getGames().getSkywars();

            for(int i = 0;i < modesList.length;i++)
            {
                for(int j = 0;j < statsList.length - 1;j++)
                    model.setValueAt(skywars.getModes().getStatistics(modesList[i] + "_" + statsList[j]), j, i + 1);
            }
            for(int i = 0;i < columns.length;i++)
                model.setValueAt(columns[i],0,i);
            for(int i = 0;i < rows.length;i++)
                model.setValueAt(rows[i],i,0);

            int[] ratio = {3,7};
            for(int row : ratio) {
                for (int column = 1; column != 5; column++) {
                    try {
                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        double result = Double.parseDouble(model.getValueAt(row - 2, column).toString()) / Double.parseDouble(model.getValueAt(row - 1, column).toString());
                        model.setValueAt(String.valueOf(decimalFormat.format(result)), row, column);
                    }
                    catch (Exception e) {
                        model.setValueAt("N/A",row,column);
                    }
                }
            }

            JTable table = new JTable(model);

            table.setCellSelectionEnabled(false);
            table.setRowSelectionAllowed(false);
            setStatisticsTable(table);
            mainPanel.add(statisticsTable);
        }
        else
        {
            mainPanel.add(new JLabel("This player has never Played SkyWars"));
        }
    }

    /**
     * Gets the main panel of that class, which contains
     * the table and the global stats that are right above
     * that table.
     * @return The main panel of that class.
     */
    public JPanel getMainPanel(){return mainPanel;}

    /**
     * Sets the JTable to display in the main panel.
     * @param _statisticsTable The JTable Object to display
     *                         in the main panel.
     */
    public void setStatisticsTable(JTable _statisticsTable) {
        statisticsTable = _statisticsTable;
    }
}
