package com.hg.inventory.modules.system.role.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.system.role.domain.entity.Role;
import com.hg.inventory.modules.system.role.domain.entity.form.RoleForm;

import java.util.List;

public interface RoleService {


    Role save(Role role);

    Role getById(Long id);

    List<Role> getByIds(List<Long> ids);

    Boolean deleteById(Long id);

    List<Role> list();

    PageInfo<Role> page(RoleForm roleForm);
}
