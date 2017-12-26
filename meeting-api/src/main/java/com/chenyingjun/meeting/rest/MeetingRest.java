package com.chenyingjun.meeting.rest;

import com.chenyingjun.meeting.dto.MtMeetingFind;
import com.chenyingjun.meeting.entity.MtMeeting;
import com.chenyingjun.meeting.service.MtMeetingService;
import com.chenyingjun.meeting.utils.FormValid;
import com.chenyingjun.meeting.utils.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value="获取用户详细信息列表", notes="获取用户详细信息列表")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Object page(@Valid MtMeetingFind find, BindingResult bindingResult, @RequestParam int pageNum, @RequestParam int pageSize){
        Result<PageInfo<MtMeeting>> result = new Result<>("200", "分页查询会员信息成功");
        try {

            if (bindingResult.hasErrors()) {

                FormValid formValid = new FormValid(bindingResult);

                Result<FormValid> errorResult = new Result<FormValid>("500", "参数检验失败");

                errorResult.setT(formValid);

                return errorResult;
            }

            PageInfo<MtMeeting> page = meetingService.page(find, pageNum, pageSize);
            result.setT(page);

        } catch (Exception e) {

            result = new Result<>("500", "查询所有会员信息失败");

        }
        return result;
    }
}
