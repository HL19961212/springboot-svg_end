package com.kuang.entity;

public class Mutil {
    private String time;
    private String cpu;
    private String process_cpu;
    private String cpu_io;
    private String sys_cpu;
    private String node_mem;
    private String process_mem;
    private String SWAP;
    private String diskio;
    private String filesys;
    private String receive;
    private String transmit;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getProcess_cpu() {
        return process_cpu;
    }

    public void setProcess_cpu(String process_cpu) {
        this.process_cpu = process_cpu;
    }

    public String getCpu_io() {
        return cpu_io;
    }

    public void setCpu_io(String cpu_io) {
        this.cpu_io = cpu_io;
    }

    public String getSys_cpu() {
        return sys_cpu;
    }

    public void setSys_cpu(String sys_cpu) {
        this.sys_cpu = sys_cpu;
    }

    public String getNode_mem() {
        return node_mem;
    }

    public void setNode_mem(String node_mem) {
        this.node_mem = node_mem;
    }

    public String getProcess_mem() {
        return process_mem;
    }

    public void setProcess_mem(String process_mem) {
        this.process_mem = process_mem;
    }

    public String getSWAP() {
        return SWAP;
    }

    public void setSWAP(String SWAP) {
        this.SWAP = SWAP;
    }

    public String getDiskio() {
        return diskio;
    }

    public void setDiskio(String diskio) {
        this.diskio = diskio;
    }

    public String getFilesys() {
        return filesys;
    }

    public void setFilesys(String filesys) {
        this.filesys = filesys;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getTransmit() {
        return transmit;
    }

    public void setTransmit(String transmit) {
        this.transmit = transmit;
    }
}
