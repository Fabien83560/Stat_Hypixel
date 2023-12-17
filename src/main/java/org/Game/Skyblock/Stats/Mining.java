package org.Game.Skyblock.Stats;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class implements the Mining statistics of
 * a player's profile in Skyblock. It is only used
 * once in the SkyblockProfilesContainer class.
 * @see org.Game.Skyblock.SkyblockProfilesContainer
 */
public class Mining {

    /**
     * String containing the current Mithril powder value of the player in Mining mode in Skyblock.
     */
    String actualMithrilPowder;

    /**
     * String containing the Hithril power spent by the player in Mining mode in Skyblock.
     */
    String spentMithrilPower;

    /**
     * String containing the current Gemstone powder value of the player in Mining mode in Skyblock.
     */
    String actualGemstonePowder;

    /**
     * String containing the Gemstone power spent of the player in Mining mode in Skyblock.
     */
    String spentGemstonePower;

    /**
     * Constructor of the Mining class. It uses a JSONObject
     * as a parameter to initialize all the data members of
     * the class.
     * @param miningObject A JSONObject containing the necessary
     *                     data to get the proper ones and put them
     *                     in the data members.
     */
    public Mining(JSONObject miningObject) {
        try {
            actualMithrilPowder = String.valueOf(miningObject.get("powder_mithril_total"));
        }
        catch (JSONException e) {
            actualMithrilPowder = "0";
        }
        try {
            spentMithrilPower = String.valueOf(miningObject.get("powder_spent_mithril"));
        }
        catch (JSONException e)
        {
            spentMithrilPower = "0";
        }
        try {
            actualGemstonePowder = String.valueOf(miningObject.get("powder_gemstone_total"));
        }
        catch (JSONException e)
        {
            actualGemstonePowder = "0";
        }
        try {
            spentGemstonePower = String.valueOf(miningObject.get("powder_spent_gemstone"));
        }
        catch (JSONException e)
        {
            spentGemstonePower = "0";
        }
    }

    /**
     * Gets the 'actualGemstonePowder' member of the class.
     * @return A String Object.
     * @see Mining#actualGemstonePowder
     */
    public String getActualGemstonePowder() {
        return actualGemstonePowder;
    }

    /**
     * Gets the 'actualMithrilPowder' member of the class.
     * @return A String Object.
     * @see Mining#actualMithrilPowder
     */
    public String getActualMithrilPowder() {
        return actualMithrilPowder;
    }

    /**
     * Gets the 'spentGemstonePower' member of the class.
     * @return A String Object.
     * @see Mining#spentGemstonePower
     */
    public String getSpentGemstonePower() {
        return spentGemstonePower;
    }

    /**
     * Gets the 'spentMithrilPower' member of the class.
     * @return A String Object.
     * @see Mining#spentMithrilPower
     */
    public String getSpentMithrilPower() {
        return spentMithrilPower;
    }
}
