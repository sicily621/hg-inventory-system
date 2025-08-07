package com.hg.inventory.modules.purchase.service;

import com.hg.inventory.modules.purchase.domain.entity.PurchaseDemandDetail;

import java.util.List;

public interface PurchaseDemandDetailService {
    boolean batchSave(List<PurchaseDemandDetail> purchaseDemandDetails);

    List<PurchaseDemandDetail> getByDemandId(Long demandId);

    void deleteByDemandId(Long demandId);
}
