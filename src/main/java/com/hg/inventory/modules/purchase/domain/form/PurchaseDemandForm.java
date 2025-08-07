package com.hg.inventory.modules.purchase.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseDemandForm extends PageQuery {
    private Long departmentId;
    private Integer status;
    private Date applyDate;
}
