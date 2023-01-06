package org.example.builder;

import org.example.model.Team;

public class TeamBuilder {
    private String id;
    private String name;
    private String flag;
    private String fifa_code;
    private String group;

    public TeamBuilder set_id(String id) {
        this.id = id;
        return this;
    }

    public TeamBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public TeamBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeamBuilder setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public TeamBuilder setFifa_code(String fifa_code) {
        this.fifa_code = fifa_code;
        return this;
    }

    public TeamBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public Team createTeam() {
        return new Team(id, id, name, flag, fifa_code, group);
    }
}