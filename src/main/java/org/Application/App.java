package org.Application;

import com.formdev.flatlaf.FlatDarkLaf;
import org.Config.Config;
import org.DataBase.Database;
import org.Window.Player.WindowPlayer;
import org.Window.Window;
import javax.swing.*;

/**
 * The App class instantiates the base of the application.
 * It initializes the Database, Config and Window classes to
 * start the app.
 * @see Database
 * @see Config
 * @see Window
 */
public final class App {

    /**
     * The database used with that application.
     */
    Database dataBase;

    /**
     * The Config class initializing the configuration data of
     * the application.
     */
    Config config;

    /**
     * An instance of that same class. It is used to stop the actual
     * instance of the application, and make sure it is only launched once.
     */
    private static App instance;

    /**
     * The main window instance of the application. It displays
     * everything else into it.
     * @see Window
     */
    public Window window;

    /**
     * Constructor of the App class, used to initialize
     * the dark theme and associate the 'instance' data
     * member to the current 'App' class.
     * @see App#instance
     */
    public App() {
        instance = this;
        FlatDarkLaf.setup();
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {
        }
    }

    /**
     * Gets the current application instance.
     * @return An App Object.
     */
    public static App getInstance() {
        if (instance == null)
            synchronized (App.class) {
                if (instance == null)
                    instance = new App();
            }
        return instance;
    }

    /**
     * Gets the config data member.
     * @return A Config Object.
     * @see Config
     */
    public Config getConfig() {
        return config;
    }

    /**
     * Gets the database of the application.
     * @return A Database Object.
     * @see Database
     */
    public Database getDataBase() {
        return dataBase;
    }

    /**
     * Loads the application when launched, initializing
     * the Config, Database and Window of the application.
     * @see Config
     * @see Database
     * @see Window
     * @see WindowPlayer
     */
    public void loadWindow() {
        config = new Config();
        dataBase = new Database();
        WindowPlayer windowPlayer = new WindowPlayer();
        window = new Window(windowPlayer.getMainPanel());
    }
}
