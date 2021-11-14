package com.kuang.service;

import com.kuang.entity.Account;
import com.kuang.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public List<User> findNew();
    public void save(User user);

    public void delete(int id);
}
