package com.hg.inventory.modules.base.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.base.warehouse.domain.entity.Shelf;
import com.hg.inventory.modules.base.warehouse.domain.form.ShelfForm;
import com.hg.inventory.modules.base.warehouse.mapper.ShelfMapper;
import com.hg.inventory.modules.base.warehouse.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService {
    @Autowired
    private ShelfMapper shelfMapper;
    @Override
    public Shelf save(Shelf shelf) {
        int flag = 0;
        if(shelf.getId()==null){
            flag= shelfMapper.insert(shelf);
        }else{
            flag = shelfMapper.updateById(shelf);
        }
        if(flag>0){
            return shelfMapper.selectById(shelf.getId());
        }else{
            return null;
        }
    }

    @Override
    public Shelf getById(Long id) {
        return shelfMapper.selectById(id);
    }

    @Override
    public List<Shelf> getByIds(List<Long> ids) {
        LambdaQueryWrapper<Shelf> lqw = Wrappers.lambdaQuery();
        lqw.eq(Shelf::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in( Shelf::getId, ids);
        return shelfMapper.selectList(lqw);
    }

    @Override
    public Boolean deleteById(Long id) {
        shelfMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Shelf> list() {
        LambdaQueryWrapper<Shelf> lqw = Wrappers.lambdaQuery();
        lqw.eq( Shelf::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return shelfMapper.selectList(lqw);
    }

    @Override
    public PageInfo<Shelf> page(ShelfForm shelfForm) {
        LambdaQueryWrapper<Shelf> lqw = Wrappers.lambdaQuery();
        lqw.eq(shelfForm.getAreaId()!=null, Shelf::getAreaId, shelfForm.getAreaId());
        lqw.like(shelfForm.getCode()!=null, Shelf::getCode, shelfForm.getCode());
        lqw.like(shelfForm.getName()!=null, Shelf::getName, shelfForm.getName());
        lqw.eq( Shelf::getDelFlag, DelFlagEnum.NORMAL.getValue());
        Page<Shelf> page = shelfForm.build();
        Page<Shelf> result = shelfMapper.selectPage(page, lqw);
        PageInfo<Shelf> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }
}
