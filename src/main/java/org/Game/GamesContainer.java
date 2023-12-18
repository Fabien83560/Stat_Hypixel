package org.Game;

import org.Game.Bedwars.Bedwars;
import org.Game.Skyblock.SkyblockProfiles;
import org.Game.Skywars.Skywars;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This GamesContainer class instantiates all the different
 * modes available in this app (Bedwars, Skywars and Skyblock).
 */
public class GamesContainer {

    /**
     * Instance of the Bedwars mode.
     * @see Bedwars
     */
    Bedwars bedwars;

    /**
     * Instance of the Skywars mode.
     * @see Skywars
     */
    Skywars skywars;

    /**
     * Instance of the Skyblock mode.
     * @see SkyblockProfiles
     */
    SkyblockProfiles skyblock;

    /**
     * Constructor of the GamesContainer class.
     * Creates one instance of each mode available,
     * using the stats, achievements (Bedwars) and playerUuid (Skyblock).
     * @param stats A JSONObject used to get the statistics of each mod.
     * @param achievements A JSONObject used to get the achievements of the
     *                     player in Bedwars.
     * @param playerUuid A String containing the uuid field of the player in
     *                   Skyblock mode.
     * @see Bedwars#Bedwars(JSONObject, JSONObject)
     * @see Skywars#Skywars(JSONObject)
     * @see SkyblockProfiles#SkyblockProfiles(JSONObject, String)
     */
    public GamesContainer(JSONObject stats, JSONObject achievements, String playerUuid)
    {
        try {
            bedwars = new Bedwars(stats.getJSONObject("Bedwars"), achievements);
        }
        catch (JSONException e) {
            bedwars = null;
        }

        try {
            skywars = new Skywars(stats.getJSONObject("SkyWars"));
        }
        catch (JSONException e) {
            skywars = null;
        }

        try {
            skyblock = new SkyblockProfiles(stats.getJSONObject("SkyBlock"), playerUuid);
        }
        catch (JSONException e) {
            skyblock = null;
        }
    }

    /**
     * Gets the Skywars instance.
     * @return The Skywars instance of the GameContainer class.
     */
    public Skywars getSkywars() {
        return skywars;
    }

    /**
     * Gets the Bedwars instance.
     * @return The Bedwars instance of the GameContainer class.
     */
    public Bedwars getBedwars() {
        return bedwars;
    }

    /**
     * Gets the Skyblock instance.
     * @return The Skyblock instance of the GameContainer class.
     */
    public SkyblockProfiles getSkyblock() {
        return skyblock;
    }
}
