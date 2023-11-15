package org.Player;

import org.Game.GamesContainer;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Player {
    static final String[] statsList = {"displayname" , "uuid" , "lastLogin" , "firstLogin" , "newPackageRank"};
    Map<String,String> statistics = new HashMap<>();
    boolean online;
    GamesContainer games;
    public Player(String Name)
    {
        String apikey = org.Config.ConfigReader.getApiKey();
        JSONObject jsonObjectPlayer = fetchPlayer(Name,apikey);

        for(String stat : statsList)
            addStatistics(stat, String.valueOf(jsonObjectPlayer.getJSONObject("player").get(stat)));

        addStatistics("skin", String.valueOf(getSkinURL(getStatistics("uuid"))));
        addStatistics("guildName", fetchGuildName(getStatistics("uuid"),apikey));

        long exp = jsonObjectPlayer.getJSONObject("player").getLong("networkExp");
        addStatistics("hypixelLevel", String.format("%.2f", Math.sqrt((2 * exp) + 30625) / 50 - 2.5));

        JSONObject jsonObjectStatus = fetchStatus(getStatistics("uuid"),apikey);
        this.online = jsonObjectStatus.getJSONObject("session").getBoolean("online");

        this.games = new GamesContainer(jsonObjectPlayer.getJSONObject("player").getJSONObject("stats") , jsonObjectPlayer.getJSONObject("player").getJSONObject("achievements"));
        display();
    }

    public void addStatistics(String key, String value)
    {
        this.statistics.putIfAbsent(key, value);
    }

    public String getStatistics(String key)
    {
        return this.statistics.get(key);
    }
    public static JSONObject fetchPlayer(String Name,String apikey)
    {
        String url = "https://api.hypixel.net/player?name=" + Name + "&key=" + apikey;
        return  new JSONObject(fetch(url));
    }

    public static JSONObject fetchStatus(String uuid,String apikey)
    {
        String url = "https://api.hypixel.net/status?uuid=" + uuid + "&key=" + apikey;
        return  new JSONObject(fetch(url));
    }

    public static URL getSkinURL(String uuid)
    {
        try
        {
            String skinURL = "https://crafatar.com/renders/body/" + uuid;
            return new URI(skinURL).toURL();
        }
        catch(IOException | URISyntaxException e)
        {
            System.out.println("Unable to create Skin URL : " + e.toString());
        }
        return null;
    }

    public static String fetchGuildName(String uuid, String apikey)
    {
        try {
            String url = "https://api.hypixel.net/v2/guild?player=" + uuid + "&key=" + apikey;
            JSONObject object = new JSONObject(fetch(url));
            return object.getJSONObject("guild").getString("name");
        }
        catch (Exception e) {
            return "N/A";
        }
    }
    public static String fetch(String _url)
    {
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
        }

        return null;
    }
    public void display()
    {
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