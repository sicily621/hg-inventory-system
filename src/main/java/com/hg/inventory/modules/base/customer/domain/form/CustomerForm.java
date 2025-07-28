package com.hg.inventory.modules.base.customer.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class CustomerForm extends PageQuery {
    private String name;
    private Integer creditLevel;
}
