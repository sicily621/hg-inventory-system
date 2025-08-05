package com.hg.inventory.modules.login.service.impl;

import com.hg.inventory.modules.login.domain.form.LoginForm;
import com.hg.inventory.modules.login.domain.vo.LoginResponse;
import com.hg.inventory.modules.login.service.LoginService;
import com.hg.inventory.modules.system.employee.domain.entity.Employee;
import com.hg.inventory.modules.system.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public LoginResponse login(LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        Employee employee = employeeService.getByUsername(username);
        LoginResponse loginResponse = new LoginResponse();
        if(employee!=null){
            if(employee.getPassword().equals(password)){
                loginResponse.setId(employee.getId());
                loginResponse.setRoleId(employee.getRoleId());
                loginResponse.setDepartmentId(employee.getDepartmentId());
                loginResponse.setUsername(employee.getUsername());
                loginResponse.setToken("123456");
                loginResponse.setMsg("登录成功");
            }else{
                loginResponse.setMsg("密码错误");
            }

        }else{
            loginResponse.setMsg("用户不存在");
        }
        return loginResponse;
    }
}
