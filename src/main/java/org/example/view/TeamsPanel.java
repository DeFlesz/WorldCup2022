package org.example.view;

import org.example.controller.SessionController;
import org.example.controller.TeamsController;
import org.example.util.model.Match;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TeamsPanel extends JPanel {
    JPanel teamsPanel;

    TeamsController teamsController;

    public TeamsPanel(SessionController sessionController, ArrayList<Match> matches) {

        setLayout(new BorderLayout());
        add(new JLabel("Teams Panel"), BorderLayout.NORTH);

        teamsPanel = new JPanel();
        teamsPanel.setLayout(new BoxLayout(teamsPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(teamsPanel), BorderLayout.CENTER);


        teamsController = new TeamsController(sessionController, matches, this);
        setVisible(true);
//        ArrayList<Team> teams = new WorldCupAPI().requestAllTeamsData(sessionController.getToken());
    }

    public JPanel getTeamsPanel() {
        return teamsPanel;
    }
}
