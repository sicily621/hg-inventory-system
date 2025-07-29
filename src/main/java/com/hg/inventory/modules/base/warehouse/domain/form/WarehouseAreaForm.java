package com.hg.inventory.modules.base.warehouse.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class WarehouseAreaForm extends PageQuery {
    private  Long warehouseId;
    private Integer type;
}
