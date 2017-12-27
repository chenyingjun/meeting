package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.constant.CommonConsts;
import com.chenyingjun.meeting.dto.MtMeetingFind;
import com.chenyingjun.meeting.entity.MtMeeting;
import com.chenyingjun.meeting.example.MtMeetingExample;
import com.chenyingjun.meeting.mapper.MtMeetingMapper;
import com.chenyingjun.meeting.utils.DateUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
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
     * 分页查询
     * @param find 查询信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return 组织列表
     */
    public PageInfo<MtMeeting> page(MtMeetingFind find, int pageNum, int pageSize) {
        MtMeetingExample example = new MtMeetingExample();
        MtMeetingExample.Criteria criteria = example.createCriteria();
        String name = find.getMeetingName();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andMeetingNameLike("%" + name + "%");
        }
        String meetingRoomIds = find.getMeetingRoomIds();
        if (StringUtils.isNotEmpty(meetingRoomIds)) {
            List<String> meetingRoomIdList = Lists.newArrayList(meetingRoomIds.split(","));
            criteria.andMeetingRoomIdIn(meetingRoomIdList);
        }
        Integer[] status = find.getMeetingStatus();
        if (null != status && status.length > 0) {
            List<Integer> statusList = Lists.newArrayList(status);
            criteria.andMeetingStatusIn(statusList);
        }
        String startTime = find.getStartTime();
        if (StringUtils.isNotBlank(startTime)) {
            criteria.andEndTimeGreaterThanOrEqualTo(DateUtil.fomatDate(startTime));
        }
        String endTime = find.getEndTime();
        if (StringUtils.isNotBlank(endTime)) {
            criteria.andStartTimeLessThanOrEqualTo(DateUtil.fomatDate(endTime));
        }
        criteria.andDelFlagEqualTo(CommonConsts.DEL_FLAG_NORMAL);
        return this.basePageByExample(example, pageNum, pageSize);
    }
}
