package edu.hut.domain;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Integer nid;
    private String html_text;
    private Date notice_time;
    private String content;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getHtml_text() {
        return html_text;
    }

    public void setHtml_text(String html_text) {
        this.html_text = html_text;
    }

    public Date getNotice_time() {
        return notice_time;
    }

    public void setNotice_time(Date notice_time) {
        this.notice_time = notice_time;
    }
}
