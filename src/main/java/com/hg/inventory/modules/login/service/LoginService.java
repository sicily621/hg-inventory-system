package com.hg.inventory.modules.login.service;
import com.hg.inventory.modules.login.domain.form.LoginForm;
import com.hg.inventory.modules.login.domain.vo.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginForm loginForm);
}
