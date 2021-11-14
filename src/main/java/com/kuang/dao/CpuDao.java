package com.kuang.dao;

import com.kuang.entity.Cpu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CpuDao{
    public List<Cpu> findAll();
    public List<Cpu> findAll_1();
    public List<Cpu> getList();

    public List<Cpu> findRecent32();//select * from node_cpu_second_idle_151 order by time desc limit 32;
    public List<Cpu> findRecent2();
    public List<Cpu> findRecentIO32();
    public List<Cpu> findRecentSys32();

    public List<Cpu> findRecentIdle32();

    public List<Cpu> findRecentIO16_139();
    public List<Cpu> findRecentSys16_139();
    public List<Cpu> findRecentIdle16_139();

    public List<Cpu> findRecentIO16_149();
    public List<Cpu> findRecentSys16_149();
    public List<Cpu> findRecentIdle16_149();

    public List<Cpu> findRecentIO16_150();
    public List<Cpu> findRecentSys16_150();
    public List<Cpu> findRecentIdle16_150();

    public List<Cpu> findRecentIO8_152();
    public List<Cpu> findRecentSys8_152();
    public List<Cpu> findRecentIdle8_152();
}
