package org.example.view;

import org.example.controller.MatchListController;
import org.example.controller.SessionController;

import javax.swing.*;
import java.awt.*;

public class MatchListPanel extends JPanel {
    MatchListController matchListController;
    JPanel matchTable;

    public MatchListPanel(SessionController sessionController) {
        setLayout(new BorderLayout());
//        add(new JLabel("Match List Panel", SwingConstants.CENTER), BorderLayout.NORTH);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(1, 5));

        Color color = new Color(0x7D7D7D);

        JLabel homeFlagHeader = new JLabel("HOME FLAG", SwingConstants.CENTER);
        homeFlagHeader.setOpaque(true);
        homeFlagHeader.setBackground(color);
        headerPanel.add(homeFlagHeader);

        JLabel homeNameHeader = new JLabel("HOME NAME", SwingConstants.CENTER);
        homeNameHeader.setOpaque(true);
        homeNameHeader.setBackground(color);
        headerPanel.add(homeNameHeader);

        JLabel scoreHeader = new JLabel("SCORE", SwingConstants.CENTER);
        scoreHeader.setOpaque(true);
        scoreHeader.setBackground(color);
        headerPanel.add(scoreHeader);

        JLabel awayNameHeader = new JLabel("AWAY NAME", SwingConstants.CENTER);
        awayNameHeader.setOpaque(true);
        awayNameHeader.setBackground(color);
        headerPanel.add(awayNameHeader);

        JLabel awayFlagHeader = new JLabel("AWAY FLAG", SwingConstants.CENTER);
        awayFlagHeader.setOpaque(true);
        awayFlagHeader.setBackground(color);
        headerPanel.add(awayFlagHeader);

//        matchTable = new JTable(, new String[] {"HOME FLAG", "HOME NAME", "SCORE", "AWAY NAME", "AWAY FLAG"});
        matchTable = new JPanel();
//        matchTable.setLayout(new BoxLayout(matchTable, BoxLayout.Y_AXIS));
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(matchTable), BorderLayout.CENTER);

        matchListController = new MatchListController(this, sessionController);
        setVisible(true);
    }

    public JPanel getMatchTable() {
        return matchTable;
    }
}
