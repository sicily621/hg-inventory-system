package com.hg.inventory.modules.purchase.service;

import com.hg.inventory.modules.purchase.domain.entity.PurchaseOrderDetail;

import java.util.List;

public interface PurchaseOrderDetailService {
    boolean batchSave(List<PurchaseOrderDetail> purchaseOrderDetails);

    List<PurchaseOrderDetail> getByOrderId(Long orderId);

    void deleteByOrderId(Long orderId);
}
