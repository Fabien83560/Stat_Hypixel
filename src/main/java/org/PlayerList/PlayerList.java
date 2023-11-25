package org.PlayerList;

import org.DataBase.Database;
import org.Player.Player;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class PlayerList {
    Map<String, String> playerList = new HashMap<>();
    public PlayerList() throws SQLException {
        Database dataBase = new Database();
        String sql = "SELECT * FROM playerList";
        try {
            PreparedStatement statement = dataBase.getDataBase().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                String uuid = result.getString("uuid");
                String name = result.getString("displayName");
                this.addPlayer(name,uuid);
            }
            result.close();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addPlayer(String player,String uuid) {
        String p = playerList.get(player);
        if(p == null)
            playerList.put(player, uuid);
        else
            System.out.println("This player is already in the list");
    }
    public void addPlayer(String player) {
        String p = playerList.get(player);
        if(p == null)
            playerList.put(player , Player.fetchPlayer(player,org.Config.ConfigReader.getApiKey()).getJSONObject("player").getString("uuid"));
        else
            System.out.println("This player is already in the list");
    }
    public void removePlayer(String player){
        String p = playerList.get(player);
        if(p != null)
            playerList.remove(player);
        else
            System.out.println("This player is not in the list");
    }
    public Map<String , String> getList(){return this.playerList;}
}
