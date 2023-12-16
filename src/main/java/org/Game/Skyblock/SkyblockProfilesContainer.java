package org.Game.Skyblock;

import org.Game.Skyblock.Stats.Crimson.Crimson;
import org.Game.Skyblock.Stats.Dungeon.Dungeon;
import org.Game.Skyblock.Stats.Fishing.Fishing;
import org.Game.Skyblock.Stats.Mining;
import org.Game.Skyblock.Stats.Pet;
import org.Game.Skyblock.Stats.Skills;
import org.Game.Skyblock.Stats.Slayer;
import org.Player.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.internal.JUnitSystem;

import java.sql.Timestamp;
import java.util.*;

public class SkyblockProfilesContainer {
    String cuteName;
    List<String> membersList = new ArrayList<>();
    String firstJoin;
    String level;
    Skills skills;
    String purse;
    String purseBank;
    String fairySoulCollected;
    String magicalPower;
    List<Pet> petList = new ArrayList<>();
    Mining mining;
    Fishing fishing;
    Dungeon dungeon;
    String totalXpSlayer;
    List<Slayer> slayerList = new ArrayList<>();
    Crimson crimson;
    String milestone;
    String milestoneUnlockTiers;
    String auctionsCreated;
    String totalFees;
    String totalBids;
    String highestBid;
    String auctionCompleted;
    String coinsEarned;
    String totalMobKill;
    String totalDeaths;
    String giftGiven;
    String giftReceived;
    String totalCandy;
    String greenCandy;
    String purpleCandy;
    Map<String,String> essenceList = new HashMap<>();
    public SkyblockProfilesContainer(String profileUuid, String playerUuid, String profileName) {
        try {
            final JSONObject json = fetchProfile(profileUuid).getJSONObject("profile");
            cuteName = profileName;
            for (Object key : json.getJSONObject("members").keySet()) {
                String memberUuid = (String) key;
                membersList.add(memberUuid);
            }
            JSONObject jsonMember = json.getJSONObject("members").getJSONObject(playerUuid);
            Timestamp timestamp = new Timestamp(Long.parseLong(jsonMember.getJSONObject("profile").get("first_join").toString()));
            Date date = new Date(timestamp.getTime());
            firstJoin = (date.getDate() < 10 ? "0" + date.getDate() : date.getDate()) + "/" +
                    (date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1) + "/" +
                    (date.getYear() + 1900);
            level = String.valueOf(jsonMember.getJSONObject("leveling").getLong("experience") / 100);
            try {
                purse = String.valueOf(jsonMember.getJSONObject("currencies").getLong("coin_purse"));
            } catch (JSONException e) {
                purse = "N/A";
            }
            try {
                purseBank = String.valueOf(json.getJSONObject("banking").get("balance"));
            } catch (JSONException e) {
                purseBank = "N/A";
            }
            try {
                fairySoulCollected = String.valueOf(jsonMember.getJSONObject("fairy_soul").get("total_collected"));
            } catch (JSONException e) {
                fairySoulCollected = "N/A";
            }
            try {
                magicalPower = String.valueOf(jsonMember.getJSONObject("accessory_bag_storage").get("highest_magical_power"));
            } catch (JSONException e) {
                magicalPower = "0";
            }
            try {
                skills = new Skills(jsonMember.getJSONObject("player_data").getJSONObject("experience"));
            } catch (JSONException e) {
                skills = null;
            }
            JSONArray petsArray = jsonMember.getJSONObject("pets_data").getJSONArray("pets");
            for (int i = 0; i < petsArray.length(); i++)
                petList.add(new Pet(petsArray.getJSONObject(i)));
            try {
                mining = new Mining(jsonMember.getJSONObject("mining_core"));
            }
            catch (JSONException e)
            {
                mining = null;
            }
            fishing = new Fishing(jsonMember);
            try {
                dungeon = new Dungeon(jsonMember.getJSONObject("dungeons"));
            }
            catch(JSONException e)
            {
                dungeon = null;
            }
            String[] slayers = {"zombie", "spider", "wolf", "enderman", "blaze", "vampire"};
            double res = 0.0;
            for (String slayer : slayers) {
                try {
                    Slayer s = new Slayer(slayer, jsonMember.getJSONObject("slayer").getJSONObject("slayer_bosses").getJSONObject(slayer));
                    res += Double.parseDouble(s.getExp());
                    slayerList.add(s);
                } catch (JSONException e) {
                    slayerList.add(new Slayer(slayer, new JSONObject()));
                }
            }
            totalXpSlayer = String.valueOf(res);
            try {
                milestone = String.valueOf(jsonMember.getJSONObject("bestiary").getJSONObject("milestone").get("last_claimed_milestone"));
            }
            catch (JSONException e)
            {
                milestone = "0";
            }
            try {
                milestoneUnlockTiers = String.valueOf(Double.parseDouble(milestone) * 10);
            }
            catch (JSONException e)
            {
                milestoneUnlockTiers = "0";
            }
            try {
                crimson = new Crimson(jsonMember.getJSONObject("nether_island_player_data"));
            } catch (JSONException e) {
                crimson = null;
            }
            try {
                auctionsCreated = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("created"));
            } catch (JSONException e) {
                auctionsCreated = "0";
            }
            try {
                totalFees = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("fees"));
            } catch (JSONException e) {
                totalFees = "0";
            }
            try {
                totalBids = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("bids"));
            } catch (JSONException e) {
                totalBids = "0";
            }
            try {
                highestBid = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("highest_bid"));
            } catch (JSONException e) {
                highestBid = "0";
            }
            try {
                coinsEarned = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("gold_earned"));
            } catch (JSONException e) {
                coinsEarned = "0";
            }
            try {
                auctionCompleted = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("completed"));
            } catch (JSONException e) {
                auctionCompleted = "0";
            }
            try {
                totalMobKill = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("kills").get("total"));
            }
            catch (JSONException e)
            {
                totalMobKill = "0";
            }
            try {
                totalDeaths = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("deaths").get("total"));
            }
            catch (JSONException e)
            {
                totalDeaths = "0";
            }
            try {
                giftGiven = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("gifts").get("total_given"));
            }
            catch (JSONException e)
            {
                giftGiven = "0";
            }
            try {
                giftReceived = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("gifts").get("total_received"));
            }
            catch (JSONException e) {
                giftReceived = "0";
            }
            try {
                totalCandy = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("candy_collected").get("total"));
                try {
                    greenCandy = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("candy_collected").get("green_candy"));
                }
                catch (JSONException e)
                {
                    greenCandy = "0";
                }
                try {
                    purpleCandy = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("candy_collected").get("purple_candy"));
                }
                catch (JSONException e)
                {
                    purpleCandy = "0";
                }
            }
            catch (JSONException e) {
                totalCandy = "0";
                greenCandy = "0";
                purpleCandy = "0";
            }
            String[] essences = {"WITHER", "DRAGON", "SPIDER", "UNDEAD", "DIAMOND", "ICE", "GOLD", "CRIMSON"};
            for (String essence : essences) {
                try {
                    essenceList.putIfAbsent(essence, String.valueOf(jsonMember.getJSONObject("currencies").getJSONObject("essence").getJSONObject(essence).get("current")));
                }
                catch (JSONException e)
                {
                    essenceList.putIfAbsent(essence,"0");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
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

    public void display() {
        System.out.println("SKYBLOCK STATISTICS");
        System.out.println("cute_name : " + cuteName);
        for(String uuid : membersList)
            System.out.println("Coop member : " + uuid);
        System.out.println("First join : " + firstJoin);
        System.out.println("SkyBlock level : " + level);
        skills.display();
        System.out.println("Purse : " + purse);
        System.out.println("Bank Account : " + purseBank);
        System.out.println("Fairy Soul Collected : " + fairySoulCollected);
        System.out.println("Magical Power : " + magicalPower);
        System.out.println();
        System.out.println("PETS LIST");
        System.out.println("----------------");
        for(Pet pet : petList)
        {
            System.out.println("Type : " + pet.getType());
            System.out.println("Tier : " + pet.getTier());
            System.out.println("Exp : " + pet.getExp());
            System.out.println("Candy Used : " + pet.getCandyUsed());
            System.out.println("----------------");
        }
        System.out.println();
        System.out.println("MINING");
        System.out.println("Actual Mithril Powder : " + mining.getActualMithrilPowder());
        System.out.println("Spent Mithril Powder : " + mining.getSpentMithrilPower());
        System.out.println("Actual Gemstone Powder : " + mining.getActualGemstonePowder());
        System.out.println("Spent Gemstone Powder : " + mining.getSpentGemstonePower());
        System.out.println();
        fishing.display();
        System.out.println();
        dungeon.display();
        System.out.println("SLAYER");
        System.out.println("Total Slayer Xp : " + totalXpSlayer);
        for(Slayer slayer : slayerList) {
            System.out.println("----------------");
            System.out.println("Name : " + slayer.getName());
            System.out.println("Exp : " + slayer.getExp());
            System.out.println("Boss Tier 1 : " + slayer.getTier1());
            System.out.println("Boss Tier 2 : " + slayer.getTier2());
            System.out.println("Boss Tier 3 : " + slayer.getTier3());
            System.out.println("Boss Tier 4 : " + slayer.getTier4());
            System.out.println("Boss Tier 5 : " + slayer.getTier5());
        }
        System.out.println("----------------");
        System.out.println("BESTIARY");
        System.out.println("Milestone : " + milestone);
        System.out.println("Unlocked Milestone Tiers : " + milestoneUnlockTiers);
        crimson.display();
        System.out.println();
        System.out.println("AUCTIONS");
        System.out.println("Total Auctions Created : " + auctionsCreated);
        System.out.println("Total Fees : " + totalFees);
        System.out.println("Total Bids : " + totalBids);
        System.out.println("Highest Bid : " + highestBid);
        System.out.println("Auctions Completed : " + auctionCompleted );
        System.out.println("Coins Earned : " + coinsEarned);
        System.out.println();
        System.out.println("OTHER STATISTICS");
        System.out.println("Total Mobs Kills : " + totalMobKill);
        System.out.println("Total Deaths : " + totalDeaths);
        System.out.println("Gifts Given : " + giftGiven);
        System.out.println("Gifts received : " + giftReceived);
        System.out.println("Total Candy : " + totalCandy);
        System.out.println("Green Candy : " + greenCandy);
        System.out.println("Purple Candy : " + purpleCandy);
        System.out.println();
        System.out.println("ESSENCE");
        for(String key : essenceList.keySet())
            System.out.println(key + " Essence : " + essenceList.get(key));
    }

    public Crimson getCrimson() {
        return crimson;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public Fishing getFishing() {
        return fishing;
    }

    public List<Slayer> getSlayerList() {
        return slayerList;
    }

    public List<String> getMembersList() {
        return membersList;
    }

    public Mining getMining() {
        return mining;
    }

    public Skills getSkills() {
        return skills;
    }

    public String getAuctionsCreated() {
        return auctionsCreated;
    }

    public String getCuteName() {
        return cuteName;
    }

    public String getAuctionCompleted() {
        return auctionCompleted;
    }

    public String getCoinsEarned() {
        return coinsEarned;
    }

    public String getFairySoulCollected() {
        return fairySoulCollected;
    }

    public String getFirstJoin() {
        return firstJoin;
    }

    public String getHighestBid() {
        return highestBid;
    }

    public String getGiftGiven() {
        return giftGiven;
    }

    public String getGiftReceived() {
        return giftReceived;
    }

    public String getLevel() {
        return level;
    }

    public String getMagicalPower() {
        return magicalPower;
    }

    public String getGreenCandy() {
        return greenCandy;
    }

    public String getMilestone() {
        return milestone;
    }

    public String getMilestoneUnlockTiers() {
        return milestoneUnlockTiers;
    }

    public String getPurse() {
        return purse;
    }

    public String getPurpleCandy() {
        return purpleCandy;
    }

    public String getPurseBank() {
        return purseBank;
    }

    public String getTotalBids() {
        return totalBids;
    }

    public String getTotalCandy() {
        return totalCandy;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public String getTotalFees() {
        return totalFees;
    }

    public Map<String, String> getEssenceList() {
        return essenceList;
    }

    public String getTotalMobKill() {
        return totalMobKill;
    }

    public String getTotalXpSlayer() {
        return totalXpSlayer;
    }
}
