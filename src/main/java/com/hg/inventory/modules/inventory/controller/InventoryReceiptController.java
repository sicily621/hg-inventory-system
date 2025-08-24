package com.hg.inventory.modules.inventory.controller;

import com.hg.inventory.common.domain.form.PageQuery;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.inventory.domain.entity.InventoryHistory;
import com.hg.inventory.modules.inventory.domain.entity.InventoryReceipt;
import com.hg.inventory.modules.inventory.domain.form.InventoryHistoryForm;
import com.hg.inventory.modules.inventory.domain.form.InventoryReceiptForm;
import com.hg.inventory.modules.inventory.service.InventoryReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入库
 */
@RequestMapping("/inventory/receipt")
@RestController
public class InventoryReceiptController {
    @Autowired
    private InventoryReceiptService inventoryReceiptService;
    /**
     * 新建入库
     */
    @PostMapping()
    public Result<InventoryReceipt> create(@RequestBody InventoryReceipt inventoryReceipt){
        return Result.success(inventoryReceiptService.save(inventoryReceipt));
    }
    /**
     * 修改入库
     * @param inventoryReceipt
     * @return
     */
    @PutMapping()
    public Result<InventoryReceipt> update(@RequestBody InventoryReceipt inventoryReceipt){
        return Result.success(inventoryReceiptService.save(inventoryReceipt));
    }
    /**
     * 根据入库Id查询入库
     */
    @GetMapping("{id}")
    public Result<InventoryReceipt> getById(@PathVariable("id") Long id){
        return Result.success(inventoryReceiptService.getById(id));
    }
    /**
     * 根据入库Ids查询入库列表
     */
    @GetMapping("/getByIds/{ids}")
    public Result<List<InventoryReceipt>> getById(@PathVariable("ids") List<Long> ids){
        return Result.success(inventoryReceiptService.getByIds(ids));
    }

    /**
     * 删除入库
     */
    @DeleteMapping("{id}")
    public Result<Void> deleteById(@PathVariable("id") Long id){
        inventoryReceiptService.deleteById(id);
        return Result.success();
    }
    /**
     * 查询入库列表
     */
    @GetMapping("/list")
    public Result<List<InventoryReceipt>> list(InventoryReceiptForm inventoryReceiptForm){
        return Result.success(inventoryReceiptService.list(inventoryReceiptForm));
    }

    /**
     * 分页查询入库列表
     */
    @GetMapping("/page")
    public Result<PageInfo<InventoryReceipt>> page(InventoryReceiptForm inventoryReceiptForm, PageQuery pageQuery){
        return Result.success(inventoryReceiptService.page(inventoryReceiptForm, pageQuery));
    }

}
