package com.hg.inventory.modules.purchase.domain.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PurchaseDemandForm extends PageQuery {
    private Long departmentId;
    private Integer status;
    private Long applicantId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
