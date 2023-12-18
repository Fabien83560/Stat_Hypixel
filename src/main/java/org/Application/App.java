package org.Application;

import com.formdev.flatlaf.FlatDarkLaf;
import org.Config.Config;
import org.DataBase.Database;
import org.Window.Player.WindowPlayer;
import org.Window.Window;

import javax.swing.*;

public final class App {
    /**
     * The database used with that application.
     */
    Database dataBase;
    Config config;
    private static volatile App instance;
    public Window window;

    public App() {
        instance = this;
        FlatDarkLaf.setup();
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static App getInstance() {
        if (instance == null)
            synchronized (App.class) {
                if (instance == null)
                    instance = new App();
            }
        return instance;
    }

    public Config getConfig() {
        return config;
    }

    public Database getDataBase() {
        return dataBase;
    }

    public void loadWindow() {
        config = new Config();
        dataBase = new Database();
        WindowPlayer windowPlayer = new WindowPlayer();
        window = new Window(windowPlayer.getMainPanel());
    }
}
