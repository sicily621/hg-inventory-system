package com.hg.inventory.modules.purchase.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseOrder;
import com.hg.inventory.modules.purchase.domain.form.PurchaseOrderForm;

import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder save(PurchaseOrder purchaseOrder);

    PurchaseOrder getById(Long id);

    boolean deleteById(Long id);

    PageInfo<PurchaseOrder> page(PurchaseOrderForm purchaseOrderForm);

    List<PurchaseOrder> list();
}
