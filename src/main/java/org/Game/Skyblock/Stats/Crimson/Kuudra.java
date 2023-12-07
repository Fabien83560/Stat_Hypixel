package org.Game.Skyblock.Stats.Crimson;

import org.json.JSONException;
import org.json.JSONObject;

public class Kuudra {
    String name;
    String kuudraKill;
    String highestWave;
    public Kuudra(String _name, JSONObject kuudraObject) {
        if (_name.equals("none"))
            name = "basic";
        else
            name = _name;
        try {
            kuudraKill = String.valueOf(kuudraObject.get(_name));
        } catch (JSONException e) {
            kuudraKill = "0";
        }
        try {
            highestWave = String.valueOf(kuudraObject.get("highest_wave_" + _name));
        } catch (JSONException e) {
            highestWave = "0";
        }
    }

    public String getName() {
        return name;
    }

    public String getHighestWave() {
        return highestWave;
    }

    public String getKuudraKill() {
        return kuudraKill;
    }
}
