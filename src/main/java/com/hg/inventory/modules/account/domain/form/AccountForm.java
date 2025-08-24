package com.hg.inventory.modules.account.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class AccountForm extends PageQuery {
    private Long orderId;
    private Integer type;
    private Long employeeId;
    private Integer status;
    private Integer relatedEntityId;
}
