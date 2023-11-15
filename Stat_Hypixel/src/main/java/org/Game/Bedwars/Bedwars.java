package org.Game.Bedwars;

import org.eclipse.jetty.util.ajax.JSON;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Bedwars {
    static final String[] statsList = {"wins_bedwars" , "kills_bedwars" , "beds_broken_bedwars" , "beds_lost_bedwars" , "final_kills_bedwars" , "games_played_bedwars" , "deaths_bedwars" , "coins"};
    Map<String, String> statistics = new HashMap<>();
    ModeContainer modes;
    public Bedwars(JSONObject stats, JSONObject achievements)
    {
        addStatistics("level", String.valueOf(achievements.getLong("bedwars_level")));

        for(String stat : statsList)
            addStatistics(stat,String.valueOf(stats.getLong(stat)));

        this.modes = new ModeContainer(stats);
    }
    public void addStatistics(String key, String value)
    {
        this.statistics.putIfAbsent(key,value);
    }
    public String getStatistics(String key)
    {
        return this.statistics.get(key);
    }
    public void display(){
        System.out.println("Global Bedwars Statistics");
        for(String stat : statsList)
            System.out.println(stat + " : " + getStatistics(stat));
        System.out.println();

        this.modes.display();
    }
}