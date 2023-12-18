package org.Game.Skyblock.Stats.Fishing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class implements the TrophyFish statistics of
 * a player's profile in Skyblock. Used by the Fishing class.
 * @see Fishing
 */
public class TrophyFish {

    /**
     * String containing the name of the trophy fished by the player in Fishing mode in Skyblock.
     */
    String name;

    /**
     * String containing the number of bronze trophies fished by the player in Fishing mode in Skyblock.
     */
    String bronze;

    /**
     * String containing the number of silver trophies fished by the player in Fishing mode in Skyblock.
     */
    String silver;

    /**
     * String containing the number of gold trophies fished by the player in Fishing mode in Skyblock.
     */
    String gold;

    /**
     * String containing the number of diamond trophies fished by the player in Fishing mode in Skyblock.
     */
    String diamond;

    /**
     * Constructor of the TrophyFish class. It initializes all
     * the data members of the class. It is only called by the
     * Fishing class. It takes two parameters, the first one
     * being the name of the Trophy, the second one being a
     * JSONObject containing all the data necessary to
     * initialize the data members of the class.
     * @param _name The name of the Trophy
     * @param trophyObject A JSONObject containing the data used
     *                     to initialize the data members.
     */
    public TrophyFish(String _name, JSONObject trophyObject) {
        name = _name;
        try {
            bronze = String.valueOf(trophyObject.get(_name + "_bronze"));
        }
        catch (JSONException e) {
            bronze = "0";
        }

        try {
            silver = String.valueOf(trophyObject.get(_name + "_silver"));
        }
        catch (JSONException e) {
            silver = "0";
        }

        try {
            gold = String.valueOf(trophyObject.get(_name + "_gold"));
        }
        catch (JSONException e) {
            gold = "0";
        }

        try {
            diamond = String.valueOf(trophyObject.get(_name + "_diamond"));
        }
        catch (JSONException e) {
            diamond = "0";
        }
    }

    /**
     * Gets the 'name' member of the class, meaning the name of the trophy
     * the player owns.
     * @return A String Object.
     * @see TrophyFish#name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the 'bronze' member of the class, meaning the number of bronze trophies
     * the player owns.
     * @return A String Object.
     * @see TrophyFish#bronze
     */
    public String getBronze() {
        return bronze;
    }

    /**
     * Gets the 'silver' member of the class, meaning the number of silver trophies
     * the player owns.
     * @return A String Object.
     * @see TrophyFish#silver
     */
    public String getSilver() {
        return silver;
    }

    /**
     * Gets the 'gold' member of the class, meaning the number of gold trophies
     * the player owns.
     * @return A String Object.
     * @see TrophyFish#gold
     */
    public String getGold() {
        return gold;
    }

    /**
     * Gets the 'diamond' member of the class, meaning the number of diamond trophies
     * the player owns.
     * @return A String Object.
     * @see TrophyFish#diamond
     */
    public String getDiamond() {
        return diamond;
    }
}
