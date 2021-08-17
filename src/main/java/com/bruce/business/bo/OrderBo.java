package com.bruce.business.bo;

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
public class OrderBo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderNo;

    private String sku;

    private BigDecimal price;

    private String mobile;

    private Boolean shadow;

    private Long count;

    private String UserName;

}
