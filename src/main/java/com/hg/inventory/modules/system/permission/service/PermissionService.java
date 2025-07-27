package com.hg.inventory.modules.system.permission.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.system.permission.domain.entity.Permission;
import com.hg.inventory.modules.system.permission.domain.form.PermissionForm;

import java.util.List;

public interface PermissionService {
    Permission save(Permission permission);

    Permission getById(Long id);

    List<Permission> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<Permission> list();

    PageInfo<Permission> page(PermissionForm permissionForm);
}
