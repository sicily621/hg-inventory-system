package com.hg.inventory.modules.login.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("hg_login_log")
public class LoginLog {
    private Long id;
    private Long employeeId;
    private Date loginTime;
    private String loginIp;
    private Integer status;
    private String message;
}
