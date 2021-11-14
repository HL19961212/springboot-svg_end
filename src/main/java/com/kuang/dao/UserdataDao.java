package com.kuang.dao;

import com.kuang.entity.Software;
import com.kuang.entity.Userdata;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserdataDao {
    public List<Userdata> findAll();

    public void add(Userdata userdata);

    public void delete(String id);
}
