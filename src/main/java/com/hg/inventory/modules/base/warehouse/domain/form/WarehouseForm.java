package com.hg.inventory.modules.base.warehouse.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class WarehouseForm extends PageQuery {
    private String code;
    private String name;
}
