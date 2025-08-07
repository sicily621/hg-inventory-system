package com.hg.inventory.modules.purchase.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseReturn;
import com.hg.inventory.modules.purchase.domain.form.PurchaseReturnForm;

import java.util.List;

public interface PurchaseReturnService {
    PurchaseReturn save(PurchaseReturn purchaseReturn);

    PurchaseReturn getById(Long id);

    boolean deleteById(Long id);

    PageInfo<PurchaseReturn> page(PurchaseReturnForm purchaseReturnForm);

    List<PurchaseReturn> list();
}
