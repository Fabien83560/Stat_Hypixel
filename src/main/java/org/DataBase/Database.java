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
            e.printStackTrace();
        }
    }
    public void removeFriendPlayerToDataBase(String name) {
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
            e.printStackTrace();
        }
    }
    public void addPlayerToDataBase(String uuid,String name) {
        try {
            String sql = "INSERT INTO Player (uuid,displayName) VALUES (?,?)";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1,uuid);
            statement.setString(2,name);
            int modify = statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String knowPlayer(String uuid,String Name) {
        try {
            String sql = "SELECT uuid FROM Player WHERE uuid = ? OR displayName = ?";
            PreparedStatement statement = dataBase.prepareStatement(sql);
            statement.setString(1,uuid);
            statement.setString(2,Name);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getString("uuid");
        }
        catch (Exception e) {
            return null;
        }
    }
}
