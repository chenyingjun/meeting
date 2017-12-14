package com.chenyingjun.meeting.rest;

import com.chenyingjun.meeting.entity.Org;
import com.chenyingjun.meeting.entity.UserTest;
import com.chenyingjun.meeting.service.OrgService;
import com.chenyingjun.meeting.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 组织相关api
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Api(description = "组织相关api")
@RestController
@RequestMapping("/api/orgs")
public class OrgController {

    @Autowired
    private OrgService orgService;

    private static final Logger logger = LoggerFactory.getLogger(OrgController.class);

    @ApiOperation(value="创建组织信息", notes="根据Org对象创建组织")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Org", name = "org", value = "组织信息", required = true)
    })
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Org org){
        orgService.save(org);
        return "OK";
    }

    @ApiOperation(value="获取指定id组织详细信息", notes="根据user的id来获取组织详细信息")
    @ApiImplicitParam(name = "id",value = "组织id", dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Org getOne(@PathVariable String id){
        return orgService.selectOne(id);
    }


    @ApiOperation(value="获取组织详细信息列表", notes="获取组织详细信息列表")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageInfo<Org> page(Org org, @RequestParam int pageNum, @RequestParam int pageSize){
        List<Org> userList = orgService.page(org, pageNum, pageSize);
        return new PageInfo<>(userList);
    }


    @ApiOperation(value="删除指定id组织", notes="根据id来删除组织信息")
    @ApiImplicitParam(name = "id",value = "组织id", dataType = "java.lang.String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id){
        orgService.delete(id);
        return "OK";
    }

}
