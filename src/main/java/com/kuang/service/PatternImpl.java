package com.kuang.service;

import com.kuang.dao.PatternDao;
import com.kuang.entity.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatternImpl implements PatternService{

    @Autowired
    PatternDao patternDao;
    @Override
    public List<Pattern> findAll() {
        return patternDao.findAll();
    }

    @Override
    public void delete(String id) {
        patternDao.delete(id);

    }

    @Override
    public void add(Pattern pattern) {
        patternDao.add(pattern);

    }

    @Override
    public void update() {

    }
}
