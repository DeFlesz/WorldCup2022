package org.example.util.builder;

import org.example.util.model.Match;

public class MatchBuilder {
    private String homeFlag;
    private String homeTeamEn;
    private String homeScore;
    private String awayFlag;
    private String awayTeamEn;
    private String awayScore;
    private String date;
    private String type;

    public MatchBuilder setHomeFlag(String homeFlag) {
        this.homeFlag = homeFlag;
        return this;
    }

    public MatchBuilder setHomeTeamEn(String homeTeamEn) {
        this.homeTeamEn = homeTeamEn;
        return this;
    }

    public MatchBuilder setHomeScore(String homeScore) {
        this.homeScore = homeScore;
        return this;
    }

    public MatchBuilder setAwayFlag(String awayFlag) {
        this.awayFlag = awayFlag;
        return this;
    }

    public MatchBuilder setAwayTeamEn(String awayTeamEn) {
        this.awayTeamEn = awayTeamEn;
        return this;
    }

    public MatchBuilder setAwayScore(String awayScore) {
        this.awayScore = awayScore;
        return this;
    }

    public MatchBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public MatchBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Match createMatch() {
        return new Match(homeFlag, homeTeamEn, homeScore, awayFlag, awayTeamEn, awayScore, date, type);
    }
}