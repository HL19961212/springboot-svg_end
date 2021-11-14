package com.kuang.dao;

import com.kuang.entity.ProcessMemory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProcessMemoryDao {
    public ProcessMemory findRecent();
    public ProcessMemory findRecent_139();
    public ProcessMemory findRecent_149();
    public ProcessMemory findRecent_150();
    public ProcessMemory findRecent_152();

}
