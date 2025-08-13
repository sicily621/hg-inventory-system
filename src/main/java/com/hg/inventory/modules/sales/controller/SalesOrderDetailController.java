package com.hg.inventory.modules.sales.controller;

import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.sales.domain.entity.SalesOrderDetail;
import com.hg.inventory.modules.sales.service.SalesOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sales/order/detail")
@RestController
public class SalesOrderDetailController {
    @Autowired
    private SalesOrderDetailService salesOrderDetailService;
    /**
     * 批量销售订单详情
     */
    @PostMapping()
    public Result<Boolean> batchSave(@RequestBody
                                     List<SalesOrderDetail> salesOrderDetails){
        salesOrderDetailService.batchSave(salesOrderDetails);
        return Result.success();
    }
    /**
     * 根据销售订单Id查询销售订单详情列表
     */
    @GetMapping("{orderId}")
    public Result<List<SalesOrderDetail>> getByOrderId(@PathVariable("orderId") Long orderId){
        return Result.success(salesOrderDetailService.getByOrderId(orderId));
    }
    /**
     * 根据销售订单Id删除销售订单详情列表
     */
    @DeleteMapping("{orderId}")
    public Result<Void> deleteByOrderId(@PathVariable("orderId") Long orderId){
        salesOrderDetailService.deleteByOrderId(orderId);
        return Result.success();
    }
}
