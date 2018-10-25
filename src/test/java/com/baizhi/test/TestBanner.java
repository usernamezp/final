package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.dao.BannerDao;
import com.baizhi.entity.AdminUser;
import com.baizhi.entity.Banner;
import com.baizhi.service.AdminUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
//开启springboot的自动配置
@SpringBootTest(classes = CmfzApp.class)
public class TestBanner {
    @Autowired
    BannerDao bannerDao;
    @Test
    public void test1(){
        Banner banner=new Banner();
        banner.setName("xz");
        banner.setUrl("11.jpg");
        banner.setDescription("11111111");
        bannerDao.insert(banner);
    }

}
