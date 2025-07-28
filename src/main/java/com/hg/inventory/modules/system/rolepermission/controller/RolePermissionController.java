package com.hg.inventory.modules.system.rolepermission.controller;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.system.rolepermission.domain.entity.RolePermission;
import com.hg.inventory.modules.system.rolepermission.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/role/permission/relations")
@RestController
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;
    /**
     * 批量新增角色权限关系
     */
    @PostMapping()
    public Result<Boolean> batchSave(@RequestBody List<RolePermission> rolePermissions){
        rolePermissionService.batchSave(rolePermissions);
        return Result.success();
    }
    /**
     * 根据权限Id查询角色权限关系
     */
    @GetMapping("{permissionId}")
    public Result<List<RolePermission>> getById(@PathVariable("permissionId") Long permissionId){
        return Result.success(rolePermissionService.getByPermissionId(permissionId));
    }
    /**
     * 批量删除角色权限关系
     */
    @DeleteMapping("{permissionId}")
    public Result<Void> deleteById(@PathVariable("permissionId") Long permissionId){
        rolePermissionService.deleteByPermissionId(permissionId);
        return Result.success();
    }
}
