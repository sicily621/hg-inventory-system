package com.hg.inventory.modules.inventory.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.inventory.domain.entity.InventoryReceipt;
import com.hg.inventory.modules.inventory.domain.form.InventoryReceiptForm;

import java.util.List;

public interface InventoryReceiptService {
    InventoryReceipt save(InventoryReceipt inventoryReceipt);

    InventoryReceipt getById(Long id);

    List<InventoryReceipt> getByIds(List<Long> ids);

    boolean deleteById(Long id);

    List<InventoryReceipt> list(InventoryReceiptForm inventoryReceiptForm);

    PageInfo<InventoryReceipt> page(InventoryReceiptForm inventoryReceiptForm, PageQuery pageQuery);
}
