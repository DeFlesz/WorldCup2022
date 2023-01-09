package org.example.layout;

import org.example.AppFrame;
import org.example.model.Team;
import org.example.view.TeamViewPanel;

import javax.swing.*;
import java.awt.*;

public class TeamPopUpPage extends JFrame {
    TeamViewPanel teamViewPanel;

    public TeamPopUpPage(Team team, AppFrame context) {
        setSize(new Dimension(400, 300));
        setTitle(team.getName());
        teamViewPanel = new TeamViewPanel(team);
        add(teamViewPanel);

//        add(new JLabel(team.toString()));
        setLocationRelativeTo(context);
        setVisible(true);
    }
}
