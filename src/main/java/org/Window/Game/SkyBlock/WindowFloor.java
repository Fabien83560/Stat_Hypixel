package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Dungeon.Floor;

import javax.swing.*;

public class WindowFloor {
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel modeLabel;
    private JLabel timePlayedLabel;
    private JLabel tierCompletionsLabel;
    private JLabel fastedTimeLabel;
    private JLabel bestScoreLabel;
    private JLabel mobKillLabel;
    private JLabel mostHealingLabel;
    private JLabel fastedSLabel;
    private JLabel fasyedSPlusLabel;

    public WindowFloor(Floor floor) {
        nameLabel.setText(floor.getName());
        modeLabel.setText(floor.getMode());
        timePlayedLabel.setText("Time Played : " + floor.getTimePlayed());
        tierCompletionsLabel.setText("Tier Completitions : " + floor.getTierCompletions());
        fastedTimeLabel.setText("Fasted Time : " + floor.getFastedTime());
        bestScoreLabel.setText("Best Score : " + floor.getBestScore());
        mobKillLabel.setText("Mobs Kills : " + floor.getMobKill());
        mostHealingLabel.setText("Most Healing : " + floor.getMostHealing());
        fastedSLabel.setText("Fasted S Run : " + floor.getFastedS());
        fasyedSPlusLabel.setText("Fasted S+ Run : " + floor.getFastedSPlus());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
