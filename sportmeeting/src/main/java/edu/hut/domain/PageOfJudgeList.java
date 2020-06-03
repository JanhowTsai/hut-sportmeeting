package edu.hut.domain;

import java.io.Serializable;

public class PageOfJudgeList implements Serializable {
    private Integer currentPageIndex;
    private Integer pageNum;
    private Integer totalPageNum;
    private Integer totalPage;
    private Integer startIndex;
    private String judgeName;
    private String judgeNumber;

    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(Integer totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    public String getJudgeNumber() {
        return judgeNumber;
    }

    public void setJudgeNumber(String judgeNumber) {
        this.judgeNumber = judgeNumber;
    }
}
