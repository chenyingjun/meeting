package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.dto.MtMeetingFind;
import com.chenyingjun.meeting.entity.MtMeeting;
import com.chenyingjun.meeting.mapper.MtMeetingMapper;
import com.chenyingjun.meeting.mapper.MtMeetingRoomMapper;
import com.chenyingjun.meeting.vo.MtMeetingPageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会议服务
 *
 * @author chenyingjun
 * @version 2017年12月25日
 * @since 1.0
 */
@Service
public class MtMeetingService extends BaseService<MtMeeting>{

    /**
     * 会议dao
     */
    @Autowired
    private MtMeetingMapper meetingMapper;

    /**
     * 会议室 dao
     */
    @Autowired
    private MtMeetingRoomMapper mtMeetingRoomMapper;

    /**
     * 分页查询
     * @param find 查询信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return 组织列表
     */
    public PageInfo<MtMeetingPageVo> page(MtMeetingFind find, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MtMeetingPageVo> list = meetingMapper.selectPage(find);
        return new PageInfo<> (list);
    }
}
