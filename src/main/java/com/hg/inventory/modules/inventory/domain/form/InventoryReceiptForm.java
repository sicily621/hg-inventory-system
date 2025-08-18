package com.hg.inventory.modules.inventory.domain.form;

import lombok.Data;

@Data
public class InventoryReceiptForm {
    private Long code;
    private Long orderId;
    private Long employeeId;
    private Long warehouseId;
}
