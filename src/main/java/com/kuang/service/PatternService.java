package com.kuang.service;

import com.kuang.entity.Pattern;

import java.util.List;

public interface PatternService {
    public List<Pattern> findAll();
    public void delete(String id);
    public void add(Pattern pattern);
    public void update();
}
