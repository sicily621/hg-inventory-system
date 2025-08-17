package com.hg.inventory.modules.inventory.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class InventoryHistoryForm {
    private Long productId;
    private Long warehouseId;
    private Long shelfId;
    private Long areaId;
    private Integer type;
    private Long employeeId;
}
