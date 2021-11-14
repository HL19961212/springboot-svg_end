package com.kuang.service;

import com.kuang.dao.FileSystemDao;
import com.kuang.entity.FileSystem;
import com.kuang.entity.NodeMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
@Service("filesystemService")
public class FileSystemServiceimpl implements FileSystemService{
    @Autowired
    FileSystemDao fileSystemDao;
    @Override
    public String getFileSystem() {
        FileSystem fy = fileSystemDao.getRecent();
        double ans=0;
        ans=1-fy.getValue();

        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getFileSystem_139() {
        FileSystem fy = fileSystemDao.getRecent_139();
        double ans=0;
        ans=1-fy.getValue();

        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getFileSystem_149() {
        FileSystem fy = fileSystemDao.getRecent_149();
        double ans=0;
        ans=1-fy.getValue();

        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getFileSystem_150() {
        FileSystem fy = fileSystemDao.getRecent_150();
        double ans=0;
        ans=1-fy.getValue();

        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getFileSystem_152() {
        FileSystem fy = fileSystemDao.getRecent_152();
        double ans=0;
        ans=1-fy.getValue();

        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }
}
