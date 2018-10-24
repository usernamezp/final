package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//开启springboot的自动配置
@SpringBootTest(classes = CmfzApp.class)
public class MenuTest {
    @Autowired
    MenuDao menuDao;

    @Test
    public void test1() {
        List<Menu> allMenu = menuDao.getAllMenu();
        for (Menu menu : allMenu) {
            System.out.println(menu);
        }

    }
}
