package edu.hut.dto;

import java.io.Serializable;

public class Item_idDTO implements Serializable {

    private Integer item_id;
    private Integer num;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
