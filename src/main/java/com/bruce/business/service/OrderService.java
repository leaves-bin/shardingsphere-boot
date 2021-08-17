package com.bruce.business.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bruce.business.bo.OrderBo;
import com.bruce.business.mapper.OrderMapper;
import com.bruce.business.po.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author yongbin
 * @since 2021-05-06
 */
@Slf4j
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    public Order create(String sku) {
        return create(sku, false);
    }

    public Order create(String sku, Boolean shadow) {
        Order order = new Order();
        order.setSku(sku);
        order.setPrice(new BigDecimal("123456.12"));
        order.setMobile("13718340651");
        if (!shadow) {
            save(order);
        } else {
            order.setShadow(shadow);
            baseMapper.insertOrder(order);
        }
        return order;
    }

    public Order read(String no) {
        return getById(no);
    }

    public List<OrderBo> selectCount() {
        return baseMapper.selectOrderCount();
    }

    public List<Order> selectOrderList() {
        return baseMapper.selectOrderList();
    }

    public List<OrderBo> selectOrderUser() {
        return baseMapper.selectOrderUser();
    }

    public Page<Order> selectPage() {
        return baseMapper.selectPage(new Page<>(1, 10), new QueryWrapper<Order>().orderByDesc(Order.ORDER_NO));
    }

    public Page<Order> selectBySku(String sku) {
        long start = System.currentTimeMillis();
        Page<Order> orderPage = baseMapper.selectPage(new Page<>(1, 10), new QueryWrapper<Order>().eq(Order.SKU, sku).orderByDesc(Order.ORDER_NO));
        long end = System.currentTimeMillis();
        log.info("SELECT COST :{} MS", (end - start));
        return orderPage;
    }

    public void batchOrder() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                20,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100000));

        for (int i = 0; i < 100000; i++) {
            executor.execute(() -> {

                List<Order> orders = new ArrayList<>(1000);
                for (int j = 0; j < 1000; j++) {
                    Order order = new Order();
                    order.setSku(j % 2 == 0 ? "ZF2021048" : "ZF2021049");
                    order.setPrice(new BigDecimal("123456.12"));
                    order.setMobile("13718340651");
                    orders.add(order);
                }
                saveBatch(orders);
            });
        }
    }


}
