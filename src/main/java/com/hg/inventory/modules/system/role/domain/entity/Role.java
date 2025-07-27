package com.hg.inventory.modules.system.role.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("hg_role")
public class Role extends BaseEntity {
    private Long id;
    private String name;
    private String code;
    private String description;
    private Integer status;
}
