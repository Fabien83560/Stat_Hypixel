package org.Game.Bedwars;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Bedwars {
    static final String[] statsList = {"wins_bedwars" , "kills_bedwars" , "beds_broken_bedwars" , "beds_lost_bedwars" , "final_kills_bedwars" , "games_played_bedwars" , "deaths_bedwars" , "coins"};
    Map<String, String> statistics = new HashMap<>();
    BedwarsModeContainer modes;
    public Bedwars(JSONObject stats, JSONObject achievements)
    {
        addStatistics("level", String.valueOf(achievements.get("bedwars_level")));

        for(String stat : statsList) {
            try {
                addStatistics(stat, String.valueOf(stats.get(stat)));
            }
            catch (Exception e) {
                addStatistics(stat, "N/A");
            }
        }

        this.modes = new BedwarsModeContainer(stats);
    }
    public void addStatistics(String key, String value)
    {
        this.statistics.putIfAbsent(key,value);
    }
    public String getStatistics(String key)
    {
        return this.statistics.get(key);
    }
    public BedwarsModeContainer getModes() { return modes;}
    public String[] getStatsList() {
        return statsList;
    }

    public void display(){
        System.out.println("Global Bedwars Statistics");
        for(String stat : statsList)
            System.out.println(stat + " : " + getStatistics(stat));
        System.out.println();

        this.modes.display();
    }
}