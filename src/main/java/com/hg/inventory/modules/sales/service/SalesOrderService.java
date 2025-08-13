package com.hg.inventory.modules.sales.service;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.sales.domain.entity.SalesOrder;
import com.hg.inventory.modules.sales.domain.form.SalesOrderForm;

import java.util.List;

public interface SalesOrderService {
    SalesOrder save(SalesOrder salesOrder);

    SalesOrder getById(Long id);

    boolean deleteById(Long id);

    PageInfo<SalesOrder> page(SalesOrderForm salesOrderForm, PageQuery pageQuery);

    List<SalesOrder> list(SalesOrderForm salesOrderForm);
}
