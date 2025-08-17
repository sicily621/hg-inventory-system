package com.hg.inventory.modules.inventory.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.inventory.domain.entity.Inventory;
import com.hg.inventory.modules.inventory.domain.form.InventoryForm;
import com.hg.inventory.modules.inventory.mapper.InventoryMapper;
import com.hg.inventory.modules.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;
    @Override
    public Inventory save(Inventory inventory) {
        int flag = 0;
        if(inventory.getId()==null){
            flag= inventoryMapper.insert(inventory);
        }else{
            flag = inventoryMapper.updateById(inventory);
        }
        if(flag>0){
            return inventoryMapper.selectById(inventory.getId());
        }else{
            return null;
        }
    }

    @Override
    public Inventory getById(Long id) {
        return inventoryMapper.selectById(id);
    }

    @Override
    public List<Inventory> getByIds(List<Long> ids) {
        LambdaQueryWrapper<Inventory> lqw = Wrappers.lambdaQuery();
        lqw.eq(Inventory::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in( Inventory::getId, ids);
        return inventoryMapper.selectList(lqw);
    }

    @Override
    public boolean deleteById(Long id) {
        inventoryMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Inventory> list(InventoryForm inventoryForm) {
        LambdaQueryWrapper<Inventory> lqw = getQueryWrapper(inventoryForm);
        return inventoryMapper.selectList(lqw);
    }

    @Override
    public PageInfo<Inventory> page(InventoryForm inventoryForm, PageQuery pageQuery) {
        LambdaQueryWrapper<Inventory> lqw = getQueryWrapper(inventoryForm);
        Page<Inventory> page = pageQuery.build();
        Page<Inventory> result = inventoryMapper.selectPage(page, lqw);
        PageInfo<Inventory> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }
    private LambdaQueryWrapper<Inventory> getQueryWrapper(InventoryForm inventoryForm) {
        LambdaQueryWrapper<Inventory> lqw = Wrappers.lambdaQuery();
        lqw.eq(inventoryForm.getProductId()!=null, Inventory::getProductId, inventoryForm.getProductId());
        lqw.eq(inventoryForm.getWarehouseId()!=null, Inventory::getWarehouseId, inventoryForm.getWarehouseId());
        lqw.eq(inventoryForm.getShelfId()!=null, Inventory::getShelfId, inventoryForm.getShelfId());
        lqw.eq(inventoryForm.getAreaId()!=null, Inventory::getAreaId, inventoryForm.getAreaId());
        lqw.eq( Inventory::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return lqw;
    }
    
}
