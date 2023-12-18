package org.Game.Skyblock.Stats.Fishing;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Fishing statistics of
 * a player's profile in Skyblock.
 */
public class Fishing {

    /**
     * String containing the number of items the player fished in Fishing mode in Skyblock.
     */
    String itemsFished;

    /**
     * String containing the number of treasures the player fished in Fishing mode in Skyblock.
     */
    String treasuresFished;

    /**
     * String containing the number of large treasures the player fished in Fishing mode in Skyblock.
     */
    String largeTreasuresFished;

    /**
     * String containing the number of trophies the player owns in Fishing mode in Skyblock.
     */
    String totalTrophyFish;

    /**
     * List of 'TrophyFish' containing all the trophies of the player in Fishing mode in Skyblock.
     */
    List<TrophyFish> trophyFishList = new ArrayList<>();

    /**
     * Constructor of the Fishing class. It has one parameter being
     * a JSONObject that contains all the data related to the Fishing mode
     * in Skyblock, Used to initialize data members with the associated fields
     * in the API.
     * @param jsonMember A JSONObject containing all the data related to the
     *                   Fishing mode in Skyblock.
     */
    public Fishing(JSONObject jsonMember) {
        try{
            itemsFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("normal"));
        }
        catch (JSONException e) {
            itemsFished = "";
        }

        try {
            treasuresFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("treasure"));
        }
        catch (JSONException e) {
            treasuresFished = "0";
        }

        try {
            largeTreasuresFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("large_treasure"));
        }
        catch (JSONException e) {
            largeTreasuresFished = "0";
        }

        try {
            totalTrophyFish = String.valueOf(jsonMember.getJSONObject("trophy_fish").get("total_caught"));
        }
        catch (JSONException e) {
            totalTrophyFish = "0";
        }

        final String[] trophyList = {"sulphur_skitter","obfuscated_fish_1","steaming_hot_flounder","obfuscated_fish_2","gusher","blobfish","slugfish","obfuscated_fish_3","flyfish","lavahorse","volcanic_stonefish","vanille","skeleton_fish","moldfin","soul_fish","mana_ray","karate_fish","golden_fish"};
        try {
            JSONObject trophyObject = jsonMember.getJSONObject("trophy_fish");
            for(String trophy : trophyList)
                trophyFishList.add(new TrophyFish(trophy,trophyObject));
        }
        catch (JSONException e) {
            trophyFishList = null;
        }
    }

    /**
     * Gets the 'trophyFishList' member of the class.
     * @return A List of 'TrophyFish' Object
     * @see TrophyFish
     * @see Fishing#trophyFishList
     */
    public List<TrophyFish> getTrophyFishList() {
        return trophyFishList;
    }

    /**
     * Gets the 'itemsFished' member of the class.
     * @return A String Object
     * @see Fishing#itemsFished
     */
    public String getItemsFished() {
        return itemsFished;
    }

    /**
     * Gets the 'largeTreasuresFished' member of the class.
     * @return A String Object
     * @see Fishing#largeTreasuresFished
     */
    public String getLargeTreasuresFished() {
        return largeTreasuresFished;
    }

    /**
     * Gets the 'totalTrophyFish' member of the class.
     * @return A String Object
     * @see Fishing#totalTrophyFish
     */
    public String getTotalTrophyFish() {
        return totalTrophyFish;
    }

    /**
     * Gets the 'treasuresFished' member of the class.
     * @return A String Object
     * @see Fishing#treasuresFished
     */
    public String getTreasuresFished() {
        return treasuresFished;
    }
}
