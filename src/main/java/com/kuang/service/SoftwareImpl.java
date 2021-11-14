package com.kuang.service;

import com.kuang.dao.SoftwareDao;
import com.kuang.entity.Software;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareImpl implements SoftwareService{
    @Autowired
    SoftwareDao softwareDao;

    @Override
    public Software findRecent() {
        Software software=softwareDao.findRecent();
        return software;
    }

    @Override
    public List<Software> findAll() {
        return softwareDao.findAll();
    }

    @Override
    public void add(Software software) {
        softwareDao.add(software);

    }

    @Override
    public void delete(String id) {
        softwareDao.delete(id);

    }
}
