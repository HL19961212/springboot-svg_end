package com.kuang.dao;

import com.kuang.entity.Mutil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MutilDao {
    public void save(Mutil mutil);
    public void save_139(Mutil mutil);
    public void save_149(Mutil mutil);
    public void save_150(Mutil mutil);
    public void save_152(Mutil mutil);
    public void save2(Mutil mutil);
    public Mutil findRecent();
    public List<Mutil> findRecent100();

    public void Delete(String time);

    public Mutil findRecent_139();
    public List<Mutil> findRecent100_139();

    public Mutil findRecent_149();
    public List<Mutil> findRecent100_149();

    public Mutil findRecent_150();
    public List<Mutil> findRecent100_150();

    public Mutil findRecent_152();
    public List<Mutil> findRecent100_152();


    public void Delete_139(String time);
    public void Delete_149(String time);
    public void Delete_150(String time);
    public void Delete_152(String time);
}
