package com.hg.inventory.modules.inventory.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.inventory.domain.entity.InventoryCheck;
import com.hg.inventory.modules.inventory.domain.form.InventoryCheckForm;

import java.util.List;

public interface InventoryCheckService {
    InventoryCheck save(InventoryCheck inventoryCheck);

    InventoryCheck getById(Long id);

    List<InventoryCheck> getByIds(List<Long> ids);

    boolean deleteById(Long id);

    List<InventoryCheck> list(InventoryCheckForm inventoryCheckForm);

    PageInfo<InventoryCheck> page(InventoryCheckForm inventoryCheckForm, PageQuery pageQuery);
}
