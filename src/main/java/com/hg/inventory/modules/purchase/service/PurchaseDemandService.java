package com.hg.inventory.modules.purchase.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseDemand;
import com.hg.inventory.modules.purchase.domain.form.PurchaseDemandForm;

import java.util.List;

public interface PurchaseDemandService {
    PurchaseDemand save(PurchaseDemand purchaseDemand);

    PurchaseDemand getById(Long id);

    boolean deleteById(Long id);

    PageInfo<PurchaseDemand> page(PurchaseDemandForm purchaseDemandForm);

    List<PurchaseDemand> list();
}
