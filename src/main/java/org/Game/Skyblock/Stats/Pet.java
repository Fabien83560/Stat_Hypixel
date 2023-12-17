package org.Game.Skyblock.Stats;

import org.json.JSONObject;

/**
 * This class implements the Pet statistics of
 * a player's profile in Skyblock. Only used once
 * in SkyblockProfilesContainer.
 * @see org.Game.Skyblock.SkyblockProfilesContainer
 */
public class Pet {

    /**
     * String containing the name of the current player's pet in Skyblock.
     */
    String type;

    /**
     * String containing the experience value of the current player's pet in Skyblock.
     */
    String exp;

    /**
     * String containing the tier of the current player's pet in Skyblock.
     */
    String tier;

    /**
     * String containing the number of candies used on the current player's pet in Skyblock.
     */
    String candyUsed;

    /**
     * Constructor of the Pet class. It uses a JSONObject
     * as a parameter to initialize all the data members of
     * the class.
     * @param petObject A JSONObject containing the necessary
     *                  data to get the proper ones and put them
     *                  in the data members.
     */
    public Pet(JSONObject petObject) {
        type = String.valueOf(petObject.get("type"));
        exp = String.valueOf(petObject.get("exp"));
        tier = String.valueOf(petObject.get("tier"));
        candyUsed = String.valueOf(petObject.get("candyUsed"));
    }

    /**
     * Gets the 'candyUsed' member of the class.
     * @return A String Object.
     * @see Pet#candyUsed
     */
    public String getCandyUsed() {
        return candyUsed;
    }

    /**
     * Gets the 'exp' member of the class.
     * @return A String Object.
     * @see Pet#exp
     */
    public String getExp() {
        return exp;
    }

    /**
     * Gets the 'tier' member of the class.
     * @return A String Object.
     * @see Pet#tier
     */
    public String getTier() {
        return tier;
    }

    /**
     * Gets the 'type' member of the class.
     * @return A String Object.
     * @see Pet#type
     */
    public String getType() {
        return type;
    }
}
