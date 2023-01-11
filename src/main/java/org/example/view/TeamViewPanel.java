package org.example.view;

import org.example.API.WorldCupAPI;
import org.example.util.model.Match;
import org.example.util.model.Team;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class TeamViewPanel extends JPanel {
//    Team team;

//    JLabel flag;
//    JLabel name;

    public TeamViewPanel(Team team, ArrayList<Match> matches) {
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

        JPanel matchListContainerPanel = new JPanel();

        matchListContainerPanel.setLayout(new BorderLayout());
//        matchListContainerPanel.add(new JLabel("MATCHES\n", SwingConstants.CENTER), BorderLayout.NORTH);
        matchListContainerPanel.add(new MatchListPanel(matches, team.getName()), BorderLayout.CENTER);
        matchListContainerPanel.setBackground(new Color(125, 125, 125,255));

        add(matchListContainerPanel, BorderLayout.CENTER);



//       Display matches for given team


////        this.team = team;
//        teamItem = new TeamItem(team);
//        add(teamItem);
    }
}
