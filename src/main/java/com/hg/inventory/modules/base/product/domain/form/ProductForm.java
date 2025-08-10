package com.hg.inventory.modules.base.product.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class ProductForm {
    private String code;
    private String name;
    private Long categoryId;
}

