package com.hg.inventory.modules.sales.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("hg_sales_order_detail")
public class SalesOrderDetail extends BaseEntity {
    private Long id;
    private Long orderId;
    private Long categoryId;
    private Long productId;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal amount;
}
