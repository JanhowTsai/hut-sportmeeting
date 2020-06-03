package edu.hut.domain;

import java.io.Serializable;

public class JudgeInfo implements Serializable {
    private Integer jid;
    private String judge_name;
    private String judge_sex;
    private String judge_xy;
    private String judge_zy;
    private String judge_class;
    private String judge_number;
    private String judge_idcard;
    private String judge_tel;
    private Integer type_id;
    private Integer item_id;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJudge_name() {
        return judge_name;
    }

    public void setJudge_name(String judge_name) {
        this.judge_name = judge_name;
    }

    public String getJudge_sex() {
        return judge_sex;
    }

    public void setJudge_sex(String judge_sex) {
        this.judge_sex = judge_sex;
    }

    public String getJudge_xy() {
        return judge_xy;
    }

    public void setJudge_xy(String judge_xy) {
        this.judge_xy = judge_xy;
    }

    public String getJudge_zy() {
        return judge_zy;
    }

    public void setJudge_zy(String judge_zy) {
        this.judge_zy = judge_zy;
    }

    public String getJudge_class() {
        return judge_class;
    }

    public void setJudge_class(String judge_class) {
        this.judge_class = judge_class;
    }

    public String getJudge_number() {
        return judge_number;
    }

    public void setJudge_number(String judge_number) {
        this.judge_number = judge_number;
    }

    public String getJudge_idcard() {
        return judge_idcard;
    }

    public void setJudge_idcard(String judge_idcard) {
        this.judge_idcard = judge_idcard;
    }

    public String getJudge_tel() {
        return judge_tel;
    }

    public void setJudge_tel(String judge_tel) {
        this.judge_tel = judge_tel;
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
}
