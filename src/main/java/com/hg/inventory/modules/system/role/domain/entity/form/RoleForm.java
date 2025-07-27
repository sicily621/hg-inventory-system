package com.hg.inventory.modules.system.role.domain.entity.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class RoleForm extends PageQuery {
    private String code;
    private String name;
}
