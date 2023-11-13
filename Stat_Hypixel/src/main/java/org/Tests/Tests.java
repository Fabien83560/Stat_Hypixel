package org.Tests;

import org.Player.Player;

public class Tests {
    @org.junit.Test
    public void createPlayer() {
        Player player = new Player("Fabien83560");
        String name = player.getName();
        String firstLogin = player.getFirstLogin();

        assert name.contains("Fabien83560");
        assert firstLogin.contains("1499622366000");
    }
}