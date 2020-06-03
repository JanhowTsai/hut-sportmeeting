package edu.hut.service.impl;

import edu.hut.dao.PlayerDao;
import edu.hut.domain.PageOfPlayerList;
import edu.hut.domain.PlayerInfo;
import edu.hut.domain.Register;
import edu.hut.dto.ItemsDTO;
import edu.hut.service.PlayerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("PlayerService")
public class PlayerServiceImpl implements PlayerService {

    @Resource(name = "PlayerDao")
    private PlayerDao playerDao;

    @Override
    public int savePlayerInfo(PlayerInfo playerInfo) {
        return playerDao.savePlayerInfo(playerInfo);
    }

    @Override
    public int saveImage(String pic_address, String player_number) {
        return playerDao.saveImage(pic_address,player_number);
    }

    @Override
    public List<String> findItems(String player_number) {
        List<String> itemsList = new ArrayList<>();
        List<ItemsDTO> list = playerDao.findItems(player_number);
        for(ItemsDTO itemsDTO:list){
            itemsList.add(itemsDTO.getItem_name());
        }
        return itemsList;
    }

    @Override
    public int findPlayerListNum(PageOfPlayerList pageOfPlayerList) {
        return playerDao.findPlayerListNum(pageOfPlayerList);
    }

    @Override
    public List<Map<String, Object>> findPlayerList(PageOfPlayerList pageOfPlayerList) {
        List<Map<String, Object>> map = playerDao.findPlayerList(pageOfPlayerList);
        return map;
    }

    @Override
    public Map<String, Object> findPlayerInfoDetail(Integer pid) {
        Map<String, Object> map = playerDao.findPlayerInfoDetail(pid);
        return map;
    }
}
