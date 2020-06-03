package edu.hut.domain;

import java.io.Serializable;

public class SearchInfo implements Serializable {
    private Integer type_id;
    private Integer item_id;
    private Integer match_index;

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
}
