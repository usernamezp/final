package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerDao bannerDao;

    @Override
    public Map getAll(int page, int rows) {
        Map map=new HashMap();
        int start=(page-1)*rows;
        int end=page*rows;
        List<Banner> all = bannerDao.getAll(start, end);
        int allCount = bannerDao.getAllCount();
        map.put("rows", all);
        map.put("total", allCount);
        return map;
    }

    @Override
    public int getAllCount() {
        return bannerDao.getAllCount();
    }

    @Override
    public void updateStstus(int status, int id) {
        bannerDao.updateStstus(status, id);
    }

    @Override
    public void insert(Banner banner) {
        bannerDao.insert(banner);
    }

    @Override
    public void deleteOne(int id) {
        bannerDao.deleteOne(id);
    }
}
