package edu.hut.service.impl;

import edu.hut.dao.JudgeDao;
import edu.hut.domain.JudgeInfo;
import edu.hut.domain.PageOfJudgeList;
import edu.hut.service.JudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("JudgeService")
public class JudgeServiceImpl implements JudgeService {

    @Resource(name = "JudgeDao")
    private JudgeDao judgeDao;

    @Override
    public int saveJudgeInfo(JudgeInfo judgeInfo) {
        return judgeDao.saveJudgeInfo(judgeInfo);
    }

    @Override
    public int saveImage(String pic_address, String judge_number) {
        return judgeDao.saveImage(pic_address,judge_number);
    }

    @Override
    public List<JudgeInfo> findJudgement(int item_id) {
        return judgeDao.findJudgement(item_id);
    }

    @Override
    public int findMatchNum(int item_id) {
        return judgeDao.findMatchNum(item_id);
    }

    @Override
    public int findJudgeListNum(PageOfJudgeList pageOfJudgeList) {
        return judgeDao.findJudgeListNum(pageOfJudgeList);
    }

    @Override
    public List<Map<String, Object>> findJudgeList(PageOfJudgeList pageOfJudgeList) {
        return judgeDao.findJudgeList(pageOfJudgeList);
    }

    @Override
    public Map<String, Object> findJudgeInfoDetail(Integer jid) {
        return judgeDao.findJudgeInfoDetail(jid);
    }
}
