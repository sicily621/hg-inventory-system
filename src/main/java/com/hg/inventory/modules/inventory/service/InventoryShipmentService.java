package com.hg.inventory.modules.inventory.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.inventory.domain.entity.InventoryShipment;
import com.hg.inventory.modules.inventory.domain.form.InventoryShipmentForm;

import java.util.List;

public interface InventoryShipmentService {
    InventoryShipment save(InventoryShipment inventoryShipment);

    InventoryShipment getById(Long id);

    List<InventoryShipment> getByIds(List<Long> ids);

    boolean deleteById(Long id);

    List<InventoryShipment> list(InventoryShipmentForm inventoryShipmentForm);

    PageInfo<InventoryShipment> page(InventoryShipmentForm inventoryShipmentForm, PageQuery pageQuery);
}
