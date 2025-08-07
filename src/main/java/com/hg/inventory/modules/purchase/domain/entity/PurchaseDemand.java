package com.hg.inventory.modules.purchase.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("hg_purchase_demand")
public class PurchaseDemand extends BaseEntity {
    private Long id;
    private Long departmentId;
    private Long applicantId;
    private Date applyDate;
    private Date expectedArrivalDate;
    private String description;
    private Integer status;
    private Long approverId;
    private Date approverTime;
}
