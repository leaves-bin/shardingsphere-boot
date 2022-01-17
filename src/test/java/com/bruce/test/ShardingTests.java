package com.bruce.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bruce.SharedingApplication;
import com.bruce.business.po.Order;
import com.bruce.business.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SharedingApplication.class)
@Slf4j
public class ShardingTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() throws Exception {
        orderService.list(new QueryWrapper<Order>().eq(Order.SKU,"123").eq(Order.ORDER_NO,"123").orderByAsc(Order.PRICE));
    }

}
