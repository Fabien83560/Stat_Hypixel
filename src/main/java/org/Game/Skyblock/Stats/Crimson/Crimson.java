package org.Game.Skyblock.Stats.Crimson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Crimson {
    String selectedFaction;
    String mageReputation;
    String barbarianReputation;
    List<Kuudra> kuudraList = new ArrayList<>();
    List<Dojo> dojoList = new ArrayList<>();

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
        String[] kuudras = {"none","hot","burning","fiery","infernal"};
        for(String kuudra : kuudras) {
            try {
                kuudraList.add(new Kuudra(kuudra, jsonCrimson.getJSONObject("kuudra_completed_tiers")));
            }
            catch (JSONException e) {
                kuudraList.add(new Kuudra(kuudra,new JSONObject()));
            }
        }
        String[] dojos = {"mob_kb","wall_jump","archer","sword_swap","snake","fireball","lock_head"};
        for(String dojo : dojos) {
            try {
                dojoList.add(new Dojo(dojo, jsonCrimson.getJSONObject("dojo")));
            }
            catch (JSONException e) {
                dojoList.add(new Dojo(dojo,new JSONObject()));
            }
        }
    }

    public void display() {
        System.out.println();
        System.out.println("CRIMSON ISLE");
        System.out.println("Selected Faction : " + selectedFaction);
        System.out.println("Mage Réputation : " + mageReputation);
        System.out.println("Barbarian Réputation : " + barbarianReputation);
        System.out.println();
        System.out.println("KUUDRA");
        for(Kuudra kuudra : kuudraList) {
            System.out.println("----------------");
            System.out.println("Tier : " + kuudra.getName());
            System.out.println("Boss kill : " + kuudra.getKuudraKill());
            System.out.println("Highest Wave : " + kuudra.getHighestWave());
        }
        for(Dojo dojo : dojoList) {
            System.out.println("----------------");
            System.out.println("Challenge : " + dojo.getName());
            System.out.println("Rank : " + dojo.getRank());
            System.out.println("Points : " + dojo.getPoints());
            System.out.println("Time : " + dojo.getTime() + "s");
        }
    }
}
