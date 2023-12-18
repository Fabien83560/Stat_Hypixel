package org.Game.Skyblock.Stats.Dungeon;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Dungeon statistics of
 * a player's profile in Skyblock.
 */
public class Dungeon {

    /**
     * String containing the dungeon experience of the Dungeon in Skyblock.
     */
    String catacomb;

    /**
     * String containing the experience of the mage class of the Dungeon in Skyblock.
     */
    String mage;

    /**
     * String containing the experience of the archer class of the Dungeon in Skyblock.
     */
    String archer;

    /**
     * String containing the experience of the tank class of the Dungeon in Skyblock.
     */
    String tank;

    /**
     * String containing the experience of the berserk class of the Dungeon in Skyblock.
     */
    String berserk;

    /**
     * String containing the experience of the healer class of the Dungeon in Skyblock.
     */
    String healer;

    /**
     * List containing the different floors of the Dungeon that a player unlocked in Skyblock.
     */
    List<Floor> floorList = new ArrayList<>();

    /**
     * Constructor of the Dungeon class. The parameter is a
     * JSONObject containing the Dungeon data of the API.
     * @param dungeonObject A JSONObject containing all the data
     *                      of the Dungeon.
     */
    public Dungeon(JSONObject dungeonObject) {
        try {
            catacomb = String.valueOf(dungeonObject.getJSONObject("dungeon_types").getJSONObject("catacombs").get("experience"));
        }
        catch (JSONException e)
        {
            catacomb = "0";
        }
        try {
            mage = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("mage").get("experience"));
        }
        catch (JSONException e)
        {
            mage = "0";
        }
        try {
            archer = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("archer").get("experience"));
        }
        catch (JSONException e)
        {
            archer = "0";
        }
        try {
            tank = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("tank").get("experience"));
        }
        catch (JSONException e)
        {
            tank = "0";
        }
        try {
            berserk = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("berserk").get("experience"));
        }
        catch (JSONException e)
        {
            berserk = "0";
        }
        try {
            healer = String.valueOf(dungeonObject.getJSONObject("player_classes").getJSONObject("healer").get("experience"));
        }
        catch (JSONException e)
        {
            healer = "0";
        }
        if( ! (catacomb.equals("0"))) {
            String[] mode = {"catacombs", "master_catacombs"};
            for (String m : mode) {
                JSONObject modeObject = dungeonObject.getJSONObject("dungeon_types").getJSONObject(m);
                for (int i = 0; i < 8; i++) {
                    try {
                        String timePlayed = "";
                        if (m.equals("catacombs")) {
                            try {
                                timePlayed = String.valueOf(modeObject.getJSONObject("times_played").get(String.valueOf(i)));
                            }
                            catch (JSONException e)
                            {
                                timePlayed = "0";
                            }
                        }
                        if (!(m.equals("master_catacombs") && i == 0)) {
                            String tierCompletions = "";
                            try {
                                tierCompletions = String.valueOf(modeObject.getJSONObject("tier_completions").get(String.valueOf(i)));
                            }
                            catch (JSONException e)
                            {
                                tierCompletions = "0";
                            }
                            String fastedTime = "";
                            try {
                                fastedTime = String.valueOf(modeObject.getJSONObject("fastest_time").get(String.valueOf(i)));
                            }
                            catch (JSONException e)
                            {
                                fastedTime = "0";
                            }
                            String bestScore = "";
                            try {
                                bestScore = String.valueOf(modeObject.getJSONObject("best_score").get(String.valueOf(i)));
                            }
                            catch (JSONException e)
                            {
                                bestScore = "0";
                            }
                            String mobKill = "";
                            try {
                                mobKill = String.valueOf(modeObject.getJSONObject("mobs_killed").get(String.valueOf(i)));
                            }
                            catch (JSONException e)
                            {
                                mobKill = "0";
                            }
                            String mostHealing = "";
                            try {
                                mostHealing = String.valueOf(modeObject.getJSONObject("most_healing").get(String.valueOf(i)));
                            }
                            catch (JSONException e)
                            {
                                mostHealing = "0";
                            }
                            String fastedS = "";
                            try {
                                fastedS = String.valueOf(modeObject.getJSONObject("fastest_time_s").get(String.valueOf(i)));
                            }
                            catch (JSONException e)
                            {
                                fastedS = "0";
                            }
                            String fastedSPlus = "";
                            try {
                                fastedSPlus = String.valueOf(modeObject.getJSONObject("fastest_time_s_plus").get(String.valueOf(i)));
                            }
                            catch (JSONException e)
                            {
                                fastedSPlus = "0";
                            }

                            floorList.add(new Floor("Floor_" + i, m, timePlayed, tierCompletions, fastedTime, bestScore, mobKill, mostHealing, fastedS, fastedSPlus));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else {
            floorList = null;
        }
    }

    /**
     * Gets the 'floorList' member of the class.
     * @return A List of 'Floor' Object.
     * @see Dungeon#floorList
     */
    public List<Floor> getFloorList() {
        return floorList;
    }

    /**
     * Gets the 'archer' member of the class.
     * @return A String Object.
     * @see Dungeon#archer
     */
    public String getArcher() {
        return archer;
    }

    /**
     * Gets the 'berserk' member of the class.
     * @return A String Object.
     * @see Dungeon#berserk
     */
    public String getBerserk() {
        return berserk;
    }

    /**
     * Gets the 'catacomb' member of the class.
     * @return A String Object.
     * @see Dungeon#catacomb
     */
    public String getCatacomb() {
        return catacomb;
    }

    /**
     * Gets the 'healer' member of the class.
     * @return A String Object.
     * @see Dungeon#healer
     */
    public String getHealer() {
        return healer;
    }

    /**
     * Gets the 'mage' member of the class.
     * @return A String Object.
     * @see Dungeon#mage
     */
    public String getMage() {
        return mage;
    }

    /**
     * Gets the 'tank' member of the class.
     * @return A String Object.
     * @see Dungeon#tank
     */
    public String getTank() {
        return tank;
    }
}
