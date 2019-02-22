package com.retech.userserver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.retech.common.entity.User;
import com.retech.common.utils.ActionResult;
import com.retech.userserver.service.OrderService;
import com.retech.userserver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


/**
 * @author qinc
 * @date 2019/2/20
 */
@RestController
@RequestMapping("/user")
@Api("User相关的api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    /**
     * @return com.retech.common.entity.User
     * @description 根据用户id查询用户信息
     * @params [id]
     */
    @HystrixCommand
    @ApiOperation(value = "根据用户id查询一个用户", notes = "查询数据库中某个的用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Long", example = "1")
    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "user")
    public ActionResult getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /**
     * @return java.util.List<com.retech.common.entity.User>
     * @description 查询用户列表
     * @params []
     */
    @HystrixCommand
    @ApiOperation(value = "查询用户列表", notes = "查询数据库中所有的用户信息")
    @GetMapping
    @Cacheable(value = "userList")
    public ActionResult getUserList() {
        return userService.getUserList();
    }

    /**
     * @return java.util.List<com.retech.common.entity.Order>
     * @description 调用order-server的根据用户id查询订单列表功能
     * @params [id]
     */
    @HystrixCommand
    @ApiOperation(value = "根据用户id查询该用户的订单列表", notes = "查询数据库中某个的用户的订单信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Long", example = "1")
    @GetMapping("/order/{id}")
    public ActionResult getUserOrderList(@PathVariable("id") Integer id) {
        return orderService.getUserOrderList(id);
    }

    /**
     *@description 新增一个用户
     *@params [user]
     *@return com.retech.common.utils.ActionResult
     */
    @HystrixCommand
    @ApiOperation(value = "新增一个用户", notes = "数据库新增一个用户数据")
    @ApiImplicitParam(name = "user", value = "实体user", required = true, dataType = "User")
    @PostMapping
    public ActionResult add(@RequestBody User user) {
        return userService.add(user);
    }

    /**
     *@description 根据id修改用户信息
     *@params [id, user]
     *@return com.retech.common.utils.ActionResult
     */
    @HystrixCommand
    @ApiOperation(value = "根据用户id更新一个用户", notes = "根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "Long",example = "1"),
            @ApiImplicitParam(name = "user", value = "实体user", required = true, dataType = "User")
    })
    @PutMapping("/{id}")
    public ActionResult update(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    /**
     *@description 根据用户id删除一个用户
     *@params [id]
     *@return com.retech.common.utils.ActionResult
     */
    @HystrixCommand
    @ApiOperation(value = "根据用户id删除一个用户", notes = "数据库删除一个用户数据")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "Long",example = "1")
    @DeleteMapping("/{id}")
    public ActionResult deleteById(@PathVariable Integer id) {
        return userService.deleteById(id);
    }
}
