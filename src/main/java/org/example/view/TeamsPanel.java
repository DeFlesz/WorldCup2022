package org.example.view;

import org.example.controller.SessionController;
import org.example.controller.TeamsController;

import javax.swing.*;
import java.awt.*;

public class TeamsPanel extends JPanel {
    JPanel teamsPanel;

    TeamsController teamsController;

    public TeamsPanel(SessionController sessionController) {
        setLayout(new BorderLayout());
        add(new JLabel("Teams Panel"), BorderLayout.NORTH);

        teamsPanel = new JPanel();
        teamsPanel.setLayout(new BoxLayout(teamsPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(teamsPanel), BorderLayout.CENTER);


        teamsController = new TeamsController(sessionController, this);
        setVisible(true);
//        ArrayList<Team> teams = new WorldCupAPI().requestAllTeamsData(sessionController.getToken());
    }

    public JPanel getTeamsPanel() {
        return teamsPanel;
    }
}
