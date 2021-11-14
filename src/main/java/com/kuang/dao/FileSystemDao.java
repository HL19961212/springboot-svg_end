package com.kuang.dao;

import com.kuang.entity.FileSystem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileSystemDao {
    public FileSystem getRecent();
    public FileSystem getRecent_139();
    public FileSystem getRecent_149();
    public FileSystem getRecent_150();
    public FileSystem getRecent_152();

}
