package org.Game.Skyblock.Stats.Fishing;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Fishing {
    String itemsFished;
    String treasuresFished;
    String largeTreasuresFished;
    String totalTrophyFish;
    List<TrophyFish> trophyFishList = new ArrayList<>();
    public Fishing(JSONObject jsonMember) {
        try{
            itemsFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("normal"));
        }
        catch (JSONException e)
        {
            itemsFished = "";
        }
        try {
            treasuresFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("treasure"));
        }
        catch (JSONException e)
        {
            treasuresFished = "0";
        }
        try {
            largeTreasuresFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("large_treasure"));
        }
        catch (JSONException e)
        {
            largeTreasuresFished = "0";
        }
        try {
            totalTrophyFish = String.valueOf(jsonMember.getJSONObject("trophy_fish").get("total_caught"));
        }
        catch (JSONException e)
        {
            totalTrophyFish = "0";
        }
        String[] trophyList = {"sulphur_skitter","obfuscated_fish_1","steaming_hot_flounder","obfuscated_fish_2","gusher","blobfish","slugfish","obfuscated_fish_3","flyfish","lavahorse","volcanic_stonefish","vanille","skeleton_fish","moldfin","soul_fish","mana_ray","karate_fish","golden_fish"};
        try {
            JSONObject trophyObject = jsonMember.getJSONObject("trophy_fish");
            for(String trophy : trophyList)
                trophyFishList.add(new TrophyFish(trophy,trophyObject));
        }
        catch (JSONException e)
        {
            trophyFishList = null;
        }
    }
    public void display() {
        System.out.println("FISHING");
        System.out.println("Items Fished : " + itemsFished);
        System.out.println("Treasures Fished : " + treasuresFished);
        System.out.println("Large Treasures Fished : " + largeTreasuresFished);
        System.out.println("Total Trophy Fish : " + totalTrophyFish);
        for(TrophyFish trophy : trophyFishList) {
            System.out.println("----------------");
            System.out.println("Name : " + trophy.getName());
            System.out.println("Bronze : " + trophy.getBronze());
            System.out.println("Silver : " + trophy.getSilver());
            System.out.println("Gold : " + trophy.getGold());
            System.out.println("Diamond : " + trophy.getDiamond());
        }
    }

    public List<TrophyFish> getTrophyFishList() {
        return trophyFishList;
    }

    public String getItemsFished() {
        return itemsFished;
    }

    public String getLargeTreasuresFished() {
        return largeTreasuresFished;
    }

    public String getTotalTrophyFish() {
        return totalTrophyFish;
    }

    public String getTreasuresFished() {
        return treasuresFished;
    }
}
