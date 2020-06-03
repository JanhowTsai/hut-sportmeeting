package edu.hut.dao;

import edu.hut.domain.Register;
import edu.hut.domain.ScoreInfo;
import edu.hut.domain.SearchInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("RecordDao")
public interface RecordDao {
    List<Register> searchPlayer(@Param("searchInfo") SearchInfo searchInfo);

    int saveScoreOfOne(List<ScoreInfo> scoreInfoList);

    int saveScoreOfTwo(List<ScoreInfo> scoreInfoList);

    int saveScoreOfThree(List<ScoreInfo> scoreInfoList);

    int saveScoreOfFour(List<ScoreInfo> scoreInfoList);

    int saveScoreOfFive(List<ScoreInfo> scoreInfoList);

    List<Map<String,Object>> findPlayerScore();

    List<ScoreInfo> searchPlayerScore(@Param("searchInfo") SearchInfo searchInfo);

    List<Map<String,Object>> vetifyExist(@Param("stroeList") List<String> stroeList, @Param("iid") Integer item_id, @Param("tid") Integer type_id);
}
