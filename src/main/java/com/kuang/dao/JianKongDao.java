package com.kuang.dao;

import com.kuang.entity.JianKong;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface JianKongDao {
    public List<JianKong> findAll();

    public void delete(String id);
}
