package edu.hut.dao;

import edu.hut.domain.PageOfPlanList;
import edu.hut.dto.PlanInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("PlanDao")
public interface PlanDao {
    int savePlanInfo(@Param("planInfoDTO") PlanInfoDTO planInfoDTO);

    int findPlanListNum(@Param("pageOfPlanList") PageOfPlanList pageOfPlanList);

    List<Map<String,Object>> findPlanInfo(@Param("pageOfPlanList") PageOfPlanList pageOfPlanList);

    Map<String, Object> findPlanInfoDetail(Integer plan_id);

    List<Map<String, Object>> findJudgeInfoList(List<String> list);
}
