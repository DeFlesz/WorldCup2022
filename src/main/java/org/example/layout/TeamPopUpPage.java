package org.example.layout;

import org.example.AppFrame;
import org.example.util.model.Match;
import org.example.util.model.Team;
import org.example.view.TeamViewPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TeamPopUpPage extends JFrame {
    TeamViewPanel teamViewPanel;

    public TeamPopUpPage(Team team, ArrayList<Match> matches, AppFrame context) {
        Dimension dimension = new Dimension(700, 500);
        setSize(dimension);
        setMinimumSize(dimension);
        setTitle(team.getName());
        teamViewPanel = new TeamViewPanel(team, matches);
        add(teamViewPanel);

//        add(new JLabel(team.toString()));
        setLocationRelativeTo(context);
        setVisible(true);
    }
}
