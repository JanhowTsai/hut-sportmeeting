package edu.hut.dao;

import edu.hut.domain.Notice;
import edu.hut.domain.PageOfNoticeList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("NoticeDao")
public interface NoticeDao {
    int saveNotice(@Param("notice") Notice notice);

    int findNoticeListNum();

    List<Notice> findNoticeList(@Param("pageOfNoticeList") PageOfNoticeList pageOfNoticeList);

    Map<String,String> findNoticeHtmlContent(Integer nid);

    List<Map<String, Object>> findNoticeListNumByTime(@Param("pageOfNoticeList") PageOfNoticeList pageOfNoticeList);

    int findNoticeListNum2(@Param("pageOfNoticeList") PageOfNoticeList pageOfNoticeList);
}
