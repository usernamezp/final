package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.Map;

public interface AlbumService {
    public void insert(Album album);
    public Map getAll(int page, int rows);//查询全部专辑
    public Album selectOne(int id);
}
