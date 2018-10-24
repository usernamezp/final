package com.baizhi.dao;

import com.baizhi.entity.AdminUser;

public interface AdminUserDao {
    public AdminUser selectAdminUser(AdminUser adminUser);//根据账号密码查对象

    public AdminUser selectName(String name);//根据用户名查对象
}
