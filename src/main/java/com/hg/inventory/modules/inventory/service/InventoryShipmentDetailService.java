package com.hg.inventory.modules.inventory.service;

import com.hg.inventory.modules.inventory.domain.entity.InventoryShipmentDetail;

import java.util.List;

public interface InventoryShipmentDetailService {
    boolean batchSave(List<InventoryShipmentDetail> inventoryShipmentDetails);

    List<InventoryShipmentDetail> getByShipmentId(Long shipmentId);

    void deleteByShipmentId(Long shipmentId);
}
