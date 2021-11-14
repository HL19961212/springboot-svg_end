package com.kuang.service;

import com.kuang.dao.AccountDao;
import com.kuang.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    public void save(Account account) {
        accountDao.save(account);

    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void Delete(String id) {
        accountDao.Delete(id);
    }
}
