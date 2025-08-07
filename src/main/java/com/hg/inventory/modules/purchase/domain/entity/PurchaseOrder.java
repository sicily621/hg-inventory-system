package com.hg.inventory.modules.purchase.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("hg_purchase_order")
public class PurchaseOrder extends BaseEntity {
    private Long id;
    private Long demandId;
    private String code;
    private Long supplierId;
    private Long employeeId;
    private Date time;
    private Date expectedDate;
    private Date actualDate;
    private Integer status;
    private BigDecimal totalAmount;
    private String remark;
}
