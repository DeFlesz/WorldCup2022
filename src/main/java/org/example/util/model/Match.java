package org.example.util.model;

import java.net.MalformedURLException;
import java.net.URL;

public class Match {
//    home team
    String homeFlag;
    String homeTeamEn;
    String homeScore;

//    away team
    String awayFlag;
    String awayTeamEn;
    String awayScore;

//  YY-MM-DD HH:MM AM/PM
    String date;
//    group or ??
    String type;

    public Match(String homeFlag, String homeTeamEn, String homeScore, String awayFlag, String awayTeamEn, String awayScore, String date, String type) {
        this.homeFlag = homeFlag;
        this.homeTeamEn = homeTeamEn;
        this.homeScore = homeScore;
        this.awayFlag = awayFlag;
        this.awayTeamEn = awayTeamEn;
        this.awayScore = awayScore;
        this.date = date;
        this.type = type;
    }

    public URL getHomeFlagURL() throws MalformedURLException {
        return new URL(homeFlag);
    }

    public String getHomeTeamEn() {
        return homeTeamEn;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public URL getAwayFlagURL() throws MalformedURLException {
        return new URL(awayFlag);
    }
    public String getAwayTeamEn() {
        return awayTeamEn;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "\nMatch{" +
                "homeFlag='" + homeFlag + '\'' +
                ", homeTeamEn='" + homeTeamEn + '\'' +
                ", homeScore='" + homeScore + '\'' +
                ", awayFlag='" + awayFlag + '\'' +
                ", awayTeamEn='" + awayTeamEn + '\'' +
                ", awayScore='" + awayScore + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                "}\n";
    }
}
