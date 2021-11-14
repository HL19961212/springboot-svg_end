package com.kuang.service;

import com.kuang.dao.MutilDao;
import com.kuang.entity.Mutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("mutilService")
public class MutilServiceImpl implements MutilService{

    @Autowired
    MutilDao mutilDao;
    @Override
    public void save(Mutil mutil) {

        mutilDao.save(mutil);
    }

    @Override
    public void save_139(Mutil mutil) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil.setTime(createtime);
        mutilDao.save_139(mutil);
    }

    @Override
    public void save_149(Mutil mutil) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil.setTime(createtime);
        mutilDao.save_149(mutil);
    }

    @Override
    public void save_150(Mutil mutil) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil.setTime(createtime);
        mutilDao.save_150(mutil);
    }

    @Override
    public void save_152(Mutil mutil) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil.setTime(createtime);
        mutilDao.save_152(mutil);
    }

    @Override
    public void save2(Mutil mutil) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil.setTime(createtime);
        mutilDao.save(mutil);
    }


    @Override
    public Mutil findRecent() {
        Mutil mutil = mutilDao.findRecent();
        return mutil;
    }

    @Override
    public void Delete(String time) {
        mutilDao.Delete(time);
    }

    @Override
    public List<Mutil> findRecent100() {
        return mutilDao.findRecent100();
    }

    @Override
    public Mutil complier(Mutil mutil) {
        Mutil mutil1 = new Mutil();
        String time=mutil.getTime();
        String cpu=mutil.getCpu();
        String process_cpu=mutil.getProcess_cpu();
        String cpu_io=mutil.getCpu_io();
        String sys_cpu=mutil.getSys_cpu();
        String node_mem=mutil.getNode_mem();
        String process_mem=mutil.getProcess_mem();
        String SWAP=mutil.getSWAP();
        String diskio=mutil.getDiskio();
        String filesys=mutil.getFilesys();
        String receive=mutil.getReceive();
        String transmit=mutil.getTransmit();
        String[] cpu_c = cpu.split("%");
        String[] process_cpu_c = process_cpu.split("%");
        String[] cpu_io_c = cpu_io.split("%");
        String[] sys_cpu_c = sys_cpu.split("%");
        String[] node_mem_c = node_mem.split("%");
        String[] process_mem_c = process_mem.split("%");
        String[] SWAP_c = SWAP.split("%");
        String[] diskio_c = diskio.split("%");
        String[] filesys_c = filesys.split("%");
        String[] receive_c = receive.split("%");
        String[] transmit_c = transmit.split("%");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil1.setTime(createtime);

        if(Double.valueOf(cpu_c[0])>80){
            mutil1.setCpu("使用率过高");
        }else{
            mutil1.setCpu("正常，未超过安全水位");
        }
        if(Double.valueOf(process_cpu_c[0])>65){
            mutil1.setProcess_cpu("使用率过高");
        }else{
            mutil1.setProcess_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(cpu_io_c[0])>10){
            mutil1.setCpu_io("占比过高");
        }else{
            mutil1.setCpu_io("正常，未超过安全水位");
        }
        if(Double.valueOf(sys_cpu_c[0])>20){
            mutil1.setSys_cpu("占比过高");
        }else{
            mutil1.setSys_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(node_mem_c[0])>80){
            mutil1.setNode_mem("使用率过高");
        }else{
            mutil1.setNode_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(process_mem_c[0])>70){
            mutil1.setProcess_mem("使用率过高");
        }else{
            mutil1.setProcess_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(filesys_c[0])>70){
            mutil1.setFilesys("使用率过高");
        }else{
            mutil1.setFilesys("正常，未超过安全水位");
        }
        if(Double.valueOf(SWAP_c[0])>75){
            mutil1.setSWAP("比例过高");
        }else{
            mutil1.setSWAP("正常，未超过安全水位");
        }
        if(Double.valueOf(diskio_c[0])>60){
            mutil1.setDiskio("时间过长");
        }else{
            mutil1.setDiskio("正常，未超过安全水位");
        }
        if(Double.valueOf(receive_c[0])>1){
            mutil1.setReceive("一般");
        }else{
            mutil1.setReceive("正常，未超过安全水位");
        }
        if(Double.valueOf(transmit_c[0])>1){
            mutil1.setTransmit("一般");
        }else{
            mutil1.setTransmit("正常，未超过安全水位");
        }

        return mutil1;
    }

    @Override
    public Mutil findRecent_139() {
        Mutil mutil = mutilDao.findRecent_139();
        return mutil;
    }

    @Override
    public void Delete_139(String time) {
        mutilDao.Delete_139(time);
    }

    @Override
    public List<Mutil> findRecent100_139() {
        return mutilDao.findRecent100_139();
    }

    @Override
    public Mutil complier_139(Mutil mutil) {
        Mutil mutil1 = new Mutil();
        String time=mutil.getTime();
        String cpu=mutil.getCpu();
        String process_cpu=mutil.getProcess_cpu();
        String cpu_io=mutil.getCpu_io();
        String sys_cpu=mutil.getSys_cpu();
        String node_mem=mutil.getNode_mem();
        String process_mem=mutil.getProcess_mem();
        String SWAP=mutil.getSWAP();
        String diskio=mutil.getDiskio();
        String filesys=mutil.getFilesys();
        String receive=mutil.getReceive();
        String transmit=mutil.getTransmit();
        String[] cpu_c = cpu.split("%");
        String[] process_cpu_c = process_cpu.split("%");
        String[] cpu_io_c = cpu_io.split("%");
        String[] sys_cpu_c = sys_cpu.split("%");
        String[] node_mem_c = node_mem.split("%");
        String[] process_mem_c = process_mem.split("%");
        String[] SWAP_c = SWAP.split("%");
        String[] diskio_c = diskio.split("%");
        String[] filesys_c = filesys.split("%");
        String[] receive_c = receive.split("%");
        String[] transmit_c = transmit.split("%");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil1.setTime(createtime);

        if(Double.valueOf(cpu_c[0])>80){
            mutil1.setCpu("使用率过高");
        }else{
            mutil1.setCpu("正常，未超过安全水位");
        }
        if(Double.valueOf(process_cpu_c[0])>65){
            mutil1.setProcess_cpu("使用率过高");
        }else{
            mutil1.setProcess_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(cpu_io_c[0])>10){
            mutil1.setCpu_io("占比过高");
        }else{
            mutil1.setCpu_io("正常，未超过安全水位");
        }
        if(Double.valueOf(sys_cpu_c[0])>20){
            mutil1.setSys_cpu("占比过高");
        }else{
            mutil1.setSys_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(node_mem_c[0])>80){
            mutil1.setNode_mem("使用率过高");
        }else{
            mutil1.setNode_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(process_mem_c[0])>70){
            mutil1.setProcess_mem("使用率过高");
        }else{
            mutil1.setProcess_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(filesys_c[0])>70){
            mutil1.setFilesys("使用率过高");
        }else{
            mutil1.setFilesys("正常，未超过安全水位");
        }
        if(Double.valueOf(SWAP_c[0])>75){
            mutil1.setSWAP("比例过高");
        }else{
            mutil1.setSWAP("正常，未超过安全水位");
        }
        if(Double.valueOf(diskio_c[0])>60){
            mutil1.setDiskio("时间过长");
        }else{
            mutil1.setDiskio("正常，未超过安全水位");
        }
        if(Double.valueOf(receive_c[0])>1){
            mutil1.setReceive("一般");
        }else{
            mutil1.setReceive("正常，未超过安全水位");
        }
        if(Double.valueOf(transmit_c[0])>1){
            mutil1.setTransmit("一般");
        }else{
            mutil1.setTransmit("正常，未超过安全水位");
        }

        return mutil1;
    }

    @Override
    public Mutil findRecent_149() {
        Mutil mutil = mutilDao.findRecent_149();
        return mutil;
    }

    @Override
    public void Delete_149(String time) {
        mutilDao.Delete_149(time);
    }

    @Override
    public List<Mutil> findRecent100_149() {
        return mutilDao.findRecent100_149();
    }

    @Override
    public Mutil complier_149(Mutil mutil) {
        Mutil mutil1 = new Mutil();
        String time=mutil.getTime();
        String cpu=mutil.getCpu();
        String process_cpu=mutil.getProcess_cpu();
        String cpu_io=mutil.getCpu_io();
        String sys_cpu=mutil.getSys_cpu();
        String node_mem=mutil.getNode_mem();
        String process_mem=mutil.getProcess_mem();
        String SWAP=mutil.getSWAP();
        String diskio=mutil.getDiskio();
        String filesys=mutil.getFilesys();
        String receive=mutil.getReceive();
        String transmit=mutil.getTransmit();
        String[] cpu_c = cpu.split("%");
        String[] process_cpu_c = process_cpu.split("%");
        String[] cpu_io_c = cpu_io.split("%");
        String[] sys_cpu_c = sys_cpu.split("%");
        String[] node_mem_c = node_mem.split("%");
        String[] process_mem_c = process_mem.split("%");
        String[] SWAP_c = SWAP.split("%");
        String[] diskio_c = diskio.split("%");
        String[] filesys_c = filesys.split("%");
        String[] receive_c = receive.split("%");
        String[] transmit_c = transmit.split("%");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil1.setTime(createtime);

        if(Double.valueOf(cpu_c[0])>80){
            mutil1.setCpu("使用率过高");
        }else{
            mutil1.setCpu("正常，未超过安全水位");
        }
        if(Double.valueOf(process_cpu_c[0])>65){
            mutil1.setProcess_cpu("使用率过高");
        }else{
            mutil1.setProcess_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(cpu_io_c[0])>10){
            mutil1.setCpu_io("占比过高");
        }else{
            mutil1.setCpu_io("正常，未超过安全水位");
        }
        if(Double.valueOf(sys_cpu_c[0])>20){
            mutil1.setSys_cpu("占比过高");
        }else{
            mutil1.setSys_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(node_mem_c[0])>80){
            mutil1.setNode_mem("使用率过高");
        }else{
            mutil1.setNode_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(process_mem_c[0])>70){
            mutil1.setProcess_mem("使用率过高");
        }else{
            mutil1.setProcess_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(filesys_c[0])>70){
            mutil1.setFilesys("使用率过高");
        }else{
            mutil1.setFilesys("正常，未超过安全水位");
        }
        if(Double.valueOf(SWAP_c[0])>75){
            mutil1.setSWAP("比例过高");
        }else{
            mutil1.setSWAP("正常，未超过安全水位");
        }
        if(Double.valueOf(diskio_c[0])>60){
            mutil1.setDiskio("时间过长");
        }else{
            mutil1.setDiskio("正常，未超过安全水位");
        }
        if(Double.valueOf(receive_c[0])>1){
            mutil1.setReceive("一般");
        }else{
            mutil1.setReceive("正常，未超过安全水位");
        }
        if(Double.valueOf(transmit_c[0])>1){
            mutil1.setTransmit("一般");
        }else{
            mutil1.setTransmit("正常，未超过安全水位");
        }

        return mutil1;
    }

    @Override
    public Mutil findRecent_150() {
        Mutil mutil = mutilDao.findRecent_150();
        return mutil;
    }

    @Override
    public void Delete_150(String time) {
        mutilDao.Delete_150(time);
    }

    @Override
    public List<Mutil> findRecent100_150() {
        return mutilDao.findRecent100_150();
    }

    @Override
    public Mutil complier_150(Mutil mutil) {
        Mutil mutil1 = new Mutil();
        String time=mutil.getTime();
        String cpu=mutil.getCpu();
        String process_cpu=mutil.getProcess_cpu();
        String cpu_io=mutil.getCpu_io();
        String sys_cpu=mutil.getSys_cpu();
        String node_mem=mutil.getNode_mem();
        String process_mem=mutil.getProcess_mem();
        String SWAP=mutil.getSWAP();
        String diskio=mutil.getDiskio();
        String filesys=mutil.getFilesys();
        String receive=mutil.getReceive();
        String transmit=mutil.getTransmit();
        String[] cpu_c = cpu.split("%");
        String[] process_cpu_c = process_cpu.split("%");
        String[] cpu_io_c = cpu_io.split("%");
        String[] sys_cpu_c = sys_cpu.split("%");
        String[] node_mem_c = node_mem.split("%");
        String[] process_mem_c = process_mem.split("%");
        String[] SWAP_c = SWAP.split("%");
        String[] diskio_c = diskio.split("%");
        String[] filesys_c = filesys.split("%");
        String[] receive_c = receive.split("%");
        String[] transmit_c = transmit.split("%");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil1.setTime(createtime);

        if(Double.valueOf(cpu_c[0])>80){
            mutil1.setCpu("使用率过高");
        }else{
            mutil1.setCpu("正常，未超过安全水位");
        }
        if(Double.valueOf(process_cpu_c[0])>65){
            mutil1.setProcess_cpu("使用率过高");
        }else{
            mutil1.setProcess_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(cpu_io_c[0])>10){
            mutil1.setCpu_io("占比过高");
        }else{
            mutil1.setCpu_io("正常，未超过安全水位");
        }
        if(Double.valueOf(sys_cpu_c[0])>20){
            mutil1.setSys_cpu("占比过高");
        }else{
            mutil1.setSys_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(node_mem_c[0])>80){
            mutil1.setNode_mem("使用率过高");
        }else{
            mutil1.setNode_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(process_mem_c[0])>70){
            mutil1.setProcess_mem("使用率过高");
        }else{
            mutil1.setProcess_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(filesys_c[0])>70){
            mutil1.setFilesys("使用率过高");
        }else{
            mutil1.setFilesys("正常，未超过安全水位");
        }
        if(Double.valueOf(SWAP_c[0])>75){
            mutil1.setSWAP("比例过高");
        }else{
            mutil1.setSWAP("正常，未超过安全水位");
        }
        if(Double.valueOf(diskio_c[0])>60){
            mutil1.setDiskio("时间过长");
        }else{
            mutil1.setDiskio("正常，未超过安全水位");
        }
        if(Double.valueOf(receive_c[0])>1){
            mutil1.setReceive("一般");
        }else{
            mutil1.setReceive("正常，未超过安全水位");
        }
        if(Double.valueOf(transmit_c[0])>1){
            mutil1.setTransmit("一般");
        }else{
            mutil1.setTransmit("正常，未超过安全水位");
        }

        return mutil1;
    }

    @Override
    public Mutil findRecent_152() {
        Mutil mutil = mutilDao.findRecent_152();
        return mutil;
    }

    @Override
    public void Delete_152(String time) {
        mutilDao.Delete_152(time);
    }

    @Override
    public List<Mutil> findRecent100_152() {
        return mutilDao.findRecent100_152();
    }

    @Override
    public Mutil complier_152(Mutil mutil) {
        Mutil mutil1 = new Mutil();
        String time=mutil.getTime();
        String cpu=mutil.getCpu();
        String process_cpu=mutil.getProcess_cpu();
        String cpu_io=mutil.getCpu_io();
        String sys_cpu=mutil.getSys_cpu();
        String node_mem=mutil.getNode_mem();
        String process_mem=mutil.getProcess_mem();
        String SWAP=mutil.getSWAP();
        String diskio=mutil.getDiskio();
        String filesys=mutil.getFilesys();
        String receive=mutil.getReceive();
        String transmit=mutil.getTransmit();
        String[] cpu_c = cpu.split("%");
        String[] process_cpu_c = process_cpu.split("%");
        String[] cpu_io_c = cpu_io.split("%");
        String[] sys_cpu_c = sys_cpu.split("%");
        String[] node_mem_c = node_mem.split("%");
        String[] process_mem_c = process_mem.split("%");
        String[] SWAP_c = SWAP.split("%");
        String[] diskio_c = diskio.split("%");
        String[] filesys_c = filesys.split("%");
        String[] receive_c = receive.split("%");
        String[] transmit_c = transmit.split("%");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = df.format(new Date());
        mutil1.setTime(createtime);

        if(Double.valueOf(cpu_c[0])>80){
            mutil1.setCpu("使用率过高");
        }else{
            mutil1.setCpu("正常，未超过安全水位");
        }
        if(Double.valueOf(process_cpu_c[0])>65){
            mutil1.setProcess_cpu("使用率过高");
        }else{
            mutil1.setProcess_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(cpu_io_c[0])>10){
            mutil1.setCpu_io("占比过高");
        }else{
            mutil1.setCpu_io("正常，未超过安全水位");
        }
        if(Double.valueOf(sys_cpu_c[0])>20){
            mutil1.setSys_cpu("占比过高");
        }else{
            mutil1.setSys_cpu("正常，未超过安全水位");
        }
        if(Double.valueOf(node_mem_c[0])>80){
            mutil1.setNode_mem("使用率过高");
        }else{
            mutil1.setNode_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(process_mem_c[0])>70){
            mutil1.setProcess_mem("使用率过高");
        }else{
            mutil1.setProcess_mem("正常，未超过安全水位");
        }
        if(Double.valueOf(filesys_c[0])>70){
            mutil1.setFilesys("使用率过高");
        }else{
            mutil1.setFilesys("正常，未超过安全水位");
        }
        if(Double.valueOf(SWAP_c[0])>75){
            mutil1.setSWAP("比例过高");
        }else{
            mutil1.setSWAP("正常，未超过安全水位");
        }
        if(Double.valueOf(diskio_c[0])>60){
            mutil1.setDiskio("时间过长");
        }else{
            mutil1.setDiskio("正常，未超过安全水位");
        }
        if(Double.valueOf(receive_c[0])>1){
            mutil1.setReceive("一般");
        }else{
            mutil1.setReceive("正常，未超过安全水位");
        }
        if(Double.valueOf(transmit_c[0])>1){
            mutil1.setTransmit("一般");
        }else{
            mutil1.setTransmit("正常，未超过安全水位");
        }

        return mutil1;
    }
    @Override
    public String computerScore(Mutil mutil,int cpuload,int menload) {
        String cpu=mutil.getCpu();
        String node_mem=mutil.getNode_mem();
        String diskio=mutil.getDiskio();
        String filesys=mutil.getFilesys();
        String receive=mutil.getReceive();
        String transmit=mutil.getTransmit();
        String[] cpu_c = cpu.split("%");
        String[] node_mem_c = node_mem.split("%");
        String[] diskio_c = diskio.split("%");
        String[] filesys_c = filesys.split("%");
        String[] receive_c = receive.split("%");
        String[] transmit_c = transmit.split("%");
        Double score=(100-Double.valueOf(cpu_c[0]))*0.4*cpuload+(100-Double.valueOf(node_mem_c[0]))*0.4*menload+(100-Double.valueOf(diskio_c[0]))*0.1+(100-Double.valueOf(filesys_c[0]))*0.05+(100-Double.valueOf(receive_c[0]))*0.025+(100-Double.valueOf(transmit_c[0]))*0.025;
        System.out.println(score);

        return String.format("%.2f", score);

    }
    @Override
    public String ioScore(Mutil mutil,int cpuload,int menload) {
        String cpu=mutil.getCpu();
        String node_mem=mutil.getNode_mem();
        String diskio=mutil.getDiskio();
        String filesys=mutil.getFilesys();
        String receive=mutil.getReceive();
        String transmit=mutil.getTransmit();
        String[] cpu_c = cpu.split("%");
        String[] node_mem_c = node_mem.split("%");
        String[] diskio_c = diskio.split("%");
        String[] filesys_c = filesys.split("%");
        String[] receive_c = receive.split("%");
        String[] transmit_c = transmit.split("%");
        Double score=(100-Double.valueOf(cpu_c[0]))*0.15*cpuload+(100-Double.valueOf(node_mem_c[0]))*0.15*menload+(100-Double.valueOf(diskio_c[0]))*0.45+(100-Double.valueOf(filesys_c[0]))*0.1+(100-Double.valueOf(receive_c[0]))*0.075+(100-Double.valueOf(transmit_c[0]))*0.075;
        System.out.println(score);

        return String.format("%.2f", score);
    }
    @Override
    public int top(List<String> str) {
        double ans=0;//记录数值
        int i=0;//记录节点
        for (int j = 0; j < str.size(); j++) {
            if(Double.valueOf(str.get(j))>ans){
                ans=Double.valueOf(str.get(j));
                i=j+1;
            }

        }
        return i;
    }
    @Override
    public Mutil computercompiler(Mutil mutil) {
        Mutil mutil1 = new Mutil();
        String cpu=mutil.getProcess_cpu();
        String io=mutil.getDiskio();
        String[] cpu_c = cpu.split("%");
        String[] io_c = io.split("%");
        if(Double.valueOf(cpu_c[0])>80){
            mutil1.setCpu("计算密集型");
        }else{
            mutil1.setCpu("一般");
        }
        if(Double.valueOf(io_c[0])>80){
            mutil1.setDiskio("IO密集型");
        }else{
            mutil1.setDiskio("一般");
        }
        return mutil1;

    }
    public  int recommend(Mutil mutil,int i,int j){
        //mutil为mutilService.computercompiler函数的返回对象
        //i,j分别为计算能力和IO能力最高的节点的id
        if(i==j){
            return i;
        }else{
            String cpu=mutil.getCpu();
            String io=mutil.getDiskio();
            if(cpu.equals(io)){
                return i;
            }else{
                if(cpu.equals("计算密集型")){
                    return i;
                }else {
                    return j;
                }
            }

        }
    }

}
