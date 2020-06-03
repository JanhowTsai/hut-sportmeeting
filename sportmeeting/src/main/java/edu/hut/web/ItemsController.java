package edu.hut.web;

import com.fasterxml.jackson.databind.util.JSONPObject;
import edu.hut.domain.*;
import edu.hut.dto.ResultDTO;
import edu.hut.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller("ItemsController")
@RequestMapping("/items")
public class ItemsController {

    @Resource(name = "ItemsService")
    private ItemsService itemsService;

    @RequestMapping("/findItemsType")
    public @ResponseBody List<ItemsType> findItemsType(){
        return itemsService.findItemsType();
    }

    @RequestMapping("/findMatchItems")
    public @ResponseBody List<Items> findMatchItems(){
        return itemsService.findMatchItems();
    }
    @RequestMapping("/findMatchItemsType")
    public @ResponseBody List<ItemsType> findMatchItemsType(){
        return itemsService.findMatchItemsType();
    }

    @RequestMapping("/findItems")
    public @ResponseBody List<Items> findItems(){
        return itemsService.findItems();
    }

    @RequestMapping("/saveItems")
    public @ResponseBody ResultDTO saveItems(@RequestBody List<MatchItems> matchItems) throws InterruptedException {
        Thread.sleep(1500);
        int num = itemsService.saveItems(matchItems);
        ResultDTO resultDTO = new ResultDTO();
        if(num==matchItems.size()){
            resultDTO.setResult_status("success");
            resultDTO.setResult_effect_rows(num);
        }else{
            resultDTO.setResult_status("failed");
            resultDTO.setResult_effect_rows(0);
        }
        return resultDTO;
    }

    @RequestMapping("/register")
    public @ResponseBody ResultDTO registerItems(@RequestBody List<Register> registers) throws InterruptedException{
        Thread.sleep(1500);
        int num = itemsService.registerItems(registers);
        ResultDTO resultDTO = new ResultDTO();
        if(num==registers.size()){
            resultDTO.setResult_status("success");
            resultDTO.setResult_effect_rows(num);
        }else{
            resultDTO.setResult_status("failed");
            resultDTO.setResult_effect_rows(0);
        }
        return resultDTO;
    }

    @RequestMapping("/findItemsList")
    public @ResponseBody List<MatchItems_info> findItemsList() throws InterruptedException {
        Thread.sleep(1500);
        List<MatchItems_info> itemsList = itemsService.findItemsList();
        return itemsList;
    }
}
