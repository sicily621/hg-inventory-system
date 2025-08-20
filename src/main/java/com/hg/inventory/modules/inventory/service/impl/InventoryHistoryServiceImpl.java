package com.hg.inventory.modules.inventory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.inventory.domain.entity.Inventory;
import com.hg.inventory.modules.inventory.domain.entity.InventoryHistory;
import com.hg.inventory.modules.inventory.domain.form.InventoryForm;
import com.hg.inventory.modules.inventory.domain.form.InventoryHistoryForm;
import com.hg.inventory.modules.inventory.mapper.InventoryHistoryMapper;
import com.hg.inventory.modules.inventory.service.InventoryHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryHistoryServiceImpl implements InventoryHistoryService {
    @Autowired
    private InventoryHistoryMapper inventoryHistoryMapper;
    @Override
    public InventoryHistory save(InventoryHistory inventoryHistory) {
        int flag = 0;
        if(inventoryHistory.getId()==null){
            flag= inventoryHistoryMapper.insert(inventoryHistory);
        }else{
            flag = inventoryHistoryMapper.updateById(inventoryHistory);
        }
        if(flag>0){
            return inventoryHistoryMapper.selectById(inventoryHistory.getId());
        }else{
            return null;
        }
    }

    @Override
    public InventoryHistory getById(Long id) {
        return inventoryHistoryMapper.selectById(id);
    }

    @Override
    public List<InventoryHistory> getByIds(List<Long> ids) {
        LambdaQueryWrapper<InventoryHistory> lqw = Wrappers.lambdaQuery();
        lqw.eq(InventoryHistory::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in(InventoryHistory::getId, ids);
        return inventoryHistoryMapper.selectList(lqw);
    }

    @Override
    public boolean deleteById(Long id) {
        inventoryHistoryMapper.deleteById(id);
        return true;
    }

    @Override
    public List<InventoryHistory> list(InventoryHistoryForm inventoryHistoryForm) {
        LambdaQueryWrapper<InventoryHistory> lqw = getQueryWrapper(inventoryHistoryForm);
        return inventoryHistoryMapper.selectList(lqw);
    }

    @Override
    public PageInfo<InventoryHistory> page(InventoryHistoryForm inventoryHistoryForm, PageQuery pageQuery) {
        LambdaQueryWrapper<InventoryHistory> lqw = getQueryWrapper(inventoryHistoryForm);
        Page<InventoryHistory> page = pageQuery.build();
        Page<InventoryHistory> result = inventoryHistoryMapper.selectPage(page, lqw);
        PageInfo<InventoryHistory> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }

    @Override
    public boolean batchSave(List<InventoryHistory> inventoryHistorys) {
        boolean result =  inventoryHistoryMapper.insertOrUpdateBatch(inventoryHistorys);
        return result;
    }

    private LambdaQueryWrapper<InventoryHistory> getQueryWrapper(InventoryHistoryForm inventoryHistoryForm) {
        LambdaQueryWrapper<InventoryHistory> lqw = Wrappers.lambdaQuery();
        lqw.eq(inventoryHistoryForm.getProductId()!=null, InventoryHistory::getProductId, inventoryHistoryForm.getProductId());
        lqw.eq(inventoryHistoryForm.getWarehouseId()!=null, InventoryHistory::getWarehouseId, inventoryHistoryForm.getWarehouseId());
        lqw.eq(inventoryHistoryForm.getShelfId()!=null, InventoryHistory::getShelfId, inventoryHistoryForm.getShelfId());
        lqw.eq(inventoryHistoryForm.getAreaId()!=null, InventoryHistory::getAreaId, inventoryHistoryForm.getAreaId());
        lqw.eq(inventoryHistoryForm.getType()!=null, InventoryHistory::getType, inventoryHistoryForm.getType());
        lqw.eq(inventoryHistoryForm.getEmployeeId()!=null, InventoryHistory::getEmployeeId, inventoryHistoryForm.getEmployeeId());
        lqw.eq( InventoryHistory::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return lqw;
    }
}
