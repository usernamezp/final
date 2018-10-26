package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {
    public void insertAlbum(@Param("album") Album album);//添加

    public List<Album> getAll(@Param("start")int start,@Param("end")int end);//查询全部专辑

    public int getAllCount();

    public Album selectOne(int id);
}
