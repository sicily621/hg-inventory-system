package com.hg.inventory.modules.inventory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.inventory.domain.entity.InventoryCheckDetail;
import com.hg.inventory.modules.inventory.mapper.InventoryCheckDetailMapper;
import com.hg.inventory.modules.inventory.service.InventoryCheckDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryCheckDetailServiceImpl implements InventoryCheckDetailService {
    @Autowired
    private InventoryCheckDetailMapper inventoryCheckDetailMapper;
    @Override
    public boolean batchSave(List<InventoryCheckDetail> inventoryCheckDetails) {
        boolean result = inventoryCheckDetailMapper.insertOrUpdateBatch(inventoryCheckDetails);
        return result;
    }

    @Override
    public List<InventoryCheckDetail> getByCheckId(Long checkId) {
        LambdaQueryWrapper<InventoryCheckDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(InventoryCheckDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(InventoryCheckDetail::getCheckId, checkId);
        return inventoryCheckDetailMapper.selectList(lqw);
    }

    @Override
    public void deleteByCheckId(Long checkId) {
        LambdaQueryWrapper<InventoryCheckDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(InventoryCheckDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(InventoryCheckDetail::getCheckId, checkId);
        inventoryCheckDetailMapper.delete(lqw);
    }
}
