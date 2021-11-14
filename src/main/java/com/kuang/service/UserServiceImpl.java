package com.kuang.service;

import com.kuang.dao.UserDao;
import com.kuang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        int chushi=0;
        for(User user1: userList){
            user1.setChazhi(user1.getValue()-chushi);
            chushi= user1.getValue();
        }
        userList.remove(0);
        return userList;
    }

    @Override
    public List<User> findNew() {
        return userDao.findNew();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
