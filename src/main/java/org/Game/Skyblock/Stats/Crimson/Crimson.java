package org.Game.Skyblock.Stats.Crimson;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Crimson statistics of
 * a player's profile in Skyblock.
 */
public class Crimson {

    /**
     * String containing the selected faction of the player in Skyblock.
     */
    String selectedFaction;

    /**
     * String containing the mage reputation of the player in Skyblock.
     */
    String mageReputation;

    /**
     * String containing the barbarian reputation of the player in Skyblock.
     */
    String barbarianReputation;

    /**
     * List of 'Kuudra' containing the statistics about the bosses of Kuudra mode in Skyblock.
     * @see Kuudra
     */
    List<Kuudra> kuudraList = new ArrayList<>();

    /**
     * List of 'Dojo' containing the statistics about the minigames of Dojo mode in Skyblock.
     * @see Dojo
     */
    List<Dojo> dojoList = new ArrayList<>();

    /**
     * Constructor of the Crimson class. The JSONObject parameter
     * contains all the statistics about the Crimson mode of the player
     * in Skyblock.
     * @param jsonCrimson A JSONObject containing the JSON of the wanted data.
     * @see Kuudra
     * @see Dojo
     */
    public Crimson(JSONObject jsonCrimson) {
        try {
            selectedFaction = String.valueOf(jsonCrimson.get("selected_faction"));
        }
        catch (JSONException e) {
            selectedFaction = "";
        }

        try {
            mageReputation = String.valueOf(jsonCrimson.get("mages_reputation"));
        }
        catch (JSONException e) {
            mageReputation = "";
        }

        try {
            barbarianReputation = String.valueOf(jsonCrimson.get("barbarians_reputation"));
        }
        catch (JSONException e) {
            barbarianReputation = "";
        }

        final String[] kuudras = {"none","hot","burning","fiery","infernal"};
        for(String kuudra : kuudras)
            try {
                kuudraList.add(new Kuudra(kuudra, jsonCrimson.getJSONObject("kuudra_completed_tiers")));
            }
            catch (JSONException e) {
                kuudraList.add(new Kuudra(kuudra,new JSONObject()));
            }

        final String[] dojos = {"mob_kb","wall_jump","archer","sword_swap","snake","fireball","lock_head"};
        for(String dojo : dojos)
            try {
                dojoList.add(new Dojo(dojo, jsonCrimson.getJSONObject("dojo")));
            }
            catch (JSONException e) {
                dojoList.add(new Dojo(dojo,new JSONObject()));
            }
    }

    /**
     * Gets the 'dojoList' member of the class.
     * @return A List of Dojo Object.
     * @see Crimson#dojoList
     */
    public List<Dojo> getDojoList() {
        return dojoList;
    }

    /**
     * Gets the 'kuudraList' member of the class.
     * @return A List of Kuudra Object.
     * @see Crimson#kuudraList
     */
    public List<Kuudra> getKuudraList() {
        return kuudraList;
    }

    /**
     * Gets the 'barbarianReputation' member of the class.
     * @return A String Object.
     * @see Crimson#barbarianReputation
     */
    public String getBarbarianReputation() {
        return barbarianReputation;
    }

    /**
     * Gets the 'mageReputation' member of the class.
     * @return A String Object.
     * @see Crimson#mageReputation
     */
    public String getMageReputation() {
        return mageReputation;
    }

    /**
     * Gets the 'selectedFaction' member of the class.
     * @return A String Object.
     * @see Crimson#selectedFaction
     */
    public String getSelectedFaction() {
        return selectedFaction;
    }
}
