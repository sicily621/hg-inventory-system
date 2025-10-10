package com.hg.inventory.modules.login.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.login.domain.form.LoginForm;
import com.hg.inventory.modules.login.domain.vo.LoginResponse;
import com.hg.inventory.modules.login.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 */
@SaIgnore
@RestController
@RequestMapping()
public class LoginController {
    @Autowired
    private LoginService loginService;
    /**
     * 登录
     */
    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginForm LoginForm, HttpServletRequest request){
        LoginResponse loginResponse = loginService.login(LoginForm, request);
        return Result.success(loginResponse);
    }
    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public Result<Void> logout(){
        loginService.logout();
        return Result.success();
    }

}
