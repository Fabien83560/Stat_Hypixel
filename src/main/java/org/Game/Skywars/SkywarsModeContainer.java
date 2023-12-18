package org.Game.Skywars;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * This class implements specific statistics of the Skywars mode
 * from Hypixel. It creates two lists of String, one containing the
 * modes of the Skywars (displayed as columns in the current mode panel),
 * the other containing the different types of statistics of the player
 * (statistics displayed as rows in the table of the current mode panel).
 * And, like the Skywars class, it creates an empty Map meant to store
 * all the statistics of the player.
 */
public class SkywarsModeContainer {

    /**
     * List of specific modes available in the Skywars mode.
     */
    static final String[] modesList = {"solo" , "solo_normal" , "solo_insane", "team", "team_normal", "team_insane"};

    /**
     * List of all the different specific statistics available in the Skywars mode.
     */
    static final String[] statsList = {"wins" , "deaths" , "losses" , "kills"};

    /**
     * A Map that will contain all the specific statistics of the Skywars mode,
     * based on the list of specific modes available and on the different specific
     * statistics available.
     * @see #modesList
     * @see #statsList
     * @see #SkywarsModeContainer(JSONObject)
     */
    Map<String, String> statistics = new HashMap<>();

    /**
     * Constructor of the SkywarsModeContainer class. It takes a
     * JSONObject parameter 'stats', containing all the statistics
     * of the player in the Skywars mode.
     * @param stats A JSONObject meant to get all the specific
     *              statistics of the player in Skywars.
     * @see #addStatistics(String, String)
     * @see #calculateNormalStats()
     */
    public SkywarsModeContainer(JSONObject stats)
    {
        for (String mode : modesList)
            for (String stat : statsList) {
                try {
                    addStatistics(mode + "_" + stat, String.valueOf(stats.get(stat + "_" + mode)));
                }
                catch (Exception e) {
                    addStatistics(mode + "_" + stat, "N/A");
                }
            }
        calculateNormalStats();
    }

    /**
     * Add a statistic in the Map, with two parameters 'key', 'value', both String.
     * It will add into the Map the pair 'key, value' if and only if the key isn't
     * already mapped to a value, or if mapped to the null value.
     * @param key A String containing the key associated to the value.
     * @param value A String containing the value of the key it's paired with.
     */
    public void addStatistics(String key, String value)
    {
        statistics.putIfAbsent(key,value);
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

    /**
     * Calculate the statistics of the 'normal' modes of the Skywars mode, by
     * subtracting the total of the statistics to the 'insane' statistics of
     * the player in Skywars mode. This method then add the result into the Map,
     * which will display the statistics in a table.
     * @see #getStatistics(String)
     * @see #addStatistics(String, String)
     */
    public void calculateNormalStats()
    {
        for(String stat : statsList)
            try {
                String stat_total = getStatistics("team_" + stat);
                String stat_insane = getStatistics("team_insane_" + stat);
                long result = Long.parseLong(stat_total) - Long.parseLong(stat_insane);
                addStatistics("team_normal_" + stat , String.valueOf(result));
            }
            catch (Exception e) {
                addStatistics("team_normal_" + stat , "N/A");
            }
    }
}
