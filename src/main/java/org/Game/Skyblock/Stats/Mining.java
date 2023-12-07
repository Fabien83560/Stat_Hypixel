package org.Game.Skyblock.Stats;

import org.json.JSONObject;

public class Mining {
    String actualMithrilPowder;
    String spentMithrilPower;
    String actualGemstonePowder;
    String spentGemstonePower;
    String forge;

    public Mining(JSONObject miningObject) {
        actualMithrilPowder = String.valueOf(miningObject.get("powder_mithril_total"));
        spentMithrilPower = String.valueOf(miningObject.get("powder_spent_mithril"));
        actualGemstonePowder = String.valueOf(miningObject.get("powder_gemstone_total"));
        spentGemstonePower = String.valueOf(miningObject.get("powder_spent_gemstone"));
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
