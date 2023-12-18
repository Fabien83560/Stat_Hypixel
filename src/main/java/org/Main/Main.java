package org.Main;

import org.Application.App;
import org.Window.Window;
import org.Window.Player.WindowPlayer;
import javax.swing.*;

/**
 * Main class that creates everything in the window for the interface.
 * Sets up everything for the application to run properly without any
 * issue.
 */
public class Main {
    /**
     * main method of the Main class.
     * Necessary for the application to run.
     * @param args A list of arguments (unused)
     * @see WindowPlayer#WindowPlayer()
     * @see Window#Window(JPanel)
     */
    public static void main(String[] args)
    {
        App app = new App();
        app.loadWindow();
    }
}