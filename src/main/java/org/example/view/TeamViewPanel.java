package org.example.view;

import org.example.model.Team;

import javax.swing.*;
import java.awt.*;

public class TeamViewPanel extends JPanel {
//    Team team;

//    JLabel flag;
//    JLabel name;

    public TeamViewPanel(Team team) {
        setLayout(new BorderLayout());

        add(new JLabel(team.getName(), SwingConstants.CENTER), BorderLayout.NORTH);

//       Display matches for given team

//
//        try {
//            JLabel imageLabel = new JLabel(" ");
//            WorldCupAPI.setImage(team.getFlagURL(), imageLabel).start();
//            add(imageLabel, BorderLayout.CENTER);
//        } catch (MalformedURLException e) {
//            System.out.println("TeamViewPanel: bad url request");
//        }

////        this.team = team;
//        teamItem = new TeamItem(team);
//        add(teamItem);
    }
}
