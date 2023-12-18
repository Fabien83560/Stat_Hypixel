package org.Game.Skyblock.Stats.Dungeon;

import org.json.JSONObject;
import java.time.Duration;

/**
 * This class implements the Floor statistics of
 * a player's profile in Skyblock.
 */
public class Floor {

    /**
     * String containing the name of the current floor in the Floor mode in Skyblock.
     */
    String name;

    /**
     * String containing the name of the floor mode (catacombs or master_catacombs) in the Floor mode in Skyblock.
     */
    String mode;

    /**
     * String containing the time the player spent playing in the Floor mode in Skyblock.
     */
    String timePlayed;

    /**
     * String containing the number of times the 'catacombs' or 'master_catacombs' mode has been
     * completed in the Floor mode in Skyblock.
     */
    String tierCompletions;

    /**
     * String containing the fastest time the played made in the Floor mode in Skyblock.
     */
    String fastedTime;

    /**
     * String containing the best score of the player in the Floor mode in Skyblock.
     */
    String bestScore;

    /**
     * String containing the total number of mobs killed by the player in the Floor mode in Skyblock.
     */
    String mobKill;

    /**
     * String containing the total value of the player's HP that has been healed in the Floor mode in Skyblock.
     */
    String mostHealing;

    /**
     * String containing the fastest time the player did for the S rank in the Floor mode in Skyblock.
     */
    String fastedS;

    /**
     * String containing the fastest time the player did for the SPlus rank in the Floor mode in Skyblock.
     */
    String fastedSPlus;

    /**
     * Constructor of the Floor class. It initializes all the data
     * members of the class. It is only called by the Dungeon class
     * constructor.
     * @param _name The name of the floor.
     * @param _mode The name of the floor mode.
     * @param _timePlayed The time spent by the player in that mode.
     * @param _tierCompletions The number of times the mode has been completed.
     * @param _fastedTime The fastest time to complete the floor mode.
     * @param _bestScore The best score of the player in the floor mode.
     * @param _mobKill The number of mobs killed by the player in the floor mode.
     * @param _mostHealing The value of the player's HP that has been healed in floor mode.
     * @param _fastedS The value of the fastest time done in the S rank by the player.
     * @param _fastedSPlus The value of the fastest time done in the SPlus rank by the player.
     * @see Dungeon#Dungeon(JSONObject)
     */
    public Floor(String _name, String _mode, String _timePlayed, String _tierCompletions, String _fastedTime, String _bestScore, String _mobKill, String _mostHealing, String _fastedS, String _fastedSPlus) {
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

    /**
     * This method converts a String Object containing a
     * millisecond value format to a String Object containing
     * the hh:mm:ss pattern format. Uses the Duration class.
     * @param millisecond String containing the time, in milliseconds.
     * @return A String containing that same time converted in hours,
     * minutes, seconds. Returns "00:00:00" if the parameter is empty.
     */
    public String millisecondToFormat(String millisecond) {
        if(millisecond.isEmpty())
            return "00:00:00";
        Duration duration = Duration.ofMillis((long) Double.parseDouble(millisecond));
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /**
     * Gets the 'name' member of the class.
     * @return A String Object.
     * @see Floor#name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the 'bestScore' member of the class.
     * @return A String Object.
     * @see Floor#bestScore
     */
    public String getBestScore() {
        return bestScore;
    }

    /**
     * Gets the 'fastedS' member of the class.
     * @return A String Object.
     * @see Floor#fastedS
     */
    public String getFastedS() {
        return fastedS;
    }

    /**
     * Gets the 'fastedSPlus' member of the class.
     * @return A String Object.
     * @see Floor#fastedSPlus
     */
    public String getFastedSPlus() {
        return fastedSPlus;
    }

    /**
     * Gets the 'fastedTime' member of the class.
     * @return A String Object.
     * @see Floor#fastedTime
     */
    public String getFastedTime() {
        return fastedTime;
    }

    /**
     * Gets the 'mobKill' member of the class.
     * @return A String Object.
     * @see Floor#mobKill
     */
    public String getMobKill() {
        return mobKill;
    }

    /**
     * Gets the 'mode' member of the class.
     * @return A String Object.
     * @see Floor#mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * Gets the 'mostHealing' member of the class.
     * @return A String Object.
     * @see Floor#mostHealing
     */
    public String getMostHealing() {
        return mostHealing;
    }

    /**
     * Gets the 'tierCompletions' member of the class.
     * @return A String Object.
     * @see Floor#tierCompletions
     */
    public String getTierCompletions() {
        return tierCompletions;
    }

    /**
     * Gets the 'timePlayed' member of the class.
     * @return A String Object.
     * @see Floor#timePlayed
     */
    public String getTimePlayed() {
        return timePlayed;
    }
}
