package edu.hut.service;

import edu.hut.domain.PageOfPlanList;
import edu.hut.domain.PlanInfo;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface PlanService {
    int savePlanInfo(PlanInfo planInfo) throws ParseException;

    int findPlanListNum(PageOfPlanList pageOfPlanList);

    List<Map<String, Object>> findPlanInfo(PageOfPlanList pageOfPlanList);

    Map<String, Object> findPlanInfoDetail(Integer plan_id);

    List<Map<String,Object>> findJudgeInfoList(List<String> list);
}
