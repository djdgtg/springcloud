package com.retech.userserver.service;

import com.retech.common.utils.ActionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order-server")
@RequestMapping("/order")
public interface OrderService {

    @GetMapping("/user/{id}")
    ActionResult getUserOrderList(@PathVariable("id") Integer id);
}
