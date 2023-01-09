package org.example.view;

import org.example.API.WorldCupAPI;
import org.example.model.Team;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.MalformedURLException;

public class TeamViewPanel extends JPanel {
//    Team team;

//    JLabel flag;
//    JLabel name;

    public TeamViewPanel(Team team) {
        setLayout(new BorderLayout());

//        add(, BorderLayout.NORTH);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        Border border = new EmptyBorder(10, 10, 10, 10);

        try {
            JLabel imageLabel = new JLabel("", SwingConstants.CENTER);
            WorldCupAPI.setImage(team.getFlagURL(), imageLabel).start();
            headerPanel.add(imageLabel, BorderLayout.WEST);
        } catch (MalformedURLException e) {
            System.out.println("TeamViewPanel: bad url request");
        }


        JLabel teamName = new JLabel(team.getName(), SwingConstants.CENTER);
        headerPanel.add(teamName, BorderLayout.CENTER);

        JLabel teamGroup = new JLabel("Group: " + team.getGroup(), SwingConstants.CENTER);
        headerPanel.add(teamGroup, BorderLayout.EAST);

        headerPanel.setBackground(new Color(125, 125,125, 255));
        headerPanel.setBorder(border);

        add(headerPanel, BorderLayout.NORTH);

//       Display matches for given team


////        this.team = team;
//        teamItem = new TeamItem(team);
//        add(teamItem);
    }
}
