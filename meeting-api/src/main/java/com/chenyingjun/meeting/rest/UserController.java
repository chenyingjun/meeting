package com.chenyingjun.meeting.rest;

import com.chenyingjun.meeting.entity.UserTest;
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
 * 用户相关api
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Api(description = "用户相关api")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "java.lang.Long", name = "id", value = "id", required = true, paramType = "path"),
            @ApiImplicitParam(dataType = "UserTest", name = "user", value = "用户信息", required = true)
    })
    @RequestMapping(value = "",method = RequestMethod.POST)
    public UserTest saveUser(@RequestBody UserTest user){

        System.out.println("user:"+user);
        return user;
    }

    @ApiOperation(value="获取指定id用户详细信息", notes="根据user的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户id", dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserTest getUser(@PathVariable Integer id){
        logger.info("--------------------------getUser");
        return userService.getUserTestByPrimaryKey(id);
    }


    @ApiOperation(value="获取用户详细信息列表", notes="获取用户详细信息列表")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageInfo<UserTest> page(UserTest user, @RequestParam int pageNum, @RequestParam int pageSize){
        List<UserTest> userList = userService.page(user, pageNum, pageSize);
        return new PageInfo<>(userList);
    }

    @ApiOperation(value="模糊查询用户信息", notes="模糊查询用户信息")
    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public List<UserTest> like(UserTest user){
        List<UserTest> userList = userService.like(user);
        return userList;
    }

    @ApiIgnore
    @ApiOperation(value="删除指定id用户", notes="根据id来删除用户信息")
    @ApiImplicitParam(name = "id",value = "用户id", dataType = "java.lang.Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        System.out.println("delete user:"+id);
        return "OK";
    }

    @ApiOperation(value="保存redis信息", notes="保存redis信息")
    @RequestMapping(value = "/redis", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "keys", value = "redisKeys", dataType = "java.lang.String"),
            @ApiImplicitParam(paramType = "query", name = "value", value = "redisValue", dataType = "java.lang.String"),})
    public String saveRedis(String keys, String value){
        userService.saveRedis(keys, value);
        return "OK";
    }

    @ApiOperation(value="获取redis信息", notes="根据keys获取redis信息")
    @ApiImplicitParam(name = "keys",value = "keys", dataType = "java.lang.String", paramType = "path")
    @RequestMapping(value = "/redis/{keys}", method = RequestMethod.GET)
    public String getRedis(@PathVariable String keys){
        return userService.getRedis(keys);
    }

    @ApiOperation(value="删除redis信息", notes="根据keys删除redis信息")
    @ApiImplicitParam(name = "keys",value = "keys", dataType = "java.lang.String", paramType = "path")
    @RequestMapping(value = "/redis/{keys}", method = RequestMethod.DELETE)
    public String removeRedis(@PathVariable String keys){
        userService.removeRedis(keys);
        return "OK";
    }
}
