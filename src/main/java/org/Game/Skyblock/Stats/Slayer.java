package org.Game.Skyblock.Stats;

import org.json.JSONException;
import org.json.JSONObject;

public class Slayer {
    String name;
    String exp;
    String tier1;
    String tier2;
    String tier3;
    String tier4;
    String tier5;

    public Slayer(String _name,JSONObject slayerObject) {
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

    public String getName() {
        return name;
    }
    public String getExp() {
        return exp;
    }
    public String getTier1() {
        return tier1;
    }
    public String getTier2() {
        return tier2;
    }
    public String getTier3() {
        return tier3;
    }
    public String getTier4() {
        return tier4;
    }
    public String getTier5() {
        return tier5;
    }
}
