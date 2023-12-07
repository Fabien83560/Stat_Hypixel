package org.Player;

import org.DataBase.Database;
import org.Game.GamesContainer;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class creates a Player. It is used to find, use
 * and display all his statistics in the Hypixel server.
 * It also gets other global information, such as his
 * name, his first and last login and his Guild name for
 * example.
 */
public class Player {

    /**
     * A list of the global statistics of each player.
     */
    static final String[] statsList = {"displayname" , "uuid" , "lastLogin" , "firstLogin" , "newPackageRank"};

    /**
     * A Map that will contain all the global statistics of a player, based
     * on the list of global statistics above.
     * @see #statsList
     * @see #Player(String)
     */
    Map<String,String> statistics = new HashMap<>();

    /**
     * Boolean Object that has the 'true' value if the player is
     * online, and false otherwise.
     */
    boolean online;

    /**
     * This data member will store the different modes that are
     * available in the application: Bedwars, Skywars and Skyblock.
     * @see GamesContainer
     */
    GamesContainer games;

    /**
     * Constructor of the Player class. This constructor
     * uses the name of player to find him in the Hypixel
     * API. The constructor adds all the global statistics
     * of the player into an empty Map of 'String, String'
     * containing both the name of the statistic, and its
     * value, for example: Guild Name: French Legacy.
     * If a player doesn't exist, shows a JOptionPane
     * to the user to tell him this player is unknown.
     * Finally, this constructor instantiates the
     * GameContainer class to get the statistics of
     * the player, in he exists, in the modes.
     * @param Name A String containing the name of the
     *             player to find and to display.
     * @see Player#addStatistics(String, String)
     * @see Player#getStatistics(String)
     * @see GamesContainer#GamesContainer(JSONObject, JSONObject, String)
     */
    public Player(String Name) {
        String apikey = org.Config.ConfigReader.getApiKey();
        JSONObject jsonObjectPlayer = fetchPlayer(Name, apikey);
        try {
            Object playerObject;
            try {
                 playerObject = jsonObjectPlayer.get("player");
            }
            catch (JSONException exeption) {
                playerObject = null;
            }
            if (playerObject == null || playerObject.equals(JSONObject.NULL)) {
                JOptionPane.showMessageDialog(null,
                        "Player " + Name + " is unknown",
                        "Unknown Player",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                for (String stat : statsList) {
                    try {
                        addStatistics(stat, String.valueOf(jsonObjectPlayer.getJSONObject("player").get(stat)));
                    }
                    catch (Exception e)
                    {
                        addStatistics(stat, "N/A");
                    }
                }

                addStatistics("skin", String.valueOf(getSkinURL(getStatistics("uuid"))));
                addStatistics("guildName", fetchGuildName(getStatistics("uuid"), apikey));

                try {
                    long exp = jsonObjectPlayer.getJSONObject("player").getLong("networkExp");
                    addStatistics("hypixelLevel", String.format("%.2f", Math.sqrt((2 * exp) + 30625) / 50 - 2.5));
                }
                catch(JSONException e){
                    addStatistics("hypixelLevel", "N/A");
                }

                JSONObject jsonObjectStatus = fetchStatus(getStatistics("uuid"), apikey);
                online = jsonObjectStatus.getJSONObject("session").getBoolean("online");

                games = new GamesContainer(jsonObjectPlayer.getJSONObject("player").getJSONObject("stats"), jsonObjectPlayer.getJSONObject("player").getJSONObject("achievements"),getStatistics("uuid"));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
            handleException(jsonObjectPlayer);
        }
    }

    /**
     * This method handles all the different exceptions
     * that can appear while trying to fetch different
     * statistics of a Player instance, for example if
     * the API Key is invalid, or if the Skin of the
     * player couldn't be obtained.
     * @param jsonObject A JSONObject used to get the name
     *                   of the error that occured while
     *                   trying to fetch statistics of a
     *                   player.
     */
    public static void handleException(JSONObject jsonObject) {
        try {
            String errorState = jsonObject.getString("errorState");
            if (errorState.equals("429")) {
                System.out.println("You have already looked up this name recently");
            }
            else if (errorState.equals("403")) {
                System.out.println("Invalid API key");
            }
            else if (errorState.equals("STATUS")) {
                System.out.println("Unable to get Status of this Player");
            }
            else if (errorState.equals("SKIN"))
                System.out.println("Unable to get Skin of this Player");
            else {
                System.out.println("Unknown Error");
            }
        }
        catch (JSONException e) {
            System.out.println("An unexpected error occurred");
            e.printStackTrace();
        }
    }

    /**
     * Adds a statistic in the Map 'statistics', represented
     * by a pair (key, value). If the key isn't already mapped
     * to a value, or if mapped to null, adds it, otherwise,
     * returns the current value of the key.
     * @param key The key associated to the value 'value'
     * @param value The value associated to the key 'key'
     */
    public void addStatistics(String key, String value)
    {
        statistics.putIfAbsent(key, value);
    }

    /**
     * Gets the value associated with the key specified
     * as a parameter into the Map 'statistics', if it
     * exists, otherwise, returns null.
     * @param key The key used to find its associated value.
     * @return The value of the key, if it exists.
     */
    public String getStatistics(String key)
    {
        return statistics.get(key);
    }

    /**
     * Gets the 'statistics' map that contains all the global
     * statistics of a player.
     * @return The Map of 'String, String' that contains all the
     * statistics of a player.
     */
    public Map<String, String> getAllStatistics() {return statistics;}

    /**
     * Used in the 'fetchPlayer' method, this one checks whether a
     * specific error (429 or 403) happened while trying to fetch
     * a basic request to find a player. 429 error code means that
     * the player already have been looked up in the five last
     * minutes, and the 403 error code means that the API Key
     * is invalid to do the fetch.
     * @param str A String containing the error state
     * @return A String containing the error code 429
     * or 403, or an empty String if none of those matches
     * the regular expression.
     */
    public static String match(String str) {
        Pattern error_429 = Pattern.compile("[Server returned HTTP response code: 429 for URL:]");
        Pattern error_403 = Pattern.compile("[Server returned HTTP response code: 403 for URL:]");

        Matcher error_429_ = error_429.matcher(str);
        Matcher error_403_ = error_403.matcher(str);

        if (error_429_.find())
            return "429";
        else if(error_403_.find())
            return "403";
        return "";
    }

    /**
     * Tries to do a successful request to the Hypixel API
     * to get a JSONObject containing all the statistics of
     * a player instance. If an error occurs, returns a
     * JSONObject containing the error state. This function
     * also adds the player to the Database if his uuid isn't
     * already into the 'Player' table of the database.
     * @param name A String containing the name of the player
     *             to find.
     * @param apikey A String containing the API Key used in
     *               'config.yml' file to do a request.
     * @return A JSONObject containing either the player's
     * data, or an error state.
     * @see Database#Database()
     * @see Database#knowPlayer(String, String)
     * @see Database#addPlayerToDataBase(String, String)
     */
    public static JSONObject fetchPlayer(String name, String apikey) {
        String data = "";
        Database dataBase = new Database();
        try {
            String url = "";
            String uuid = dataBase.knowPlayer("", name);
            if (uuid != null)
                url = "https://api.hypixel.net/v2/player?uuid=" + uuid + "&key=" + apikey;
            else
                url = "https://api.hypixel.net/v2/player?name=" + name + "&key=" + apikey;

            data = fetch(url);
            JSONObject jsonObject = new JSONObject(data);

            if(uuid == null)
                dataBase.addPlayerToDataBase(jsonObject.getJSONObject("player").getString("uuid"), name);

            return jsonObject;
        }
        catch (Exception e) {
            JSONObject jsonError = new JSONObject();
            jsonError.put("errorState" , match(data));
            return jsonError;
        }
    }

    /**
     * Tries to get the status of the player in order to
     * know if he's offline, or online, and if he's online,
     * will show in the interface (in the friend List if that
     * player have been added into it) in which mod he plays.
     * @param uuid A String containing the uuid of the current
     *             player.
     * @param apikey A String containing the API Key used to do
     *               a fetch.
     * @return A JSONObject containing either the data stored in
     * the 'status' part of the API, or an error state if there was
     * an error trying to fetch the status.
     */
    public static JSONObject fetchStatus(String uuid,String apikey) {
        String url = "https://api.hypixel.net/v2/status?uuid=" + uuid + "&key=" + apikey;
        String data = fetch(url);
        try {
            return new JSONObject(data);
        }
        catch (Exception e) {
            JSONObject jsonError = new JSONObject();
            jsonError.put("errorState" , "STATUS");
            return jsonError;
        }
    }

    /**
     * This method tries to get the skin of the player by
     * returning the URL of his skin. If the skin can't be
     * obtained, shows an error.
     * @param uuid A String containing the uuid of the player
     *             whose skin we want.
     * @return A URL Object containing the URL of the skin of
     *         the player.
     */
    public static URL getSkinURL(String uuid) {
        try
        {
            String skinURL = "https://crafatar.com/renders/body/" + uuid;
            return new URI(skinURL).toURL();
        }
        catch(IOException | URISyntaxException e)
        {
            JSONObject jsonError = new JSONObject();
            jsonError.put("errorState" , "SKIN");
            handleException(jsonError);
        }
        return null;
    }

    /**
     * This method works the exact same way as 'getSkinURL',
     * but instead returns the name of the player's guild.
     * If the player doesn't have any guild, returns 'N/A'
     * meaning that the player does not belong to a guild.
     * @param uuid A String containing the uuid of the player.
     * @param apikey A String containing the API Key stored in
     *               'config.yml'.
     * @return A String containing the name of the player's guild,
     *         or 'N/A' if he doesn't have one.
     */
    public static String fetchGuildName(String uuid, String apikey) {
        try {
            String url = "https://api.hypixel.net/v2/guild?player=" + uuid + "&key=" + apikey;
            JSONObject object = new JSONObject(fetch(url));
            return object.getJSONObject("guild").getString("name");
        }
        catch (Exception e) {
            return "N/A";
        }
    }

    /**
     * This method is called by all the other 'fetch' methods
     * of the Player class to get a String Object containing
     * the data of the specified URL, but parsed to a String
     * Object. It allows to get specific objects of the
     * statistics in an easier way.
     * @param _url A String containing the URL of a request
     *             to do in the Hypixel API.
     * @return A String containing the data of the URL
     *         used in the parameter.
     */
    public static String fetch(String _url) {
        try
        {
            URL url = new URI(_url).toURL();

            InputStream is = url.openStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int bytesRead;
            byte[] buffer = new byte[1024];
            while((bytesRead = is.read(buffer)) != -1)
                baos.write(buffer, 0, bytesRead);

            String data = baos.toString(StandardCharsets.UTF_8);
            is.close();
            return data;

        }
        catch(IOException | URISyntaxException e)
        {
            System.out.println("Unable to fetch resource at " + _url);
            return e.getMessage();
        }
    }

    /**
     * Gets all the statistics of the different game modes
     * of the player.
     * @return A GameContainer Object containing the statistics
     * of all the modes of the player.
     * @see GamesContainer
     */
    public GamesContainer getGames(){return games;}
}