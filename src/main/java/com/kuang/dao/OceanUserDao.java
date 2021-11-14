package com.kuang.dao;

import com.kuang.entity.OceanUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OceanUserDao{
    public OceanUser findByUsername(String username);
    public OceanUser findByToken(String token);
    public void save(OceanUser oceanUser);
    public void insert(OceanUser oceanUser);
}
