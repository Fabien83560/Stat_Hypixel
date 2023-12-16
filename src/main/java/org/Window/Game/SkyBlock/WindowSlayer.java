package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Slayer;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WindowSlayer {
    private JPanel mainPanel;
    private JLabel zombieExpLabel;
    private JLabel tier1ZombieLabel;
    private JLabel tier2ZombieLabel;
    private JLabel tier3ZombieLabel;
    private JLabel tier4ZombieLabel;
    private JLabel tier5ZombieLabel;
    private JLabel spiderExpLabel;
    private JLabel wolfExpLabel;
    private JLabel endermanExpLabel;
    private JLabel blazeExpLabel;
    private JLabel vampireExpLabel;
    private JLabel totalXpSlayerLabel;
    private JLabel tier1SpiderLabel;
    private JLabel tier2SpiderLabel;
    private JLabel tier3SpiderLabel;
    private JLabel tier4SpiderLabel;
    private JLabel tier5SpiderLabel;
    private JLabel tier1WolfLabel;
    private JLabel tier2WolfLabel;
    private JLabel tier3WolfLabel;
    private JLabel tier4WolfLabel;
    private JLabel tier5WolfLabel;
    private JLabel tier1EndermanLabel;
    private JLabel tier2EndermanLabel;
    private JLabel tier3EndermanLabel;
    private JLabel tier4EndermanLabel;
    private JLabel tier5EndermanLabel;
    private JLabel tier1BlazeLabel;
    private JLabel tier2BlazeLabel;
    private JLabel tier3BlazeLabel;
    private JLabel tier4BlazeLabel;
    private JLabel tier5BlazeLabel;
    private JLabel tier1VampireLabel;
    private JLabel tier2VampireLabel;
    private JLabel tier3VampireLabel;
    private JLabel tier4VampireLabel;
    private JLabel tier5VampireLabel;
    private JLabel titleLabel;

    public WindowSlayer(Map<String,Slayer> slayers, String xp) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        totalXpSlayerLabel.setText(xp);
        Slayer s = slayers.get("zombie");
        zombieExpLabel.setText("Exp : " + s.getExp());
        tier1ZombieLabel.setText("Tier 1 : " + s.getTier1());
        tier2ZombieLabel.setText("Tier 2 : " + s.getTier2());
        tier3ZombieLabel.setText("Tier 3 : " + s.getTier3());
        tier4ZombieLabel.setText("Tier 4 : " + s.getTier4());
        tier5ZombieLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("spider");
        spiderExpLabel.setText("Exp : " + s.getExp());
        tier1SpiderLabel.setText("Tier 1 : " + s.getTier1());
        tier2SpiderLabel.setText("Tier 2 : " + s.getTier2());
        tier3SpiderLabel.setText("Tier 3 : " + s.getTier3());
        tier4SpiderLabel.setText("Tier 4 : " + s.getTier4());
        tier5SpiderLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("wolf");
        wolfExpLabel.setText("Exp : " + s.getExp());
        tier1WolfLabel.setText("Tier 1 : " + s.getTier1());
        tier2WolfLabel.setText("Tier 2 : " + s.getTier2());
        tier3WolfLabel.setText("Tier 3 : " + s.getTier3());
        tier4WolfLabel.setText("Tier 4 : " + s.getTier4());
        tier5WolfLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("enderman");
        endermanExpLabel.setText("Exp : " + s.getExp());
        tier1EndermanLabel.setText("Tier 1 : " + s.getTier1());
        tier2EndermanLabel.setText("Tier 2 : " + s.getTier2());
        tier3EndermanLabel.setText("Tier 3 : " + s.getTier3());
        tier4EndermanLabel.setText("Tier 4 : " + s.getTier4());
        tier5EndermanLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("blaze");
        blazeExpLabel.setText("Exp : " + s.getExp());
        tier1BlazeLabel.setText("Tier 1 : " + s.getTier1());
        tier2BlazeLabel.setText("Tier 2 : " + s.getTier2());
        tier3BlazeLabel.setText("Tier 3 : " + s.getTier3());
        tier4BlazeLabel.setText("Tier 4 : " + s.getTier4());
        tier5BlazeLabel.setText("Tier 5 : " + s.getTier5());
        s = slayers.get("vampire");
        vampireExpLabel.setText("Exp : " + s.getExp());
        tier1VampireLabel.setText("Tier 1 : " + s.getTier1());
        tier2VampireLabel.setText("Tier 2 : " + s.getTier2());
        tier3VampireLabel.setText("Tier 3 : " + s.getTier3());
        tier4VampireLabel.setText("Tier 4 : " + s.getTier4());
        tier5VampireLabel.setText("Tier 5 : " + s.getTier5());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
