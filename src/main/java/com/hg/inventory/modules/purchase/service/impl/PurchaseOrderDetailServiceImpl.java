package com.hg.inventory.modules.purchase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseDemandDetail;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseOrderDetail;
import com.hg.inventory.modules.purchase.mapper.PurchaseOrderDetailMapper;
import com.hg.inventory.modules.purchase.service.PurchaseOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderDetailServiceImpl implements PurchaseOrderDetailService {
    @Autowired
    private PurchaseOrderDetailMapper purchaseOrderDetailMapper;
    @Override
    public boolean batchSave(List<PurchaseOrderDetail> purchaseOrderDetails) {
        boolean result = purchaseOrderDetailMapper.insertOrUpdateBatch(purchaseOrderDetails);
        return result;
    }

    @Override
    public List<PurchaseOrderDetail> getByOrderId(Long orderId) {
        LambdaQueryWrapper<PurchaseOrderDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(PurchaseOrderDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(PurchaseOrderDetail::getOrderId, orderId);
        return purchaseOrderDetailMapper.selectList(lqw);
    }

    @Override
    public void deleteByOrderId(Long orderId) {
        LambdaQueryWrapper<PurchaseOrderDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(PurchaseOrderDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(PurchaseOrderDetail::getOrderId, orderId);
        purchaseOrderDetailMapper.delete(lqw);
    }
}
