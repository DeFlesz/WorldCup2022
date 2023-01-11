package org.example.controller;

import org.example.API.WorldCupAPI;
import org.example.util.model.Standing;
import org.example.util.model.StandingTeam;
import org.example.view.StandingsPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class StandingController {

    public StandingController(SessionController sessionController, StandingsPanel context) {
        WorldCupAPI worldCupAPI = new WorldCupAPI();
        try {
            ArrayList<Standing> standings = worldCupAPI.requestStandingData(sessionController.getToken());

            standings.forEach(standing -> {
                ArrayList<StandingTeam> standingTeams = standing.getStandingTeams();

                context.add(new JLabel("Group: " + standing.getGroup()));

                standingTeams.forEach(standingTeam -> {
                    context.add(new JLabel(standingTeam.toString()));
                });

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
