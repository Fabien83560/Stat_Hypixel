package org.Game.Bedwars;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * This class implements specific statistics of the Bedwars mode
 * from Hypixel. It creates two lists of String, one containing the
 * modes of the Bedwars (displayed above the table of the current mode panel),
 * the other containing the different types of statistics of the player
 * (statistics displayed in the table of the current mode panel).
 * And, like the Bedwars class, it creates an empty Map meant to store
 * all the statistics of the player.
 */
public class BedwarsModeContainer {

    /**
     * List of specific modes available in the Bedwars mode.
     */
    static final String[] modesList = {"eight_one", "eight_two", "four_three", "four_four"};

    /**
     * List of all the different specific statistics available in the Bedwars mode.
     */
    static final String[] statsList = {"games_played_bedwars" , "wins_bedwars" , "losses_bedwars" , "kills_bedwars" , "deaths_bedwars" , "final_kills_bedwars" ,"final_deaths_bedwars", "winstreak" , "beds_broken_bedwars" , "beds_lost_bedwars"};

    /**
     * A Map that will contain all the specific statistics of the Bedwars mode,
     * based on the list of specific modes available and on the different specific
     * statistics available.
     * @see #modesList
     * @see #statsList
     * @see #BedwarsModeContainer(JSONObject)
     */
    Map<String, String> statistics = new HashMap<>();

    /**
     * Constructor of the BedwarsModeContainer class. It takes a
     * JSONObject parameter 'stats', containing all the statistics
     * of the player in the Bedwars mode.
     * @param stats A JSONObject meant to get all the specific
     *              statistics of the player in Bedwars.
     */
    public BedwarsModeContainer(JSONObject stats)
    {
        for (String mode : modesList)
            for (String stat : statsList)
                try {
                    addStatistics(mode + "_" + stat, String.valueOf(stats.get(mode + "_" + stat)));
                }
                catch (Exception e) {
                    addStatistics(mode + "_" + stat, "N/A");
                }
    }

    /**
     * Add a statistic in the Map, with two parameters 'key', 'value', both String.
     * It will add into the Map that pair if and only if the key isn't
     * already mapped to a value, or if mapped to the null value.
     * @param key A String containing the key associated to the value.
     * @param value A String containing the value of the key it's paired with.
     */
    public void addStatistics(String key, String value)
    {
        statistics.putIfAbsent(key, value);
    }

    /**
     * Gets the value of the statistic associated with the key 'key', if it exists.
     * @param key The key used to get its value.
     * @return A String containing the value linked to the key.
     */
    public String getStatistics(String key)
    {
        return statistics.get(key);
    }
}