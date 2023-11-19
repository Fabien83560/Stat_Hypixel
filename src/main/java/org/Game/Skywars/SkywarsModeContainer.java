package org.Game.Skywars;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SkywarsModeContainer {
    static final String[] modesList = {"solo" , "solo_normal" , "solo_insane", "team", "team_insane"};
    static final String[] statsList = {"wins" , "deaths" , "losses" , "kills"};
    Map<String, String> statistics = new HashMap<>();
    public SkywarsModeContainer(JSONObject stats)
    {
        for (String mode : modesList)
            for (String stat : statsList) {
                try {
                    addStatistics(mode + "_" + stat, String.valueOf(stats.get(stat + "_" + mode)));
                } catch (Exception e) {
                    addStatistics(mode + "_" + stat, "N/A");
                }
            }
        calculateNormalStats();
    }
    public void addStatistics(String key, String value)
    {
        this.statistics.putIfAbsent(key,value);
    }
    public String getStatistics(String key)
    {
        return this.statistics.get(key);
    }
    public void calculateNormalStats()
    {
        String [] normalStats = {"team"};
        for(String mode : normalStats)
            for(String stat : statsList)
            {
                try {
                    String stat_total = getStatistics(mode + "_" + stat);
                    String stat_insane = getStatistics(mode + "_insane_" + stat);
                    long result = Long.parseLong(stat_total) - Long.parseLong(stat_insane);
                    addStatistics(mode + "_normal_" + stat , String.valueOf(result));
                }
                catch (Exception e) {
                    addStatistics(mode + "_normal_" + stat , "N/A");
                }

            }
    }
    public void display()
    {
        for(String mode : modesList) {
            for (String stat : statsList)
                System.out.println(mode + " " + stat + " : " + getStatistics(mode + "_" + stat));
            System.out.println();
        }

        for(String stat : statsList)
            System.out.println("team_normal " + stat + " : " + getStatistics("team_normal_" + stat));
        System.out.println();
    }
}
