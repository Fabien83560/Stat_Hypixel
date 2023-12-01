package org.Player;

import org.DataBase.Database;
import org.Game.GamesContainer;
import org.json.JSONException;
import org.json.JSONObject;
import org.Window.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

public class Player {
    static final String[] statsList = {"displayname" , "uuid" , "lastLogin" , "firstLogin" , "newPackageRank"};
    Map<String,String> statistics = new HashMap<>();
    boolean online;
    GamesContainer games;
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
                        "Player " + Name + " is Unknown",
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
                this.online = jsonObjectStatus.getJSONObject("session").getBoolean("online");

                this.games = new GamesContainer(jsonObjectPlayer.getJSONObject("player").getJSONObject("stats"), jsonObjectPlayer.getJSONObject("player").getJSONObject("achievements"),getStatistics("uuid"));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
            handleException(jsonObjectPlayer);
        }
    }

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

    public void addStatistics(String key, String value)
    {
        this.statistics.putIfAbsent(key, value);
    }

    public String getStatistics(String key)
    {
        return this.statistics.get(key);
    }

    public Map<String, String> getAllStatistics() {return this.statistics;}

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

    public static JSONObject fetchPlayer(String name,String apikey) {
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

    public static String fetch(String _url) {
        try
        {
            URL url = new URI(_url).toURL();

            InputStream is = url.openStream();
            ReadableByteChannel rbc = Channels.newChannel(is);

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

    public void display() {
        System.out.println("Name : " + getStatistics("displayname"));
        System.out.println("Uuid : " + getStatistics("uuid"));
        System.out.println("Rank : " + getStatistics("newPackageRank"));
        System.out.println("Hypixel Level : " + getStatistics("hypixelLevel"));
        System.out.println("Online : " + this.online);
        System.out.println("First Login : " + getStatistics("firstLogin"));
        System.out.println("Last Login : " + getStatistics("lastLogin"));
        System.out.println("Guild Name : " + getStatistics("guildName"));
        System.out.println("Skin at : " + getStatistics("skin"));
        System.out.println();
        this.games.display();
    }
}