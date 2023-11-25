package org.Game;

import org.Game.Bedwars.Bedwars;
import org.Game.Skyblock.SkyblockProfiles;
import org.Game.Skywars.Skywars;
import org.json.JSONObject;

public class GamesContainer {
    Bedwars bedwars;
    Skywars skywars;
    SkyblockProfiles skyblock;
    public GamesContainer(JSONObject stats,JSONObject achievements,String playerUuid)
    {
        this.bedwars = new Bedwars(stats.getJSONObject("Bedwars"), achievements);
        this.skywars = new Skywars(stats.getJSONObject("SkyWars"));
        this.skyblock = new SkyblockProfiles(stats.getJSONObject("SkyBlock"),playerUuid);
    }
    public void display()
    {
        this.bedwars.display();
        this.skywars.display();
    }
}
