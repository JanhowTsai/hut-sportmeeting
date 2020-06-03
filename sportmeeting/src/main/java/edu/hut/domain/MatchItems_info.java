package edu.hut.domain;

import java.io.Serializable;

public class MatchItems_info implements Serializable {
    private Integer mid;
    private String type_name ;
    private String item_name;
    private Integer match_num;
    private Integer people_num;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getMatch_num() {
        return match_num;
    }

    public void setMatch_num(Integer match_num) {
        this.match_num = match_num;
    }

    public Integer getPeople_num() {
        return people_num;
    }

    public void setPeople_num(Integer people_num) {
        this.people_num = people_num;
    }
}
