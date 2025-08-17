package com.hg.inventory.modules.inventory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.inventory.domain.entity.InventoryCheck;
import com.hg.inventory.modules.inventory.domain.form.InventoryCheckForm;
import com.hg.inventory.modules.inventory.mapper.InventoryCheckMapper;
import com.hg.inventory.modules.inventory.service.InventoryCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryCheckServiceImpl implements InventoryCheckService {
    @Autowired
    private InventoryCheckMapper inventoryCheckMapper;
    @Override
    public InventoryCheck save(InventoryCheck inventoryCheck) {
        int flag = 0;
        if(inventoryCheck.getId()==null){
            flag= inventoryCheckMapper.insert(inventoryCheck);
        }else{
            flag = inventoryCheckMapper.updateById(inventoryCheck);
        }
        if(flag>0){
            return inventoryCheckMapper.selectById(inventoryCheck.getId());
        }else{
            return null;
        }
    }

    @Override
    public InventoryCheck getById(Long id) {
        return inventoryCheckMapper.selectById(id);
    }

    @Override
    public List<InventoryCheck> getByIds(List<Long> ids) {
        LambdaQueryWrapper<InventoryCheck> lqw = Wrappers.lambdaQuery();
        lqw.eq(InventoryCheck::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in(InventoryCheck::getId, ids);
        return inventoryCheckMapper.selectList(lqw);
    }

    @Override
    public boolean deleteById(Long id) {
        inventoryCheckMapper.deleteById(id);
        return true;
    }

    @Override
    public List<InventoryCheck> list(InventoryCheckForm inventoryCheckForm) {
        LambdaQueryWrapper<InventoryCheck> lqw = getQueryWrapper(inventoryCheckForm);
        return inventoryCheckMapper.selectList(lqw);
    }

    @Override
    public PageInfo<InventoryCheck> page(InventoryCheckForm inventoryCheckForm, PageQuery pageQuery) {
        LambdaQueryWrapper<InventoryCheck> lqw = getQueryWrapper(inventoryCheckForm);
        Page<InventoryCheck> page = pageQuery.build();
        Page<InventoryCheck> result = inventoryCheckMapper.selectPage(page, lqw);
        PageInfo<InventoryCheck> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }
    private LambdaQueryWrapper<InventoryCheck> getQueryWrapper(InventoryCheckForm inventoryCheckForm) {
        LambdaQueryWrapper<InventoryCheck> lqw = Wrappers.lambdaQuery();
        lqw.like(inventoryCheckForm.getCode()!=null, InventoryCheck::getCode, inventoryCheckForm.getCode());
        lqw.eq(inventoryCheckForm.getWarehouseId()!=null, InventoryCheck::getWarehouseId, inventoryCheckForm.getWarehouseId());
        lqw.eq(inventoryCheckForm.getStatus()!=null, InventoryCheck::getStatus, inventoryCheckForm.getStatus());
        lqw.eq(inventoryCheckForm.getEmployeeId()!=null, InventoryCheck::getEmployeeId, inventoryCheckForm.getEmployeeId());
        lqw.eq( InventoryCheck::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return lqw;
    }
}
