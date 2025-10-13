package com.hg.inventory.modules.inventory.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.inventory.domain.entity.Inventory;
import com.hg.inventory.modules.inventory.domain.form.InventoryForm;

import java.util.List;

public interface InventoryService {
    Inventory save(Inventory inventory);

    Inventory getById(Long id);

    List<Inventory> getByIds(List<Long> ids);

    boolean deleteById(Long id);

    List<Inventory> list(InventoryForm inventoryForm);

    PageInfo<Inventory> page(InventoryForm inventoryForm, PageQuery pageQuery);

    List<Inventory> receipt(List<Inventory> inventoryList);

    List<Inventory> shipment(List<Inventory> inventoryList);

    List<Inventory> batchUpdate(List<Inventory> inventoryList);

    List<Inventory> getByProductIds(List<Long> ids);
}
