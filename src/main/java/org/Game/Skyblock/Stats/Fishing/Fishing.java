package org.Game.Skyblock.Stats.Fishing;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Fishing {
    String itemsFished;
    String treasuresFished;
    String largeTreasuresFished;
    String totalTropyFish;
    List<TrophyFish> trophyFishList = new ArrayList<>();
    public Fishing(JSONObject jsonMember) {
        itemsFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("normal"));
        treasuresFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("treasure"));
        largeTreasuresFished = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("items_fished").get("large_treasure"));
        totalTropyFish = String.valueOf(jsonMember.getJSONObject("trophy_fish").get("total_caught"));
        String[] trophyList = {"sulphur_skitter","obfuscated_fish_1","steaming_hot_flounder","obfuscated_fish_2","gusher","blobfish","slugfish","obfuscated_fish_3","flyfish","lavahorse","volcanic_stonefish","vanille","skeleton_fish","moldfin","soul_fish","mana_ray","karate_fish","golden_fish"};
        JSONObject trophyObject = jsonMember.getJSONObject("trophy_fish");
        for(String trophy : trophyList)
            trophyFishList.add(new TrophyFish(trophy,trophyObject));

    }
    public void display() {
        System.out.println("FISHING");
        System.out.println("Items Fished : " + itemsFished);
        System.out.println("Treasures Fished : " + treasuresFished);
        System.out.println("Large Treasures Fished : " + largeTreasuresFished);
        System.out.println("Total Trophy Fish : " + totalTropyFish);
        for(TrophyFish trophy : trophyFishList) {
            System.out.println("----------------");
            System.out.println("Name : " + trophy.getName());
            System.out.println("Bronze : " + trophy.getBronze());
            System.out.println("Silver : " + trophy.getSilver());
            System.out.println("Gold : " + trophy.getGold());
            System.out.println("Diamond : " + trophy.getDiamond());
        }
    }
}
