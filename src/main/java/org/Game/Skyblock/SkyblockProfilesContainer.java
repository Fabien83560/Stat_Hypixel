package org.Game.Skyblock;

import org.Player.Player;
import org.json.JSONObject;

public class SkyblockProfilesContainer {
    public SkyblockProfilesContainer(String profileUuid, String playerUuid) {
        JSONObject profile = fetchProfile(profileUuid);
    }

    public static JSONObject fetchProfile(String profilUuid) {
        String url = "https://api.hypixel.net/v2/skyblock/profile?profile=" + profilUuid + "&key=" + org.Config.ConfigReader.getApiKey();
        String data = Player.fetch(url);
        try {
            return new JSONObject(data);
        }
        catch (Exception e) {

            JSONObject jsonError = new JSONObject();
            jsonError.put("errorState" , "PROFILE_STATUS");
            return jsonError;
        }
    }
}
