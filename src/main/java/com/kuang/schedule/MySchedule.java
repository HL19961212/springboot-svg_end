package com.kuang.schedule;
import com.kuang.entity.Mutil;
import com.kuang.service.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MySchedule {
//    // 当前任务执行结束1秒后开启另一个任务
//    @Scheduled(fixedDelay = 1000)
//    public void fixedDelay() {
//        System.out.println("fixedDelay："+new Date());
//    }
//
//    // 当前任务开始执行2秒后开启另一个定时任务
//    @Scheduled(fixedRate = 2000)
//    public void fixedRate() {
//        System.out.println("fixedRate："+new Date());
//    }
//
//    // 当前任务开始执行2秒后开启另一个定时任务，并且首次延迟1秒执行
//    @Scheduled(initialDelay = 1000, fixedRate = 2000)
//    public void initialDelay() {
//        System.out.println("initialDelay："+new Date());
//    }









    // 使用crom 表达式，下面表示定时任务每10s执行一次
    @Scheduled(cron = "0/10 * * * * ?")
    public void cron() {
        CpuService cpuService=(CpuService) ApplicationContextUtil.getBean("cpuService");
        String cpu=cpuService.getCpuidle();
        String cpuio=cpuService.getCpuIO();
        String cpusys=cpuService.getCpuSys();
        ProcessCpuService processCpuService=(ProcessCpuService) ApplicationContextUtil.getBean("processcpuService");
        String processcpu=processCpuService.getProcessCpu();
        NodeMemoryService nodeMemoryService=(NodeMemoryService) ApplicationContextUtil.getBean("nodememoryService");
        String nodememory=nodeMemoryService.getNodeMemory();
        ProcessMemoryService processMemoryService=(ProcessMemoryService) ApplicationContextUtil.getBean("processmemoryService");
        String processmem=processMemoryService.getProcessMemory();
        String swap=nodeMemoryService.getSWAP();
        DiskIOService diskIOService=(DiskIOService) ApplicationContextUtil.getBean("diskioService");
        String diskio=diskIOService.getDiskIO();
        String receive=diskIOService.getReceive();
        String transmit=diskIOService.getTransmit();
        FileSystemService fileSystemService=(FileSystemService) ApplicationContextUtil.getBean("filesystemService");
        String fy=fileSystemService.getFileSystem();

        MutilService mutilService=(MutilService) ApplicationContextUtil.getBean("mutilService");

        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
        Mutil mutil=new Mutil();
        mutil.setTime(time);
        mutil.setCpu(cpu);
        mutil.setProcess_cpu(processcpu);
        mutil.setCpu_io(cpuio);
        mutil.setSys_cpu(cpusys);
        mutil.setNode_mem(nodememory);
        mutil.setProcess_mem(processmem);
        mutil.setSWAP(swap);
        mutil.setDiskio(diskio);
        mutil.setFilesys(fy);
        mutil.setReceive(receive);
        mutil.setTransmit(transmit);
        mutilService.save(mutil);


        String cpu139=cpuService.getCpuidle_139();
        String cpuio139=cpuService.getCpuIO_139();
        String cpusys139=cpuService.getCpuSys_139();
        String processcpu139=processCpuService.getProcessCpu_139();
        String nodememory139=nodeMemoryService.getNodeMemory_139();
        String processmem139=processMemoryService.getProcessMemory_139();
        String swap139=nodeMemoryService.getSWAP_139();
        String diskio139=diskIOService.getDiskIO_139();
        String receive139=diskIOService.getReceive_139();
        String transmit139=diskIOService.getTransmit_139();
        String fy139=fileSystemService.getFileSystem_139();
        Mutil mutil139=new Mutil();
        mutil139.setTime(time);
        mutil139.setCpu(cpu139);
        mutil139.setProcess_cpu(processcpu139);
        mutil139.setCpu_io(cpuio139);
        mutil139.setSys_cpu(cpusys139);
        mutil139.setNode_mem(nodememory139);
        mutil139.setProcess_mem(processmem139);
        mutil139.setSWAP(swap139);
        mutil139.setDiskio(diskio139);
        mutil139.setFilesys(fy139);
        mutil139.setReceive(receive139);
        mutil139.setTransmit(transmit139);
        mutilService.save_139(mutil139);

        String cpu149=cpuService.getCpuidle_149();
        String cpuio149=cpuService.getCpuIO_149();
        String cpusys149=cpuService.getCpuSys_149();
        //String processcpu149=processCpuService.getProcessCpu_149();
        String nodememory149=nodeMemoryService.getNodeMemory_149();
        //String processmem149=processMemoryService.getProcessMemory_149();
        String swap149=nodeMemoryService.getSWAP_149();
        String diskio149=diskIOService.getDiskIO_149();
        String receive149=diskIOService.getReceive_149();
        String transmit149=diskIOService.getTransmit_149();
        String fy149=fileSystemService.getFileSystem_149();
        Mutil mutil149=new Mutil();
        mutil149.setTime(time);
        mutil149.setCpu(cpu149);
        //mutil149.setProcess_cpu(processcpu149);
        mutil149.setCpu_io(cpuio149);
        mutil149.setSys_cpu(cpusys149);
        mutil149.setNode_mem(nodememory149);
        //mutil149.setProcess_mem(processmem149);
        mutil149.setSWAP(swap149);
        mutil149.setDiskio(diskio149);
        mutil149.setFilesys(fy149);
        mutil149.setReceive(receive149);
        mutil149.setTransmit(transmit149);
        mutilService.save_149(mutil149);



        String cpu150=cpuService.getCpuidle_150();
        String cpuio150=cpuService.getCpuIO_150();
        String cpusys150=cpuService.getCpuSys_150();
        //String processcpu150=processCpuService.getProcessCpu_150();
        String nodememory150=nodeMemoryService.getNodeMemory_150();
        //String processmem150=processMemoryService.getProcessMemory_150();
        String swap150=nodeMemoryService.getSWAP_150();
        String diskio150=diskIOService.getDiskIO_150();
        String receive150=diskIOService.getReceive_150();
        String transmit150=diskIOService.getTransmit_150();
        String fy150=fileSystemService.getFileSystem_150();
        Mutil mutil150=new Mutil();
        mutil150.setTime(time);
        mutil150.setCpu(cpu150);
        //mutil150.setProcess_cpu(processcpu150);
        mutil150.setCpu_io(cpuio150);
        mutil150.setSys_cpu(cpusys150);
        mutil150.setNode_mem(nodememory150);
        //mutil150.setProcess_mem(processmem150);
        mutil150.setSWAP(swap150);
        mutil150.setDiskio(diskio150);
        mutil150.setFilesys(fy150);
        mutil150.setReceive(receive150);
        mutil150.setTransmit(transmit150);
        mutilService.save_150(mutil150);


        String cpu152=cpuService.getCpuidle_152();
        String cpuio152=cpuService.getCpuIO_152();
        String cpusys152=cpuService.getCpuSys_152();
        //String processcpu152=processCpuService.getProcessCpu_152();
        String nodememory152=nodeMemoryService.getNodeMemory_152();
        //String processmem152=processMemoryService.getProcessMemory_152();
        String swap152=nodeMemoryService.getSWAP_152();
        String diskio152=diskIOService.getDiskIO_152();
        String receive152=diskIOService.getReceive_152();
        String transmit152=diskIOService.getTransmit_152();
        String fy152=fileSystemService.getFileSystem_152();
        Mutil mutil152=new Mutil();
        mutil152.setTime(time);
        mutil152.setCpu(cpu152);
        //mutil152.setProcess_cpu(processcpu152);
        mutil152.setCpu_io(cpuio152);
        mutil152.setSys_cpu(cpusys152);
        mutil152.setNode_mem(nodememory152);
        //mutil152.setProcess_mem(processmem152);
        mutil152.setSWAP(swap152);
        mutil152.setDiskio(diskio152);
        mutil152.setFilesys(fy152);
        mutil152.setReceive(receive152);
        mutil152.setTransmit(transmit152);
        mutilService.save_152(mutil152);




        System.out.println("cron："+new Date());
    }
}