package edu.hut.domain;

import java.io.Serializable;

public class PlayerInfo implements Serializable {
    private Integer pid;
    private String player_name;
    private String player_sex;
    private String player_xy;
    private String player_zy;
    private String player_class;
    private String player_number;
    private String player_idcard;
    private String player_tel;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_sex() {
        return player_sex;
    }

    public void setPlayer_sex(String player_sex) {
        this.player_sex = player_sex;
    }

    public String getPlayer_xy() {
        return player_xy;
    }

    public void setPlayer_xy(String player_xy) {
        this.player_xy = player_xy;
    }

    public String getPlayer_zy() {
        return player_zy;
    }

    public void setPlayer_zy(String player_zy) {
        this.player_zy = player_zy;
    }

    public String getPlayer_class() {
        return player_class;
    }

    public void setPlayer_class(String player_class) {
        this.player_class = player_class;
    }

    public String getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(String player_number) {
        this.player_number = player_number;
    }

    public String getPlayer_idcard() {
        return player_idcard;
    }

    public void setPlayer_idcard(String player_idcard) {
        this.player_idcard = player_idcard;
    }

    public String getPlayer_tel() {
        return player_tel;
    }

    public void setPlayer_tel(String player_tel) {
        this.player_tel = player_tel;
    }

}
