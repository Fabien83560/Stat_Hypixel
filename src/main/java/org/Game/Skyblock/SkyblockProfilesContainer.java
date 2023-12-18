package org.Game.Skyblock;

import org.Application.App;
import org.Game.Skyblock.Stats.Crimson.Crimson;
import org.Game.Skyblock.Stats.Dungeon.Dungeon;
import org.Game.Skyblock.Stats.Fishing.Fishing;
import org.Game.Skyblock.Stats.Mining;
import org.Game.Skyblock.Stats.Pet;
import org.Game.Skyblock.Stats.Skills;
import org.Game.Skyblock.Stats.Slayer;
import org.Player.Player;
import org.Window.Window;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.Timestamp;
import java.util.*;

/**
 * This class implements all the specific statistics
 * of a profile in Skyblock mode. It contains, among
 * others, Fishing, Dojo, Dungeon...
 * @see SkyblockProfiles
 * @see Crimson
 * @see org.Game.Skyblock.Stats.Crimson.Dojo
 * @see org.Game.Skyblock.Stats.Crimson.Kuudra
 * @see Dungeon
 * @see org.Game.Skyblock.Stats.Dungeon.Floor
 * @see Fishing
 * @see org.Game.Skyblock.Stats.Fishing.TrophyFish
 * @see Mining
 * @see Pet
 * @see Skills
 * @see Slayer
 */
public class SkyblockProfilesContainer {

    /**
     * Contains the 'cute_name' field of a profile.
     */
    String cuteName;

    /**
     * A list of String containing the members of a group when
     * playing in a squad in Skyblock.
     */
    List<String> membersList = new ArrayList<>();

    /**
     * String containing the first time the player
     * logged in to that profile.
     */
    String firstJoin;

    /**
     * String containing the level of his profile.
     */
    String level;

    /**
     * Skills Object containing the different skills of
     * the player's profile.
     * @see Skills
     */
    Skills skills;

    /**
     * String containing the money of the player in Skyblock.
     */
    String purse;

    /**
     * String containing the bank money of a squad in Skyblock.
     */
    String purseBank;

    /**
     * A String containing the number of souls collected in Skyblock.
     */
    String fairySoulCollected;

    /**
     * A String containing the highest value of the player's power in Skyblock.
     */
    String magicalPower;

    /**
     * A List of 'Pet' Object containing the different pets of a player.
     * @see Pet
     */
    List<Pet> petList = new ArrayList<>();

    /**
     * The mining instance of the player in Skyblock.
     * @see Mining
     */
    Mining mining;

    /**
     * The fishing instance of the player in Skyblock.
     * @see Fishing
     */
    Fishing fishing;

    /**
     * The dungeon instance of the player in Skyblock.
     * @see Dungeon
     */
    Dungeon dungeon;

    /**
     * String containing the total slayer experience of a player.
     */
    String totalXpSlayer;

    /**
     * Map of 'String, Slayer' containing the different types of slayers in Slayer mode.
     */
    Map<String,Slayer> slayerList = new HashMap<>();

    /**
     * A crimson class instance used to initialize the Crimson statistics of the player.
     */
    Crimson crimson;

    /**
     * String containing the milestone statistic of a player in Skyblock.
     */
    String milestone;

    /**
     * String containing the milestone unlock tiers statistic of a player in Skyblock.
     */
    String milestoneUnlockTiers;

    /**
     * String containing the number of created auctions of a player in Skyblock.
     */
    String auctionsCreated;

    /**
     * String containing the number of fees that have been paid by the player in Skyblock.
     */
    String totalFees;

    /**
     * String containing the number of bids that have been done by the player in Skyblock.
     */
    String totalBids;

    /**
     * String containing the highest bid the player has made in Skyblock.
     */
    String highestBid;

    /**
     * String containing the number of auctions that have been completed by a player in Skyblock.
     */
    String auctionCompleted;

    /**
     * A string containing the number of coins earned by the player in Skyblock.
     */
    String coinsEarned;

    /**
     * String containing the total number of enemies killed by the player in Skyblock.
     */
    String totalMobKill;

    /**
     * String containing the number of times the player died in Skyblock.
     */
    String totalDeaths;

    /**
     * String containing the number of gifts the player gave in Skyblock.
     */
    String giftGiven;

    /**
     * String containing the number of gifts the player received in Skyblock.
     */
    String giftReceived;

    /**
     * String containing the total number of candies the player owns in Skyblock.
     */
    String totalCandy;

    /**
     * String containing the number of green candies of the player in Skyblock.
     */
    String greenCandy;

    /**
     * String containing the number of purple candies of the player in Skyblock.
     */
    String purpleCandy;

    /**
     * A Map of 'String, String' containing the name of the essence as a key,
     * and the number of this essence as a value.
     */
    Map<String,String> essenceList = new HashMap<>();

