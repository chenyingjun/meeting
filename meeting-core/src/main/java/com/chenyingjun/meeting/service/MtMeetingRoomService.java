package com.chenyingjun.meeting.service;

import com.chenyingjun.meeting.constant.CommonConsts;
import com.chenyingjun.meeting.dto.MtMeetingFind;
import com.chenyingjun.meeting.dto.MtMeetingRoomFind;
import com.chenyingjun.meeting.entity.MtMeeting;
import com.chenyingjun.meeting.entity.MtMeetingRoom;
import com.chenyingjun.meeting.example.MtMeetingExample;
import com.chenyingjun.meeting.example.MtMeetingRoomExample;
import com.chenyingjun.meeting.mapper.MtMeetingRoomMapper;
import com.chenyingjun.meeting.utils.DateUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会议室服务
 *
 * @author chenyingjun
 * @version 2017年12月25日
 * @since 1.0
 */
@Service
public class MtMeetingRoomService extends BaseService<MtMeetingRoom>{

    @Autowired
    private MtMeetingRoomMapper mtMeetingRoomMapper;

    /**
     * 分页查询
     * @param find 查询信息
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return 组织列表
     */
    public PageInfo<MtMeetingRoom> page(MtMeetingRoomFind find, int pageNum, int pageSize) {
        MtMeetingRoomExample example = new MtMeetingRoomExample();
        MtMeetingRoomExample.Criteria criteria = example.createCriteria();
        String name = find.getName();
        if (StringUtils.isNotEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        Integer minSeatNumber = find.getMinSeatNumber();
        if (null != minSeatNumber && minSeatNumber.intValue() > 0) {
            criteria.andSeatNumberGreaterThanOrEqualTo(minSeatNumber);
        }
        Integer maxSeatNumber = find.getMaxSeatNumber();
        if (null != maxSeatNumber && maxSeatNumber.intValue() > 0) {
            criteria.andSeatNumberLessThanOrEqualTo(maxSeatNumber);
        }
        criteria.andDelFlagEqualTo(CommonConsts.DEL_FLAG_NORMAL);
        return this.basePageByExample(example, pageNum, pageSize);
    }
}
