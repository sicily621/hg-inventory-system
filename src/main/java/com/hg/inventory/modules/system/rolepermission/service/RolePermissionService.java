package com.hg.inventory.modules.system.rolepermission.service;

import com.hg.inventory.modules.system.rolepermission.domain.entity.RolePermission;

import java.util.List;

public interface RolePermissionService {
    Boolean batchSave(List<RolePermission> rolePermissions);

    List<RolePermission> getByPermissionId(Long permissionId);

    void deleteByPermissionId(Long permissionId);

    List<RolePermission> getByRoleId(Long roleId);

    void deleteByRoleId(Long roleId);
}
