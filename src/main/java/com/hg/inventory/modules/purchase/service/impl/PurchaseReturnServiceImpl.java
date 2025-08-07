package com.hg.inventory.modules.purchase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseReturn;
import com.hg.inventory.modules.purchase.domain.form.PurchaseReturnForm;
import com.hg.inventory.modules.purchase.mapper.PurchaseReturnMapper;
import com.hg.inventory.modules.purchase.service.PurchaseReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseReturnServiceImpl implements PurchaseReturnService {
    @Autowired
    private PurchaseReturnMapper purchaseReturnMapper;

    @Override
    public PurchaseReturn save(PurchaseReturn purchaseReturn) {
        int flag = 0;
        if(purchaseReturn.getId()==null){
            flag= purchaseReturnMapper.insert(purchaseReturn);
        }else{
            flag = purchaseReturnMapper.updateById(purchaseReturn);
        }
        if(flag>0){
            return purchaseReturnMapper.selectById(purchaseReturn.getId());
        }else{
            return null;
        }
    }

    @Override
    public PurchaseReturn getById(Long id) {
        return purchaseReturnMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        purchaseReturnMapper.deleteById(id);
        return true;
    }

    @Override
    public PageInfo<PurchaseReturn> page(PurchaseReturnForm purchaseReturnForm) {
        LambdaQueryWrapper<PurchaseReturn> lqw = Wrappers.lambdaQuery();
        lqw.eq(purchaseReturnForm.getStatus()!=null, PurchaseReturn::getStatus, purchaseReturnForm.getStatus());
        lqw.like(purchaseReturnForm.getCode()!=null, PurchaseReturn::getCode, purchaseReturnForm.getCode());
        lqw.eq(purchaseReturnForm.getEmployeeId()!=null, PurchaseReturn::getEmployeeId, purchaseReturnForm.getEmployeeId());
        lqw.eq(purchaseReturnForm.getTime()!=null, PurchaseReturn::getTime, purchaseReturnForm.getTime());
        lqw.eq(PurchaseReturn::getDelFlag, DelFlagEnum.NORMAL.getValue());
        Page<PurchaseReturn> page = purchaseReturnForm.build();
        Page<PurchaseReturn> result = purchaseReturnMapper.selectPage(page, lqw);
        PageInfo<PurchaseReturn> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }

    @Override
    public List<PurchaseReturn> list() {
        LambdaQueryWrapper<PurchaseReturn> lqw = Wrappers.lambdaQuery();
        lqw.eq( PurchaseReturn::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return purchaseReturnMapper.selectList(lqw);
    }
}
