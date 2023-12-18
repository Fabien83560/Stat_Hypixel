package org.Game.Bedwars;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * This class implements the Bedwars mode from the Hypixel
 * Minecraft server. It creates a list of String containing the
 * different types of global statistics of a player in this mode in order to
 * create a Map of 'String, String' that will contain all the BedWars
 * global statistics of a player in that current mode.
 */
public class Bedwars {

    /**
     * A list of the different type of global statistics in the Bedwars mode.
     */
    static final String[] statsList = {"wins_bedwars" , "kills_bedwars" , "beds_broken_bedwars" , "beds_lost_bedwars" , "final_kills_bedwars" , "games_played_bedwars" , "deaths_bedwars" , "coins"};

    /**
     * A Map that will contain all the global statistics of the BedWars mode,
     * based on the list of types of global statistics in Bedwars mode.
     * @see #statsList
     * @see #Bedwars(JSONObject, JSONObject)
     */
    Map<String, String> statistics = new HashMap<>();

    /**
     * This data member contains all the different modes available
     * in the Bedwars mode.
     */
    BedwarsModeContainer modes;

    /**
     * Constructor of the Bedwars class. It takes two parameters,
     * both JSONObject, the first one being all the statistics of the
     * player, the second one being the achievements of the player.
     * The constructor adds all the statistics of the BedWars mode
     * into a Map that will be used to display those in the user
     * interface.
     * @param stats A JSONObject containing all the statistics of the
     *              player in Bedwars mode.
     * @param achievements A JSONObject containing all the achievements
     *                     of the player in Bedwars mode.
     * @see Bedwars#addStatistics(String, String)
     * @see BedwarsModeContainer#BedwarsModeContainer(JSONObject)
     */
    public Bedwars(JSONObject stats, JSONObject achievements)
    {
        addStatistics("level", String.valueOf(achievements.get("bedwars_level")));

        for(String stat : statsList)
            try {
                addStatistics(stat, String.valueOf(stats.get(stat)));
            }
            catch (Exception e) {
                addStatistics(stat, "N/A");
            }

        modes = new BedwarsModeContainer(stats);
    }

    /**
     * This function adds a pair 'key, value' into the Map containing
     * the statistics of the player, in Bedwars mode, if the key 'key' isn't
     * already associated with a value.
     * @param key A String containing the key to associate to a value in the Map Object.
     * @param value A String containing the value to add into the Map, coupled with the key.
     */
    public void addStatistics(String key, String value)
    {
        statistics.putIfAbsent(key, value);
    }

    /**
     * Gets the value of the specified key in the 'statistics' Map by returning a String.
     * @param key the key whose associated value is returned.
     * @return A String containing the value associated to the key, if the key exists, and
     *         null otherwise.
     */
    public String getStatistics(String key)
    {
        return statistics.get(key);
    }

    /**
     * Gets the BedwarsModeContainer member data of the Bedwars class.
     * @return The BedwarsModeContainer Object, named 'modes'.
     */
    public BedwarsModeContainer getModes() { return modes;}
}