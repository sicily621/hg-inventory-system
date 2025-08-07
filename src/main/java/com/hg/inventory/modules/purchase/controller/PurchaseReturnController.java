package com.hg.inventory.modules.purchase.controller;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseReturn;
import com.hg.inventory.modules.purchase.domain.form.PurchaseReturnForm;
import com.hg.inventory.modules.purchase.service.PurchaseReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/purchase/return")
@RestController
public class PurchaseReturnController {
    @Autowired
    private PurchaseReturnService purchaseReturnService;
    /**
     * 新增采购退货单
     */
    @PostMapping()
    public Result<PurchaseReturn> create(@RequestBody PurchaseReturn purchaseReturn){
        return Result.success(purchaseReturnService.save(purchaseReturn));
    }

    /**
     * 修改采购退货单
     * @param purchaseReturn
     * @return
     */
    @PutMapping()
    public Result<PurchaseReturn> update(@RequestBody PurchaseReturn purchaseReturn){
        return Result.success(purchaseReturnService.save(purchaseReturn));
    }
    /**
     * 根据采购退货单Id查询采购退货单
     */
    @GetMapping("{id}")
    public Result<PurchaseReturn> getById(@PathVariable("id") Long id){
        return Result.success(purchaseReturnService.getById(id));
    }
    /**
     * 删除采购退货单
     */
    @DeleteMapping("{id}")
    public Result<Void> deleteById(@PathVariable("id") Long id){
        purchaseReturnService.deleteById(id);
        return Result.success();
    }
    /**
     * 分页查询采购退货单列表
     */
    @GetMapping("/page")
    public Result<PageInfo<PurchaseReturn>> page(PurchaseReturnForm purchaseReturnForm){
        return Result.success(purchaseReturnService.page(purchaseReturnForm));
    }
    /**
     * 查询采购退货单列表
     */
    @GetMapping("/list")
    public Result<List<PurchaseReturn>> list(){
        return Result.success(purchaseReturnService.list());
    }
}
