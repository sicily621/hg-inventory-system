package com.hg.inventory.modules.inventory.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("hg_inventory_receipt")
public class InventoryReceipt extends BaseEntity {
    private Long id;
    private Long code;
    private Long orderId;
    private Long employeeId;
    private Long warehouseId;
    private String description;
}
