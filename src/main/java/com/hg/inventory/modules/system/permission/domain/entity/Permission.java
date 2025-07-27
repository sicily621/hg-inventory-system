package com.hg.inventory.modules.system.permission.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("hg_permission")
public class Permission extends BaseEntity {
    private Long id;
    private String name;
    private String moduleCode;
    private Long parentId;
    private String url;
    private String description;
}
