package com.hg.inventory.modules.purchase.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("hg_purchase_return")
public class PurchaseReturn extends BaseEntity {
    private Long id;
    private String code;
    private Long orderId;
    private Long employeeId;
    private Date time;
    private Integer status;
    private Long supplierId;
    private String remark;
}
