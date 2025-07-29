package com.hg.inventory.modules.base.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.base.warehouse.domain.entity.Warehouse;
import com.hg.inventory.modules.base.warehouse.domain.entity.WarehouseArea;
import com.hg.inventory.modules.base.warehouse.domain.form.WarehouseAreaForm;
import com.hg.inventory.modules.base.warehouse.mapper.WarehouseAreaMapper;
import com.hg.inventory.modules.base.warehouse.service.WarehouseAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseAreaServiceImpl implements WarehouseAreaService {
    @Autowired
    private WarehouseAreaMapper warehouseAreaMapper;
    @Override
    public WarehouseArea save(WarehouseArea warehouseArea) {
        int flag = 0;
        if(warehouseArea.getId()==null){
            flag= warehouseAreaMapper.insert(warehouseArea);
        }else{
            flag = warehouseAreaMapper.updateById(warehouseArea);
        }
        if(flag>0){
            return warehouseAreaMapper.selectById(warehouseArea.getId());
        }else{
            return null;
        }
    }

    @Override
    public WarehouseArea getById(Long id) {
        return warehouseAreaMapper.selectById(id);
    }

    @Override
    public List<WarehouseArea> getByIds(List<Long> ids) {
        LambdaQueryWrapper<WarehouseArea> lqw = Wrappers.lambdaQuery();
        lqw.eq(WarehouseArea::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in( WarehouseArea::getId, ids);
        return warehouseAreaMapper.selectList(lqw);
    }

    @Override
    public Boolean deleteById(Long id) {
        warehouseAreaMapper.deleteById(id);
        return true;
    }

    @Override
    public List<WarehouseArea> list() {
        LambdaQueryWrapper<WarehouseArea> lqw = Wrappers.lambdaQuery();
        lqw.eq( WarehouseArea::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return warehouseAreaMapper.selectList(lqw);
    }

    @Override
    public PageInfo<WarehouseArea> page(WarehouseAreaForm warehouseAreaForm) {
        LambdaQueryWrapper<WarehouseArea> lqw = Wrappers.lambdaQuery();
        lqw.eq(warehouseAreaForm.getWarehouseId()!=null, WarehouseArea::getWarehouseId, warehouseAreaForm.getWarehouseId());
        lqw.like(warehouseAreaForm.getType()!=null, WarehouseArea::getType, warehouseAreaForm.getType());
        lqw.eq( WarehouseArea::getDelFlag, DelFlagEnum.NORMAL.getValue());
        Page<WarehouseArea> page = warehouseAreaForm.build();
        Page<WarehouseArea> result = warehouseAreaMapper.selectPage(page, lqw);
        PageInfo<WarehouseArea> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }
}
