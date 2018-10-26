package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    //吉祥妙音
    @Autowired
    AlbumService albumService;

    @RequestMapping("/selectOne")
    @ResponseBody
    //专辑详情
    public Album getAll2(int id){
        System.out.println(id);
        Album album = albumService.selectOne(id);
        System.out.println(album);
        return album;
    }
    @RequestMapping("/getAll")
    @ResponseBody
    //展示主页面
    public Map getAll(int page, int rows){
//        System.out.println("进入Controller..........");
        Map all = albumService.getAll(page, rows);
//        System.out.println("走出Controller...............");
//        System.out.println(all.get("rows"));
        return all;
    }

    @RequestMapping("/insert")
    @ResponseBody
    //添加专辑
    public boolean insert(Album album, MultipartFile file, HttpServletRequest request) {

            String name = new Date().getTime() + "" + file.getOriginalFilename();
            //获取当前项目名
            String path = request.getSession().getServletContext().getRealPath("/");
            //在当前项目下的banner目录下
            File file1 = new File(path + "/banner");
            //如果目录不存在就创建
            if (!file1.exists()) {
                file1.mkdir();
            }
            album.setCoverlmg(name);
        try {
            //把文件保存在制定位置file1是目录    name是文件名字
            file.transferTo(new File(file1, name));
//            System.out.println(album+"......................");

            albumService.insert(album);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



}
