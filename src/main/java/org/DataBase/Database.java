package org.DataBase;

import org.Player.Player;

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
}
