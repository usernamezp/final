package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.entity.AdminUser;
import com.baizhi.service.AdminUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//开启springboot的自动配置
@SpringBootTest(classes = CmfzApp.class)
public class TestAdmin {
    @Autowired
    AdminUserService adminUserService;

    @Test
    public void test1(){
        AdminUser adminUser = new AdminUser(0, "admin", "admin");
//        AdminUser adminUser1 = adminUserService.selectAdminUser(adminUser);
//        System.out.println(adminUser1);
    }

}
