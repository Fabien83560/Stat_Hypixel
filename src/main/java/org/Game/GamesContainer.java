package org.Game;

import org.Game.Bedwars.Bedwars;
import org.Game.Skywars.Skywars;
import org.json.JSONObject;

public class GamesContainer {
    Bedwars bedwars;
    Skywars skywars;
    public GamesContainer(JSONObject stats,JSONObject achievements)
    {
        this.bedwars = new Bedwars(stats.getJSONObject("Bedwars"), achievements);
        this.skywars = new Skywars(stats.getJSONObject("SkyWars"));
    }

    public Bedwars getBedwars()
    {
        return bedwars;
    }

    public Skywars getSkywars()
    {
        return skywars;
    }
    public void display()
    {
        this.bedwars.display();
        this.skywars.display();
    }
}
