package edu.hut.web;

import edu.hut.domain.Register;
import edu.hut.domain.ScoreInfo;
import edu.hut.domain.SearchInfo;
import edu.hut.dto.ResultDTO;
import edu.hut.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller("RecordController")
@RequestMapping("/record")
public class RecordController {

    @Resource(name = "RecordService")
    private RecordService recordService;

    @RequestMapping("/searchPlayer")
    public @ResponseBody List<Register> searchPlayer(@RequestBody SearchInfo searchInfo){
         List<Register> list = recordService.searchPlayer(searchInfo);
         return list;
    }

    @RequestMapping("/searchPlayerScore")
    public @ResponseBody List<Map<String, Object>> searchPlayerScore(@RequestBody SearchInfo searchInfo){
        List<Map<String, Object>> list = recordService.searchPlayerScore(searchInfo);
        return list;
    }

    @RequestMapping("/searchPlayerRank")
    public @ResponseBody List<Map<String, Object>> searchPlayerRank(@RequestBody SearchInfo searchInfo){
        List<Map<String, Object>> list = recordService.searchPlayerRank(searchInfo);
        return list;
    }

    @RequestMapping("/saveScore")
    public @ResponseBody ResultDTO saveScore(@RequestBody List<ScoreInfo> scoreInfoList){
        ResultDTO resultDTO = new ResultDTO();
        int result = recordService.saveScore(scoreInfoList);
        if(result==0){
            resultDTO.setResult_effect_rows(0);
            resultDTO.setResult_status("failed");
        }else{
            resultDTO.setResult_status("success");
            resultDTO.setResult_effect_rows(1);
        }
        return resultDTO;
    }
}
