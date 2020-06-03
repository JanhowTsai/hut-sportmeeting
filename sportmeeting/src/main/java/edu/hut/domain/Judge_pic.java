package edu.hut.domain;

import java.io.Serializable;

public class Judge_pic implements Serializable {
    private Integer pic_id;
    private String judge_number;
    private String pic_address;

    public Integer getPic_id() {
        return pic_id;
    }

    public void setPic_id(Integer pic_id) {
        this.pic_id = pic_id;
    }

    public String getJudge_number() {
        return judge_number;
    }

    public void setJudge_number(String judge_number) {
        this.judge_number = judge_number;
    }

    public String getPic_address() {
        return pic_address;
    }

    public void setPic_address(String pic_address) {
        this.pic_address = pic_address;
    }
}
