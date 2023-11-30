package org.Game.Skyblock;

import org.Game.Skyblock.Stats.Skills;
import org.Player.Player;
import org.json.JSONException;
import org.json.JSONObject;

public class SkyblockProfilesContainer {
    Skills skills;
    public SkyblockProfilesContainer(String profileUuid, String playerUuid) {
        JSONObject jsonMember = fetchProfile(profileUuid).getJSONObject("profile").getJSONObject("members").getJSONObject(playerUuid);
        try {
            skills = new Skills(jsonMember.getJSONObject("player_data").getJSONObject("experience"));
        }
        catch (JSONException e)
        {
            this.skills = null;
        }
    }

    public static JSONObject fetchProfile(String profileUuid) {
        String url = "https://api.hypixel.net/v2/skyblock/profile?profile=" + profileUuid + "&key=" + org.Config.ConfigReader.getApiKey();
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
