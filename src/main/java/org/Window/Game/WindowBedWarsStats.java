package org.Window.Game;

import org.Game.Bedwars.Bedwars;
import org.Player.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Timestamp;
import java.util.Date;

public class WindowBedWarsStats extends JFrame {
    private JPanel mainPanel;
    private JTable statisticsTable;
    private JPanel testPanel;


    public WindowBedWarsStats() {

    }
    public WindowBedWarsStats(Player player) {
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
                    lab.setText("Coins : " + res + " ");
                    break;
                default:
                    break;
            }

            lab.setFont(new Font("Cascadia Code", Font.PLAIN, 16));
            hbox.add(lab);
        }
        testPanel.add(hbox);

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
                    model.setValueAt(String.valueOf(Integer.parseInt(model.getValueAt(row - 2, column).toString()) / Integer.parseInt(model.getValueAt(row - 1, column).toString())), row, column);
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

    public JPanel getMainPanel(){return mainPanel;}

    public void setStatisticsTable(JTable statisticsTable) {
        this.statisticsTable = statisticsTable;
    }
}

class NonEditableTableModel extends DefaultTableModel {
    NonEditableTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}