package com.hg.inventory.modules.inventory.domain.form;

import lombok.Data;

@Data
public class InventoryCheckForm {
    private String code;
    private Long warehouseId;
    private Long employeeId;
    private Integer status;
}
