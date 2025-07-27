package com.hg.inventory.modules.system.department.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.system.department.domain.entity.Department;
import com.hg.inventory.modules.system.department.mapper.DepartmentMapper;
import com.hg.inventory.modules.system.department.service.DepartmentService;
import com.hg.inventory.modules.system.employee.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public Department save(Department department) {
        int flag = 0;
        if(department.getId()==null){
            flag= departmentMapper.insert(department);
        }else{
            flag = departmentMapper.updateById(department);
        }
        if(flag>0){
            return departmentMapper.selectById(department.getId());
        }else{
            return null;
        }

    }

    @Override
    public Department getById(Long id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        departmentMapper.deleteById(id);
        return true;
    }

    @Override
    public List<Department> list() {
        LambdaQueryWrapper<Department> lqw = Wrappers.lambdaQuery();
        lqw.eq( Department::getDelFlag, DelFlagEnum.NORMAL.getValue());
        return departmentMapper.selectList(lqw);
    }

    @Override
    public List<Department> getByIds(List<Long> ids) {
        LambdaQueryWrapper<Department> lqw = Wrappers.lambdaQuery();
        lqw.eq( Department::getDelFlag, DelFlagEnum.NORMAL.getValue());
        lqw.in( Department::getId, ids);
        return departmentMapper.selectList(lqw);
    }
}
