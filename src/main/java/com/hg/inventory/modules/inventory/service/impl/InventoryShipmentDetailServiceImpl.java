package com.hg.inventory.modules.inventory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.inventory.domain.entity.InventoryReceiptDetail;
import com.hg.inventory.modules.inventory.domain.entity.InventoryShipmentDetail;
import com.hg.inventory.modules.inventory.mapper.InventoryShipmentDetailMapper;
import com.hg.inventory.modules.inventory.service.InventoryShipmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryShipmentDetailServiceImpl implements InventoryShipmentDetailService {
    @Autowired
    private InventoryShipmentDetailMapper inventoryShipmentDetailMapper;
    @Override
    public boolean batchSave(List<InventoryShipmentDetail> inventoryShipmentDetails) {
        boolean result = inventoryShipmentDetailMapper.insertOrUpdateBatch(inventoryShipmentDetails);
        return result;
    }

    @Override
    public List<InventoryShipmentDetail> getByShipmentId(Long shipmentId) {
        LambdaQueryWrapper<InventoryShipmentDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(InventoryShipmentDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(InventoryShipmentDetail::getShipmentId, shipmentId);
        return inventoryShipmentDetailMapper.selectList(lqw);
    }

    @Override
    public void deleteByShipmentId(Long shipmentId) {
        LambdaQueryWrapper<InventoryShipmentDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(InventoryShipmentDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(InventoryShipmentDetail::getShipmentId, shipmentId);
        inventoryShipmentDetailMapper.delete(lqw);
    }
}
