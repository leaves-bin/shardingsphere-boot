package com.bruce.business.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bruce.business.bo.OrderBo;
import com.bruce.business.po.Order;
import com.bruce.business.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yongbin
 * @since 2021-05-06
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "创建记录 , SKU为 ZF2021049，预期落库 test2.order_1")
    @GetMapping("/create1")
    public Order create1() {
        return orderService.create("ZF2021049");
    }

    @ApiOperation(value = "创建记录, SKU为ZF2021048 ，预期落库 test1.order_0")
    @GetMapping("/create2")
    public Order create2() {
        return orderService.create("ZF2021048");
    }

    @ApiOperation(value = "创建记录 shadow=false,预期落库test1")
    @GetMapping("/create3")
    public Order create3() {
        return orderService.create("ZF2021048");
    }

    @ApiOperation(value = "创建记录 shadow=true,预期落库test2")
    @GetMapping("/create4")
    public Order create4() {
        return orderService.create("ZF2021048", Boolean.TRUE);
    }

    @ApiOperation(value = "查询记录")
    @GetMapping("/read")
    public Order read(@RequestParam("no") String no) {
        return orderService.read(no);
    }

    @ApiOperation(value = "count")
    @GetMapping("/count")
    public List<OrderBo> count() {
        return orderService.selectCount();
    }

    @ApiOperation(value = "selectOrderList")
    @GetMapping("/selectOrderList")
    public List<Order> selectOrderList() {
        return orderService.selectOrderList();
    }

    @ApiOperation(value = "selectOrderUser")
    @GetMapping("/selectOrderUser")
    public List<OrderBo> selectOrderUser() {
        return orderService.selectOrderUser();
    }

    @ApiOperation(value = "selectPage")
    @GetMapping("/selectPage")
    public Page<Order> selectPage() {
        return orderService.selectPage();
    }

    @GetMapping("/selectBySku")
    public Page<Order> selectBySku(@RequestParam("sku")String sku) {
        return orderService.selectBySku(sku);
    }

    @ApiOperation(value = "batchOrder")
    @GetMapping("/batchOrder")
    public Boolean batchOrder() {
        orderService.batchOrder();
        return true;
    }


}
