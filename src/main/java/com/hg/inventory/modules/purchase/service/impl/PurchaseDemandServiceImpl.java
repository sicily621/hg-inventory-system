package com.hg.inventory.modules.purchase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseDemand;
import com.hg.inventory.modules.purchase.domain.form.PurchaseDemandForm;
import com.hg.inventory.modules.purchase.mapper.PurchaseDemandMapper;
import com.hg.inventory.modules.purchase.service.PurchaseDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseDemandServiceImpl implements PurchaseDemandService {
    @Autowired
    private PurchaseDemandMapper purchaseDemandMapper;
    @Override
    public PurchaseDemand save(PurchaseDemand purchaseDemand) {
        int flag = 0;
        if(purchaseDemand.getId()==null){
            flag= purchaseDemandMapper.insert(purchaseDemand);
        }else{
            flag = purchaseDemandMapper.updateById(purchaseDemand);
        }
        if(flag>0){
            return purchaseDemandMapper.selectById(purchaseDemand.getId());
        }else{
            return null;
        }
    }

    @Override
    public PurchaseDemand getById(Long id) {
        return purchaseDemandMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        purchaseDemandMapper.deleteById(id);
        return true;
    }

    @Override
    public PageInfo<PurchaseDemand> page(PurchaseDemandForm purchaseDemandForm) {
        LambdaQueryWrapper<PurchaseDemand> lqw = Wrappers.lambdaQuery();
        lqw.eq(purchaseDemandForm.getDepartmentId()!=null, PurchaseDemand::getDepartmentId, purchaseDemandForm.getDepartmentId());
        lqw.eq(purchaseDemandForm.getStatus()!=null, PurchaseDemand::getStatus, purchaseDemandForm.getStatus());
        lqw.eq(purchaseDemandForm.getApplyDate()!=null, PurchaseDemand::getApplyDate, purchaseDemandForm.getApplyDate());
        lqw.eq(PurchaseDemand::getDelFlag, DelFlagEnum.NORMAL.getValue());
        Page<PurchaseDemand> page = purchaseDemandForm.build();
        Page<PurchaseDemand> result = purchaseDemandMapper.selectPage(page, lqw);
        PageInfo<PurchaseDemand> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }

    @Override
    public List<PurchaseDemand> list() {
        LambdaQueryWrapper<PurchaseDemand> lqw = Wrappers.lambdaQuery();
        lqw.eq( PurchaseDemand::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return purchaseDemandMapper.selectList(lqw);
    }
}
