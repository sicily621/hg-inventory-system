package com.hg.inventory.modules.purchase.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("hg_purchase_demand_detail")
public class PurchaseDemandDetail extends BaseEntity {
    private Long id;
    private Long demandId;
    private Long productId;
    private Long categoryId;
    private BigDecimal quantity;
}
