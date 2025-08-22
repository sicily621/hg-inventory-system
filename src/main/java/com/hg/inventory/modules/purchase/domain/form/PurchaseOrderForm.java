package com.hg.inventory.modules.purchase.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PurchaseOrderForm {
    private Long demandId;
    private String code;
    private Long employeeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private Integer status;
    private Integer startStatus;
    private Integer endStatus;
}
