package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumDao albumDao;

    @Override
    public void insert(Album album) {
        albumDao.insertAlbum(album);
    }

    @Override
    public Map getAll(int page, int rows) {
//        System.out.println("进入serviceimpl...............");
        Map map=new HashMap();
        int start=(page-1)*rows;
        int end=page*rows;
        List<Album> all = albumDao.getAll(start, end);
        int allCount = albumDao.getAllCount();
//        System.out.println(all);
        map.put("rows", all);
        map.put("total", allCount);
//        System.out.println("走出serviceimpl...........");
        return map;
    }

    @Override
    public Album selectOne(int id) {
        return albumDao.selectOne(id);
    }
}
