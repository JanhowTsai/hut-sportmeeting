package edu.hut.service;

import edu.hut.domain.Register;
import edu.hut.domain.ScoreInfo;
import edu.hut.domain.SearchInfo;

import java.util.List;
import java.util.Map;

public interface RecordService {
    List<Register> searchPlayer(SearchInfo searchInfo);

    int saveScore(List<ScoreInfo> scoreInfoList);

    List<Map<String, Object>> searchPlayerScore(SearchInfo searchInfo);

    List<Map<String, Object>> searchPlayerRank(SearchInfo searchInfo);
}
