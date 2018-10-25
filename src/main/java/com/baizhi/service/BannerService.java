package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;
import java.util.Map;

public interface BannerService {
    public Map getAll(int page, int rows);

    public int getAllCount();

    public void updateStstus(int status, int id);

    public void insert(Banner banner);

    public void deleteOne(int id);
}
