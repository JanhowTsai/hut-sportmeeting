package edu.hut.service;

import edu.hut.domain.JudgeInfo;
import edu.hut.domain.PageOfJudgeList;

import java.util.List;
import java.util.Map;

public interface JudgeService {
    int saveJudgeInfo(JudgeInfo judgeInfo);

    int saveImage(String pic_address, String judge_number);

    List<JudgeInfo> findJudgement(int item_id);

    int findMatchNum(int item_id);

    int findJudgeListNum(PageOfJudgeList pageOfJudgeList);

    List<Map<String, Object>> findJudgeList(PageOfJudgeList pageOfJudgeList);

    Map<String, Object> findJudgeInfoDetail(Integer jid);
}
