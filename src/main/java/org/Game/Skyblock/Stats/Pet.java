package org.Game.Skyblock.Stats;

import org.json.JSONObject;

public class Pet {
    String type;
    String exp;
    String tier;
    String candyUsed;

    public Pet(JSONObject petObject) {
        type = String.valueOf(petObject.get("type"));
        exp = String.valueOf(petObject.get("exp"));
        tier = String.valueOf(petObject.get("tier"));
        candyUsed = String.valueOf(petObject.get("candyUsed"));
    }

    public String getCandyUsed() {
        return candyUsed;
    }

    public String getExp() {
        return exp;
    }

    public String getTier() {
        return tier;
    }

    public String getType() {
        return type;
    }
}
