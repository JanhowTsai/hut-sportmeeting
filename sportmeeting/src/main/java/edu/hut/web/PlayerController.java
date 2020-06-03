package edu.hut.web;

import edu.hut.domain.PageOfPlayerList;
import edu.hut.domain.PlayerInfo;
import edu.hut.dto.ItemsDTO;
import edu.hut.dto.ResultDTO;
import edu.hut.service.PlayerService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("ALL")
@Controller("PlayerController")
@RequestMapping("/player")
public class PlayerController {

    @Resource(name = "PlayerService")
    private PlayerService playerService;

    @RequestMapping("/savePlayerInfo")
    public @ResponseBody ResultDTO savePlayerInfo(@RequestBody PlayerInfo playerInfo) throws InterruptedException {
        Thread.sleep(2000);
        int result = 0;
        if(playerInfo!=null){
            result = playerService.savePlayerInfo(playerInfo);
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
    public @ResponseBody ResultDTO saveImage(HttpServletRequest request, MultipartFile upload,String player_number) throws IOException {
//        System.out.println(player_number);
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
         int result = playerService.saveImage(pic_address, player_number);
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

    @RequestMapping("/findItems")
    public @ResponseBody List<String> findItems(@RequestBody ItemsDTO itemsDTO){
        String player_number = itemsDTO.getPlayer_number();
        List<String> list = playerService.findItems(player_number);
        return list;
    }

    public int findPlayerListNum(PageOfPlayerList pageOfPlayerList){
        return playerService.findPlayerListNum(pageOfPlayerList);
    }

    @RequestMapping("/findPlayerList")
    public @ResponseBody List<Map<String,Object>> findPlayerList(@RequestBody Map<String,String> map){
        int totalPageNum = 0;
        Integer currentPageIndex = Integer.parseInt(map.get("currentPageIndex"));
        PageOfPlayerList pageOfPlayerList = new PageOfPlayerList();
        pageOfPlayerList.setCurrentPageIndex(currentPageIndex);
        if(map.containsKey("playernumber")&&map.get("playernumber")!=""){
            pageOfPlayerList.setPlayerNumber(map.get("playernumber"));
        }
        if(map.containsKey("playername")&&map.get("playername")!=""){
            pageOfPlayerList.setPlayerName(map.get("playername"));
        }
        totalPageNum = findPlayerListNum(pageOfPlayerList);
        pageOfPlayerList.setPageNum(10);
        pageOfPlayerList.setTotalPageNum(totalPageNum);
        pageOfPlayerList.setTotalPage((int)Math.ceil((double)totalPageNum/(double)pageOfPlayerList.getPageNum()));
        pageOfPlayerList.setStartIndex(currentPageIndex*pageOfPlayerList.getPageNum()-pageOfPlayerList.getPageNum());
        List<Map<String, Object>> list = playerService.findPlayerList(pageOfPlayerList);

        for(Map<String,Object> inmap:list){
            inmap.put("totalPage",pageOfPlayerList.getTotalPage());
            inmap.put("totalPageNum",pageOfPlayerList.getTotalPageNum());
        }

        return  list;
    }

    @RequestMapping("/findPlayerInfoDetail")
    public @ResponseBody Map<String,Object> findPlayerInfoDetail(@RequestBody Map<String,String> map){
        String id = map.get("pid");
        Integer pid = Integer.parseInt(id);
        Map<String,Object> resutlmap = playerService.findPlayerInfoDetail(pid);
        return resutlmap;
    }
}
