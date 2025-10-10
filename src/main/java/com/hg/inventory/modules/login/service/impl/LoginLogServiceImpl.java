package com.hg.inventory.modules.login.service.impl;

import com.hg.inventory.modules.login.domain.entity.LoginLog;
import com.hg.inventory.modules.login.mapper.LoginLogMapper;
import com.hg.inventory.modules.login.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogMapper loginLogMapper;
    @Override
    public void create(LoginLog loginLog) {
        loginLogMapper.insert(loginLog);
    }
}
