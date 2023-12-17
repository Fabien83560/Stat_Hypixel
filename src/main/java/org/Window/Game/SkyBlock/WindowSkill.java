package org.Window.Game.SkyBlock;

import org.Game.Skyblock.Stats.Skills;
import javax.swing.*;
import java.awt.*;

/**
 * This class sets all the interface of the different
 * player's skills when Skyblock mode is selected. Used only once
 * in the WindowSkyBlockStats class.
 * @see WindowSkyBlockStats
 */
public class WindowSkill {

    /**
     * Main panel of the WindowSkill class.
     */
    private JPanel mainPanel;

    /**
     * Title of the statistic (Skills).
     */
    private JLabel titleLabel;

    /**
     * Average of all the player skills.
     */
    private JLabel skillAverageLabel;

    /**
     * Panel of the social skill value.
     */
    private JPanel socialPanel;

    /**
     * Panel containing all the skill values.
     */
    private JPanel skillsPanel;

    /**
     * Left panel contained in the 'skillsPanel'.
     * @see WindowSkill#skillsPanel
     */
    private JPanel LeftSkillPanel;

    /**
     * Right panel contained in the 'skillsPanel'.
     * @see WindowSkill#skillsPanel
     */
    private JPanel RightSkillPanel;

    /**
     * Panel of the Farming skill value contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JPanel farmingPanel;

    /**
     * Panel of the Mining skill value contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JPanel miningPanel;

    /**
     * Panel of the Combat skill value contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JPanel combatPanel;

    /**
     * Panel of the Foraging skill value contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JPanel foragingPanel;

    /**
     * Panel of the Fishing skill value contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JPanel fishingPanel;

    /**
     * Panel of the Enchanting skill value contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JPanel enchantingPanel;

    /**
     * Panel of the Alchemy skill value contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JPanel alchemyPanel;

    /**
     * Panel of the Carpentry skill value contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JPanel carpentryPanel;

    /**
     * Panel of the Rune Crafting skill value contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JPanel runecraftingPanel;

    /**
     * Panel of the Taming skill value contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JPanel tamingPanel;

    /**
     * Image of the Farming skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel farmingImageLabel;

    /**
     * Image of the Mining skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel miningImageLabel;

    /**
     * Image of the Combat skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel combatImageLabel;

    /**
     * Image of the Foraging skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel foragingImageLabel;

    /**
     * Image of the Fishing skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel fishingImageLabel;

    /**
     * Image of the Social skill contained in the
     * 'socialPanel'.
     * @see WindowSkill#socialPanel
     */
    private JLabel socialImageLabel;

    /**
     * Image of the Enchanting skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel enchantingImageLabel;

    /**
     * Image of the Alchemy skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel alchemyImageLabel;

    /**
     * Image of the Carpentry skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel carpentryImageLabel;

    /**
     * Image of the Rune Crafting skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel runecraftingImageLabel;

    /**
     * Image of the Farming skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel tamingImageLabel;

    /**
     * Name of the Farming skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel farmingLabel;

    /**
     * Name of the Mining skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel miningLabel;

    /**
     * Name of the Combat skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel combatLabel;

    /**
     * Name of the Foraging skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel foragingLabel;

    /**
     * Name of the Fishing skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel fishingLabel;

    /**
     * Name of the Enchanting skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel enchantingLabel;

    /**
     * Name of the Alchemy skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel alchemyLabel;

    /**
     * Name of the Carpentry skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel carpentryLabel;

    /**
     * Name of the Rune Crafting skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel runecraftingLabel;

    /**
     * Name of the Taming skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel tamingLabel;

    /**
     * Value of the Farming skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel farmingAmountLabel;

    /**
     * Value of the Mining skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel miningAmountLabel;

    /**
     * Value of the Combat skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel combatAmountLabel;

    /**
     * Value of the Foraging skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel foragingAmountLabel;

    /**
     * Value of the Fishing skill contained in the
     * 'LeftSkillPanel'.
     * @see WindowSkill#LeftSkillPanel
     */
    private JLabel fishingAmountLabel;

    /**
     * Value of the Enchanting skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel enchantingAmountLabel;

    /**
     * Value of the Alchemy skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel alchemyAmountLabel;

    /**
     * Value of the Carpentry skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel carpentryAmountLabel;

    /**
     * Value of the Rune Crafting skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel runecraftingAmountLabel;

    /**
     * Value of the Taming skill contained in the
     * 'RightSkillPanel'.
     * @see WindowSkill#RightSkillPanel
     */
    private JLabel tamingAmountLabel;

    /**
     * Name of the Social skill contained in the
     * 'socialPanel'.
     * @see WindowSkill#socialPanel
     */
    private JLabel socialLabel;

    /**
     * Value of the Social skill contained in the
     * 'socialPanel'.
     * @see WindowSkill#socialPanel
     */
    private JLabel socialAmountLabel;

    /**
     * Constructor of the WindowSkill class, displaying
     * every single player's skill in the interface through
     * a 'Skills' class instance passed as a parameter.
     * @param skill A Skills class instance used to initialize
     *              the player's skill statistics in Skyblock mode.
     * @see Skills
     */
    public WindowSkill(Skills skill) {
        titleLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 24));
        skillAverageLabel.setText(String.valueOf("Average skill value: " + skill.getSkillAverage()));

        farmingAmountLabel.setText("LvL " + skill.get("SKILL_FARMING"));
        miningAmountLabel.setText("LvL " + skill.get("SKILL_MINING"));
        combatAmountLabel.setText("LvL " + skill.get("SKILL_COMBAT"));
        foragingAmountLabel.setText("LvL " + skill.get("SKILL_FORAGING"));
        fishingAmountLabel.setText("LvL " + skill.get("SKILL_FISHING"));
        enchantingAmountLabel.setText("LvL " + skill.get("SKILL_ENCHANTING"));
        alchemyAmountLabel.setText("LvL " + skill.get("SKILL_ALCHEMY"));
        carpentryAmountLabel.setText("LvL " + skill.get("SKILL_CARPENTRY"));
        runecraftingAmountLabel.setText("LvL " + skill.get("SKILL_RUNECRAFTING"));
        tamingAmountLabel.setText("LvL " + skill.get("SKILL_TAMING"));
        socialAmountLabel.setText("LvL " + skill.get("SKILL_SOCIAL"));
    }

    /**
     * Gets the main panel of the class.
     * @return A JPanel Object.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
