package com.hg.inventory.modules.base.product.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("hg_category")
public class Category extends BaseEntity {
    private Long id;
    private String name;
    private Long parentId;
}
