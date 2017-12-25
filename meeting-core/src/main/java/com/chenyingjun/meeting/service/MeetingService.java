package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.constant.CommonConsts;
import com.chenyingjun.meeting.dto.MeetingFind;
import com.chenyingjun.meeting.entity.Meeting;
import com.chenyingjun.meeting.example.MeetingExample;
import com.chenyingjun.meeting.mapper.MeetingMapper;
import com.chenyingjun.meeting.utils.Collections;
import com.chenyingjun.meeting.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 会议服务
 *
 * @author chenyingjun
 * @version 2017年12月25日
 * @since 1.0
 */
public class MeetingService extends BaseService<Meeting>{

    /**
     * 会议dao
     */
    @Autowired
    private MeetingMapper meetingMapper;
    /**
     * 分页查询
     * @param find 查询信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return 组织列表
     */
    public PageInfo<Meeting> page(MeetingFind find, int pageNum, int pageSize) {
        MeetingExample example = new MeetingExample();
        MeetingExample.Criteria criteria = example.createCriteria();
        String name = find.getMeetingName();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andMeetingNameLike("%" + name + "%");
        }
        String meetingRoomIds = find.getMeetingRoomIds();
        if (StringUtils.isNotEmpty(meetingRoomIds)) {
            List<String> meetingRoomIdList = Lists.newArrayList(meetingRoomIds.split(","));
            criteria.andMeetingRoomIdIn(meetingRoomIdList);
        }
        List<Integer> statusList = find.getMeetingStatusList();
        if (Collections.isNotEmpty(statusList)) {
            criteria.andMeetingStatusIn(statusList);
        }
        String startTime = find.getStartTime();

        criteria.andDelFlagEqualTo(CommonConsts.DEL_FLAG_NORMAL);
        return this.basePageByExample(example, pageNum, pageSize);
    }
}
