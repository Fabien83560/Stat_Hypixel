package org.Game.Skyblock.Stats;

import org.Player.Player;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Skills {
    Map<String,Double> skills = new HashMap<>();
    public Skills(JSONObject jsonSkills) {
        Set<String> keys = jsonSkills.keySet();
        for(String key : keys)
            addSkills(key,jsonSkills.getDouble(key));
    }

    public void addSkills(String key, Double value) {
        skills.putIfAbsent(key,value);
    }

    public Map<String, Double> getSkills() {
        return skills;
    }

    public Double calculateLevel(String skill, Double exp) {
        // skill.substring(6) pour retiré le SKILL_ avant le nom du skill
        return null;
    }

    public JSONObject fetchSkillsLevel(String skill) {
        String url = "https://api.hypixel.net/v2/resources/skyblock/skills";
        return new JSONObject(Player.fetch(url)).getJSONObject("skills").getJSONObject(skill);
    }
}
