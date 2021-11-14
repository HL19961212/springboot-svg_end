package com.kuang.service;

import com.kuang.dao.NodeMemoryDao;
import com.kuang.entity.Cpu;
import com.kuang.entity.NodeMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
@Service("nodememoryService")
public class NodeMemoryServiceImpl implements NodeMemoryService{
    @Autowired
    NodeMemoryDao nodeMemoryDao;
    @Override
    public String getNodeMemory() {
        NodeMemory nodememory = nodeMemoryDao.findRecent();
        int i=0;
        double ans=0;
        ans=1-nodememory.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getSWAP() {
        NodeMemory swap = nodeMemoryDao.findRecentSWAP();
        int i=0;
        double ans=0;
        ans=1-swap.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getNodeMemory_139() {
        NodeMemory nodememory = nodeMemoryDao.findRecent_139();
        int i=0;
        double ans=0;
        ans=1-nodememory.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getSWAP_139() {
        NodeMemory swap = nodeMemoryDao.findRecentSWAP_139();
        int i=0;
        double ans=0;
        ans=1-swap.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getNodeMemory_149() {
        NodeMemory nodememory = nodeMemoryDao.findRecent_149();
        int i=0;
        double ans=0;
        ans=1-nodememory.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getSWAP_149() {
        NodeMemory swap = nodeMemoryDao.findRecentSWAP_149();
        int i=0;
        double ans=0;
        ans=1-swap.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getNodeMemory_150() {
        NodeMemory nodememory = nodeMemoryDao.findRecent_150();
        int i=0;
        double ans=0;
        ans=1-nodememory.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getSWAP_150() {
        NodeMemory swap = nodeMemoryDao.findRecentSWAP_150();
        int i=0;
        double ans=0;
        ans=1-swap.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getNodeMemory_152() {
        NodeMemory nodememory = nodeMemoryDao.findRecent_152();
        int i=0;
        double ans=0;
        ans=1-nodememory.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getSWAP_152() {
        NodeMemory swap = nodeMemoryDao.findRecentSWAP_152();
        int i=0;
        double ans=0;
        ans=1-swap.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }
}
