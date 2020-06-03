package edu.hut.web;

import edu.hut.domain.PageOfPlanList;
import edu.hut.domain.PlanInfo;
import edu.hut.domain.PlayerInfo;
import edu.hut.dto.ResultDTO;
import edu.hut.service.PlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("Duplicates")
@Controller("PlanController")
@RequestMapping("/plan")
public class PlanController {

    @Resource(name = "PlanService")
    private PlanService planService;


    @RequestMapping("/savePlanInfo")
    public @ResponseBody ResultDTO savePlanInfo(@RequestBody PlanInfo planInfo) throws Exception {
//        Thread.sleep(2000);
        int result = planService.savePlanInfo(planInfo);
        ResultDTO resultDTO = new ResultDTO();
        if(result==0){
            resultDTO.setResult_effect_rows(0);
            resultDTO.setResult_status("failed");
        }else{
            resultDTO.setResult_status("success");
            resultDTO.setResult_effect_rows(1);
        }
        return resultDTO;
    }


    public int findPlanListNum(PageOfPlanList pageOfPlanList){
            return planService.findPlanListNum(pageOfPlanList);
    }

    @RequestMapping("/findPlanInfo")
    public @ResponseBody List<Map<String,Object>> findPlanInfo(@RequestBody Map<String,String> map) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PageOfPlanList pageOfPlanList = new PageOfPlanList();
        Integer currentPageIndex = Integer.parseInt(map.get("currentPageIndex"));
        pageOfPlanList.setCurrentPageIndex(currentPageIndex);
        if(map.containsKey("starttime")&&map.get("starttime")!=""){
            Date startTime = dateFormat.parse(map.get("starttime"));
            pageOfPlanList.setStartTime(startTime);
        }
        if(map.containsKey("endtime")&&map.get("endtime")!=""){
            Date endTime = dateFormat.parse(map.get("endtime"));
            pageOfPlanList.setEndTime(endTime);
        }
        int totalPageNum = findPlanListNum(pageOfPlanList);
        pageOfPlanList.setPageNum(10);
        pageOfPlanList.setTotalPageNum(totalPageNum);
        pageOfPlanList.setStartIndex(currentPageIndex*pageOfPlanList.getPageNum()-pageOfPlanList.getPageNum());
        pageOfPlanList.setTotalPage((int)Math.ceil((double)totalPageNum/(double)pageOfPlanList.getPageNum()));
        List<Map<String, Object>> planInfo = planService.findPlanInfo(pageOfPlanList);
        for(Map<String,Object> inmap:planInfo){
            inmap.put("totalPage",pageOfPlanList.getTotalPage());
            inmap.put("totalPageNum",pageOfPlanList.getTotalPageNum());
        }
        return planInfo;
    }

    @RequestMapping("/findPlanInfoDetail")
    public @ResponseBody Map<String,Object> findPlanInfoDetail(@RequestBody Map<String,String> map) throws ParseException {
        String id = map.get("plan_id");
        Integer plan_id = Integer.parseInt(id);
        Map<String,Object> resutlmap = planService.findPlanInfoDetail(plan_id);
        Date start_time = (Date) resutlmap.get("start_time");
        Date end_time = (Date) resutlmap.get("end_time");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        resutlmap.put("start_time",dateFormat.format(start_time));
        resutlmap.put("end_time",dateFormat.format(end_time));
        return resutlmap;
    }
}
