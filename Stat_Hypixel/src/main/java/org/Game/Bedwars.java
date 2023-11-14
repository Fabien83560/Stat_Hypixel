package org.Game;

import org.eclipse.jetty.util.ajax.JSON;
import org.json.JSONObject;

public class Bedwars {
    String bedwarsLevel;
    String bedwarsWins;
    String kills;
    String bedDestroy;
    String bedLosts;
    String finalKills;
    String gamePlayed;
    String deaths;
    String coins;
    public Bedwars(JSONObject stats, JSONObject achievements){
        this.bedwarsLevel = String.valueOf(achievements.getLong("bedwars_level"));
        this.bedwarsWins = String.valueOf(stats.getLong("wins_bedwars"));
        this.kills = String.valueOf(stats.getLong("kills_bedwars"));
        this.bedDestroy = String.valueOf(stats.getLong("beds_broken_bedwars"));
        this.bedLosts = String.valueOf(stats.getLong("beds_lost_bedwars"));
        this.finalKills = String.valueOf(stats.getLong("final_kills_bedwars"));
        this.gamePlayed = String.valueOf(stats.getLong("games_played_bedwars"));
        this.deaths = String.valueOf(stats.getLong("deaths_bedwars"));
        this.coins = String.valueOf(stats.getLong("coins"));
    }

    public void display(){
        System.out.println("Bedwars Level : " + this.bedwarsLevel);
        System.out.println("Bedwars Game Played : " + this.gamePlayed);
        System.out.println("Bedwars Coins : " + this.coins);
        System.out.println("Bedwars Wins : " + this.bedwarsWins);
        System.out.println("Bedwars Kills : " + this.kills);
        System.out.println("Bedwars Final Kills : " + this.finalKills);
        System.out.println("Bedwars Beds Destroy : " + this.bedDestroy);
        System.out.println("Bedwars Beds Losts : " + this.bedLosts);
        System.out.println("Bedwars Deaths : " + this.deaths);
    }
}
