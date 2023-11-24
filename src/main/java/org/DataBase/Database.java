package org.DataBase;

import org.Player.Player;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.sql.*;

public class Database {
    Connection dataBase;
    String url,username,password;

    public Database(){
        this.url = org.Config.ConfigReader.getUrlDataBase();
        this.username = org.Config.ConfigReader.getUsernameDataBase();
        this.password = org.Config.ConfigReader.getPasswordDataBase();
        try {
            this.dataBase = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getDataBase(){return this.dataBase;}

    public void addFriendPlayerToDataBase(String uuid,String name){
        try {
            String sql = "INSERT INTO `playerList`(`uuid`, `displayName`) VALUES (?,?)";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1,uuid);
            statement.setString(2,name);
            int modify = statement.executeUpdate();
            if(modify > 0)
                JOptionPane.showMessageDialog(null,
                        "Player " + name + " has been correctly added",
                        "Player added",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeFriendPlayerToDataBase(String uuid) {
        try {
            String sql = "DELETE FROM `playerList` WHERE uuid = ?";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1,uuid);
            int modify = statement.executeUpdate();
            if(modify > 0)
                JOptionPane.showMessageDialog(null,
                        "Player has been correctly removed",
                        "Player removed",
                        JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPlayerToDataBase(JSONObject jsonObject) {
        try {
            String sql = "INSERT INTO `Player`(`uuid`, `displayname`, `lastLogin`, `firstLogin`, `newPackageRank`, `online`, `skin`, `guildName`, `hypixelLevel`, `lastModified` ) VALUES (?,?,?,?,?,?,?,?,?,DEFAULT)";
            PreparedStatement statement = dataBase.prepareStatement(sql);

            statement.setString(1,String.valueOf(jsonObject.getJSONObject("player").get("uuid")));
            statement.setString(2,String.valueOf(jsonObject.getJSONObject("player").get("displayname")));
            statement.setString(3,String.valueOf(jsonObject.getJSONObject("player").get("lastLogin")));
            statement.setString(4,String.valueOf(jsonObject.getJSONObject("player").get("firstLogin")));
            statement.setString(5,String.valueOf(jsonObject.getJSONObject("player").get("newPackageRank")));
            statement.setString(6,String.valueOf(Player.fetchStatus(jsonObject.getJSONObject("player").getString("uuid"),org.Config.ConfigReader.getApiKey()).getJSONObject("session").get("online")));
            statement.setString(7,String.valueOf(Player.getSkinURL(jsonObject.getJSONObject("player").getString("uuid"))));
            statement.setString(8,Player.fetchGuildName(jsonObject.getJSONObject("player").getString("uuid"),org.Config.ConfigReader.getApiKey()));
            statement.setString(9,String.format("%.2f", Math.sqrt((2 * jsonObject.getJSONObject("player").getLong("networkExp")) + 30625) / 50 - 2.5));
            int modify = statement.executeUpdate();

            sql = "INSERT INTO `Skywars`(`player_uuid`, `wins`, `deaths`, `losses`, `kills`, `wins_solo`, `deaths_solo`, `losses_solo`, `kills_solo`, `wins_team`, `deaths_team`, `losses_team`, `kills_team`, `wins_solo_normal`, `deaths_solo_normal`, `losses_solo_normal`, `kills_solo_normal`, `wins_solo_insane`, `deaths_solo_insane`, `losses_solo_insane`, `kills_solo_insane`, `wins_team_normal`, `deaths_team_normal`, `losses_team_normal`, `kills_team_normal`, `wins_team_insane`, `deaths_team_insane`, `losses_team_insane`, `kills_team_insane`, `lastModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,DEFAULT)";
            statement = dataBase.prepareStatement(sql);

            statement.setString(1,String.valueOf(jsonObject.getJSONObject("player").get("uuid")));

            String [] tabListSkyWars = {"wins", "deaths", "losses", "kills", "wins_solo", "deaths_solo", "losses_solo", "kills_solo", "wins_team", "deaths_team", "losses_team", "kills_team", "wins_solo_normal", "deaths_solo_normal", "losses_solo_normal", "kills_solo_normal", "wins_solo_insane", "deaths_solo_insane", "losses_solo_insane", "kills_solo_insane", "wins_team_normal", "deaths_team_normal", "losses_team_normal", "kills_team_normal", "wins_team_insane", "deaths_team_insane", "losses_team_insane", "kills_team_insane"};
            int increment = 2;
            try {
                JSONObject jsonSkyWars = jsonObject.getJSONObject("player").getJSONObject("stats").getJSONObject("SkyWars");
                for(String element : tabListSkyWars)
                {
                    try {
                        String value = String.valueOf(jsonSkyWars.get(element));
                        statement.setString(increment,value);
                        increment++;
                    }
                    catch (JSONException e) {
                        statement.setString(increment,"N/A");
                        increment++;
                    }
                }
            }
            catch (JSONException e) {
                for(int i = 0 ; i < tabListSkyWars.length; i ++)
                    statement.setString(i+2,"N/A");
            }
            modify = statement.executeUpdate();

            sql = "INSERT INTO `Bedwars`(`player_uuid`, `bedwars_level`, `coins`, `eight_one_games_played_bedwars`, `eight_one_wins_bedwars`, `eight_one_losses_bedwars`, `eight_one_kills_bedwars`, `eight_one_deaths_bedwars`, `eight_one_final_kills_bedwars`, `eight_one_winstreak`, `eight_one_beds_broken_bedwars`, `eight_one_beds_lost_bedwars`, `eight_two_games_played_bedwars`, `eight_two_wins_bedwars`, `eight_two_losses_bedwars`, `eight_two_kills_bedwars`, `eight_two_deaths_bedwars`, `eight_two_final_kills_bedwars`, `eight_two_winstreak`, `eight_two_beds_broken_bedwars`, `eight_two_beds_lost_bedwars`, `four_three_games_played_bedwars`, `four_three_wins_bedwars`, `four_three_losses_bedwars`, `four_three_kills_bedwars`, `four_three_deaths_bedwars`, `four_three_final_kills_bedwars`, `four_three_winstreak`, `four_three_beds_broken_bedwars`, `four_three_beds_lost_bedwars`, `four_four_games_played_bedwars`, `four_four_wins_bedwars`, `four_four_losses_bedwars`, `four_four_kills_bedwars`, `four_four_deaths_bedwars`, `four_four_final_kills_bedwars`, `four_four_winstreak`, `four_four_beds_broken_bedwars`, `four_four_beds_lost_bedwars`, `lastModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,DEFAULT)";
            statement = dataBase.prepareStatement(sql);

            statement.setString(1,String.valueOf(jsonObject.getJSONObject("player").get("uuid")));

            String [] tabListBedWars = {"bedwars_level", "coins", "eight_one_games_played_bedwars", "eight_one_wins_bedwars", "eight_one_losses_bedwars", "eight_one_kills_bedwars", "eight_one_deaths_bedwars", "eight_one_final_kills_bedwars", "eight_one_winstreak", "eight_one_beds_broken_bedwars", "eight_one_beds_lost_bedwars", "eight_two_games_played_bedwars", "eight_two_wins_bedwars", "eight_two_losses_bedwars", "eight_two_kills_bedwars", "eight_two_deaths_bedwars", "eight_two_final_kills_bedwars", "eight_two_winstreak", "eight_two_beds_broken_bedwars", "eight_two_beds_lost_bedwars", "four_three_games_played_bedwars", "four_three_wins_bedwars", "four_three_losses_bedwars", "four_three_kills_bedwars", "four_three_deaths_bedwars", "four_three_final_kills_bedwars", "four_three_winstreak", "four_three_beds_broken_bedwars", "four_three_beds_lost_bedwars", "four_four_games_played_bedwars", "four_four_wins_bedwars", "four_four_losses_bedwars", "four_four_kills_bedwars", "four_four_deaths_bedwars", "four_four_final_kills_bedwars", "four_four_winstreak", "four_four_beds_broken_bedwars", "four_four_beds_lost_bedwars"};
            increment = 2;
            try {
                JSONObject jsonBedWars = jsonObject.getJSONObject("player").getJSONObject("stats").getJSONObject("Bedwars");
                for(String element : tabListBedWars)
                {
                    try {
                        String value = String.valueOf(jsonBedWars.get(element));
                        statement.setString(increment,value);
                        increment++;
                    }
                    catch (JSONException e) {
                        statement.setString(increment,"N/A");
                        increment++;
                    }
                }
            }
            catch (JSONException e) {
                for(int i = 0 ; i < tabListBedWars.length; i ++)
                    statement.setString(i+2,"N/A");
            }
            modify = statement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error adding a Player to DataBase");
            e.printStackTrace();
        }
    }
    public JSONObject get(String Name) {
        String uuid = "";
        try {
            String sql = "SELECT * FROM Player WHERE displayname = ?";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1,Name);
            ResultSet result = statement.executeQuery();

            JSONObject jsonObjectResult = new JSONObject();
            JSONObject jsonObjectPlayer = new JSONObject();
            JSONObject jsonObjectAchievements = new JSONObject();
            JSONObject jsonObjectStats = new JSONObject();
            JSONObject jsonObjectSkyWars = new JSONObject();
            JSONObject jsonObjectBedwars = new JSONObject();

            while(result.next())
            {
                uuid = result.getString("uuid");
                jsonObjectPlayer.put("uuid",result.getString("uuid"));
                jsonObjectPlayer.put("displayname",result.getString("displayname"));
                jsonObjectPlayer.put("lastLogin",result.getString("lastLogin"));
                jsonObjectPlayer.put("firstLogin",result.getString("firstLogin"));
                jsonObjectPlayer.put("newPackageRank",result.getString("newPackageRank"));
                jsonObjectPlayer.put("online",result.getString("online"));
                jsonObjectPlayer.put("skin",result.getString("skin"));
                jsonObjectPlayer.put("guildName",result.getString("guildName"));
                jsonObjectPlayer.put("hypixelLevel",result.getString("hypixelLevel"));
            }

            result.close();
            sql = "SELECT * FROM Skywars WHERE player_uuid = ?";
            statement = dataBase.prepareStatement(sql);
            statement.setString(1,uuid);
            ResultSet result2 = statement.executeQuery();

            while (result2.next())
            {
                String [] skywarsList = {"wins", "deaths", "losses", "kills", "wins_solo", "deaths_solo", "losses_solo", "kills_solo", "wins_team", "deaths_team", "losses_team", "kills_team", "wins_solo_normal", "deaths_solo_normal", "losses_solo_normal", "kills_solo_normal", "wins_solo_insane", "deaths_solo_insane", "losses_solo_insane", "kills_solo_insane", "wins_team_normal", "deaths_team_normal", "losses_team_normal", "kills_team_normal", "wins_team_insane", "deaths_team_insane", "losses_team_insane", "kills_team_insane"};
                for(String element : skywarsList)
                    jsonObjectSkyWars.put(element,result2.getString(element));
            }
            result2.close();

            sql = "SELECT * FROM Bedwars WHERE player_uuid = ?";
            statement = dataBase.prepareStatement(sql);
            statement.setString(1,uuid);
            ResultSet result3 = statement.executeQuery();

            while (result3.next())
            {
                String [] bedwarsList = {"coins", "eight_one_games_played_bedwars", "eight_one_wins_bedwars", "eight_one_losses_bedwars", "eight_one_kills_bedwars", "eight_one_deaths_bedwars", "eight_one_final_kills_bedwars", "eight_one_winstreak", "eight_one_beds_broken_bedwars", "eight_one_beds_lost_bedwars", "eight_two_games_played_bedwars", "eight_two_wins_bedwars", "eight_two_losses_bedwars", "eight_two_kills_bedwars", "eight_two_deaths_bedwars", "eight_two_final_kills_bedwars", "eight_two_winstreak", "eight_two_beds_broken_bedwars", "eight_two_beds_lost_bedwars", "four_three_games_played_bedwars", "four_three_wins_bedwars", "four_three_losses_bedwars", "four_three_kills_bedwars", "four_three_deaths_bedwars", "four_three_final_kills_bedwars", "four_three_winstreak", "four_three_beds_broken_bedwars", "four_three_beds_lost_bedwars", "four_four_games_played_bedwars", "four_four_wins_bedwars", "four_four_losses_bedwars", "four_four_kills_bedwars", "four_four_deaths_bedwars", "four_four_final_kills_bedwars", "four_four_winstreak", "four_four_beds_broken_bedwars", "four_four_beds_lost_bedwars"};
                for(String element : bedwarsList)
                    jsonObjectBedwars.put(element,result3.getString(element));
                jsonObjectAchievements.put("bedwars_level",result3.getString("bedwars_level"));
            }
            result3.close();

            jsonObjectStats.put("Bedwars",jsonObjectBedwars);
            jsonObjectStats.put("SkyWars",jsonObjectSkyWars);
            jsonObjectPlayer.put("stats",jsonObjectStats);
            jsonObjectPlayer.put("achievements",jsonObjectAchievements);
            jsonObjectResult.put("player",jsonObjectPlayer);

            return jsonObjectResult;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return new JSONObject("");
        }
    }
    public long getLastModified(String Name) {
        try {
            String sql = "SELECT lastModified FROM Player WHERE displayname = ?";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1, Name);
            ResultSet result = statement.executeQuery();
            while(result.next())
                return result.getTimestamp("lastModified").getTime();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public boolean lastModified(String name,long timestamp) {
        try {
            long timestampPlayer = getLastModified(name);

            long timeDifferenceInMilliseconds = timestamp - timestampPlayer;
            long timeDifferenceInSeconds = timeDifferenceInMilliseconds / 1000;
            long timeDifferenceInMinutes = timeDifferenceInSeconds / 60;

            return !(timeDifferenceInMinutes > 1 || (timeDifferenceInMinutes == 1 && timeDifferenceInSeconds % 60 > 30));

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
