package edu.hut.dao;

import edu.hut.domain.JudgeInfo;
import edu.hut.domain.PageOfJudgeList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("JudgeDao")
public interface JudgeDao {
    int saveJudgeInfo(@Param("judgeInfo") JudgeInfo judgeInfo);

    int saveImage(@Param("pic_address") String pic_address, @Param("judge_number") String judge_number);

    List<JudgeInfo> findJudgement(@Param("item_id") int item_id);

    int findMatchNum(@Param("item_id") int item_id);

    int findJudgeListNum(@Param("pageOfJudgeList") PageOfJudgeList pageOfJudgeList);

    List<Map<String, Object>> findJudgeList(@Param("pageOfJudgeList") PageOfJudgeList pageOfJudgeList);

    Map<String, Object> findJudgeInfoDetail(Integer jid);
}
