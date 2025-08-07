package com.hg.inventory.modules.purchase.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("hg_purchase_demand_detail")
public class PurchaseDemandDetail extends BaseEntity {
    private Long detailId;
    private Long DemandId;
    private Long productId;
    private String productName;
    private String productSpec;
    private String unit;
    private BigDecimal quantity;
    private BigDecimal suggestedPrice;
    private String remarks;
}