    /**
     * Constructor of the SkyblockProfilesContainer class.
     * When called, initializes all the data members of the class
     * by doing a fetch, then getting the associated statistic for
     * each member.
     * @param profileUuid A String containing the uuid of the player's profile.
     * @param playerUuid A String containing the player's uuid.
     * @param profileName A String containing the name of the player's profile.
     * @see SkyblockProfilesContainer#fetchProfile(String)
     * @see Pet
     * @see Skills
     * @see Mining
     * @see Fishing
     * @see Dungeon
     * @see Slayer
     * @see Crimson
     */
    public SkyblockProfilesContainer(String profileUuid, String playerUuid, String profileName) {
        try {
            final JSONObject json = fetchProfile(profileUuid).getJSONObject("profile");
            cuteName = profileName;
            for (Object key : json.getJSONObject("members").keySet()) {
                String memberUuid = (String) key;
                membersList.add(memberUuid);
            }
            JSONObject jsonMember = json.getJSONObject("members").getJSONObject(playerUuid);
            try {
                Timestamp timestamp = new Timestamp(Long.parseLong(jsonMember.getJSONObject("profile").get("first_join").toString()));
                Date date = new Date(timestamp.getTime());
                firstJoin = (date.getDate() < 10 ? "0" + date.getDate() : date.getDate()) + "/" +
                        (date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1) + "/" +
                        (date.getYear() + 1900);
            }
            catch(JSONException e) {
                firstJoin = "N/A";
            }
            try {
                level = String.valueOf(jsonMember.getJSONObject("leveling").getLong("experience") / 100);
            }
            catch (JSONException e) {
                level = "N/A";
            }
            try {
                purse = String.valueOf(jsonMember.getJSONObject("currencies").getLong("coin_purse"));
            }
            catch (JSONException e) {
                purse = "N/A";
            }
            try {
                purseBank = String.valueOf(json.getJSONObject("banking").get("balance"));
            }
            catch (JSONException e) {
                purseBank = "N/A";
            }
            try {
                fairySoulCollected = String.valueOf(jsonMember.getJSONObject("fairy_soul").get("total_collected"));
            }
            catch (JSONException e) {
                fairySoulCollected = "N/A";
            }
            try {
                magicalPower = String.valueOf(jsonMember.getJSONObject("accessory_bag_storage").get("highest_magical_power"));
            }
            catch (JSONException e) {
                magicalPower = "0";
            }
            try {
                skills = new Skills(jsonMember.getJSONObject("player_data").getJSONObject("experience"));
            } catch (JSONException e) {
                skills = new Skills("null");
            }
            try {
                JSONArray petsArray = jsonMember.getJSONObject("pets_data").getJSONArray("pets");
                for (int i = 0; i < petsArray.length(); i++)
                    petList.add(new Pet(petsArray.getJSONObject(i)));
            }
            catch (JSONException e)
            {
                petList = null;
            }
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
                    slayerList.put(slayer,s);
                } catch (JSONException e) {
                    slayerList.put(slayer,new Slayer(slayer, new JSONObject()));
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
            }
            catch (JSONException e) {
                crimson = null;
            }
            try {
                auctionsCreated = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("created"));
            }
            catch (JSONException e) {
                auctionsCreated = "0";
            }
            try {
                totalFees = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("fees"));
            }
            catch (JSONException e) {
                totalFees = "0";
            }
            try {
                totalBids = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("bids"));
            }
            catch (JSONException e) {
                totalBids = "0";
            }
            try {
                highestBid = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("highest_bid"));
            }
            catch (JSONException e) {
                highestBid = "0";
            }
            try {
                coinsEarned = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("gold_earned"));
            }
            catch (JSONException e) {
                coinsEarned = "0";
            }
            try {
                auctionCompleted = String.valueOf(jsonMember.getJSONObject("player_stats").getJSONObject("auctions").get("completed"));
            }
            catch (JSONException e) {
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

    /**
     * This method tries to do a fetch to get a player's profile in Skyblock.
     * @param profileUuid The uuid of the player's profile in Skyblock.
     * @return A JSONObject containing all the data of the player's profile,
     * if found, otherwise returns a JSONObject containing the errorState handled
     * in the 'handleException' method of the Player class.
     * @see Player#handleException(JSONObject)
     */
    public static JSONObject fetchProfile(String profileUuid) {
        String url = "https://api.hypixel.net/v2/skyblock/profile?profile=" + profileUuid + "&key=" + App.getInstance().getConfig().getApikey();
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

    /**
     * Gets the crimson member of the class.
     * @return A Crimson Object.
     * @see Crimson
     */
    public Crimson getCrimson() {
        return crimson;
    }

    /**
     * Gets the List of Pet member of the class.
     * @return A List of 'Pet' Object.
     * @see Pet
     */
    public List<Pet> getPetList() {
        return petList;
    }

    /**
     * Gets the dungeon member of the class.
     * @return A Dungeon Object.
     * @see Dungeon
     */
    public Dungeon getDungeon() {
        return dungeon;
    }

    /**
     * Gets the fishing member of the class.
     * @return A Fishing Object.
     * @see Fishing
     */
    public Fishing getFishing() {
        return fishing;
    }

    /**
     * Gets the Map of 'String, Slayer' 'slayerList'.
     * @return A Map of 'String, Slayer' Object.
     */
    public Map<String, Slayer> getSlayerList() {
        return slayerList;
    }

    /**
     * Gets the List of members member of the class.
     * @return A List of 'String' Object.
     * @see SkyblockProfilesContainer#membersList
     */
    public List<String> getMembersList() {
        return membersList;
    }

    /**
     * Gets the mining member of the class.
     * @return A Mining Object.
     * @see Mining
     */
    public Mining getMining() {
        return mining;
    }

    /**
     * Gets the skills member of the class.
     * @return A Skills Object.
     * @see Skills
     */
    public Skills getSkills() {
        return skills;
    }

    /**
     * Gets the 'auctionsCreated' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#auctionsCreated
     */
    public String getAuctionsCreated() {
        return auctionsCreated;
    }

    /**
     * Gets the 'cuteName' member of the class.
     * @return A Dungeon Object.
     * @see Dungeon
     */
    public String getCuteName() {
        return cuteName;
    }

    /**
     * Gets the 'auctionCompleted' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#auctionCompleted
     */
    public String getAuctionCompleted() {
        return auctionCompleted;
    }

    /**
     * Gets the 'coinsEarned' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#coinsEarned
     */
    public String getCoinsEarned() {
        return coinsEarned;
    }

    /**
     * Gets the 'fairySoulCollected' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#fairySoulCollected
     */
    public String getFairySoulCollected() {
        return fairySoulCollected;
    }

    /**
     * Gets the 'firstJoin' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#firstJoin
     */
    public String getFirstJoin() {
        return firstJoin;
    }

    /**
     * Gets the 'highestBid' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#highestBid
     */
    public String getHighestBid() {
        return highestBid;
    }

    /**
     * Gets the 'giftGiven' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#giftGiven
     */
    public String getGiftGiven() {
        return giftGiven;
    }

    /**
     * Gets the 'giftReceived' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#giftReceived
     */
    public String getGiftReceived() {
        return giftReceived;
    }

    /**
     * Gets the 'level' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Gets the 'magicalPower' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#magicalPower
     */
    public String getMagicalPower() {
        return magicalPower;
    }

    /**
     * Gets the 'greenCandy' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#greenCandy
     */
    public String getGreenCandy() {
        return greenCandy;
    }

    /**
     * Gets the 'milestone' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#milestone
     */
    public String getMilestone() {
        return milestone;
    }

    /**
     * Gets the 'milestoneUnlockTiers' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#milestoneUnlockTiers
     */
    public String getMilestoneUnlockTiers() {
        return milestoneUnlockTiers;
    }

    /**
     * Gets the 'purse' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#purse
     */
    public String getPurse() {
        return purse;
    }

    /**
     * Gets the 'purpleCandy' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#purpleCandy
     */
    public String getPurpleCandy() {
        return purpleCandy;
    }

    /**
     * Gets the 'purseBank' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#purseBank
     */
    public String getPurseBank() {
        return purseBank;
    }

    /**
     * Gets the 'totalBids' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#totalBids
     */
    public String getTotalBids() {
        return totalBids;
    }

    /**
     * Gets the 'totalCandy' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#totalCandy
     */
    public String getTotalCandy() {
        return totalCandy;
    }

    /**
     * Gets the 'totalDeaths' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#totalDeaths
     */
    public String getTotalDeaths() {
        return totalDeaths;
    }

    /**
     * Gets the 'totalFees' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#totalFees
     */
    public String getTotalFees() {
        return totalFees;
    }

    /**
     * Gets the 'essenceList' member of the class.
     * @return A Map of 'String, String' Object.
     * @see SkyblockProfilesContainer#essenceList
     */
    public Map<String, String> getEssenceList() {
        return essenceList;
    }

    /**
     * Gets the 'totalMobKill' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#totalMobKill
     */
    public String getTotalMobKill() {
        return totalMobKill;
    }

    /**
     * Gets the 'totalXpSlayer' member of the class.
     * @return A String Object.
     * @see SkyblockProfilesContainer#totalXpSlayer
     */
    public String getTotalXpSlayer() {
        return totalXpSlayer;
    }
}
