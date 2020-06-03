package edu.hut.domain;

import java.io.Serializable;

public class MatchItems implements Serializable {

    private Integer mid;
    private Integer type_id;
    private Integer item_id;
    private Integer match_num;
    private Integer people_num;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    @Override
    public String toString() {
        return "MatchItems{" +
                "mid=" + mid +
                ", type_id=" + type_id +
                ", item_id=" + item_id +
                ", match_num=" + match_num +
                ", people_num=" + people_num +
                '}';
    }
}
