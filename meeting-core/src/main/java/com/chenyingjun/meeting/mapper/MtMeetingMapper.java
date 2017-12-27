package com.chenyingjun.meeting.mapper;

import com.chenyingjun.meeting.dto.MtMeetingFind;
import com.chenyingjun.meeting.entity.MtMeeting;
import com.chenyingjun.meeting.utils.MyMapper;
import com.chenyingjun.meeting.vo.MtMeetingPageVo;

import java.util.List;

/**
 * 会议 mapper
 */
public interface MtMeetingMapper extends MyMapper<MtMeeting> {

    /**
     * 列表查询
     * @param find 查询条件
     * @return 列表信息
     */
    List<MtMeetingPageVo> selectPage(MtMeetingFind find);
}