package org.example.view;

import org.example.model.Team;

import javax.swing.*;
import java.awt.*;

public class TeamViewPanel extends JPanel {
//    Team team;

//    JLabel flag;
//    JLabel name;

    public TeamViewPanel(ImageIcon flagImage, Team team) {
        setLayout(new BorderLayout());

        add(new JLabel(team.getName(), SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JLabel(flagImage), BorderLayout.CENTER);
////        this.team = team;
//        teamItem = new TeamItem(team);
//        add(teamItem);
    }
}
