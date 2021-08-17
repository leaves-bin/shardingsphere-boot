package com.bruce.business.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bruce.business.bo.OrderBo;
import com.bruce.business.po.Order;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yongbin
 * @since 2021-05-06
 */
public interface OrderMapper extends BaseMapper<Order> {

    int insertOrder(Order order);

    List<OrderBo> selectOrderCount();

    List<OrderBo> selectOrderUser();

    List<Order> selectOrderList();

}
