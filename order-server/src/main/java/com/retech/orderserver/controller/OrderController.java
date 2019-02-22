package com.retech.orderserver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.retech.common.entity.Order;
import com.retech.common.entity.User;
import com.retech.common.utils.ActionResult;
import com.retech.orderserver.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qinc
 * @date 2019/2/20
 */
@RestController
@RequestMapping("/order")
@Api("Order相关的api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     *@description 根据订单id查询订单信息
     *@params [orderid]
     *@return com.retech.common.entity.Order
     */
    @HystrixCommand
    @ApiOperation(value = "根据订单id查询一个订单", notes = "查询数据库中某个的订单信息")
    @ApiImplicitParam(name = "orderid", value = "订单ID", paramType = "path", required = true, dataType = "String")
    @GetMapping("/{orderid}")
    public ActionResult getOrderById(@PathVariable String orderid){
        return orderService.getOrderById(orderid);
    }

    /**
     *@description 查询订单列表
     *@params []
     *@return java.util.List<com.retech.common.entity.Order>
     */
    @HystrixCommand
    @ApiOperation(value = "查询订单列表", notes = "查询数据库中所有的订单信息")
    @GetMapping
    public ActionResult getOrderList(){
        return orderService.getOrderList();
    }

    /**
     *@description 根据用户id查询订单列表
     *@params [id]
     *@return java.util.List<com.retech.common.entity.Order>
     */
    @HystrixCommand
    @ApiOperation(value = "根据用户id查询该用户的订单列表", notes = "查询数据库中某个的用户的订单信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Long")
    @GetMapping("/user/{id}")
    public ActionResult getUserOrderList(@PathVariable Integer id){
        return orderService.getUserOrderList(id);
    }

    /**
     *@description 新增一个订单
     *@params [user]
     *@return com.retech.common.utils.ActionResult
     */
    @HystrixCommand
    @ApiOperation(value = "新增一个订单", notes = "数据库新增一个订单数据")
    @ApiImplicitParam(name = "order", value = "实体order", required = true, dataType = "Order")
    @PostMapping
    public ActionResult add(@RequestBody Order order) {
        return orderService.add(order);
    }

    /**
     *@description 根据订单id更新一个订单
     *@params [orderid, user]
     *@return com.retech.common.utils.ActionResult
     */
    @HystrixCommand
    @ApiOperation(value = "根据订单id更新一个订单", notes = "根据订单id更新一个订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderid", value = "订单id", paramType = "path", required = true, dataType = "String"),
            @ApiImplicitParam(name = "order", value = "实体order", required = true, dataType = "Order")
    })
    @PutMapping("/{orderid}")
    public ActionResult update(@PathVariable("orderid") String orderid, @RequestBody Order order) {
        return orderService.update(orderid, order);
    }

    /**
     *@description 根据用户id删除一个用户
     *@params [orderid]
     *@return com.retech.common.utils.ActionResult
     */
    @HystrixCommand
    @ApiOperation(value = "根据订单id删除一个订单", notes = "数据库删除一个订单数据")
    @ApiImplicitParam(name = "orderid", value = "订单id", paramType = "path", required = true, dataType = "String")
    @DeleteMapping("/{orderid}")
    public ActionResult deleteById(@PathVariable String orderid) {
        return orderService.deleteById(orderid);
    }
}
