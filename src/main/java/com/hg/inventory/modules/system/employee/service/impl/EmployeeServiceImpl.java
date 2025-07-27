package com.hg.inventory.modules.system.employee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.common.enums.DelFlagEnum;
import com.hg.inventory.modules.system.employee.domain.entity.Employee;
import com.hg.inventory.modules.system.employee.domain.form.EmployeeForm;
import com.hg.inventory.modules.system.employee.mapper.EmployeeMapper;
import com.hg.inventory.modules.system.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Employee save(Employee employee) {
        int flag = 0;
        if(employee.getId()==null){
            flag= employeeMapper.insert(employee);
        }else{
            flag = employeeMapper.updateById(employee);
        }
        if(flag>0){
            return employeeMapper.selectById(employee.getId());
        }else{
            return null;
        }

    }

    @Override
    public Employee getById(Long id) {
        return employeeMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        employeeMapper.deleteById(id);
        return true;
    }

    @Override
    public PageInfo<Employee> page(EmployeeForm employeeForm) {
        LambdaQueryWrapper<Employee> lqw = Wrappers.lambdaQuery();
        lqw.like(employeeForm.getCode()!=null, Employee::getCode, employeeForm.getCode());
        lqw.like(employeeForm.getRealName()!=null, Employee::getRealName, employeeForm.getRealName());
        lqw.eq(employeeForm.getDepartmentId()!=null, Employee::getDepartmentId, employeeForm.getDepartmentId());
        lqw.eq(employeeForm.getRoleId()!=null, Employee::getRoleId, employeeForm.getRoleId());
        lqw.eq( Employee::getDelFlag, DelFlagEnum.NORMAL.getValue());
        Page<Employee> page = employeeForm.build();
        Page<Employee> result = employeeMapper.selectPage(page, lqw);
        PageInfo<Employee> tableDataInfo = PageInfo.build(result);
        return tableDataInfo;
    }

}
