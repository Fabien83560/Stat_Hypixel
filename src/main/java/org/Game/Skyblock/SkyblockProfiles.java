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
            try {
                profiles.put(uuid,new SkyblockProfilesContainer(uuid,playerUuid,profilesNames.get(uuid)));
            }
            catch (Exception e) {
                profiles.put(uuid, null);
            }
        }
    }

    public Map<String, SkyblockProfilesContainer> getProfiles() {
        return profiles;
    }

    public SkyblockProfilesContainer getProfile(String uuid) {
        return profiles.get(uuid);
    }

    public Map<String, String> getProfilesNames() {
        return profilesNames;
    }
}
