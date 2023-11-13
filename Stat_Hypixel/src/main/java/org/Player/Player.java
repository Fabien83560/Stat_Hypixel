package org.Player;

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

public class Player {

    String name;
    String uuid;
    String firstLogin;
    String lastLogin;
    String rank;
    String hypixelLevel;
    URL skin;
    boolean online;
    public Player(String Name)
    {
        this.name = Name;
        String apikey = org.Config.ConfigReader.getApiKey();
        JSONObject jsonObjectPlayer = fetchPlayer(this.name,apikey);
        this.uuid = jsonObjectPlayer.getJSONObject("player").getString("uuid");
        this.lastLogin = String.valueOf(jsonObjectPlayer.getJSONObject("player").getLong("lastLogin"));
        this.firstLogin = String.valueOf(jsonObjectPlayer.getJSONObject("player").getLong("firstLogin"));
        this.rank = jsonObjectPlayer.getJSONObject("player").getString("newPackageRank");
        long exp = jsonObjectPlayer.getJSONObject("player").getLong("networkExp");
        this.hypixelLevel = String.format("%.2f", Math.sqrt((2 * exp) + 30625) / 50 - 2.5);

        JSONObject jsonObjectStatus = fetchStatus(this.uuid,apikey);
        this.online = jsonObjectStatus.getJSONObject("session").getBoolean("online");

        this.skin = fetchSkin(this.uuid);
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

    public static URL fetchSkin(String uuid)
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
        System.out.println("Name : " + this.name);
        System.out.println("Uuid : " + this.uuid);
        System.out.println("Rank : " + this.rank);
        System.out.println("Hypixel Level : " + this.hypixelLevel);
        System.out.println("Online : " + this.online);
        System.out.println("First Login : " + this.firstLogin);
        System.out.println("Last Login : " + this.lastLogin);
        System.out.println("Skin at : " + this.skin);
    }

    public String getName() {return this.name;}
    public String getUuid() {return this.uuid;}
    public String getRank() {return this.rank;}
    public String getHypixelLevel() {return this.hypixelLevel;}
    public boolean isOnline() {return this.online;}
    public String getFirstLogin() {return this.firstLogin;}
    public String getLastLogin() {return this.lastLogin;}
    public URL getSkin() {return this.skin;}
}