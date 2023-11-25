package org.Game.Skyblock;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SkyblockProfiles {
    Map<String,SkyblockProfilesContainer> profiles = new HashMap<>();
    Map<String,String> profilesNames = new HashMap<>();
    public SkyblockProfiles(JSONObject stats, String playerUuid){
        JSONObject jsonProfiles = stats.getJSONObject("profiles");
        Set<String> uuidProfiles = jsonProfiles.keySet();
        for(String uuid : uuidProfiles)
        {
            profilesNames.put(uuid,String.valueOf(jsonProfiles.getJSONObject(uuid).get("cute_name")));
            profiles.put(uuid,new SkyblockProfilesContainer(uuid,playerUuid));
        }
    }
}
