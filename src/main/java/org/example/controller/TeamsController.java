package org.example.controller;

import org.example.API.WorldCupAPI;
import org.example.component.TeamListItem;
import org.example.util.model.Match;
import org.example.util.model.Team;
import org.example.view.TeamsPanel;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TeamsController {
    SessionController sessionController;
    TeamsPanel teamsPanel;

    public TeamsController(SessionController sessionController, ArrayList<Match> matches, TeamsPanel teamsPanel) {
        this.sessionController = sessionController;
        this.teamsPanel = teamsPanel;

        try {
            ArrayList<Team> teams = new WorldCupAPI().requestAllTeamsData(sessionController.getToken());

            teams.forEach(team -> {
//                System.out.println("binding new label");
                teamsPanel.getTeamsPanel().add(new TeamListItem(team, sessionController.getContext(), matches), BorderLayout.WEST);
            });

            teamsPanel.invalidate();
            teamsPanel.validate();
            teamsPanel.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
