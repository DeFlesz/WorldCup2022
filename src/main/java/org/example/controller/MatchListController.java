package org.example.controller;

import org.example.API.WorldCupAPI;
import org.example.util.model.Match;
import org.example.view.MatchListPanel;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class MatchListController {

    public MatchListController(MatchListPanel context, ArrayList<Match> matches, String selector) {
        JPanel matchTable = context.getMatchTable();

        ArrayList<Match> filteredMatches = new ArrayList<>();

        if (selector != null) {
//            String teamFilter = selector.getTeamName();
//            String dateFilter = selector.getDate();

//            maybe not
//            String groupFilter = selector.getGroup();

//            if (teamFilter != null) {
//                matches.forEach(match -> {
//                    if (Objects.equals(match.getAwayTeamEn(), teamFilter) || Objects.equals(match.getHomeTeamEn(), teamFilter)) {
//                        filteredMatches.add(match);
//                    }
//                });
//            }
//
//            if (dateFilter != null) {
//                matches.forEach(match -> {
//                    if (match.getDate().contains(dateFilter)) {
//                        filteredMatches.add(match);
//                    }
//                });
//            }
            matches.forEach(match -> {
                if (match.getHomeTeamEn().contains(selector) || match.getAwayTeamEn().contains(selector) || match.getDate().contains(selector)) {
                    filteredMatches.add(match);
                }
            });

            matches = filteredMatches;
        }

        matchTable.setLayout(new GridLayout(matches.size(), 5));

        matches.forEach(match -> {
            JLabel homeFlag = new JLabel("", SwingConstants.CENTER);
            JLabel homeName = new JLabel(match.getHomeTeamEn(), SwingConstants.CENTER);
            JLabel score = new JLabel(match.getHomeScore() + ":" + match.getAwayScore(), SwingConstants.CENTER);
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

    }
}
