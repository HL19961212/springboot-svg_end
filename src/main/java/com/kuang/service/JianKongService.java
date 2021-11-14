package com.kuang.service;

import com.kuang.entity.JianKong;

import java.util.List;

public interface JianKongService {
    public List<JianKong> findAll();
    public void delete(String id);
}
