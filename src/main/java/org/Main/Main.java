package org.Main;

import com.formdev.flatlaf.FlatDarkLaf;
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
        FlatDarkLaf.setup();
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        WindowPlayer windowPlayer = new WindowPlayer();
        Window w = new Window(windowPlayer.getMainPanel());
    }
}