package io.github.pve.client.model.node;

import java.util.List;

public class NodeStatus {
    public MemoryInfo memory;
    public CpuInfo cpuinfo;
    public double cpu;
    public List<Double> loadavg;
    public RootFsInfo rootfs;
    public String pveversion;

    public static class MemoryInfo {
        public Long total, used, free;
    }

    public static class CpuInfo {
        public Integer cores, sockets;
        public String model, cpus;
    }

    public static class RootFsInfo {
        public Long total, used, free, avail;
    }

    @Override
    public String toString() {
        return "NodeStatus{pveversion='" + pveversion + "', cpu=" + cpu + "}";
    }
}