package edu.hut.domain;

import java.io.Serializable;

public class Items implements Serializable {

    private Integer item_id;
    private String item_name;
    private Integer type_id;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "Items{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", type_id=" + type_id +
                '}';
    }
}
