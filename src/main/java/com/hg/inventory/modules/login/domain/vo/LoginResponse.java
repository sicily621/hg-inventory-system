package com.hg.inventory.modules.login.domain.vo;

import lombok.Data;

@Data
public class LoginResponse {
    private String msg;
    private String token;
}
