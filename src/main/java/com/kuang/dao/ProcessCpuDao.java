package com.kuang.dao;

import com.kuang.entity.ProcessCpu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProcessCpuDao {
    public List<ProcessCpu> findRecent2();
    public List<ProcessCpu> findRecent2_139();
    public List<ProcessCpu> findRecent2_149();
    public List<ProcessCpu> findRecent2_150();
    public List<ProcessCpu> findRecent2_152();
}
