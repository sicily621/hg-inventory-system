package com.hg.inventory.modules.system.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.system.permission.domain.entity.Permission;
import com.hg.inventory.modules.system.permission.domain.form.PermissionForm;
import com.hg.inventory.modules.system.permission.mapper.PermissionMapper;
import com.hg.inventory.modules.system.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public Permission save(Permission permission) {
        int flag = 0;
        if(permission.getId()==null){
            flag= permissionMapper.insert(permission);
        }else{
            flag = permissionMapper.updateById(permission);
        }
        if(flag>0){
            return permissionMapper.selectById(permission.getId());
        }else{
            return null;
        }

    }

    @Override
    public Permission getById(Long id) {
        return permissionMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        permissionMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Permission> list() {
        LambdaQueryWrapper<Permission> lqw = Wrappers.lambdaQuery();
        lqw.eq( Permission::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return permissionMapper.selectList(lqw);
    }

    @Override
    public PageInfo<Permission> page(PermissionForm permissionForm) {
        LambdaQueryWrapper<Permission> lqw = Wrappers.lambdaQuery();
        lqw.like(permissionForm.getName()!=null, Permission::getName, permissionForm.getName());
        lqw.eq( Permission::getDelFlag, DelFlagEnum.NORMAL.getValue());
        Page<Permission> page = permissionForm.build();
        Page<Permission> result = permissionMapper.selectPage(page, lqw);
        PageInfo<Permission> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }

    @Override
    public List<Permission> getByIds(List<Long> ids) {
        LambdaQueryWrapper<Permission> lqw = Wrappers.lambdaQuery();
        lqw.eq( Permission::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in( Permission::getId, ids);
        return permissionMapper.selectList(lqw);
    }
}
