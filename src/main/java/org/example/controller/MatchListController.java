package org.example.controller;

import org.example.API.WorldCupAPI;
import org.example.model.Match;
import org.example.view.MatchListPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class MatchListController {

    public MatchListController(MatchListPanel context, SessionController sessionController) {
        try {
            ArrayList<Match> matches = new WorldCupAPI().requestMatchData(sessionController.getToken());
            JPanel matchTable = context.getMatchTable();
            matchTable.setLayout(new GridLayout(matches.size()+1, 5));

//            POSSIBLE REFACTOR - make a function out of this

            matches.forEach(match -> {
                JLabel homeFlag = new JLabel("", SwingConstants.CENTER);
                JLabel homeName = new JLabel(match.getHomeTeamEn(), SwingConstants.CENTER);
                JLabel score = new JLabel(match.getHomeScore()+":"+match.getAwayScore(), SwingConstants.CENTER);
                JLabel awayName = new JLabel(match.getAwayTeamEn(), SwingConstants.CENTER);
                JLabel awayFlag = new JLabel("", SwingConstants.CENTER);

                matchTable.add(homeFlag);
                matchTable.add(homeName);
                matchTable.add(score);
                matchTable.add(awayName);
                matchTable.add(awayFlag);

                try {
                    WorldCupAPI.setImage(match.getHomeFlagURL(), homeFlag).start();
                    WorldCupAPI.setImage(match.getAwayFlagURL(), awayFlag).start();
                } catch (MalformedURLException e) {
                    System.out.println("MatchListController: couldn't process the url");
                }
            });
        } catch (IOException e) {
            System.out.println("MatchListPanel: no matches");
        }
    }
}
