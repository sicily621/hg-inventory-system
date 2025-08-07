package com.hg.inventory.modules.purchase.controller;


import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseDemand;
import com.hg.inventory.modules.purchase.domain.entity.PurchaseDemandDetail;
import com.hg.inventory.modules.purchase.domain.form.PurchaseDemandForm;
import com.hg.inventory.modules.purchase.service.PurchaseDemandDetailService;
import com.hg.inventory.modules.system.rolepermission.domain.entity.RolePermission;
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

@RequestMapping("/purchase/demand/detail")
@RestController
public class PurchaseDemandDetailController {
    @Autowired
    private PurchaseDemandDetailService purchaseDemandDetailService;
    /**
     * 批量采购需求详情
     */
    @PostMapping()
    public Result<Boolean> batchSave(@RequestBody List<PurchaseDemandDetail> purchaseDemandDetails){
        purchaseDemandDetailService.batchSave(purchaseDemandDetails);
        return Result.success();
    }
    /**
     * 根据采购需求Id查询采购需求详情列表
     */
    @GetMapping("{demandId}")
    public Result<List<PurchaseDemandDetail>> getByDemandId(@PathVariable("demandId") Long demandId){
        return Result.success(purchaseDemandDetailService.getByDemandId(demandId));
    }
    /**
     * 根据采购需求Id删除采购需求详情列表
     */
    @DeleteMapping("{demandId}")
    public Result<Void> deleteByDemandId(@PathVariable("demandId") Long demandId){
        purchaseDemandDetailService.deleteByDemandId(demandId);
        return Result.success();
    }

}
