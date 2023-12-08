package org.Game.Skyblock.Stats.Fishing;

import org.json.JSONException;
import org.json.JSONObject;

public class TrophyFish {
    String name;
    String bronze;
    String silver;
    String gold;
    String diamond;

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

    public String getBronze() {
        return bronze;
    }

    public String getDiamond() {
        return diamond;
    }

    public String getGold() {
        return gold;
    }

    public String getName() {
        return name;
    }

    public String getSilver() {
        return silver;
    }
}
