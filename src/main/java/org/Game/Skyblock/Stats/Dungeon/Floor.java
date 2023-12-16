package org.Game.Skyblock.Stats.Dungeon;

import java.time.Duration;

public class Floor {
    String name;
    String mode;
    String timePlayed;
    String tierCompletions;
    String fastedTime;
    String bestScore;
    String mobKill;
    String mostHealing;
    String fastedS;
    String fastedSPlus;

    public Floor(String _name,String _mode,String _timePlayed,String _tierCompletions,String _fastedTime,String _bestScore,String _mobKill,String _mostHealing,String _fastedS,String _fastedSPlus) {
        try {
            name = _name;
            mode = _mode;
            timePlayed = millisecondToFormat(_timePlayed);
            tierCompletions = _tierCompletions;
            fastedTime = millisecondToFormat(_fastedTime);
            bestScore = _bestScore;
            mobKill = _mobKill;
            mostHealing = _mostHealing;
            fastedS = millisecondToFormat(_fastedS);
            fastedSPlus = millisecondToFormat(_fastedSPlus);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void display() {
        System.out.println(name);
        System.out.println(mode);
        System.out.println("Time Played : " + timePlayed);
        System.out.println("Tier Completitions : " + tierCompletions);
        System.out.println("Fasted Time : " + fastedTime);
        System.out.println("Best Score : " + bestScore);
        System.out.println("Mobs Kill : " + mobKill);
        System.out.println("Most Healing : " + mostHealing);
        System.out.println("Fasted S : " + fastedS);
        System.out.println("Fasted S+ : " + fastedSPlus);
    }
    public String millisecondToFormat(String millisecond) {
        if(millisecond.isEmpty())
            return "00:00:00";
        Duration duration = Duration.ofMillis((long) Double.parseDouble(millisecond));
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String getName() {
        return name;
    }

    public String getBestScore() {
        return bestScore;
    }

    public String getFastedS() {
        return fastedS;
    }

    public String getFastedSPlus() {
        return fastedSPlus;
    }

    public String getFastedTime() {
        return fastedTime;
    }

    public String getMobKill() {
        return mobKill;
    }

    public String getMode() {
        return mode;
    }

    public String getMostHealing() {
        return mostHealing;
    }

    public String getTierCompletions() {
        return tierCompletions;
    }

    public String getTimePlayed() {
        return timePlayed;
    }
}
