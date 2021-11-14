package com.kuang.service;

import com.kuang.dao.DiskIODao;
import com.kuang.entity.DiskIO;
import com.kuang.entity.ProcessCpu;
import com.kuang.entity.ProcessMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
@Service("diskioService")
public class DiskIOServiceImpl implements DiskIOService{
    @Autowired
    DiskIODao diskIODao;
    @Override
    public String getDiskIO() {
        List<DiskIO> diskIOList = diskIODao.getRecent2();
        int i=0;
        double ans=0;
        for(DiskIO diskIO: diskIOList){
            if(i<1){
                ans+=diskIO.getValue();
            }else{
                ans-=diskIO.getValue();
            }
            i++;
        }
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getReceive() {
        DiskIO receive = diskIODao.getReceive();
        int i=0;
        double ans=0;
        ans=receive.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getTransmit() {
        DiskIO transmit = diskIODao.getTransmit();
        int i=0;
        double ans=0;
        ans=transmit.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getDiskIO_139() {
        List<DiskIO> diskIOList = diskIODao.getRecent2_139();
        int i=0;
        double ans=0;
        for(DiskIO diskIO: diskIOList){
            if(i<1){
                ans+=diskIO.getValue();
            }else{
                ans-=diskIO.getValue();
            }
            i++;
        }
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getReceive_139() {
        DiskIO receive = diskIODao.getReceive_139();
        int i=0;
        double ans=0;
        ans=receive.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getTransmit_139() {
        DiskIO transmit = diskIODao.getTransmit_139();
        int i=0;
        double ans=0;
        ans=transmit.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getDiskIO_149() {
        List<DiskIO> diskIOList = diskIODao.getRecent2_149();
        int i=0;
        double ans=0;
        for(DiskIO diskIO: diskIOList){
            if(i<1){
                ans+=diskIO.getValue();
            }else{
                ans-=diskIO.getValue();
            }
            i++;
        }
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getReceive_149() {
        DiskIO receive = diskIODao.getReceive_149();
        int i=0;
        double ans=0;
        ans=receive.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getTransmit_149() {
        DiskIO transmit = diskIODao.getTransmit_149();
        int i=0;
        double ans=0;
        ans=transmit.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getDiskIO_150() {
        List<DiskIO> diskIOList = diskIODao.getRecent2_150();
        int i=0;
        double ans=0;
        for(DiskIO diskIO: diskIOList){
            if(i<1){
                ans+=diskIO.getValue();
            }else{
                ans-=diskIO.getValue();
            }
            i++;
        }
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getReceive_150() {
        DiskIO receive = diskIODao.getReceive_150();
        int i=0;
        double ans=0;
        ans=receive.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getTransmit_150() {
        DiskIO transmit = diskIODao.getTransmit_150();
        int i=0;
        double ans=0;
        ans=transmit.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getDiskIO_152() {
        List<DiskIO> diskIOList = diskIODao.getRecent2_152();
        int i=0;
        double ans=0;
        for(DiskIO diskIO: diskIOList){
            if(i<1){
                ans+=diskIO.getValue();
            }else{
                ans-=diskIO.getValue();
            }
            i++;
        }
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getReceive_152() {
        DiskIO receive = diskIODao.getReceive_152();
        int i=0;
        double ans=0;
        ans=receive.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getTransmit_152() {
        DiskIO transmit = diskIODao.getTransmit_152();
        int i=0;
        double ans=0;
        ans=transmit.getValue();
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }
}
