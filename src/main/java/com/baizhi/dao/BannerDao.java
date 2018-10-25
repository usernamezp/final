package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {
    public List<Banner> getAll(@Param("start")int start,@Param("end")int end);

    public int getAllCount();

    public void updateStstus(@Param("status") int status, @Param("id") int id);

    public void insert(@Param("banner") Banner banner);

    public void deleteOne(int id);
}
