package org.DataBase;

import javax.swing.*;
import java.sql.*;

/**
 * This class is meant to create and manage the database in order to store
 * data related to the Player and FriendList classes.
 */
public class Database {

    /**
     * The dataBase Object. Used to connect the application to its DataBase.
     */
    Connection dataBase;

    /**
     * The URL of the DataBase.
     */
    final String url = "jdbc:mysql://mysql-iitzwolfyy.alwaysdata.net:3306/iitzwolfyy_stats_hypixel";

    /**
     * The username of the DataBase.
     */
    final String username = "333319";

    /**
     * The password of the DataBase.
     */
    final String password = "}ZVZe7tECD+h>_&";

    /**
     * Constructor of the DataBase class. Connects the Database to the
     * application through the URL, Username and Password of the Database.
     */
    public Database(){
        try {
            dataBase = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the DataBase object.
     * @return A Connection Object containing the DataBase itself.
     */
    public Connection getDataBase(){return dataBase;}

    /**
     * Method to add a player to the 'FriendList' table of the DataBase, using his
     * uuid and his name. If the INSERT command is unsuccessful, shows a dialog to
     * the user telling him that an error occurred while trying to add him,
     * otherwise, shows a dialog meaning that the player has successfully been added.
     * @param uuid A String Object containing the uuid of the player to add.
     * @param name A String Object containing the name of the player to add.
     */
    public void addFriendPlayerToDataBase(String uuid, String name){
        try {
            String sql = "INSERT INTO `FriendList`(`uuid`, `displayName`) VALUES (?,?)";
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
            JOptionPane.showMessageDialog(null,
                    "Error trying to add " + name + " to the FriendList table of the DataBase.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method to remove a player from the 'FriendList' table of the DataBase, using his
     * name as a parameter to find him. If the DELETE command is unsuccessful, shows a dialog
     * to the user telling him that an error occurred while trying to remove him,
     * otherwise, shows a JOptionPane meaning that the player has successfully been removed.
     * @param name A String Object containing the name of the player to remove.
     */
    public void removeFriendPlayerFromDataBase(String name) {
        try {
            String sql = "DELETE FROM `FriendList` WHERE displayName = ?";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1,name);
            int modify = statement.executeUpdate();
            if(modify > 0)
                JOptionPane.showMessageDialog(null,
                        "Player has been correctly removed",
                        "Player removed",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error trying to remove " + name + " to the FriendList table of the DataBase.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Add a player in the 'Player' table of the DataBase, using his
     * uuid and his name. If the INSERT command is unsuccessful, throws a SQLException.
     * @param uuid A String Object containing the uuid of the player to add.
     * @param name A String Object containing the name of the player to add.
     */
    public void addPlayerToDataBase(String uuid, String name) {
        try {
            String sql = "INSERT INTO Player (uuid,displayName) VALUES (?, ?)";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1, uuid);
            statement.setString(2, name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error trying to add " + name + " to the Player table of the DataBase.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Method returning the uuid of a player if the latter is already known
     * in the 'Player' table of the DataBase. If it isn't, returns null.
     * @param uuid The uuid of the player
     * @param name The name of the player.
     * @return A String Object containing the uuid of the player, if it's in the 'Player' table.
     *         Otherwise, returns null.
     */
    public String knowPlayer(String uuid, String name) {
        try {
            String sql = "SELECT uuid FROM Player WHERE uuid = ? OR displayName = ?";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1, uuid);
            statement.setString(2, name);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getString("uuid");
        }
        catch (SQLException e) {
            return null;
        }
    }
}
