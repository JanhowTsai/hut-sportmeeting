package edu.hut.dto;

import java.io.Serializable;

public class ResultDTO implements Serializable {

    private String result_status;

    private Integer result_effect_rows;

    public String getResult_status() {
        return result_status;
    }

    public void setResult_status(String result_status) {
        this.result_status = result_status;
    }

    public Integer getResult_effect_rows() {
        return result_effect_rows;
    }

    public void setResult_effect_rows(Integer result_effect_rows) {
        this.result_effect_rows = result_effect_rows;
    }
}
