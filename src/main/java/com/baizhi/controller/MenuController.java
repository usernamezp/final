package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    //手风琴页面展示
    @Autowired
    MenuService menuService;

    @RequestMapping("/getAllMenu")
    public String getAllMenu(HttpServletRequest request) {
//        System.out.println("+++++++++++++++++");
        List<Menu> allMenu = menuService.getAllMenu();
        request.setAttribute("list", allMenu);
        return "main/main";
    }
}
