package com.hg.inventory.modules.system.department.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("hg_department")
public class Department extends BaseEntity {
    private Long id;
    private String name;
    private Long parentId;
    private Long managerId;

}
