package com.hg.inventory.modules.system.employee.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.system.employee.domain.entity.Employee;
import com.hg.inventory.modules.system.employee.domain.form.EmployeeForm;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee getById(Long id);

    boolean deleteById(Long id);

    PageInfo<Employee> page(EmployeeForm employeeForm);

    Employee getByUsername(String username);

    List<Employee> list();
}
