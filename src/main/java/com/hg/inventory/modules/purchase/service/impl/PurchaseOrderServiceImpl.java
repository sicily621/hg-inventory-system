package com.hg.inventory.modules.purchase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.account.domain.entity.Account;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseOrder;
import com.hg.inventory.modules.purchase.domain.form.PurchaseOrderForm;
import com.hg.inventory.modules.purchase.mapper.PurchaseOrderMapper;
import com.hg.inventory.modules.purchase.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        int flag = 0;
        if(purchaseOrder.getId()==null){
            flag= purchaseOrderMapper.insert(purchaseOrder);
        }else{
            flag = purchaseOrderMapper.updateById(purchaseOrder);
        }
        if(flag>0){
            return purchaseOrderMapper.selectById(purchaseOrder.getId());
        }else{
            return null;
        }
    }

    @Override
    public PurchaseOrder getById(Long id) {
        return purchaseOrderMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        purchaseOrderMapper.deleteById(id);
        return true;
    }

    @Override
    public PageInfo<PurchaseOrder> page(PurchaseOrderForm purchaseOrderForm, PageQuery pageQuery) {
        LambdaQueryWrapper<PurchaseOrder> lqw = getPurchaseOrderLambdaQueryWrapper(purchaseOrderForm);
        Page<PurchaseOrder> page = pageQuery.build();
        Page<PurchaseOrder> result = purchaseOrderMapper.selectPage(page, lqw);
        PageInfo<PurchaseOrder> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }

    private static LambdaQueryWrapper<PurchaseOrder> getPurchaseOrderLambdaQueryWrapper(PurchaseOrderForm purchaseOrderForm) {
        LambdaQueryWrapper<PurchaseOrder> lqw = Wrappers.lambdaQuery();
        lqw.eq(purchaseOrderForm.getDemandId()!=null, PurchaseOrder::getDemandId, purchaseOrderForm.getDemandId());
        lqw.eq(purchaseOrderForm.getStatus()!=null, PurchaseOrder::getStatus, purchaseOrderForm.getStatus());
        lqw.like(purchaseOrderForm.getCode()!=null, PurchaseOrder::getCode, purchaseOrderForm.getCode());
        lqw.eq(purchaseOrderForm.getEmployeeId()!=null, PurchaseOrder::getEmployeeId, purchaseOrderForm.getEmployeeId());
        lqw.ge(purchaseOrderForm.getStartTime()!=null, PurchaseOrder::getCreateTime, purchaseOrderForm.getStartTime());
        lqw.le(purchaseOrderForm.getEndTime()!=null, PurchaseOrder::getCreateTime, purchaseOrderForm.getEndTime());
        lqw.ge(purchaseOrderForm.getStartStatus()!=null, PurchaseOrder::getStatus, purchaseOrderForm.getStartStatus());
        lqw.le(purchaseOrderForm.getEndStatus()!=null, PurchaseOrder::getStatus, purchaseOrderForm.getEndStatus());
        lqw.eq(PurchaseOrder::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.orderByDesc(PurchaseOrder::getId);
        return lqw;
    }

    @Override
    public List<PurchaseOrder> list(PurchaseOrderForm purchaseOrderForm) {
        LambdaQueryWrapper<PurchaseOrder> lqw = getPurchaseOrderLambdaQueryWrapper(purchaseOrderForm);
        return purchaseOrderMapper.selectList(lqw);
    }
}
