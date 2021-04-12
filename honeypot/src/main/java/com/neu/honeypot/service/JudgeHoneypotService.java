package com.neu.honeypot.service;

public interface JudgeHoneypotService {
    String judgeHoneypotByIp(String ip);

    boolean isExistIp(String ip);
}
