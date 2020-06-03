package edu.hut.dao;

import edu.hut.domain.PageOfPlayerList;
import edu.hut.domain.PlayerInfo;
import edu.hut.domain.Register;
import edu.hut.dto.ItemsDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("PlayerDao")
public interface PlayerDao {
    int savePlayerInfo(@Param("playerInfo") PlayerInfo playerInfo);

    int saveImage(@Param("pic_address") String pic_address, @Param("player_number") String player_number);

    List<ItemsDTO> findItems(String player_number);

    int findPlayerListNum(@Param("pageOfPlayerList") PageOfPlayerList pageOfPlayerList);

    List<Map<String, Object>> findPlayerList(@Param("pageOfPlayerList") PageOfPlayerList pageOfPlayerList);

    Map<String, Object> findPlayerInfoDetail(Integer pid);
}
