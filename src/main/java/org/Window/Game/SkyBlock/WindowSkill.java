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
        titleLabel.setText("Skills");
        skillAverageLabel.setText(String.valueOf(skill.getSkillAverage()));

        farmingAmountLabel.setText(skill.get("SKILL_FARMING") + "exp");
        miningAmountLabel.setText(skill.get("SKILL_MINING") + "exp");
        combatAmountLabel.setText(skill.get("SKILL_COMBAT") + "exp");
        foragingAmountLabel.setText(skill.get("SKILL_FORAGING") + "exp");
        fishingAmountLabel.setText(skill.get("SKILL_FISHING") + "exp");
        enchantingAmountLabel.setText(skill.get("SKILL_ENCHANTING") + "exp");
        alchemyAmountLabel.setText(skill.get("SKILL_ALCHEMY") + "exp");
        carpentryAmountLabel.setText(skill.get("SKILL_CARPENTRY") + "exp");
        runecraftingAmountLabel.setText(skill.get("SKILL_RUNECRAFTING") + "exp");
        tamingAmountLabel.setText(skill.get("SKILL_TAMING") + "exp");
        socialAmountLabel.setText(skill.get("SKILL_SOCIAL") + "exp");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
