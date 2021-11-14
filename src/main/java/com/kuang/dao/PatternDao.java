package com.kuang.dao;

import com.kuang.entity.Pattern;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatternDao {
    public List<Pattern> findAll();
    public void delete(String id);
    public void add(Pattern pattern);
    public void update();

}
