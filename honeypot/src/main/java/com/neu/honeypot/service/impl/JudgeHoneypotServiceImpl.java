package com.neu.honeypot.service.impl;

import com.neu.honeypot.entity.Honeypot;
import com.neu.honeypot.mapper.HoneypotMapper;
import com.neu.honeypot.service.JudgeHoneypotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* 服务层：调用 python 程序，返回训练结果.
* @author  ydq
* @date  2021/4/9/009 11:29
*/
@Service
public class JudgeHoneypotServiceImpl implements JudgeHoneypotService {
    private static final String PY_PROGRAM_PATH = "G:\\Cybersecurity\\honeypotRes\\allhoneypot_recog.py";

    private static final String S7 = "G:\\Cybersecurity\\honeypotRes\\s7_100.csv";

    private static final String MODBUS = "G:\\Cybersecurity\\honeypotRes\\modbus_100.csv";

    private static final String ATG = "G:\\Cybersecurity\\honeypotRes\\atg_100.csv";

    @Autowired
    private HoneypotMapper mapper;

    public String judgeHoneypotByIp(String ip) {
        //判断数据库中是否有该ip
        if(!isExistIp(ip)){
            return null;
        }
        Process proc;
        String result = null;
        try {
            String[] arg = new String[]{"python", PY_PROGRAM_PATH, ip, S7, MODBUS, ATG};
            proc = Runtime.getRuntime().exec(arg);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                sb.append(line);
            }
            result = sb.toString();
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean isExistIp(String ip) {
        List<Honeypot> list = new ArrayList<>();
        list = mapper.selectByIp(ip);
        if (list != null && list.size() > 0){
            return true;
        }
        return false;
    }
}
