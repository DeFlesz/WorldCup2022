package org.example.layout;

import org.example.API.WorldCupAPI;
import org.example.controller.SessionController;
import org.example.util.model.Match;
import org.example.view.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class LandingPage extends JTabbedPane {
    SessionController sessionController;
    TeamsPanel teamsPanel;
    FiltrableMatchListPanel matchListPanel;
    MatchLadderPanel matchLadderPanel;
    StandingsPanel standingsPanel;
    SettingsPanel settingsPanel;

    public LandingPage(SessionController sessionController) {
        System.out.println("Creating [LandingPage]");
        this.sessionController = sessionController;


        ArrayList<Match> matches = null;
        try {
            matches = new WorldCupAPI().requestMatchData(sessionController.getToken());
        } catch (IOException e) {
            System.out.println("LandingPage: couldn't get matches");
        }

        teamsPanel = new TeamsPanel(sessionController, matches);
        matchListPanel = new FiltrableMatchListPanel(matches);
        matchLadderPanel = new MatchLadderPanel();
        standingsPanel = new StandingsPanel();
        settingsPanel = new SettingsPanel(sessionController);

        addTab("Teams", teamsPanel);
        addTab("Matches", matchListPanel);
        addTab("Ladder", matchLadderPanel);
        addTab("Standings", standingsPanel);
        addTab("Settings", settingsPanel);
    }
}
