package com.kuang.dao;

import com.kuang.entity.Account;
import com.kuang.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    public List<User> findAll();

    public List<User> findNew();

    public void save(User user);

    public void delete(int id);
}
