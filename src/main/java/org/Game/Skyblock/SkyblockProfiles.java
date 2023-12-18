package org.Game.Skyblock;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class implements the SkyBlock mode from the Hypixel
 * Minecraft server. It creates a Map of 'String, String' that
 * will contain the uuid of the player and its name in Skyblock.
 * It also creates a Map of 'String,
 * SkyblockProfilesContainer' meant to contain all the different
 * profiles of a player in Skyblock, the key being the uuid of the
 * player.
 * @see SkyblockProfilesContainer
 */
public class SkyblockProfiles {

    /**
     * Map of 'String, SkyblockProfilesContainer' containing all the
     * different profiles of a player in Skyblock.
     */
    Map<String,SkyblockProfilesContainer> profiles = new HashMap<>();

    /**
     * Map of 'String, String' containing all the uuids and names of a
     * player in Skyblock.
     */
    Map<String,String> profilesNames = new HashMap<>();

    /**
     * Constructor of the SkyblockProfiles class. It uses
     * a JSONObject containing the global JSON of the HyPixel
     * API and a String containing the uuid of the player that got
     * instantiated.
     * @param stats A JSONObject used to get the 'profiles' section of
     *              the player.
     * @param playerUuid A String containing the uuid of the player.
     * @see SkyblockProfilesContainer
     */
    public SkyblockProfiles(JSONObject stats, String playerUuid){
        final JSONObject jsonProfiles = stats.getJSONObject("profiles");
        Set<String> uuidProfiles = jsonProfiles.keySet();
        for(String uuid : uuidProfiles)
        {
            profilesNames.put(uuid,String.valueOf(jsonProfiles.getJSONObject(uuid).get("cute_name")));
            try {
                profiles.put(uuid,new SkyblockProfilesContainer(uuid,playerUuid,profilesNames.get(uuid)));
            }
            catch (Exception e) {
                profiles.put(uuid, null);
            }
        }
    }

    /**
     * Gets a specific Skyblock profile through an uuid passed
     * as a parameter.
     * @param uuid A String containing the uuid of the profile.
     * @return A SkyblockProfilesContainer Object containing all
     * the statistics of the profile linked to the uuid.
     */
    public SkyblockProfilesContainer getProfile(String uuid) {
        return profiles.get(uuid);
    }

    /**
     * Gets the 'profilesNames' Map of the SkyblockProfiles class.
     * @return A Map of 'String, String'
     * @see SkyblockProfiles#profilesNames
     */
    public Map<String, String> getProfilesNames() {
        return profilesNames;
    }
}
