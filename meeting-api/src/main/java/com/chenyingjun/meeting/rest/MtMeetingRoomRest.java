package com.chenyingjun.meeting.rest;

import com.chenyingjun.meeting.dto.MtMeetingRoomFind;
import com.chenyingjun.meeting.entity.MtMeetingRoom;
import com.chenyingjun.meeting.service.MtMeetingRoomService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 会议室接口
 *
 * @author chenyingjun
 * @version 2017年12月26日
 * @since 1.0
 */
@Api(description = "会议室相关api")
@RestController
@RequestMapping("/api/meetingRoom")
public class MtMeetingRoomRest {

    /**
     * 会议室服务
     */
    @Autowired
    private MtMeetingRoomService mtMeetingRoomService;

    @ApiOperation(value="获取会议室信息列表", notes="获取会议室信息列表")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<MtMeetingRoom> page(@Valid MtMeetingRoomFind find, @RequestParam int pageNum, @RequestParam int
            pageSize){
        return mtMeetingRoomService.page(find, pageNum, pageSize);
    }
}
