package com.learn.world.spring.test;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KeyDomain {
    private String ip;
    private int port;
    private long time;
    private long expireTime;
    private ETaskType taskType;

    public KeyDomain(ETaskType taskType, String ip, int port, long expireTime) {
        this.ip = ip;
        this.port = port;
        this.time = System.currentTimeMillis();
        this.expireTime = time + expireTime;
        this.taskType = taskType;
    }
}
