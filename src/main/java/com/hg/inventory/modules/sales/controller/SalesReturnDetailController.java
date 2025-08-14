package com.hg.inventory.modules.sales.controller;

import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.sales.domain.entity.SalesReturnDetail;
import com.hg.inventory.modules.sales.domain.entity.SalesReturnDetail;
import com.hg.inventory.modules.sales.service.SalesReturnDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/sales/return/detail")
@RestController
public class SalesReturnDetailController {
    @Autowired
    private SalesReturnDetailService salesReturnDetailService;
    /**
     * 批量销售退单详情
     */
    @PostMapping()
    public Result<Boolean> batchSave(@RequestBody
                                     List<SalesReturnDetail> salesReturnDetails){
        salesReturnDetailService.batchSave(salesReturnDetails);
        return Result.success();
    }
    /**
     * 根据销售退单Id查询销售退单详情列表
     */
    @GetMapping("{returnId}")
    public Result<List<SalesReturnDetail>> getByOrderId(@PathVariable("returnId") Long returnId){
        return Result.success(salesReturnDetailService.getByOrderId(returnId));
    }
    /**
     * 根据销售退单Id删除销售退单详情列表
     */
    @DeleteMapping("{returnId}")
    public Result<Void> deleteByOrderId(@PathVariable("returnId") Long returnId){
        salesReturnDetailService.deleteByOrderId(returnId);
        return Result.success();
    }
}
