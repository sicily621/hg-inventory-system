package com.hg.inventory.modules.login.controller;

import com.hg.inventory.common.domain.vo.Result;
import com.hg.inventory.modules.base.customer.domain.entity.Customer;
import com.hg.inventory.modules.login.domain.form.LoginForm;
import com.hg.inventory.modules.login.domain.vo.LoginResponse;
import com.hg.inventory.modules.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    /**
     * 登录
     */
    @PostMapping()
    public Result<LoginResponse> login(@RequestBody LoginForm LoginForm){
        return Result.success(loginService.login(LoginForm));
    }
}
