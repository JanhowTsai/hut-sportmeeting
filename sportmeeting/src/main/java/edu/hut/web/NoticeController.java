package edu.hut.web;

import edu.hut.domain.Notice;
import edu.hut.domain.PageOfNoticeList;
import edu.hut.dto.ResultDTO;
import edu.hut.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller("NoticeController")
@RequestMapping("/notice")
public class NoticeController {

    @Resource(name = "NoticeService")
    private NoticeService noticeService;

    @RequestMapping("/saveNotice")
    public @ResponseBody ResultDTO saveNotice(@RequestBody Notice notice){
        Date notice_time = new Date();
        notice.setNotice_time(notice_time);
        int result = noticeService.saveNotice(notice);
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

    public int findNoticeListNum(){
        return noticeService.findNoticeListNum();
    }

    @RequestMapping("/findNoticeList")
    public @ResponseBody List<Map<String, Object>> findNoticeList(@RequestBody Map<String,String> map){
        int totalPageNum = findNoticeListNum();
        List<Notice> list = null;
        List<Map<String,Object>> newList = new ArrayList<>();
        PageOfNoticeList pageOfNoticeList = new PageOfNoticeList();
        if(map.containsKey("currentPageIndex")){
            String index = map.get("currentPageIndex");
            Integer currentPageIndex = Integer.parseInt(index);
            pageOfNoticeList.setCurrentPageIndex(currentPageIndex);
            pageOfNoticeList.setPageNum(10);
            pageOfNoticeList.setTotalPageNum(totalPageNum);
            pageOfNoticeList.setTotalPage((int)Math.ceil((double)totalPageNum/(double)pageOfNoticeList.getPageNum()));
            pageOfNoticeList.setStartIndex(currentPageIndex*pageOfNoticeList.getPageNum()-pageOfNoticeList.getPageNum());
            list = noticeService.findNoticeList(pageOfNoticeList);
        }
        for(Notice notice:list){
            Map<String,Object> newmap = new HashMap<>();
            newmap.put("nid",notice.getNid());
            newmap.put("content",notice.getContent());
            newmap.put("time",notice.getTime());
            newmap.put("totalPage",pageOfNoticeList.getTotalPage());
            newmap.put("totalPageNum",totalPageNum);
            newList.add(newmap);
        }
        return newList;
    }

    @RequestMapping("/findNoticeHtmlContent")
    public @ResponseBody Map<String, String> findNoticeHtmlContent(@RequestBody Map<String,String> map){
        Integer nid = Integer.parseInt(map.get("nid"));
        Map<String, String> resultMap = noticeService.findNoticeHtmlContent(nid);
        return resultMap;
    }

    public int findNoticeListNum2(PageOfNoticeList pageOfNoticeList){
        return noticeService.findNoticeListNum2(pageOfNoticeList);
    }

    @RequestMapping("/findNoticeByTime")
    public @ResponseBody List<Map<String, Object>> findNoticeByTime(@RequestBody Map<String,String> map) throws ParseException {
        int totalPageNum = 0;
        List<Map<String, Object>> list = null;
        List<Map<String,Object>> newList = new ArrayList<>();
        PageOfNoticeList pageOfNoticeList = new PageOfNoticeList();
        if(map.get("starttime")==""&&map.get("endtime")==""){
            list = findNoticeList(map);
            return list;
        }else if(map.get("starttime")==""&&map.get("endtime")!=""){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date endTime = dateFormat.parse(map.get("endtime"));
            pageOfNoticeList.setStartTime(null);
            pageOfNoticeList.setEndTime(endTime);
            pageOfNoticeList.setCurrentPageIndex(Integer.parseInt(map.get("currentPageIndex")));
            pageOfNoticeList.setPageNum(10);
            pageOfNoticeList.setStartIndex(Integer.parseInt(map.get("currentPageIndex"))*pageOfNoticeList.getPageNum()-pageOfNoticeList.getPageNum());
            totalPageNum = findNoticeListNum2(pageOfNoticeList);
            pageOfNoticeList.setTotalPage((int)Math.ceil((double)totalPageNum/(double)pageOfNoticeList.getPageNum()));
            list = noticeService.findNoticeListNumByTime(pageOfNoticeList);
        }else if(map.get("starttime")!=""&&map.get("endtime")==""){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = dateFormat.parse(map.get("starttime"));
            pageOfNoticeList.setEndTime(null);
            pageOfNoticeList.setStartTime(startTime);
            pageOfNoticeList.setCurrentPageIndex(Integer.parseInt(map.get("currentPageIndex")));
            pageOfNoticeList.setPageNum(10);
            pageOfNoticeList.setStartIndex(Integer.parseInt(map.get("currentPageIndex"))*pageOfNoticeList.getPageNum()-pageOfNoticeList.getPageNum());
            totalPageNum = findNoticeListNum2(pageOfNoticeList);
            pageOfNoticeList.setTotalPage((int)Math.ceil((double)totalPageNum/(double)pageOfNoticeList.getPageNum()));
            list = noticeService.findNoticeListNumByTime(pageOfNoticeList);
        }else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = dateFormat.parse(map.get("starttime"));
            Date endTime = dateFormat.parse(map.get("endtime"));
            pageOfNoticeList.setStartTime(startTime);
            pageOfNoticeList.setEndTime(endTime);
            pageOfNoticeList.setCurrentPageIndex(Integer.parseInt(map.get("currentPageIndex")));
            pageOfNoticeList.setPageNum(10);
            pageOfNoticeList.setStartIndex(Integer.parseInt(map.get("currentPageIndex"))*pageOfNoticeList.getPageNum()-pageOfNoticeList.getPageNum());
            totalPageNum = findNoticeListNum2(pageOfNoticeList);
            pageOfNoticeList.setTotalPage((int)Math.ceil((double)totalPageNum/(double)pageOfNoticeList.getPageNum()));
            list = noticeService.findNoticeListNumByTime(pageOfNoticeList);
        }
        for(Map map1:list){
            Map<String,Object> newmap = new HashMap<>();
            newmap.put("nid",map1.get("nid"));
            newmap.put("content",map1.get("content"));
            newmap.put("time",map1.get("time"));
            newmap.put("totalPage",pageOfNoticeList.getTotalPage());
            newmap.put("totalPageNum",totalPageNum);
            newList.add(newmap);
        }
        return newList;
    }
}
