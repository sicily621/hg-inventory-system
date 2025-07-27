package com.hg.inventory.modules.system.permission.domain.form;

import com.hg.inventory.common.domain.form.PageQuery;
import lombok.Data;

@Data
public class PermissionForm extends PageQuery {
    private String name;
}
