package com.neu.honeypot.mapper;

import com.neu.honeypot.entity.Honeypot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoneypotMapper {
    List<Honeypot> selectByIp(String ip);
}
