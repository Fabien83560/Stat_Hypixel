package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Skills;

import javax.swing.*;

public class WindowSkill {

    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel skillAverageLabel;
    private JPanel socialPanel;
    private JPanel skillsPanel;
    private JPanel LeftSkillPanel;
    private JPanel RightSkillPanel;
    private JPanel farmingPanel;
    private JPanel miningPanel;
    private JPanel combatPanel;
    private JPanel foragingPanel;
    private JPanel fishingPanel;
    private JPanel enchantingPanel;
    private JPanel alchemy;
    private JPanel carpentry;
    private JPanel runecrafting;
    private JPanel taming;
    private JLabel farmingImageLabel;
    private JLabel miningImageLabel;
    private JLabel combatImageLabel;
    private JLabel foragingImageLabel;
    private JLabel fishingImageLabel;
    private JLabel socialImageLabel;
    private JLabel enchantingImageLabel;
    private JLabel alchemyImageLabel;
    private JLabel carpentryImageLabel;
    private JLabel runecraftingImageLabel;
    private JLabel tamingImageLabel;
    private JLabel farmingLabel;
    private JLabel miningLabel;
    private JLabel combatLabel;
    private JLabel foragingLabel;
    private JLabel fishingLabel;
    private JLabel enchantingLabel;
    private JLabel alchemyLabel;
    private JLabel carpentryLabel;
    private JLabel runecraftingLabel;
    private JLabel tamingLabel;
    private JLabel farmingAmountLabel;
    private JLabel miningAmountLabel;
    private JLabel combatAmountLabel;
    private JLabel foragingAmountLabel;
    private JLabel fishingAmountLabel;
    private JLabel enchantingAmountLabel;
    private JLabel alchemyAmountLabel;
    private JLabel carpentryAmountLabel;
    private JLabel runecraftingAmountLabel;
    private JLabel tamingAmountLabel;
    private JLabel socialLabel;
    private JLabel socialAmountLabel;

    public WindowSkill(Skills skill) {
        skillAverageLabel.setText(String.valueOf(skill.getSkillAverage()));

        farmingAmountLabel.setText(skill.get("SKILL_FARMING") + " LvL");
        miningAmountLabel.setText(skill.get("SKILL_MINING") + " LvL");
        combatAmountLabel.setText(skill.get("SKILL_COMBAT") + " LvL");
        foragingAmountLabel.setText(skill.get("SKILL_FORAGING") + " LvL");
        fishingAmountLabel.setText(skill.get("SKILL_FISHING") + " LvL");
        enchantingAmountLabel.setText(skill.get("SKILL_ENCHANTING") + " LvL");
        alchemyAmountLabel.setText(skill.get("SKILL_ALCHEMY") + " LvL");
        carpentryAmountLabel.setText(skill.get("SKILL_CARPENTRY") + " LvL");
        runecraftingAmountLabel.setText(skill.get("SKILL_RUNECRAFTING") + " LvL");
        tamingAmountLabel.setText(skill.get("SKILL_TAMING") + " LvL");
        socialAmountLabel.setText(skill.get("SKILL_SOCIAL") + " LvL");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
