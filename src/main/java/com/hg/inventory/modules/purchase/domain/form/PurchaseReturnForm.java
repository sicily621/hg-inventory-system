package com.hg.inventory.modules.purchase.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseReturnForm extends PageQuery {
    private String code;
    private Long employeeId;
    private Date time;
    private Integer status;
}
