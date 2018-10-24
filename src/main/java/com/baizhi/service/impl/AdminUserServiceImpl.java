package com.baizhi.service.impl;

import com.baizhi.dao.AdminUserDao;
import com.baizhi.entity.AdminUser;
import com.baizhi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserDao adminUserDao;


    @Override
    public boolean selectAdminUser(AdminUser adminUser) {
        AdminUser adminUser1 = adminUserDao.selectAdminUser(adminUser);
        if (adminUser1==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean selectName(String name) {
        AdminUser adminUser = adminUserDao.selectName(name);
        if (adminUser==null){
            return false;
        }
        return true;
    }
}
