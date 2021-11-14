package com.kuang.service;

import com.kuang.dao.JianKongDao;
import com.kuang.entity.JianKong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JianKongServiceImpl implements JianKongService{
    @Autowired
    JianKongDao jianKongDao;
    @Override
    public List<JianKong> findAll() {
        return jianKongDao.findAll();
    }

    @Override
    public void delete(String id) {
        jianKongDao.delete(id);
    }
}
