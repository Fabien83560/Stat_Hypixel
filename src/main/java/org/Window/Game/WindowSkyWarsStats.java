package org.Window.Game;

import org.Game.Skywars.Skywars;
import org.Player.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

public class WindowSkyWarsStats {
    private JPanel mainPanel;
    private JTable statisticsTable;

    public WindowSkyWarsStats() {

    }
    public WindowSkyWarsStats(Player player) {
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

    public void setStatisticsTable(JTable statisticsTable) {
        this.statisticsTable = statisticsTable;
    }

    public JPanel getMainPanel(){return mainPanel;}
}
