package com.kuang.dao;

import com.kuang.entity.Software;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SoftwareDao {
    public Software findRecent();
    public List<Software> findAll();

    public void add(Software software);

    public void delete(String id);

}
