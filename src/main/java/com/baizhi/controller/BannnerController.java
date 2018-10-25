package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannnerController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("/getAllBanner")
    @ResponseBody
    public Map getAll(int page, int rows) {
        return bannerService.getAll(page, rows);
    }

    @RequestMapping("/update")
    public void update(int status, int id) {
        bannerService.updateStstus(status, id);
//        System.out.println("修改...................");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(int id) {

        try {
            bannerService.deleteOne(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
//        System.out.println("删除.....................");
    }

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(Banner banner,MultipartFile file,HttpServletRequest request) {
//        System.out.println(banner);
        try {
           /*
           之前的写法  这种写法把路径写死了  不是很好
           String name=new Date().getTime()+""+file.getOriginalFilename();
            File file1=new File("D:\\software\\ideaIU-2018.1.6.win\\count\\final\\cmfz-zp\\src\\main\\webapp\\banner\\"+name);
            banner.setUrl(name);
            file.transferTo(file1);*/
            String name=new Date().getTime()+""+file.getOriginalFilename();
           //获取当前项目名
            String path = request.getSession().getServletContext().getRealPath("/");
            //在当前项目下的banner目录下
            File file1 = new File(path+"/banner");
            //如果目录不存在就创建
            if (!file1.exists()){
                file1.mkdir();
            }
            banner.setUrl(name);
            //把文件保存在制定位置file1是目录    name是文件名字
            file.transferTo(new File(file1,name));
            bannerService.insert(banner);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
