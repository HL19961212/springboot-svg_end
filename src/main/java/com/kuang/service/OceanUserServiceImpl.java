package com.kuang.service;

import com.kuang.dao.OceanUserDao;
import com.kuang.entity.OceanUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OceanUserServiceImpl implements OceanUserService{
    @Autowired
    OceanUserDao oceanUserDao;
    @Override
    public OceanUser findByUsername(String username) {
        return oceanUserDao.findByUsername(username);
    }

    //12小时后失效
    private final static int EXPIRE = 12;
    @Override
    public String createToken(OceanUser user) {
        //用UUID生成token
        String token = UUID.randomUUID().toString();
        //当前时间
        LocalDateTime now = LocalDateTime.now();
        //过期时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);
        //保存到数据库
        user.setLoginTime(now);
        user.setExpireTime(expireTime);
        user.setToken(token);
        oceanUserDao.save(user);
        return token;

    }

    @Override
    public void logout(String token) {
        OceanUser user = oceanUserDao.findByToken(token);
        //用UUID生成token
        token = UUID.randomUUID().toString();
        //修改用户的token使原本的token失效，前端需配合将token清除
        user.setToken(token);
        oceanUserDao.save(user);
    }

    public void insert(OceanUser oceanUser) {
        oceanUserDao.insert(oceanUser);
    }

    @Override
    public OceanUser findByToken(String token) {
        return oceanUserDao.findByToken(token);
    }
}
