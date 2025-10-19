package com.hg.inventory.modules.purchase.domain.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PurchaseOrderDetailForm {

    private Long orderId;
    private Long supplierId;
    private Long categoryId;
    private Long productId;
}
