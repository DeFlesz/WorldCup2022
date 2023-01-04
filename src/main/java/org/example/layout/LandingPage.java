package org.example.layout;

import org.example.controller.SessionController;
import org.example.view.MatchLadderPanel;
import org.example.view.MatchListPanel;
import org.example.view.StandingsPanel;
import org.example.view.TeamsPanel;

import javax.swing.*;

public class LandingPage extends JTabbedPane {
    SessionController sessionController;
    TeamsPanel teamsPanel;
    MatchListPanel matchListPanel;
    MatchLadderPanel matchLadderPanel;
    StandingsPanel standingsPanel;

    public LandingPage(SessionController sessionController) {
        System.out.println("Creating [LandingPage]");
        this.sessionController = sessionController;

        teamsPanel = new TeamsPanel();
        matchListPanel = new MatchListPanel(sessionController);
        matchLadderPanel = new MatchLadderPanel();
        standingsPanel = new StandingsPanel();

        addTab("Teams", teamsPanel);
        addTab("Matches", matchListPanel);
        addTab("Ladder", matchLadderPanel);
        addTab("Standings", standingsPanel);
    }
}
