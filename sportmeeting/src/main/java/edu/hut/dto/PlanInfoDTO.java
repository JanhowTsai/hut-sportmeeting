package edu.hut.dto;

import java.io.Serializable;
import java.util.Date;

public class PlanInfoDTO implements Serializable {
    private Integer plan_id;
    private Integer type_id;
    private Integer item_id;
    private Integer match_index;
    private Date start_time;
    private Date end_time;
    private String match_address;
    private String judge_list;

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getMatch_address() {
        return match_address;
    }

    public void setMatch_address(String match_address) {
        this.match_address = match_address;
    }

    public String getJudge_list() {
        return judge_list;
    }

    public void setJudge_list(String judge_list) {
        this.judge_list = judge_list;
    }
}
