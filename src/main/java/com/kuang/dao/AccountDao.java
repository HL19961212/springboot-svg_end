package com.kuang.dao;

import com.kuang.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {
    public void save(Account account);

    public List<Account> findAll();
    public void Delete(String id);
}
