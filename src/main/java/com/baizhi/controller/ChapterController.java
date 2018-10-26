package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    //吉祥妙音
    @Autowired
    ChapterService chapterService;

    @RequestMapping("/insert")
    @ResponseBody
    //添加章节(上传)
    public boolean insert(Chapter chapter, MultipartFile file, HttpServletRequest request) {
        try {
            String name = new Date().getTime() + "" + file.getOriginalFilename();
            //获取当前项目名
            String path = request.getSession().getServletContext().getRealPath("/");
            //在当前项目下的banner目录下
            File file1 = new File(path + "/banner");
            //如果目录不存在就创建
            if (!file1.exists()) {
                file1.mkdir();
            }
            chapter.setUrl(name);
            //获取文件大小
            double size = file.getSize() / 1048576.0;
            BigDecimal bg = new BigDecimal(size);
            double j = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            chapter.setSize(j + "MB");
            //获取文件时长
//            File file2 = new File(path + "/banner"+name);
            file.transferTo(new File(file1, name));
            MP3File f = (MP3File) AudioFileIO.read(new File(file1, name));
            MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
            int hour, minute, second;
            second = audioHeader.getTrackLength();
            hour = second / 3600;
            minute = (second - hour * 3600) / 60;
            second = second - hour * 300 - minute * 60;
            chapter.setDuration(String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
            //把文件保存在制定位置file1是目录    name是文件名字
//            file.transferTo(new File(file1, name));
//            System.out.println(album+"......................");
            chapterService.insertChapter(chapter);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("xiazai")
    public void getXiazai(String url, HttpServletRequest request, HttpServletResponse response) throws Exception {
//    System.out.println(url);
        String time = new Date().getTime() + "";
        int length = time.length();
//    System.out.println(time);
//    System.out.println(length);
        //获取路径
        String realPath = request.getSession().getServletContext().getRealPath("/banner");
        //找到这个文件
        File file = new File(realPath + "/" + url);

        //设置响应信息给客户端以附件的方式下载
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(url.substring(length), "utf-8"));
        //把file以输出流的方法响应给客户端
        FileUtils.copyFile(file, response.getOutputStream());
    }

}
