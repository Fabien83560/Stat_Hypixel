package org.PlayerList;

import org.DataBase.Database;
import org.Player.Player;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class FriendList {
    Map<String, String> friendList = new HashMap<>();
    public FriendList() throws SQLException {
        Database dataBase = new Database();
        String sql = "SELECT * FROM FriendList";
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
        String p = friendList.get(player);
        if(p == null)
            friendList.put(player, uuid);
        else
            System.out.println("This player is already in the list");
    }

    public void removePlayer(String player) {
        String p = friendList.get(player);
        if(p != null)
            friendList.remove(player);
        else
            System.out.println("This player is not in the list");
    }

    public Map<String , String> getList(){return this.friendList;}
}
