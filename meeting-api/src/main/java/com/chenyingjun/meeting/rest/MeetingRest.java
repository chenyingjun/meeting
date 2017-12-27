package com.chenyingjun.meeting.rest;

import com.chenyingjun.meeting.dto.MtMeetingFind;
import com.chenyingjun.meeting.entity.MtMeeting;
import com.chenyingjun.meeting.service.MtMeetingService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 会议接口
 *
 * @author chenyingjun
 * @version 2017年12月26日
 * @since 1.0
 */
@Api(description = "会议相关api")
@RestController
@RequestMapping("/api/meeting")
public class MeetingRest {

    /**
     * 会议服务
     */
    @Autowired
    private MtMeetingService meetingService;

    @ApiOperation(value="获取会议信息列表", notes="获取会议信息列表")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<MtMeeting> page(@Valid @RequestBody MtMeetingFind find, @RequestParam int pageNum, @RequestParam int pageSize){
        return meetingService.page(find, pageNum, pageSize);
    }
}
