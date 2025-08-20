package com.hg.inventory.modules.inventory.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.inventory.domain.entity.InventoryHistory;
import com.hg.inventory.modules.inventory.domain.form.InventoryHistoryForm;

import java.util.List;

public interface InventoryHistoryService {
    InventoryHistory save(InventoryHistory inventoryHistory);

    InventoryHistory getById(Long id);

    List<InventoryHistory> getByIds(List<Long> ids);

    boolean deleteById(Long id);

    List<InventoryHistory> list(InventoryHistoryForm inventoryHistoryForm);

    PageInfo<InventoryHistory> page(InventoryHistoryForm inventoryHistoryForm, PageQuery pageQuery);

    boolean batchSave(List<InventoryHistory> inventoryHistorys);
}
