package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

public interface ChapterDao {
    public void insertChapter(@Param("chapter") Chapter chapter);//添加
}
