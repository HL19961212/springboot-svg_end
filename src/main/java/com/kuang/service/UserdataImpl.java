package com.kuang.service;

import com.kuang.dao.UserdataDao;
import com.kuang.entity.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserdataImpl implements UserdataService{
    @Autowired
    UserdataDao userdataDao;
    @Override
    public List<Userdata> findAll() {
        return userdataDao.findAll();
    }

    @Override
    public void add(Userdata userdata) {
        userdataDao.add(userdata);

    }

    @Override
    public void delete(String id) {
        userdataDao.delete(id);

    }
}
