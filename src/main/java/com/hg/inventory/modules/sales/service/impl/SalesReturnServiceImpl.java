package com.hg.inventory.modules.sales.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.sales.domain.entity.SalesReturn;
import com.hg.inventory.modules.sales.domain.form.SalesReturnForm;
import com.hg.inventory.modules.sales.mapper.SalesReturnMapper;
import com.hg.inventory.modules.sales.service.SalesReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesReturnServiceImpl implements SalesReturnService {
    @Autowired
    private SalesReturnMapper salesReturnMapper;
    @Override
    public SalesReturn save(SalesReturn salesReturn) {
        int flag = 0;
        if(salesReturn.getId()==null){
            flag= salesReturnMapper.insert(salesReturn);
        }else{
            flag = salesReturnMapper.updateById(salesReturn);
        }
        if(flag>0){
            return salesReturnMapper.selectById(salesReturn.getId());
        }else{
            return null;
        }
    }

    @Override
    public SalesReturn getById(Long id) {
        return salesReturnMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        salesReturnMapper.deleteById(id);
        return true;
    }

    @Override
    public PageInfo<SalesReturn> page(SalesReturnForm salesReturnForm, PageQuery pageQuery) {

        LambdaQueryWrapper<SalesReturn> lqw = getSalesReturnLambdaQueryWrapper(salesReturnForm);
        Page<SalesReturn> page = pageQuery.build();
        Page<SalesReturn> result = salesReturnMapper.selectPage(page, lqw);
        PageInfo<SalesReturn> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }

    private static LambdaQueryWrapper<SalesReturn> getSalesReturnLambdaQueryWrapper(SalesReturnForm salesReturnForm) {
        LambdaQueryWrapper<SalesReturn> lqw = Wrappers.lambdaQuery();
        lqw.eq(salesReturnForm.getStatus()!=null, SalesReturn::getStatus, salesReturnForm.getStatus());
        lqw.like(salesReturnForm.getCode()!=null, SalesReturn::getCode, salesReturnForm.getCode());
        lqw.eq(salesReturnForm.getEmployeeId()!=null, SalesReturn::getEmployeeId, salesReturnForm.getEmployeeId());
        lqw.ge(salesReturnForm.getStartTime()!=null, SalesReturn::getCreateTime, salesReturnForm.getStartTime());
        lqw.le(salesReturnForm.getEndTime()!=null, SalesReturn::getCreateTime, salesReturnForm.getEndTime());
        lqw.eq(SalesReturn::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return lqw;
    }

    @Override
    public List<SalesReturn> list(SalesReturnForm salesReturnForm) {
        LambdaQueryWrapper<SalesReturn> lqw = getSalesReturnLambdaQueryWrapper(salesReturnForm);
        return salesReturnMapper.selectList(lqw);
    }
}
