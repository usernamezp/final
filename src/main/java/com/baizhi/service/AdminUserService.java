package com.baizhi.service;

import com.baizhi.entity.AdminUser;

public interface AdminUserService {
    public boolean selectAdminUser(AdminUser adminUser);//登录

    public boolean selectName(String name);//查询用户名是否存在
}
