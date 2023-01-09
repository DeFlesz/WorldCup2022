package org.example.layout;

import org.example.component.TeamListItem;
import org.example.model.Team;
import org.example.view.TeamViewPanel;

import javax.swing.*;
import java.awt.*;

public class TeamPopUpPage extends JFrame {
    TeamViewPanel teamViewPanel;

    public TeamPopUpPage(TeamListItem teamListItem, Team team) {
        setSize(new Dimension(400, 300));
        teamViewPanel = new TeamViewPanel(team);
        add(teamViewPanel);

//        add(new JLabel(team.toString()));

        setVisible(true);
    }
}
