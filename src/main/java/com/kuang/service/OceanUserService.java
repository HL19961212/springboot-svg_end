package com.kuang.service;

import com.kuang.entity.OceanUser;

public interface OceanUserService {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */

    public OceanUser findByUsername(String username);

    /**
     * 为user生成token
     * @param user
     * @return
     */
    public String createToken(OceanUser user);

    /**
     * 根据token去修改用户token ，使原本token失效
     * @param token
     */
    public void logout(String token);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    public OceanUser findByToken(String token);
    public void insert(OceanUser oceanUser);

}
