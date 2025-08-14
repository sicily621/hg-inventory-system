package com.hg.inventory.modules.sales.service;

import com.hg.inventory.modules.sales.domain.entity.SalesReturnDetail;

import java.util.List;

public interface SalesReturnDetailService {
    boolean batchSave(List<SalesReturnDetail> salesReturnDetails);

    List<SalesReturnDetail> getByOrderId(Long returnId);

    void deleteByOrderId(Long returnId);
}
