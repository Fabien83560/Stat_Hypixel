package org.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    private JButton quitButton;
    private JPanel mainPanel;
    private JButton compare2PlayersButton;
    private JButton onePlayerButton;
    private JPanel panelLeft;
    private JScrollPane panelRight;
    private JScrollPane friendListPanel;
    private JTextField searchAPlayerHereTextField;
    private JButton TODOButton;
    private JButton bedWarsButton;
    private JButton skyWarsButton;
    private JButton TODOButton1;
    private JButton TODOButton2;
    private JList friendList;
    private JLabel globalStatsLabel;
    private JScrollPane globalStatsPanel;
    private JLabel selectedModeLabel;
    private JScrollPane selectedModePanel;
    private JButton addNewPlayerButton;

    public Window(){
        setMinimumSize(new Dimension(800, 600));
        setTitle("Hypixel Statistics");
        setSize(1400, 1000);
        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quitButton.setActionCommand("quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("quit"))
                    quit();
            }
        });
    }

    public void quit(){
        if( JOptionPane.showConfirmDialog(null,
                "Do you want to quit ?",
                "Quit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION )
        {
            System.exit(0);
        }
    }
}
