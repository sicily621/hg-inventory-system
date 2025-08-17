package com.hg.inventory.modules.inventory.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class InventoryForm {
    private Long productId;
    private Long warehouseId;
    private Long shelfId;
    private Long areaId;
}
