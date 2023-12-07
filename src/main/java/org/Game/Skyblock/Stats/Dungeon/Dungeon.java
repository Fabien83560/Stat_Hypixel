package org.Game.Skyblock.Stats.Dungeon;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    String catacomb;
    String mage;
    String archer;
    String tank;
    String berserk;
    String healer;
    List<Floor> floorList = new ArrayList<>();

    public Dungeon(JSONObject dungeonObject) {
        catacomb = String.valueOf(dungeonObject.getJSONObject("dungeon_types").getJSONObject("catacombs").get("experience"));
        mage = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("mage").get("experience"));
        archer = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("archer").get("experience"));
        tank = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("tank").get("experience"));
        berserk = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("berserk").get("experience"));
        healer = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("healer").get("experience"));
        String[] mode = {"catacombs","master_catacombs"};
        for(String m : mode) {
            JSONObject modeObject = dungeonObject.getJSONObject("dungeon_types").getJSONObject(m);
            for (int i = 0; i < 8; i++) {
                try {
                    String timePlayed = "";
                    if(m.equals("catacombs"))
                        timePlayed = String.valueOf(modeObject.getJSONObject("times_played").get(String.valueOf(i)));
                    if( ! (m.equals("master_catacombs") && i == 0)) {
                        String tierCompletions = "";
                        try {
                            tierCompletions = String.valueOf(modeObject.getJSONObject("tier_completions").get(String.valueOf(i)));
                        }
                        catch (JSONException e) {}
                        String fastedTime = "";
                        try {
                            fastedTime = String.valueOf(modeObject.getJSONObject("fastest_time").get(String.valueOf(i)));
                        }
                        catch (JSONException e) {}
                        String bestScore = "";
                        try {
                            bestScore = String.valueOf(modeObject.getJSONObject("best_score").get(String.valueOf(i)));
                        }
                        catch (JSONException e) {}
                        String mobKill = "";
                        try {
                            mobKill = String.valueOf(modeObject.getJSONObject("mobs_killed").get(String.valueOf(i)));
                        }
                        catch (JSONException e) {}
                        String mostHealing = "";
                        try {
                            mostHealing = String.valueOf(modeObject.getJSONObject("most_healing").get(String.valueOf(i)));
                        }
                        catch (JSONException e) {}
                        String fastedS = "";
                        try {
                            fastedS = String.valueOf(modeObject.getJSONObject("fastest_time_s").get(String.valueOf(i)));
                        }
                        catch (JSONException e) {}
                        String fastedSPlus = "";
                        try {
                            fastedSPlus = String.valueOf(modeObject.getJSONObject("fastest_time_s_plus").get(String.valueOf(i)));
                        }
                        catch (JSONException  e) {}

                        floorList.add(new Floor("Floor_" + i,m,timePlayed,tierCompletions,fastedTime,bestScore,mobKill,mostHealing,fastedS,fastedSPlus));
                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void display() {
        System.out.println("DUNGEONS");
        System.out.println("Cataconb Exp : " +catacomb);
        System.out.println("Mage Exp : " + mage);
        System.out.println("Acher Exp : " + archer);
        System.out.println("Tank Exp : " + tank);
        System.out.println("berserk Exp : " + berserk);
        System.out.println("Healer Exp : " + healer);
        for(Floor floor : floorList) {
            System.out.println("----------------");
            floor.display();
        }
    }
}
