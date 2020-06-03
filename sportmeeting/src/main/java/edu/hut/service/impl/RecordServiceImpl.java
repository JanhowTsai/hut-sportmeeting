package edu.hut.service.impl;

import edu.hut.dao.RecordDao;
import edu.hut.domain.Register;
import edu.hut.domain.ScoreInfo;
import edu.hut.domain.SearchInfo;
import edu.hut.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("RecordService")
public class RecordServiceImpl implements RecordService {

    @Resource(name = "RecordDao")
    private RecordDao recordDao;
    @Override
    public List<Register> searchPlayer(SearchInfo searchInfo) {
        List<String> stroeList = new ArrayList<>();
        Integer item_id = searchInfo.getItem_id();
        Integer type_id = searchInfo.getType_id();
        List<Register> list = recordDao.searchPlayer(searchInfo);
        for(Register rs : list){
            stroeList.add(rs.getPlayer_number());
        }
        List<Map<String,Object>> vetifyExistList = recordDao.vetifyExist(stroeList, item_id, type_id);
        String playernumber = "";
        Iterator<Register> iterator = list.iterator();
        while(iterator.hasNext()){
            Register res = iterator.next();
            for (Map map:vetifyExistList){
                playernumber = (String) map.get("player_number");
                if(!((String)map.get("score1")).equals("")||!((String)map.get("score1")==null)){
                    if(res.getPlayer_number().equals(playernumber)){
                        iterator.remove();
                    }
                }
            }
        }
        /*for (Map map:vetifyExistList){
            playernumber = (String) map.get("player_number");
            if(!((String)map.get("score1")).equals("")||!((String)map.get("score1")==null)){
                //解决方法，使用迭代器
                while (iterator.hasNext()){
                    if(iterator.next().getPlayer_number().equals(playernumber)){
                        iterator.remove();
                    }
                }
                //ConcurrentModificationException异常
                for(Register rs:list){
                    if(rs.getPlayer_number().equals(playernumber)){
                        list.remove(rs);
                    }
                }
            }
        }*/
        return list;
    }

    @Override
    public int saveScore(List<ScoreInfo> scoreInfoList) {
        int result = 0;
        int match_index = scoreInfoList.get(0).getMatch_index();
        if(match_index==1){
            result = recordDao.saveScoreOfOne(scoreInfoList);
        }else if(match_index==2){
            result = recordDao.saveScoreOfTwo(scoreInfoList);
        }else if(match_index==3){
            result = recordDao.saveScoreOfThree(scoreInfoList);
        }else if(match_index==4){
            result = recordDao.saveScoreOfFour(scoreInfoList);
        }else if(match_index==5){
            result = recordDao.saveScoreOfFive(scoreInfoList);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> searchPlayerScore(SearchInfo searchInfo) {
        List<ScoreInfo> list = recordDao.searchPlayerScore(searchInfo);
        List<Map<String,Object>> newlist = new ArrayList<>();
        for(ScoreInfo scoreInfo:list){
            Map<String,Object> map = new HashMap<>();
            map.put("type_id",scoreInfo.getType_id());
            map.put("item_id",scoreInfo.getItem_id());
            map.put("player_name",scoreInfo.getPlayer_name());
            map.put("player_number",scoreInfo.getPlayer_number());
            map.put("this_score",scoreInfo.getThis_score());
            String this_score = scoreInfo.getThis_score();
            String[] time = this_score.split(":");
            map.put("hour",time[0]);
            map.put("minutes",time[1]);
            String[] time2 = time[2].split("\\.");
            map.put("seconds",time2[0]);
            map.put("mseconds",time2[1]);
            newlist.add(map);
        }
        return newlist;
    }

    @Override
    public List<Map<String, Object>> searchPlayerRank(SearchInfo searchInfo) {
        List<Map<String, Object>> list = searchPlayerScore(searchInfo);
        for(Map<String,Object> map:list){
            String score = (String) map.get("this_score");
            String[] str = score.split(":");
            Double tran_score = 0.0;
            for(int i=0;i<str.length;i++){
                if(i==0){
                    tran_score+=Double.valueOf(str[i])*3600;
                }else if(i==1){
                    tran_score+=Double.valueOf(str[i])*60;
                }else {
                    tran_score+=Double.valueOf(str[i]);
                }
            }
            if(tran_score==0.0){
                tran_score = 360000.0;
            }
            map.put("tran_score",tran_score);
        }
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                int result = 0;
                if((Double)o1.get("tran_score")>(Double)o2.get("tran_score")){
                    result = 1;
                }else if((Double)o1.get("tran_score")<(Double)o2.get("tran_score")){
                    result = -1;
                }else {
                    result = 0;
                }
                return result;
            }
        });
        return list;
    }
}
