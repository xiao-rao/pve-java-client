package io.github.pve.client.model.vm;

public class VirtualMachineSummary {
    public Integer vmid;
    public String name;
    public String status;
    public Long uptime;
    public Long maxdisk;
    public Long mem;
    public Integer cpus;
    public String node;
    public String template;

    @Override
    public String toString() {
        return "VirtualMachineSummary{vmid=" + vmid + ", name='" + name + "'}";
    }
}
