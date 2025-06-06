package io.github.pve.client.model.common;


import lombok.Data;

@Data
public class TaskStatusInfo {
    // 根据 /nodes/{node}/tasks/{upid}/status 响应定义
    public String node;
    public String user;
    public String status; // "running", "stopped"
    public String exitstatus; // "OK" on success, or error message
    public String type; // e.g. "qmcreate", "qmstart"
    public String id; // resource id, e.g. vmid
    public Integer pid;
    public Long pstart;
    public String upid;
    public Long starttime;

}
