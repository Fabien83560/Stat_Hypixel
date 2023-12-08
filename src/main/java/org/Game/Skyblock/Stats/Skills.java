package org.Game.Skyblock.Stats;

import org.Player.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Skills {
    Map<String,Double> skills = new HashMap<>();
    Double skillAverage;
    public Skills(JSONObject jsonSkills) {
            Set<String> keys = jsonSkills.keySet();
            for(String key : keys)
                addSkills(key,calculateLevel(key,jsonSkills.getDouble(key)));
            skillAverage = calculateSkillAverage();
    }

    public void addSkills(String key, Double value) {
        skills.putIfAbsent(key,value);
    }

    public Map<String, Double> getSkills() {
        return skills;
    }

    public Double calculateLevel(String skill, Double exp) {
        try {
            JSONObject jsonSkillsInformation = fetchSkillsLevel(skill.substring(6));
            int maxLevel = (int) jsonSkillsInformation.get("maxLevel");
            JSONArray jsonSkillsLists = jsonSkillsInformation.getJSONArray("levels");
            for(int level = 0 ; level < maxLevel ; level++) {
                int xpRequired = ((BigDecimal) ((JSONObject) jsonSkillsLists.get(level)).get("totalExpRequired")).intValue();
                if(!(xpRequired < exp))
                    return Double.parseDouble(String.valueOf(level+1));
                if((xpRequired < exp) || xpRequired == exp)
                    return Double.parseDouble(String.valueOf(maxLevel));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Double calculateSkillAverage() {
        Double res = 0.0;
        String[] skillCalculate = {"SKILL_FARMING", "SKILL_MINING", "SKILL_COMBAT", "SKILL_FORAGING", "SKILL_FISHING", "SKILL_ENCHANTING", "SKILL_ALCHEMY", "SKILL_CARPENTRY"};

        for (String skill : skillCalculate)
            if (skills.containsKey(skill))
                res += skills.get(skill);
        return res / (double) skillCalculate.length;
    }


    public JSONObject fetchSkillsLevel(String skill) {
        String url = "https://api.hypixel.net/v2/resources/skyblock/skills";
        return new JSONObject(Player.fetch(url)).getJSONObject("skills").getJSONObject(skill);
    }

    public void display() {
        System.out.println("Skill Average : " + skillAverage);
        for (Map.Entry<String, Double> entry : skills.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
