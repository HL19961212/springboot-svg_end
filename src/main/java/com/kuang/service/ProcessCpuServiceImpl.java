package com.kuang.service;

import com.kuang.dao.ProcessCpuDao;
import com.kuang.entity.Cpu;
import com.kuang.entity.ProcessCpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
@Service("processcpuService")
public class ProcessCpuServiceImpl implements ProcessCpuService{
    @Autowired
    ProcessCpuDao processCpuDao;
    @Override
    public String getProcessCpu() {
        List<ProcessCpu> processCpuList = processCpuDao.findRecent2();
        int i=0;
        double ans=0;
        for(ProcessCpu processCpu: processCpuList){
            if(i<1){
                ans+=processCpu.getValue();
            }else{
                ans-=processCpu.getValue();
            }
            i++;
        }
        ans/=160;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getProcessCpu_139() {
        List<ProcessCpu> processCpuList = processCpuDao.findRecent2_139();
        int i=0;
        double ans=0;
        for(ProcessCpu processCpu: processCpuList){
            if(i<1){
                ans+=processCpu.getValue();
            }else{
                ans-=processCpu.getValue();
            }
            i++;
        }
        ans/=160;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getProcessCpu_149() {
        List<ProcessCpu> processCpuList = processCpuDao.findRecent2_149();
        int i=0;
        double ans=0;
        for(ProcessCpu processCpu: processCpuList){
            if(i<1){
                ans+=processCpu.getValue();
            }else{
                ans-=processCpu.getValue();
            }
            i++;
        }
        ans/=160;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getProcessCpu_150() {
        List<ProcessCpu> processCpuList = processCpuDao.findRecent2_150();
        int i=0;
        double ans=0;
        for(ProcessCpu processCpu: processCpuList){
            if(i<1){
                ans+=processCpu.getValue();
            }else{
                ans-=processCpu.getValue();
            }
            i++;
        }
        ans/=160;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }

    @Override
    public String getProcessCpu_152() {
        List<ProcessCpu> processCpuList = processCpuDao.findRecent2_152();
        int i=0;
        double ans=0;
        for(ProcessCpu processCpu: processCpuList){
            if(i<1){
                ans+=processCpu.getValue();
            }else{
                ans-=processCpu.getValue();
            }
            i++;
        }
        ans/=160;
        DecimalFormat df = new DecimalFormat("0.00%");
        String s = df.format(ans);
        return s;
    }
}
