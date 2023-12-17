package org.Window.Game;

import org.Game.Bedwars.Bedwars;
import org.Game.GamesContainer;
import org.Player.Player;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * The WindowBedWarsStats class displays, in a non-editable table,
 * all the BedWars statistics of a player in the interface.
 * That is displayed by default in the interface, but can
 * also be displayed by clicking on the 'Bedwars' button if
 * another mode was displayed instead.
 */
public class WindowBedWarsStats extends JFrame {

    /**
     * The main panel of the WindowBedWarsStats class.
     * Displayed when the user wants to see the player's
     * Bedwars statistics.
     */
    private JPanel mainPanel;

    /**
     * The table that contains all the specific statistics
     * of the player in Bedwars mode.
     */
    private JTable statisticsTable;

    /**
     * A panel meant to display the global statistics
     * of the player in Bedwars mode, such as his coins, or wins.
     * This panel is displayed above the table of the specific
     * statistics of the player.
     */
    private JPanel globalStatsBedwars;

    /**
     * Constructor of the WindowBedWarsStats class.
     * It uses a Player instance as a parameter to
     * get the Bedwars statistics of that said player.
     * It then will display the table of all the statistics,
     * as well as the global ones right above that table.
     * @param player A Player Object to get the Bedwars
     *               statistics of.
     * @see NonEditableTableModel
     * @see Bedwars
     * @see Bedwars#getStatistics(String)
     * @see Bedwars#getModes()
     * @see Player#getGames()
     * @see GamesContainer#getBedwars()
     * @see org.Game.Bedwars.BedwarsModeContainer#getStatistics(String)
     * @see #setStatisticsTable(JTable)
     */
    public WindowBedWarsStats(Player player) {
        if(player.getGames().getBedwars() != null) {
            String[] columns = {"","1v1", "2v2", "3v3", "4v4"};
            String[] rows = {"","Games Played", "Winstreak", "Wins", "Losses", "Ratio Wins / Losses","",
                    "Kills", "Deaths", "Ratio Kills / Deaths", "", "Final Kills", "Final Deaths",
                    "Ratio Final K / D", "", "Beds Brokens", "Beds Losts", "Ratio Beds B / L"};
            String[] modesList = {"eight_one", "eight_two", "four_three", "four_four"};
            String[] statsList = {"games_played_bedwars" , "winstreak" , "wins_bedwars" , "losses_bedwars" ,
                    "","", "kills_bedwars" , "deaths_bedwars" ,"","", "final_kills_bedwars" ,"final_kills_bedwars","","",
                    "beds_broken_bedwars" , "beds_lost_bedwars", ""};

            DefaultTableModel model = new NonEditableTableModel(columns, rows.length);
            Bedwars bedwars = player.getGames().getBedwars();

            Box hbox = Box.createHorizontalBox();
            String[] globalBedwarsStats = {"games_played_bedwars" , "wins_bedwars" , "kills_bedwars" , "beds_broken_bedwars" , "final_kills_bedwars" , "coins"};
            for(String value : globalBedwarsStats)
            {
                JLabel lab = new JLabel();
                String res = bedwars.getStatistics(value);
                switch(value) {
                    case "games_played_bedwars":
                        lab.setText("Global Game Played : " + res + " | ");
                        break;
                    case "wins_bedwars":
                        lab.setText("Global Wins : " + res + " | ");
                        break;
                    case "kills_bedwars":
                        lab.setText("Global Kills : " + res + " | ");
                        break;
                    case "beds_broken_bedwars":
                        lab.setText("Global Beds Broken : " + res + " | ");
                        break;
                    case "final_kills_bedwars":
                        lab.setText("Global Final Kills : " + res + " | ");
                        break;
                    case "coins":
                        lab.setText("Coins : " + res);
                        break;
                    default:
                        break;
                }

                lab.setFont(new Font("Cascadia Code", Font.PLAIN, 16));
                hbox.add(lab);
            }
            globalStatsBedwars.add(hbox);

            for(int i = 0;i < columns.length;i++)
                model.setValueAt(columns[i],0,i);
            for(int i = 0;i < rows.length;i++)
                model.setValueAt(rows[i],i,0);
            for(int i = 0;i < modesList.length;i++)
            {
                for(int j = 0;j < statsList.length;j++)
                    model.setValueAt(bedwars.getModes().getStatistics(modesList[i] + "_" + statsList[j]),j+1,i+1);
            }

            int[] ratio = {5,9,13,17};
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
            mainPanel.add(new JLabel("This player has never Played BedWars"));
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

/**
 * This class creates a NonEditableTableModel instance in order
 * for the table of the Bedwars statistics not to be editable by
 * the user. The WindowBedWarsStats class calls it.
 */
class NonEditableTableModel extends DefaultTableModel {

    /**
     * Constructor of the NonEditableTableModel class
     * @param columnNames A List containing the name of the
     *                    columns of the table.
     * @param rowCount The number of rows of the table.
     */
    NonEditableTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    /**
     * Makes sure that all the cells of the table can't be edited
     * by the user.
     * @param row The row whose value is to be queried
     * @param column The column whose value is to be queried
     * @return false in any case.
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}