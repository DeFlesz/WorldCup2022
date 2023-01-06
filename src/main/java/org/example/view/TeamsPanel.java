package org.example.view;

import org.example.API.WorldCupAPI;
import org.example.controller.SessionController;
import org.example.model.Team;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TeamsPanel extends JPanel {

    public TeamsPanel(SessionController sessionController) throws IOException {
        add(new JLabel("Teams Panel"), BorderLayout.CENTER);

        ArrayList<Team> teams = new WorldCupAPI().requestAllTeamsData(sessionController.getToken());
    }
}
