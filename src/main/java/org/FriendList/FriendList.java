package org.FriendList;

import org.Application.App;
import org.DataBase.Database;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class instantiates a friend list used in the interface for the user
 * to add/remove a player from this list, and display the statistics of the
 * selected player. Interacts with the Database. Uses a Map of String, String
 * to store the players, the first String being the name of the player, the
 * second one being his uuid.
 */
public class FriendList {

    /**
     * A Map that will contain all the players the user decided
     * to add into his friend list.
     */
    Map<String, String> friendList = new HashMap<>();

    /**
     * Default constructor of the FriendList, creating a new DataBase object
     * and adding all the known players to the JList displayed on the left
     * side of the user interface.
     * @throws SQLException if a Database error occurs.
     * @see Database
     * @see FriendList#addPlayer(String, String)
     */
    public FriendList() throws SQLException {
        Database dataBase = App.getInstance().getDataBase();
        String sql = "SELECT * FROM FriendList";
        try {
            PreparedStatement statement = dataBase.getDataBase().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String uuid = result.getString("uuid");
                String name = result.getString("displayName");
                addPlayer(name,uuid);
            }
            result.close();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a player to the JList displayed in the user interface by doing
     * a SQL Request to the 'FriendList' table of the Database, to get all
     * the players that the user added into the list.
     * @param player A String Object containing the name of the player to add.
     * @param uuid A String containing the uuid of the player to add.
     */
    public void addPlayer(String player, String uuid) {
        if(friendList.get(player) == null)
            friendList.put(player, uuid);
    }

    /**
     * Removes a player from the friend list displayed in the interface.
     * Another method from the Database class removes the player from
     * the 'FriendList' table of the database.
     * @param player The player to remove from the friend list.
     * @see Database#removeFriendPlayerFromDataBase(String)
     */
    public void removePlayer(String player) {
        if(friendList.get(player) != null)
            friendList.remove(player);
    }

    /**
     * Gets the friend list of the user.
     * @return A Map of 'String, String' Object containing the friend list of the user.
     */
    public Map<String , String> getList(){return friendList;}
}
