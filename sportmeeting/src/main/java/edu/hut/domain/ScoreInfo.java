package edu.hut.domain;

import java.io.Serializable;

public class ScoreInfo implements Serializable {
    private Integer type_id;
    private Integer item_id;
    private Integer match_index;
    private String player_number;
    private String player_name;
    private String this_score;


    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
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

    public Integer getMatch_index() {
        return match_index;
    }

    public void setMatch_index(Integer match_index) {
        this.match_index = match_index;
    }

    public String getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(String player_number) {
        this.player_number = player_number;
    }

    public String getThis_score() {
        return this_score;
    }

    public void setThis_score(String this_score) {
        this.this_score = this_score;
    }
}
