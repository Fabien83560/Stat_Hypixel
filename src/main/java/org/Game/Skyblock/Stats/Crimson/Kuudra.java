package org.Game.Skyblock.Stats.Crimson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class implements the Kuudra statistics of
 * a player's profile in Skyblock.
 */
public class Kuudra {

    /**
     * String containing the name of the current Kuudra mode in Skyblock.
     */
    String name;

    /**
     * String containing the number of kills the player has in Kuudra mode in Skyblock.
     */
    String kuudraKill;

    /**
     * String containing the highest wave the player got in Kuudra mode in Skyblock.
     */
    String highestWave;

    /**
     * Constructor of the Kuudra class. It takes two
     * parameters, the first one being the name of the Kuudra difficulty,
     * the second one being the JSONObject to access to the Kuudra data
     * in the API.
     * @param _name A String containing the difficulty of the Kuudra.
     * @param kuudraObject A JSONObject to access to the Kuudra data
     *                     in the API.
     */
    public Kuudra(String _name, JSONObject kuudraObject) {
        if (_name.equals("none"))
            name = "basic";
        else
            name = _name;
        try {
            kuudraKill = String.valueOf(kuudraObject.get(_name));
        }
        catch (JSONException e) {
            kuudraKill = "0";
        }
        try {
            highestWave = String.valueOf(kuudraObject.get("highest_wave_" + _name));
        }
        catch (JSONException e) {
            highestWave = "0";
        }
    }

    /**
     * Gets the 'name' member of the class.
     * @return A String Object.
     * @see Kuudra#name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the 'highestWave' member of the class.
     * @return A String Object.
     * @see Kuudra#highestWave
     */
    public String getHighestWave() {
        return highestWave;
    }

    /**
     * Gets the 'kuudraKill' member of the class.
     * @return A String Object.
     * @see Kuudra#kuudraKill
     */
    public String getKuudraKill() {
        return kuudraKill;
    }
}
