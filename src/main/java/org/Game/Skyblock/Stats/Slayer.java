package org.Game.Skyblock.Stats;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class implements the Slayer statistics of
 * a player's profile in Skyblock.
 */
public class Slayer {

    /**
     * A String containing the name of the slayer in Skyblock.
     */
    String name;

    /**
     * A String containing the total experience of the slayer in Skyblock.
     */
    String exp;

    /**
     * A String containing the number of bosses killed by the player in tier 0 in Skyblock.
     */
    String tier1;

    /**
     * A String containing the number of bosses killed by the player in tier 1 in Skyblock.
     */
    String tier2;

    /**
     * A String containing the number of bosses killed by the player in tier 2 in Skyblock.
     */
    String tier3;

    /**
     * A String containing the number of bosses killed by the player in tier 3 in Skyblock.
     */
    String tier4;

    /**
     * A String containing the number of bosses killed by the player in tier 4 in Skyblock.
     */
    String tier5;

    /**
     * Constructor of the Slayer class. It is only
     * used in the SkyblockProfilesContainer class. It
     * uses two parameters, the first one being the name of
     * the slayer, the second one being the JSONObject used
     * to access to the slayer data in the API in order to
     * associate those to the data members.
     * @param _name A String containing the name of the slayer.
     * @param slayerObject A JSONObject containing the data
     *                     necessary to initialize the Slayer
     *                     data members.
     */
    public Slayer(String _name, JSONObject slayerObject) {
        name = _name;

        try {
            exp = String.valueOf(slayerObject.get("xp"));
        }
        catch (JSONException e) {
            exp = "0";
        }

        try {
            tier1 = String.valueOf(slayerObject.get("boss_kills_tier_0"));
        }
        catch (JSONException e) {
            tier1 = "0";
        }

        try {
            tier2 = String.valueOf(slayerObject.get("boss_kills_tier_1"));
        }
        catch (JSONException e) {
            tier2 = "0";
        }

        try {
            tier3 = String.valueOf(slayerObject.get("boss_kills_tier_2"));
        }
        catch (JSONException e) {
            tier3 = "0";
        }

        try {
            tier4 = String.valueOf(slayerObject.get("boss_kills_tier_3"));
        }
        catch (JSONException e) {
            tier4 = "0";
        }

        try {
            tier5 = String.valueOf(slayerObject.get("boss_kills_tier_4"));
        }
        catch (JSONException e) {
            tier5 = "0";
        }
    }

    /**
     * Gets the name of the slayer.
     * @return A String Object.
     * @see Slayer#name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the experience of the slayer.
     * @return A String Object.
     * @see Slayer#exp
     */
    public String getExp() {
        return exp;
    }

    /**
     * Gets the first tier of the slayer.
     * @return A String Object.
     * @see Slayer#tier1
     */
    public String getTier1() {
        return tier1;
    }

    /**
     * Gets the second tier of the slayer.
     * @return A String Object.
     * @see Slayer#tier2
     */
    public String getTier2() {
        return tier2;
    }

    /**
     * Gets the third tier of the slayer.
     * @return A String Object.
     * @see Slayer#tier3
     */
    public String getTier3() {
        return tier3;
    }

    /**
     * Gets the fourth tier of the slayer.
     * @return A String Object.
     * @see Slayer#tier4
     */
    public String getTier4() {
        return tier4;
    }

    /**
     * Gets the fifth tier of the slayer.
     * @return A String Object.
     * @see Slayer#tier5
     */
    public String getTier5() {
        return tier5;
    }
}
