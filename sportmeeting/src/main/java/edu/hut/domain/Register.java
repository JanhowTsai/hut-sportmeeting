package edu.hut.domain;

import java.io.Serializable;

public class Register implements Serializable {
    private Integer rid;
    private Integer type_id;
    private Integer item_id;
    private String player_name;
    private String player_number;
    private String player_class;
    public Integer match_index;
    public Integer pid;
    public Integer mid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getMatch_index() {
        return match_index;
    }

    public void setMatch_index(Integer match_index) {
        this.match_index = match_index;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(String player_number) {
        this.player_number = player_number;
    }

    public String getPlayer_class() {
        return player_class;
    }

    public void setPlayer_class(String player_class) {
        this.player_class = player_class;
    }
}
