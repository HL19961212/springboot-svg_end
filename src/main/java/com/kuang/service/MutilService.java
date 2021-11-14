package com.kuang.service;

import com.kuang.entity.Mutil;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MutilService {
    public void save(Mutil mutil);
    public void save_139(Mutil mutil);
    public void save_149(Mutil mutil);
    public void save_150(Mutil mutil);
    public void save_152(Mutil mutil);

    public void save2(Mutil mutil);
    public Mutil findRecent();
    public void Delete(String time);
    public List<Mutil> findRecent100();
    public Mutil complier(Mutil mutil);

    public Mutil findRecent_139();
    public void Delete_139(String time);
    public List<Mutil> findRecent100_139();
    public Mutil complier_139(Mutil mutil);

    public Mutil findRecent_149();
    public void Delete_149(String time);
    public List<Mutil> findRecent100_149();
    public Mutil complier_149(Mutil mutil);

    public Mutil findRecent_150();
    public void Delete_150(String time);
    public List<Mutil> findRecent100_150();
    public Mutil complier_150(Mutil mutil);

    public Mutil findRecent_152();
    public void Delete_152(String time);
    public List<Mutil> findRecent100_152();
    public Mutil complier_152(Mutil mutil);

    public String computerScore(Mutil mutil,int cpuload,int memload);
    public String ioScore(Mutil mutil,int cpuload,int memload);
    public int top(List<String> str);//能力最高的节点
    public Mutil computercompiler(Mutil mutil);
    public  int recommend(Mutil mutil,int i,int j);
}
