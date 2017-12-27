package com.chenyingjun.meeting.rest;

import com.chenyingjun.meeting.dto.MtMeetingFind;
import com.chenyingjun.meeting.dto.MtMeetingRoomFind;
import com.chenyingjun.meeting.entity.MtMeeting;
import com.chenyingjun.meeting.entity.MtMeetingRoom;
import com.chenyingjun.meeting.service.MtMeetingRoomService;
import com.chenyingjun.meeting.service.MtMeetingService;
import com.chenyingjun.meeting.utils.FormValid;
import com.chenyingjun.meeting.utils.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public Object page(@Valid @RequestBody MtMeetingRoomFind find, BindingResult bindingResult, @RequestParam int pageNum, @RequestParam int pageSize){
        Result<PageInfo<MtMeetingRoom>> result = new Result<>("200", "分页查询会议室信息成功");
        try {

            if (bindingResult.hasErrors()) {

                FormValid formValid = new FormValid(bindingResult);

                Result<FormValid> errorResult = new Result<>("500", "参数检验失败");

                errorResult.setT(formValid);

                return errorResult;
            }

            PageInfo<MtMeetingRoom> page = mtMeetingRoomService.page(find, pageNum, pageSize);
            result.setT(page);

        } catch (Exception e) {

            result = new Result<>("500", "查询会议室信息失败");

        }
        return result;
    }
}
