package com.kuang.service;

import com.kuang.entity.Cpu;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CpuService {
    public List<Cpu> findAll();
    public List<Cpu> findAll_1();
    public List<Cpu> getList();
    public List<Cpu> getAllPage();
    //考虑抽取service
    public String getCpu();//计算节点cpu使用率(最近32条数据16核对应相减再求平均)
    public String getCpuIO();
    public String getCpuSys();
    public String getCpuidle();
    public String getCpuIO_139();
    public String getCpuSys_139();
    public String getCpuidle_139();
    public String getCpuIO_149();
    public String getCpuSys_149();
    public String getCpuidle_149();
    public String getCpuIO_150();
    public String getCpuSys_150();
    public String getCpuidle_150();
    public String getCpuIO_152();
    public String getCpuSys_152();
    public String getCpuidle_152();




}
