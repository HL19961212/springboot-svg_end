package com.kuang.service;

import com.kuang.dao.SoftwareDao;
import com.kuang.entity.Software;

import java.util.List;

public interface SoftwareService {


    public Software findRecent();
    public List<Software> findAll();

    public void add(Software software);

    public void delete(String id);
}
