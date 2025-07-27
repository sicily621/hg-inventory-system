package com.hg.inventory.modules.system.employee.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class EmployeeForm extends PageQuery {
    private String code;
    private String realName;
    private Long departmentId;
    private Long roleId;
}
