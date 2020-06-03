package edu.hut.service.impl;

import edu.hut.dao.NoticeDao;
import edu.hut.domain.Notice;
import edu.hut.domain.PageOfNoticeList;
import edu.hut.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {

    @Resource(name = "NoticeDao")
    private NoticeDao noticeDao;
    @Override
    public int saveNotice(Notice notice) {
        int result = noticeDao.saveNotice(notice);
        return result;
    }

    @Override
    public int findNoticeListNum() {
        return noticeDao.findNoticeListNum();
    }

    @Override
    public List<Notice> findNoticeList(PageOfNoticeList pageOfNoticeList) {
        List<Notice> list = noticeDao.findNoticeList(pageOfNoticeList);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(Notice notice:list){
            Date notice_time = notice.getNotice_time();
            String time = dateFormat.format(notice_time);
            notice.setTime(time);
            String content = notice.getContent();
            if(content.length()>10){
                content = content.substring(0,10)+"...";
            }else{
                content = content.substring(0,content.length())+"...";
            }
            notice.setContent(content);
        }
        return list;
    }

    @Override
    public Map<String, String> findNoticeHtmlContent(Integer nid) {
        Map<String, String> map = noticeDao.findNoticeHtmlContent(nid);
        return map;
    }

    @Override
    public List<Map<String, Object>> findNoticeListNumByTime(PageOfNoticeList pageOfNoticeList) {
        List<Map<String, Object>> list = noticeDao.findNoticeListNumByTime(pageOfNoticeList);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(Map map:list){
            Date notice_time = (Date) map.get("notice_time");
            String time = dateFormat.format(notice_time);
            map.put("time",time);
            String content = (String) map.get("content");
            if(content.length()>10){
                content = content.substring(0,10)+"...";
            }else{
                content = content.substring(0,content.length())+"...";
            }
            map.put("content",content);
        }
        return list;
    }

    @Override
    public int findNoticeListNum2(PageOfNoticeList pageOfNoticeList) {
        return noticeDao.findNoticeListNum2(pageOfNoticeList);
    }
}
