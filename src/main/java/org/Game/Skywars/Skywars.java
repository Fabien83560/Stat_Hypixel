package org.Game.Skywars;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * This class instantiates the Skywars mode of the Hypixel server.
 * It creates a list of String containing the global statistics
 * (wins, deaths, losses, kills) and as always, creates an empty
 * Map Object that will contain all the global statistics of the
 * Skywars mode.
 */
public class Skywars {

    /**
     * A list of the different type of global statistics in the Skywars mode.
     */
    static final String[] statsList = {"wins" , "deaths" , "losses" , "kills"};

    /**
     * A Map that will contain all the global statistics of the BedWars mode,
     * based on the list of types of global statistics in Bedwars mode.
     * @see #statsList
     * @see #Skywars(JSONObject)
     */
    Map<String,String> statistics = new HashMap<>();

    /**
     * This data member contains all the different modes available
     * in the Skywars mode.
     */
    SkywarsModeContainer modes;

    /**
     * Constructor of the Skywars class, taking a JSONObject
     * as a parameter, that will allow to add all the statistics
     * of the player into the empty Map. Also creates an instance
     * of the SkywarsModeContainer class to get all the more
     * specific statistics of the player, in that mode.
     * @param stats A JSONObject used to search and add into the
     *              Map each statistic.
     * @see Skywars#addStatistics(String, String)
     * @see SkywarsModeContainer#SkywarsModeContainer(JSONObject)
     */
    public Skywars(JSONObject stats)
    {
        for(String stat : statsList)
            try {
                addStatistics(stat, String.valueOf(stats.get(stat)));
            }
            catch (Exception e) {
                addStatistics(stat, "N/A");
            }

        modes = new SkywarsModeContainer(stats);
    }

    /**
     * This function add a pair 'key, value' into the Map containing
     * the statistics of the player, in Skywars mode, if the key 'key' isn't
     * already associated with a value.
     * @param key A String containing the key to associate to a value in the Map Object.
     * @param value A String containing the value to add into the Map, coupled with the key.
     */
    public void addStatistics(String key, String value)
    {
        statistics.putIfAbsent(key,value);
    }

    /**
     * Gets the SkywarsModeContainer member data of the Skywars class.
     * @return the SkywarsModeContainer Object, named 'modes'.
     */
    public SkywarsModeContainer getModes() {
        return modes;
    }
}
