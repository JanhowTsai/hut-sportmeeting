package edu.hut.web;

import edu.hut.domain.JudgeInfo;
import edu.hut.domain.PageOfJudgeList;
import edu.hut.domain.PageOfPlayerList;
import edu.hut.dto.Item_idDTO;
import edu.hut.dto.ResultDTO;
import edu.hut.service.JudgeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("Duplicates")
@Controller("JudgeController")
@RequestMapping("/judge")
public class JudgeController {

    @Resource(name = "JudgeService")
    private JudgeService judgeService;

    @RequestMapping("/saveJudgeInfo")
    public @ResponseBody ResultDTO saveJudgeInfo(@RequestBody JudgeInfo judgeInfo) throws InterruptedException {
        Thread.sleep(2000);
        int result = 0;
        if(judgeInfo!=null){
            result = judgeService.saveJudgeInfo(judgeInfo);
        }
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

    @RequestMapping("/saveImage")
    public @ResponseBody
    ResultDTO saveImage(HttpServletRequest request, MultipartFile upload, String judge_number) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if(!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        filename = uuid+"_"+filename;
        upload.transferTo(new File(file,filename));
        String pic_address = "uploads/"+filename;
        int result = judgeService.saveImage(pic_address, judge_number);
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

    @RequestMapping("/findMatchNum")
    public @ResponseBody Item_idDTO findMatchNum(@RequestBody Item_idDTO item_idDTO){
        int item_id = item_idDTO.getItem_id();
        int num = judgeService.findMatchNum(item_id);
        Item_idDTO dto = new Item_idDTO();
        dto.setNum(num);
        return dto;
    }

    @RequestMapping("/findJudgement")
    public @ResponseBody List<JudgeInfo> findJudgement(@RequestBody Item_idDTO item_idDTO){
        int item_id = item_idDTO.getItem_id();
        List<JudgeInfo> list = judgeService.findJudgement(item_id);
        return list;
    }

    public int findJudgeListNum(PageOfJudgeList pageOfJudgeList){
        return judgeService.findJudgeListNum(pageOfJudgeList);
    }

    @RequestMapping("/findJudgeList")
    public @ResponseBody List<Map<String,Object>> findJudgeList(@RequestBody Map<String,String> map){
        int totalPageNum = 0;
        Integer currentPageIndex = Integer.parseInt(map.get("currentPageIndex"));
        PageOfJudgeList pageOfJudgeList = new PageOfJudgeList();
        pageOfJudgeList.setCurrentPageIndex(currentPageIndex);
        if(map.containsKey("judgenumber")&&map.get("judgenumber")!=""){
            pageOfJudgeList.setJudgeNumber(map.get("judgenumber"));
        }
        if(map.containsKey("judgename")&&map.get("judgename")!=""){
            pageOfJudgeList.setJudgeName(map.get("judgename"));
        }
        totalPageNum = findJudgeListNum(pageOfJudgeList);
        pageOfJudgeList.setPageNum(10);
        pageOfJudgeList.setTotalPageNum(totalPageNum);
        pageOfJudgeList.setTotalPage((int)Math.ceil((double)totalPageNum/(double)pageOfJudgeList.getPageNum()));
        pageOfJudgeList.setStartIndex(currentPageIndex*pageOfJudgeList.getPageNum()-pageOfJudgeList.getPageNum());
        List<Map<String, Object>> list = judgeService.findJudgeList(pageOfJudgeList);

        for(Map<String,Object> inmap:list){
            inmap.put("totalPage",pageOfJudgeList.getTotalPage());
            inmap.put("totalPageNum",pageOfJudgeList.getTotalPageNum());
        }

        return  list;
    }

    @RequestMapping("/findJudgeInfoDetail")
    public @ResponseBody Map<String,Object> findJudgeInfoDetail(@RequestBody Map<String,String> map){
        String id = map.get("jid");
        Integer jid = Integer.parseInt(id);
        Map<String,Object> resutlmap = judgeService.findJudgeInfoDetail(jid);
        return resutlmap;
    }
}
