package org.Game.Skywars;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Skywars {
    static final String[] statsList = {"wins" , "deaths" , "losses" , "kills"};
    Map<String,String> statistics = new HashMap<>();
    SkywarsModeContainer modes;
    public Skywars(JSONObject stats)
    {
        for(String stat : statsList) {
            try {
                addStatistics(stat, String.valueOf(stats.get(stat)));
            } catch (Exception e) {
                addStatistics(stat, "N/A");
            }
        }
        this.modes = new SkywarsModeContainer(stats);
    }
    public void addStatistics(String key, String value)
    {
        this.statistics.putIfAbsent(key,value);
    }
    public String getStatistics(String key)
    {
        return this.statistics.get(key);
    }

    public SkywarsModeContainer getModes() {
        return modes;
    }

    public void display()
    {
        System.out.println("Global SkyWars Statistics");
        for(String stat : statsList)
            System.out.println("Global " + stat + " : " + getStatistics(stat));
        System.out.println();

        this.modes.display();
    }
}
