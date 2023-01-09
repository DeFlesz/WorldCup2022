package org.example.controller;

import org.example.API.WorldCupAPI;
import org.example.component.TeamListItem;
import org.example.model.Team;
import org.example.view.TeamsPanel;

import java.io.IOException;
import java.util.ArrayList;

public class TeamsController {
    SessionController sessionController;
    TeamsPanel teamsPanel;

    public TeamsController(SessionController sessionController, TeamsPanel teamsPanel) {
        this.sessionController = sessionController;
        this.teamsPanel = teamsPanel;

        try {
            ArrayList<Team> teams = new WorldCupAPI().requestAllTeamsData(sessionController.getToken());

            teams.forEach(team -> {
//                System.out.println("binding new label");
                teamsPanel.getTeamsPanel().add(new TeamListItem(team));
            });

            teamsPanel.invalidate();
            teamsPanel.validate();
            teamsPanel.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
