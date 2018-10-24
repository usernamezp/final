package com.baizhi.controller;

import com.baizhi.entity.AdminUser;
import com.baizhi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    @RequestMapping("/login")
    public @ResponseBody boolean login(AdminUser adminUser, String code, HttpSession session) {//登录
        String c= (String) session.getAttribute("vrifyCode");
//        System.out.println("++++++++++++++++");
//        System.out.println(adminUser);
        if(!code.equalsIgnoreCase(c)){
              return false;
         }
        boolean b = adminUserService.selectAdminUser(adminUser);
//        System.out.println(adminUser.getName());
        if(b){
            session.setAttribute("admin",adminUser.getName());
        }
        return b;
    }

    @RequestMapping("/selectName")
    @ResponseBody
    public boolean selectName(String name) {//判断用户名是否存在(暂时没用到)
       return adminUserService.selectName(name);
    }


}
