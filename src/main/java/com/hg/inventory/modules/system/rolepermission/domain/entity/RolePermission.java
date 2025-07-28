package com.hg.inventory.modules.system.rolepermission.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;
@Data
@TableName("hg_role_permission")
public class RolePermission  extends BaseEntity {
    private Long id;
    private Long roleId;
    private Long permissionId;
}
