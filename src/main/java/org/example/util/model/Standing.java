package org.example.util.model;

import java.util.ArrayList;

public class Standing {
    String group;
    ArrayList<StandingTeam> standingTeams;

    public Standing(String group, ArrayList<StandingTeam> standingTeams) {
        this.group = group;
        this.standingTeams = standingTeams;
    }

    public String getGroup() {
        return group;
    }

    public ArrayList<StandingTeam> getStandingTeams() {
        return standingTeams;
    }

    @Override
    public String toString() {
        return "Standing{" +
                "group='" + group + '\'' +
                ", standingTeams=" + standingTeams +
                '}';
    }
}
