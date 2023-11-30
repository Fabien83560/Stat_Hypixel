package org.Main;

import org.Window.Window;
import org.Window.WindowPlayer;

public class Main {
    public static void main(String[] args)
    {
        WindowPlayer windowPlayer = new WindowPlayer();
        Window w = new Window(windowPlayer.getMainPanel());
    }
}