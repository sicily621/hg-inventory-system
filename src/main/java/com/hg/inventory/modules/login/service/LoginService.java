package com.hg.inventory.modules.login.service;
import com.hg.inventory.modules.login.domain.form.LoginForm;
import com.hg.inventory.modules.login.domain.vo.LoginResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {
    LoginResponse login(LoginForm loginForm, HttpServletRequest request);

    void logout();
}
