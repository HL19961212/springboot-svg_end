package com.kuang.dao;

import com.kuang.entity.NodeMemory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NodeMemoryDao {
    public NodeMemory findRecent();
    public NodeMemory findRecentSWAP();
    public NodeMemory findRecent_139();
    public NodeMemory findRecentSWAP_139();
    public NodeMemory findRecent_149();
    public NodeMemory findRecentSWAP_149();
    public NodeMemory findRecent_150();
    public NodeMemory findRecentSWAP_150();
    public NodeMemory findRecent_152();
    public NodeMemory findRecentSWAP_152();
}
