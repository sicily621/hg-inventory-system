package com.hg.inventory.modules.base.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.base.warehouse.domain.entity.Warehouse;
import com.hg.inventory.modules.base.warehouse.domain.form.WarehouseForm;
import com.hg.inventory.modules.base.warehouse.mapper.WarehouseMapper;
import com.hg.inventory.modules.base.warehouse.service.WarehouseService;
import com.hg.inventory.modules.system.role.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Override
    public Warehouse save(Warehouse warehouse) {
        int flag = 0;
        if(warehouse.getId()==null){
            flag= warehouseMapper.insert(warehouse);
        }else{
            flag = warehouseMapper.updateById(warehouse);
        }
        if(flag>0){
            return warehouseMapper.selectById(warehouse.getId());
        }else{
            return null;
        }
    }

    @Override
    public Warehouse getById(Long id) {
        return warehouseMapper.selectById(id);
    }

    @Override
    public List<Warehouse> getByIds(List<Long> ids) {
        LambdaQueryWrapper<Warehouse> lqw = Wrappers.lambdaQuery();
        lqw.eq(Warehouse::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in( Warehouse::getId, ids);
        return warehouseMapper.selectList(lqw);
    }

    @Override
    public Boolean deleteById(Long id) {
        warehouseMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Warehouse> list() {
        LambdaQueryWrapper<Warehouse> lqw = Wrappers.lambdaQuery();
        lqw.eq( Warehouse::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return warehouseMapper.selectList(lqw);
    }

    @Override
    public PageInfo<Warehouse> page(WarehouseForm warehouseForm) {
        LambdaQueryWrapper<Warehouse> lqw = Wrappers.lambdaQuery();
        lqw.like(warehouseForm.getCode()!=null, Warehouse::getCode, warehouseForm.getCode());
        lqw.like(warehouseForm.getName()!=null, Warehouse::getName, warehouseForm.getName());
        lqw.eq( Warehouse::getDelFlag, DelFlagEnum.NORMAL.getValue());
        Page<Warehouse> page = warehouseForm.build();
        Page<Warehouse> result = warehouseMapper.selectPage(page, lqw);
        PageInfo<Warehouse> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }
}
