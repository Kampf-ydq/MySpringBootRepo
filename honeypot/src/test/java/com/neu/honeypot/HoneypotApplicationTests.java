package com.neu.honeypot;

import com.neu.honeypot.service.JudgeHoneypotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
class HoneypotApplicationTests {

    @Autowired
    private JudgeHoneypotService service;

    @Test
    void contextLoads() {
    }

    @Test
    void execPythonProgram(){
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python G:\\Cybersecurity\\honeypotRes\\allhoneypot_recog.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                System.out.println("??");
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSQL(){
        // "5.26.88.89"
        System.out.println(service.judgeHoneypotByIp("5.26.88.89"));
    }

}
