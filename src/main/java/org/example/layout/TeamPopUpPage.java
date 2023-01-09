package org.example.layout;

import org.example.component.TeamItem;
import org.example.model.Team;
import org.example.view.TeamViewPanel;

import javax.swing.*;
import java.awt.*;

public class TeamPopUpPage extends JFrame {
    TeamViewPanel teamViewPanel;

    public TeamPopUpPage(TeamItem teamItem, Team team) {
        setSize(new Dimension(400, 300));
        teamViewPanel = new TeamViewPanel(teamItem.getImageIcon(), team);
        add(teamViewPanel);

//        add(new JLabel(team.toString()));

        setVisible(true);
    }
}
