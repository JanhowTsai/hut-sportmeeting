package edu.hut.service.impl;

import edu.hut.dao.PlanDao;
import edu.hut.domain.PageOfPlanList;
import edu.hut.domain.PlanInfo;
import edu.hut.dto.PlanInfoDTO;
import edu.hut.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("PlanService")
public class PlanServiceImpl implements PlanService {

    @Resource(name = "PlanDao")
    private PlanDao planDao;

    @Override
    public int savePlanInfo(PlanInfo planInfo) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start_time = dateFormat.parse(planInfo.getStart_time());
        Date end_time = dateFormat.parse(planInfo.getEnd_time());
        List<Integer> judgelist = planInfo.getJudge_list();
        String judge_list = "";
        if(judgelist.size()>1){
            for(int i=0;i<judgelist.size();i++){
                if(i==judgelist.size()-1){
                    judge_list+=String.valueOf(judgelist.get(i));
                }else{
                    judge_list+=String.valueOf(judgelist.get(i))+"-";
                }
            }
        }else{
            judge_list = String.valueOf(judgelist.get(0));
        }

        PlanInfoDTO planInfoDTO = new PlanInfoDTO();
        planInfoDTO.setPlan_id(planInfo.getPlan_id());
        planInfoDTO.setItem_id(planInfo.getItem_id());
        planInfoDTO.setType_id(planInfo.getType_id());
        planInfoDTO.setStart_time(start_time);
        planInfoDTO.setEnd_time(end_time);
        planInfoDTO.setMatch_address(planInfo.getMatch_address());
        planInfoDTO.setMatch_index(planInfo.getMatch_index());
        planInfoDTO.setJudge_list(judge_list);

        return planDao.savePlanInfo(planInfoDTO);
    }

    @Override
    public int findPlanListNum(PageOfPlanList pageOfPlanList) {
        return planDao.findPlanListNum(pageOfPlanList);
    }

    @Override
    public List<Map<String, Object>> findPlanInfo(PageOfPlanList pageOfPlanList) {
        return planDao.findPlanInfo(pageOfPlanList);
    }

    @Override
    public Map<String, Object> findPlanInfoDetail(Integer plan_id) {
        Map<String,Object> map = planDao.findPlanInfoDetail(plan_id);
        String judge_list = (String) map.get("judge_list");
        if(judge_list.length()!=1){
            String[] str = judge_list.split("-");
            List<String> list = new ArrayList<>();
            for(int i=0;i<str.length;i++){
                list.add(str[i]);
            }
            List<Map<String, Object>> judgeInfoList = findJudgeInfoList(list);
            map.put("judgeInfoList",judgeInfoList);
        }else {
            List<String> list = new ArrayList<>();
            list.add(judge_list);
            List<Map<String,Object>> judgeInfoList = findJudgeInfoList(list);
            map.put("judgeInfoList",judgeInfoList);
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> findJudgeInfoList(List<String> list) {
        List<Map<String,Object>> judgeInfoList = planDao.findJudgeInfoList(list);
        return judgeInfoList;
    }
}
