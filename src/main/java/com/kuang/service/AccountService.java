package com.kuang.service;

import com.kuang.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    public void save(Account account);
    public List<Account> findAll();
    public void Delete(String id);
}
