package edu.hut.service;

import edu.hut.domain.PageOfPlayerList;
import edu.hut.domain.PlayerInfo;
import edu.hut.domain.Register;
import edu.hut.dto.ItemsDTO;

import java.util.List;
import java.util.Map;

public interface PlayerService {
    int savePlayerInfo(PlayerInfo playerInfo);

    int saveImage(String pic_address, String player_number);

    List<String> findItems(String player_number);

    int findPlayerListNum(PageOfPlayerList pageOfPlayerList);

    List<Map<String,Object>> findPlayerList(PageOfPlayerList pageOfPlayerList);

    Map<String, Object> findPlayerInfoDetail(Integer pid);
}
