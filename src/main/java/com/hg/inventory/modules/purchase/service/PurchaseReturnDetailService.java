package com.hg.inventory.modules.purchase.service;

import com.hg.inventory.modules.purchase.domain.entity.PurchaseOrderDetail;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseReturnDetail;

import java.util.List;

public interface PurchaseReturnDetailService {
    boolean batchSave(List<PurchaseReturnDetail> purchaseReturnDetails);

    List<PurchaseReturnDetail> getByReturnId(Long returnId);

    void deleteByReturnId(Long returnId);
}
