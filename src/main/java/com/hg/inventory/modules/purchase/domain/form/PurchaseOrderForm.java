package com.hg.inventory.modules.purchase.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseOrderForm extends PageQuery {
    private Long demandId;
    private String code;
    private Long supplierId;
    private Long employeeId;
    private Date time;
    private Integer status;
}
