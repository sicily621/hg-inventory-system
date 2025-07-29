package com.hg.inventory.modules.base.warehouse.controller;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.base.warehouse.domain.entity.Warehouse;
import com.hg.inventory.modules.base.warehouse.domain.form.WarehouseForm;
import com.hg.inventory.modules.base.warehouse.service.WarehouseService;
import com.hg.inventory.modules.system.role.domain.entity.Role;
import com.hg.inventory.modules.system.role.domain.form.RoleForm;
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

@RequestMapping("/warehouse")
@RestController
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;
    /**
     * 新增仓库
     */
    @PostMapping()
    public Result<Warehouse> create(@RequestBody Warehouse warehouse){
        return Result.success(warehouseService.save(warehouse));
    }
    /**
     * 修改仓库
     * @param warehouse
     * @return
     */
    @PutMapping()
    public Result<Warehouse> update(@RequestBody Warehouse warehouse){
        return Result.success(warehouseService.save(warehouse));
    }
    /**
     * 根据仓库Id查询仓库
     */
    @GetMapping("{id}")
    public Result<Warehouse> getById(@PathVariable("id") Long id){
        return Result.success(warehouseService.getById(id));
    }
    /**
     * 根据仓库Ids查询仓库列表
     */
    @GetMapping("/getByIds/{ids}")
    public Result<List<Warehouse>> getById(@PathVariable("ids") List<Long> ids){
        return Result.success(warehouseService.getByIds(ids));
    }

    /**
     * 删除仓库
     */
    @DeleteMapping("{id}")
    public Result<Void> deleteById(@PathVariable("id") Long id){
        warehouseService.deleteById(id);
        return Result.success();
    }
    /**
     * 查询仓库列表
     */
    @GetMapping("/list")
    public Result<List<Warehouse>> list(){
        return Result.success(warehouseService.list());
    }

    /**
     * 分页查询仓库列表
     */
    @GetMapping("/page")
    public Result<PageInfo<Warehouse>> page(WarehouseForm warehouseForm){
        return Result.success(warehouseService.page(warehouseForm));
    }

}
