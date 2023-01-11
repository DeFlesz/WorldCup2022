package org.example.component;

import org.example.API.WorldCupAPI;
import org.example.AppFrame;
import org.example.layout.TeamPopUpPage;
import org.example.util.model.Match;
import org.example.util.model.Team;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TeamListItem extends JPanel {
    Team team;

    ImageIcon imageIcon;

    public TeamListItem(Team team, AppFrame context, ArrayList<Match> matches) {
        setLayout(new BorderLayout());
        Border border = new EmptyBorder(10, 10, 10, 10);
        setBorder(border);
        setMaximumSize(new Dimension(500, 300));
//        setBackground(Color.BLUE);
        this.team = team;

        try {
//            imageIcon = new ImageIcon(ImageIO.read(new URL(team.getFlag())));
            JLabel imageLabel = new JLabel("", SwingConstants.CENTER);
            WorldCupAPI.setImage(team.getFlagURL(), imageLabel).start();
            add(imageLabel, BorderLayout.WEST);
        } catch (IOException e) {
            System.out.println("couldn't get retrieve an image for: " + team.getName());
        }

        JButton jButton = new JButton(">");
        jButton.addActionListener(l -> {
            TeamPopUpPage teamPopUpPage = new TeamPopUpPage(team, matches, context);
        });

        add(new JLabel(team.getName(), SwingConstants.CENTER), BorderLayout.CENTER);
        add(jButton, BorderLayout.EAST);
    }
}
