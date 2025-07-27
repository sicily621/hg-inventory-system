package com.hg.inventory.modules.system.department.service;

import com.hg.inventory.common.domain.vo.PageInfo;
import com.hg.inventory.modules.system.department.domain.entity.Department;
import com.hg.inventory.modules.system.employee.domain.entity.Employee;
import com.hg.inventory.modules.system.employee.domain.form.EmployeeForm;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);
    Department getById(Long id);

    boolean deleteById(Long id);

    List<Department> list();

    List<Department> getByIds(List<Long> ids);
}
