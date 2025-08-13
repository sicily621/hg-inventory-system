package com.hg.inventory.modules.sales.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.sales.domain.entity.SalesOrder;
import com.hg.inventory.modules.sales.domain.form.SalesOrderForm;
import com.hg.inventory.modules.sales.mapper.SalesOrderMapper;
import com.hg.inventory.modules.sales.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {
    @Autowired
    private SalesOrderMapper salesOrderMapper;
    @Override
    public SalesOrder save(SalesOrder salesOrder) {
        int flag = 0;
        if(salesOrder.getId()==null){
            flag= salesOrderMapper.insert(salesOrder);
        }else{
            flag = salesOrderMapper.updateById(salesOrder);
        }
        if(flag>0){
            return salesOrderMapper.selectById(salesOrder.getId());
        }else{
            return null;
        }
    }

    @Override
    public SalesOrder getById(Long id) {
        return salesOrderMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        salesOrderMapper.deleteById(id);
        return true;
    }

    @Override
    public PageInfo<SalesOrder> page(SalesOrderForm salesOrderForm, PageQuery pageQuery) {
        LambdaQueryWrapper<SalesOrder> lqw = getSaleOrderLambdaQueryWrapper(salesOrderForm);
        Page<SalesOrder> page = pageQuery.build();
        Page<SalesOrder> result = salesOrderMapper.selectPage(page, lqw);
        PageInfo<SalesOrder> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }
    private static LambdaQueryWrapper<SalesOrder> getSaleOrderLambdaQueryWrapper(SalesOrderForm salesOrderForm) {
        LambdaQueryWrapper<SalesOrder> lqw = Wrappers.lambdaQuery();
        lqw.eq(salesOrderForm.getStatus()!=null, SalesOrder::getStatus, salesOrderForm.getStatus());
        lqw.like(salesOrderForm.getCode()!=null, SalesOrder::getCode, salesOrderForm.getCode());
        lqw.eq(salesOrderForm.getCustomerId()!=null, SalesOrder::getCustomerId, salesOrderForm.getCustomerId());
        lqw.eq(salesOrderForm.getEmployeeId()!=null, SalesOrder::getEmployeeId, salesOrderForm.getEmployeeId());
        lqw.ge(salesOrderForm.getStartTime()!=null, SalesOrder::getCreateTime, salesOrderForm.getStartTime());
        lqw.le(salesOrderForm.getEndTime()!=null, SalesOrder::getCreateTime, salesOrderForm.getEndTime());
        lqw.eq(SalesOrder::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return lqw;
    }

    @Override
    public List<SalesOrder> list(SalesOrderForm salesOrderForm) {
        LambdaQueryWrapper<SalesOrder> lqw = getSaleOrderLambdaQueryWrapper(salesOrderForm);
        return salesOrderMapper.selectList(lqw);
    }
}
