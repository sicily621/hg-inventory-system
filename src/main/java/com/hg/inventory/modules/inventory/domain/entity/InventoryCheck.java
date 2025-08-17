package com.hg.inventory.modules.inventory.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("hg_inventory_check")
public class InventoryCheck extends BaseEntity {
    private Long id;
    private Long code;
    private Long warehouseId;
    private Long employeeId;
    private Integer status;
    private String description;
}
