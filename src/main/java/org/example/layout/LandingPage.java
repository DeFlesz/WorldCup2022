package org.example.layout;

import org.example.controller.SessionController;
import org.example.view.*;

import javax.swing.*;
import java.io.IOException;

public class LandingPage extends JTabbedPane {
    SessionController sessionController;
    TeamsPanel teamsPanel;
    MatchListPanel matchListPanel;
    MatchLadderPanel matchLadderPanel;
    StandingsPanel standingsPanel;
    SettingsPanel settingsPanel;

    public LandingPage(SessionController sessionController) {
        System.out.println("Creating [LandingPage]");
        this.sessionController = sessionController;

        teamsPanel = new TeamsPanel(sessionController);
        matchListPanel = new MatchListPanel();
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
