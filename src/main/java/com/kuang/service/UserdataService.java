package com.kuang.service;

import com.kuang.entity.Userdata;

import java.util.List;

public interface UserdataService {
    public List<Userdata> findAll();

    public void add(Userdata userdata);

    public void delete(String id);
}
