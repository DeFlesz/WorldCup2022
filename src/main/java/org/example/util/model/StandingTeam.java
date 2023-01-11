package org.example.util.model;

public class StandingTeam {
    String name;
    String pts;
    String flag;

    public StandingTeam(String name, String pts, String flag) {
        this.name = name;
        this.pts = pts;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getPts() {
        return pts;
    }

    public String getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return "StandingTeam{" +
                "name='" + name + '\'' +
                ", pts='" + pts + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
