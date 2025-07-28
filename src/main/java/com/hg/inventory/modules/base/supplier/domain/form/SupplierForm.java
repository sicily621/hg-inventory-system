package com.hg.inventory.modules.base.supplier.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class SupplierForm extends PageQuery {
    private String name;
    private String code;
}
