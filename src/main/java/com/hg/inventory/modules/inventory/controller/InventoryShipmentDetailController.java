package com.hg.inventory.modules.inventory.controller;

import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.inventory.domain.entity.InventoryShipmentDetail;
import com.hg.inventory.modules.inventory.service.InventoryShipmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/inventory/shipment/detail")
@RestController
public class InventoryShipmentDetailController {
    @Autowired
    private InventoryShipmentDetailService inventoryShipmentDetailService;
    /**
     * 批量出库详情
     */
    @PostMapping()
    public Result<Boolean> batchSave(@RequestBody List<InventoryShipmentDetail> inventoryShipmentDetails){
        inventoryShipmentDetailService.batchSave(inventoryShipmentDetails);
        return Result.success();
    }
    /**
     * 根据出库Id查询出库详情列表
     */
    @GetMapping("{shipmentId}")
    public Result<List<InventoryShipmentDetail>> getByDemandId(@PathVariable("shipmentId") Long shipmentId){
        return Result.success(inventoryShipmentDetailService.getByShipmentId(shipmentId));
    }
    /**
     * 根据出库Id删除出库详情列表
     */
    @DeleteMapping("{shipmentId}")
    public Result<Void> deleteByDemandId(@PathVariable("shipmentId") Long shipmentId){
        inventoryShipmentDetailService.deleteByShipmentId(shipmentId);
        return Result.success();
    }
}
