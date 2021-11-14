package com.kuang.service;

import com.kuang.dao.ProcessMemoryDao;
import com.kuang.entity.ProcessCpu;
import com.kuang.entity.ProcessMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
@Service("processmemoryService")
public class ProcessMemoryServiceImpl implements ProcessMemoryService{
    @Autowired
    ProcessMemoryDao processMemoryDao;
    @Override
    public String getProcessMemory() {
        ProcessMemory processMemoryList =processMemoryDao.findRecent();
        int i=0;
        double ans=0;
        ans=processMemoryList.getValue();
        ans=ans/1024;
        ans=ans/1024;
        ans=ans/524288;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getProcessMemory_139() {
        ProcessMemory processMemoryList =processMemoryDao.findRecent_139();
        int i=0;
        double ans=0;
        ans=processMemoryList.getValue();
        ans=ans/1024;
        ans=ans/1024;
        ans=ans/524288;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getProcessMemory_149() {
        ProcessMemory processMemoryList =processMemoryDao.findRecent_149();
        int i=0;
        double ans=0;
        ans=processMemoryList.getValue();
        ans=ans/1024;
        ans=ans/1024;
        ans=ans/524288;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getProcessMemory_150() {
        ProcessMemory processMemoryList =processMemoryDao.findRecent_150();
        int i=0;
        double ans=0;
        ans=processMemoryList.getValue();
        ans=ans/1024;
        ans=ans/1024;
        ans=ans/524288;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getProcessMemory_152() {
        ProcessMemory processMemoryList =processMemoryDao.findRecent_152();
        int i=0;
        double ans=0;
        ans=processMemoryList.getValue();
        ans=ans/1024;
        ans=ans/1024;
        ans=ans/524288;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }
}
