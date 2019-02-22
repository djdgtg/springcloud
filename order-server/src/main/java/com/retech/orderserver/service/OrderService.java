package com.retech.orderserver.service;

import com.retech.common.entity.Order;
import com.retech.common.utils.ActionResult;

public interface OrderService {
    ActionResult getOrderById(String orderid);

    ActionResult getOrderList();

    ActionResult getUserOrderList(Integer id);

    ActionResult deleteById(String orderid);

    ActionResult update(String orderid, Order order);

    ActionResult add(Order order);
}
