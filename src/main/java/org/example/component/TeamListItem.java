package org.example.component;

import org.example.API.WorldCupAPI;
import org.example.AppFrame;
import org.example.layout.TeamPopUpPage;
import org.example.model.Team;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TeamListItem extends JPanel {
    Team team;

    ImageIcon imageIcon;

    public TeamListItem(Team team, AppFrame context) {
        setLayout(new FlowLayout());
        this.team = team;

        try {
//            imageIcon = new ImageIcon(ImageIO.read(new URL(team.getFlag())));
            JLabel imageLabel = new JLabel();
            WorldCupAPI.setImage(team.getFlagURL(), imageLabel).start();
            add(imageLabel);
        } catch (IOException e) {
            System.out.println("couldn't get retrieve an image for: " + team.getName());
        }

        JButton jButton = new JButton(">");
        jButton.addActionListener(l -> {
            TeamPopUpPage teamPopUpPage = new TeamPopUpPage(team, context);
        });

        add(new JLabel(team.getName()));
        add(jButton);
    }
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public Team getTeam() {
        return team;
    }


}
