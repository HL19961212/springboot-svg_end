package com.kuang.dao;

import com.kuang.entity.DiskIO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DiskIODao {
    public List<DiskIO> getRecent2();
    public DiskIO getReceive();
    public DiskIO getTransmit();
    public List<DiskIO> getRecent2_139();
    public DiskIO getReceive_139();
    public DiskIO getTransmit_139();
    public List<DiskIO> getRecent2_149();
    public DiskIO getReceive_149();
    public DiskIO getTransmit_149();
    public List<DiskIO> getRecent2_150();
    public DiskIO getReceive_150();
    public DiskIO getTransmit_150();
    public List<DiskIO> getRecent2_152();
    public DiskIO getReceive_152();
    public DiskIO getTransmit_152();
}
