package org.Game.Skyblock.Stats;

import org.Player.Player;
import org.json.JSONArray;
import org.json.JSONObject;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class implements the Skills statistics of
 * a player's profile in Skyblock.
 */
public class Skills {

    /**
     * A Map of 'String, Double' containing the names of the skills as keys, and their level as values.
     */
    Map<String,Double> skills = new HashMap<>();

    /**
     * Double containing the average value of all the different skills of a player.
     */
    Double skillAverage;

    /**
     * Constructor of the Skills class. It uses a JSONObject
     * as a parameter to initialize both data members of the class.
     * @param jsonSkills A JSONObject containing the data of the Skills
     *                   field in the API.
     */
    public Skills(JSONObject jsonSkills) {
            Set<String> keys = jsonSkills.keySet();
            for(String key : keys)
                addSkills(key,calculateLevel(key,jsonSkills.getDouble(key)));
            skillAverage = calculateSkillAverage();
    }

    /**
     * Adds a skill and its value in the 'skills' Map, only
     * if the key doesn't already have a value associated to
     * it. The key is the name of the skill, and the value is
     * its associated value.
     * @param key A String containing the name of the skill.
     * @param value A Double containing the value associated to the skill.
     */
    public void addSkills(String key, Double value) {
        skills.putIfAbsent(key,value);
    }

    /**
     * Calculates the level of the skill passed as the first
     * parameter, and uses the second one to determine the level
     * corresponding to it.
     * @param skill A String containing the name of the skill.
     * @param exp A Double containing the experience value of the skill.
     * @return A Double containing the level of the skill.
     * @see Skills#fetchSkillsLevel(String)
     */
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

    /**
     * Calculates the average of all the different skill
     * values available.
     * @return A Double containing the average value.
     */
    public Double calculateSkillAverage() {
        Double res = 0.0;
        String[] skillCalculate = {"SKILL_FARMING", "SKILL_MINING", "SKILL_COMBAT", "SKILL_FORAGING", "SKILL_FISHING", "SKILL_ENCHANTING", "SKILL_ALCHEMY", "SKILL_CARPENTRY"};

        for (String skill : skillCalculate)
            if (skills.containsKey(skill))
                res += skills.get(skill);
        return res / (double) skillCalculate.length;
    }

    /**
     * This function does a fetch to the HyPixel API in order
     * to get the JSONObject associated to the skill 'skill' passed
     * as a parameter.
     * @param skill A String containing the name of the skill from which
     *              we want the data.
     * @return A JSONObject containing the data of the skill.
     * @see Player#fetch(String)
     */
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

    /**
     * Gets the average value of all the skills.
     * @return A Double containing the average value.
     */
    public Double getSkillAverage() {
        return skillAverage;
    }
}
