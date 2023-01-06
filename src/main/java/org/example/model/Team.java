package org.example.model;

public class Team {
    String _id;
    String id;
    String name;
    String flag;
    String fifa_code;
    String group;

    public Team(String _id, String id, String name, String flag, String fifa_code, String group) {
        this._id = _id;
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.fifa_code = fifa_code;
        this.group = group;
    }

    public String get_id() {
        return _id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public String getFifa_code() {
        return fifa_code;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Team{" +
                "_id='" + _id + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                ", fifa_code='" + fifa_code + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
