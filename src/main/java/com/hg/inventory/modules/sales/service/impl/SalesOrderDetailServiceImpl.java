package com.hg.inventory.modules.sales.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.sales.domain.entity.SalesOrderDetail;
import com.hg.inventory.modules.sales.mapper.SaleOrderDetailMapper;
import com.hg.inventory.modules.sales.service.SalesOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderDetailServiceImpl implements SalesOrderDetailService {
    @Autowired
    private SaleOrderDetailMapper saleOrderDetailMapper;
    @Override
    public boolean batchSave(List<SalesOrderDetail> salesOrderDetails) {
        boolean result = saleOrderDetailMapper.insertOrUpdateBatch(salesOrderDetails);
        return result;
    }

    @Override
    public List<SalesOrderDetail> getByOrderId(Long orderId) {
        LambdaQueryWrapper<SalesOrderDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(SalesOrderDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(SalesOrderDetail::getOrderId, orderId);
        return saleOrderDetailMapper.selectList(lqw);
    }

    @Override
    public void deleteByOrderId(Long orderId) {
        LambdaQueryWrapper<SalesOrderDetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(SalesOrderDetail::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.eq(SalesOrderDetail::getOrderId, orderId);
        saleOrderDetailMapper.delete(lqw);
    }
}
