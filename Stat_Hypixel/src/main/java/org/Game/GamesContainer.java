package org.Game;

import org.json.JSONObject;

public class GamesContainer {
    Bedwars bedwars;
    public GamesContainer(JSONObject stats,JSONObject achievements) {
        this.bedwars = new Bedwars(stats.getJSONObject("Bedwars"),achievements);
    }

    public Bedwars getBedwars() {
        return bedwars;
    }
}
