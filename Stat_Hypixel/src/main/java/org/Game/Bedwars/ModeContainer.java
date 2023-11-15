package org.Game.Bedwars;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ModeContainer {
    static final String[] modesList = {"eight_one", "eight_two", "four_three", "four_four"};
    static final String[] statsList = {"games_played_bedwars" , "wins_bedwars" , "losses_bedwars" , "kills_bedwars" , "deaths_bedwars" , "final_kills_bedwars" , "winstreak" , "beds_broken_bedwars" , "beds_lost_bedwars"};
    Map<String, String> statistics = new HashMap<>();
    public ModeContainer(JSONObject stats)
    {
        for (String mode : modesList)
            for (String stat : statsList)
                addStatistics(mode + "_" + stat , String.valueOf(stats.getLong(mode + "_" + stat)));
    }
    public void addStatistics(String key, String value)
    {
        this.statistics.putIfAbsent(key,value);
    }
    public String getStatistics(String key)
    {
        return this.statistics.get(key);
    }

    public void display()
    {
        for(String mode : modesList)
        {
            for (String stat : statsList)
                System.out.println(stat + " : " + getStatistics(mode + "_" + stat));
            System.out.println();
        }
    }
}