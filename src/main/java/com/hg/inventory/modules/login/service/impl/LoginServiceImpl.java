package com.hg.inventory.modules.login.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.hg.inventory.common.exception.ServiceException;
import com.hg.inventory.common.utils.ip.IpUtils;
import com.hg.inventory.modules.login.domain.entity.LoginLog;
import com.hg.inventory.modules.login.domain.form.LoginForm;
import com.hg.inventory.modules.login.domain.vo.LoginResponse;
import com.hg.inventory.modules.login.service.LoginLogService;
import com.hg.inventory.modules.login.service.LoginService;
import com.hg.inventory.modules.system.employee.domain.entity.Employee;
import com.hg.inventory.modules.system.employee.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LoginLogService loginLogService;
    @Override
    public LoginResponse login(LoginForm loginForm, HttpServletRequest request) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        Employee employee = employeeService.getByUsername(username);
        if (ObjectUtil.isNull(employee)) {
            log.info("登录用户：{} 不存在.", username);
            throw new ServiceException("用户不存在/密码错误");
        }
        String clientIP = IpUtils.getIpAddr(request);
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginIp(clientIP);
        LoginResponse loginResponse = new LoginResponse();
        if(employee!=null){
//            if(employee.getPassword().equals(password)){
            if(checkPwd(password, employee)){
                StpUtil.login(employee.getId());
                StpUtil.getTokenSession().set(""+employee.getId(), employee);
                loginResponse.setId(employee.getId());
                loginResponse.setRoleId(employee.getRoleId());
                loginResponse.setDepartmentId(employee.getDepartmentId());
                loginResponse.setUsername(employee.getUsername());
                loginResponse.setToken(StpUtil.getTokenValue());
                loginResponse.setTokenTimeout(StpUtil.getTokenTimeout());
                loginResponse.setMsg("登录成功");
                loginResponse.setAvatar(employee.getAvatar());
                loginLog.setEmployeeId(employee.getId());
                loginLog.setStatus(1);
                loginLog.setMessage("登录成功");
            }else{
                loginResponse.setMsg("密码错误");
                loginLog.setEmployeeId(employee.getId());
                loginLog.setStatus(0);
                loginLog.setMessage("密码错误");
                loginResponse.setAvatar("");
            }
            loginLogService.create(loginLog);
        }else{
            loginResponse.setMsg("用户不存在");
        }
        return loginResponse;
    }

    private static boolean checkPwd(String password, Employee employee) {
        boolean checkpw = BCrypt.checkpw(password, employee.getPassword());
        if(!checkpw){
            throw new ServiceException("用户不存在/密码错误");
        }
        return checkpw;
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }
}
