package com.kuang.service;

import com.github.pagehelper.PageHelper;
import com.kuang.dao.CpuDao;
import com.kuang.entity.Cpu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
@Service("cpuService")
public class CpuServiceImpl implements CpuService{
    @Autowired
    CpuDao cpuDao;
    @Override
    public List<Cpu> findAll() {
        List<Cpu> cpuList = cpuDao.findAll();
        int id=1;
        double chushi=0;
        for(Cpu cpu: cpuList){
            cpu.setId(id);
            id++;
            cpu.setChazhi(cpu.getValue()-chushi);
            chushi= cpu.getValue();
        }
        cpuList.remove(0);
        return cpuList;
    }

    @Override
    public List<Cpu> findAll_1() {
        List<Cpu> cpuList_1 = cpuDao.findAll_1();
        int id=1;
        double chushi=0;
        for(Cpu cpu: cpuList_1){
            cpu.setId(id);
            id++;
            cpu.setChazhi(cpu.getValue()-chushi);
            chushi= cpu.getValue();
        }
        cpuList_1.remove(0);
        return cpuList_1;
    }

    @Override
    public List<Cpu> getList() {
        PageHelper.startPage(0, 5);
        // 获取
        List<Cpu> cpuList = cpuDao.getList();
        return cpuList;
    }

    @Override
    public List<Cpu> getAllPage() {
        List<Cpu> cpuList = cpuDao.getList();

        int id=1;
        double chushi=0;
        for(Cpu cpu: cpuList){
            cpu.setId(id);
            id++;
            cpu.setChazhi(cpu.getValue()-chushi);
            chushi= cpu.getValue();
        }
        return cpuList;
    }

    @Override
    public String getCpu() {
        //用差值返回结果
        List<Cpu> cpuList = cpuDao.findRecent32();
        int i=0;
        double ans=0;

        for(Cpu cpu: cpuList){
            if(i<16){
                ans+=cpu.getValue();

            }else{
                ans-=cpu.getValue();

            }
            i++;
        }
        ans/=16;
        ans/=10;

        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuIO() {
        List<Cpu> cpuList = cpuDao.findRecentIO32();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<16){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=16;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }


    @Override
    public String getCpuSys() {
        List<Cpu> cpuList = cpuDao.findRecentSys32();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<16){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=16;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuidle() {
        List<Cpu> cpuList = cpuDao.findRecentIdle32();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<16){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=16;
        ans/=10;
        ans=1-ans;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuIO_139() {
        List<Cpu> cpuList = cpuDao.findRecentIO16_139();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuSys_139() {
        List<Cpu> cpuList = cpuDao.findRecentSys16_139();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuidle_139() {
        List<Cpu> cpuList = cpuDao.findRecentIdle16_139();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        ans=1-ans;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuIO_149() {
        List<Cpu> cpuList = cpuDao.findRecentIO16_149();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuSys_149() {
        List<Cpu> cpuList = cpuDao.findRecentSys16_149();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuidle_149() {
        List<Cpu> cpuList = cpuDao.findRecentIdle16_149();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        ans=1-ans;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuIO_150() {
        List<Cpu> cpuList = cpuDao.findRecentIO16_150();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuSys_150() {
        List<Cpu> cpuList = cpuDao.findRecentSys16_150();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuidle_150() {
        List<Cpu> cpuList = cpuDao.findRecentIdle16_150();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<8){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=8;
        ans/=10;
        ans=1-ans;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuIO_152() {
        List<Cpu> cpuList = cpuDao.findRecentIO8_152();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<4){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=4;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuSys_152() {
        List<Cpu> cpuList = cpuDao.findRecentSys8_152();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<4){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=4;
        ans/=10;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getCpuidle_152() {
        List<Cpu> cpuList = cpuDao.findRecentIdle8_152();
        int i=0;
        double ans=0;
        for(Cpu cpu: cpuList){
            if(i<4){
                ans+=cpu.getValue();
            }else{
                ans-=cpu.getValue();
            }
            i++;
        }
        ans/=4;
        ans/=10;
        ans=1-ans;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }


}
