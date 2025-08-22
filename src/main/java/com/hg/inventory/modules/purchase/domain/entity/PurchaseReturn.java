package com.hg.inventory.modules.purchase.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("hg_purchase_return")
public class PurchaseReturn extends BaseEntity {
    private Long id;
    private String code;
    private Long orderId;
    private Long employeeId;
    private Integer status;
    private String description;
    private BigDecimal totalAmount;
    private Long approverId;
    private Date approvalTime;
    private Integer receipt;
}
