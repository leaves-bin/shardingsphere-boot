package com.bruce.business.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author yongbin
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`order`")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("`order_no`")
    private String orderNo;

    @TableField("`sku`")
    private String sku;

    @TableField("`price`")
    private BigDecimal price;

    @TableField("`mobile`")
    private String mobile;

    @TableField(value = "`mobile`", exist = false)
    private Boolean shadow;

    public static final String ORDER_NO = "`order_no`";

    public static final String SKU = "`sku`";

    public static final String PRICE = "`price`";

    public static final String MOBILE = "`mobile`";

}
