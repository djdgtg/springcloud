package com.retech.orderserver.service.impl;

import com.retech.common.entity.Order;
import com.retech.common.entity.OrderExample;
import com.retech.common.mapper.OrderMapper;
import com.retech.common.utils.ActionResult;
import com.retech.orderserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qinc
 * @date 2019/2/20
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public ActionResult getOrderById(String orderid) {
        return ActionResult.ok(orderMapper.selectByPrimaryKey(orderid));
    }

    @Override
    public ActionResult getOrderList() {
        return ActionResult.ok(orderMapper.selectByExample(new OrderExample()));
    }

    @Override
    public ActionResult getUserOrderList(Integer id) {
        OrderExample example=new OrderExample();
        example.createCriteria().andUseridEqualTo(id);
        return ActionResult.ok(orderMapper.selectByExample(example));
    }

    @Override
    public ActionResult deleteById(String orderid) {
        int count = orderMapper.deleteByPrimaryKey(orderid);
        if(count>0){
            return ActionResult.ok();
        }
        return ActionResult.build(-1,"删除订单失败！");
    }

    @Override
    public ActionResult update(String orderid, Order order) {
        int count = orderMapper.updateByPrimaryKey(order);
        if(count>0){
           return ActionResult.ok();
        }
        return ActionResult.build(-1,"更新订单失败！");
    }

    @Override
    public ActionResult add(Order order) {
        int count = orderMapper.insert(order);
        if(count>0){
            return ActionResult.ok();
        }
        return ActionResult.build(-1,"添加订单失败！");
    }
}
