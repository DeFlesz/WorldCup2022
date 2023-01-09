package org.example.component;

import org.example.layout.TeamPopUpPage;
import org.example.model.Team;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class TeamItem extends JPanel {
    Team team;

    ImageIcon imageIcon;

    public TeamItem(Team team) {
        setLayout(new FlowLayout());
        this.team = team;

        try {
            imageIcon = new ImageIcon(ImageIO.read(new URL(team.getFlag())));
            add(new JLabel(imageIcon));
        } catch (IOException e) {
            System.out.println("couldn't get retrieve an image for: " + team.getFlag());
        }

        JButton jButton = new JButton(">");
        jButton.addActionListener(l -> {
            TeamPopUpPage teamPopUpPage = new TeamPopUpPage(this, team);
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
