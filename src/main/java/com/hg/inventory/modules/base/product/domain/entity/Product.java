package com.hg.inventory.modules.base.product.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hg.inventory.common.domain.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("hg_product")
public class Product extends BaseEntity {
        private Long id;
        private String code;
        private String name;
        private Long categoryId;
        private BigDecimal purchasePrice;
        private BigDecimal retailPrice;
        private String specification;
        private String unit;
        private String brand;
        private String barcode;
}
