package org.Tests;

import org.Player.Player;

public class Tests {
    @org.junit.Test
    public void createPlayer() {
        Player player = new Player("Fabien83560");
        String name = player.getStatistics("name");
        String firstLogin = player.getStatistics("firstLogin");
        String uuid = player.getStatistics("uuid");

        assert name.contains("Fabien83560");
        assert firstLogin.contains("1499622366000");
        assert uuid.contains("8a4819c8c92849e1b1522c3d2be0a88c");
    }
}