package edu.hut.service;

import edu.hut.domain.Notice;
import edu.hut.domain.PageOfNoticeList;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NoticeService {
    int saveNotice(Notice notice);

    int findNoticeListNum();

    List<Notice> findNoticeList(PageOfNoticeList pageOfNoticeList);

    Map<String,String> findNoticeHtmlContent(Integer nid);

    List<Map<String, Object>> findNoticeListNumByTime(PageOfNoticeList pageOfNoticeList);

    int findNoticeListNum2(PageOfNoticeList pageOfNoticeList);
}
