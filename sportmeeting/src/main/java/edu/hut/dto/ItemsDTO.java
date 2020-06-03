package edu.hut.dto;

import java.io.Serializable;

public class ItemsDTO implements Serializable {

    private String player_number;
    private String item_name;

    public String getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(String player_number) {
        this.player_number = player_number;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
