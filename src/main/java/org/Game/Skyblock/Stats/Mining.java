package org.Game.Skyblock.Stats;

import org.json.JSONException;
import org.json.JSONObject;

public class Mining {
    String actualMithrilPowder;
    String spentMithrilPower;
    String actualGemstonePowder;
    String spentGemstonePower;
    String forge;

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
        forge = null;
    }

    public String getActualGemstonePowder() {
        return actualGemstonePowder;
    }

    public String getActualMithrilPowder() {
        return actualMithrilPowder;
    }

    public String getForge() {
        return forge;
    }

    public String getSpentGemstonePower() {
        return spentGemstonePower;
    }

    public String getSpentMithrilPower() {
        return spentMithrilPower;
    }
}
