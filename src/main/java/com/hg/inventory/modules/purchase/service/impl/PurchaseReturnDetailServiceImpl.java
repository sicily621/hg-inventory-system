package com.hg.inventory.modules.purchase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseReturnDetail;
import com.hg.inventory.modules.purchase.mapper.PurchaseReturnDetailMapper;
import com.hg.inventory.modules.purchase.service.PurchaseReturnDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseReturnDetailServiceImpl implements PurchaseReturnDetailService {
    @Autowired
    private PurchaseReturnDetailMapper purchaseReturnDetailMapper;
    @Override
    public boolean batchSave(List<PurchaseReturnDetail> purchaseReturnDetails) {
        boolean result = purchaseReturnDetailMapper.insertOrUpdateBatch(purchaseReturnDetails);
        return result;
    }

    @Override
    public List<PurchaseReturnDetail> getByReturnId(Long returnId) {
        LambdaQueryWrapper<PurchaseReturnDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(PurchaseReturnDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(PurchaseReturnDetail::getId, returnId);
        return purchaseReturnDetailMapper.selectList(lqw);
    }

    @Override
    public void deleteByReturnId(Long returnId) {
        LambdaQueryWrapper<PurchaseReturnDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(PurchaseReturnDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(PurchaseReturnDetail::getId, returnId);
        purchaseReturnDetailMapper.delete(lqw);
    }
}
