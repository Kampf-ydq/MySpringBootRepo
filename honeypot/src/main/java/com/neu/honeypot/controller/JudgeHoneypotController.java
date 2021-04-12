package com.neu.honeypot.controller;

import com.neu.honeypot.service.JudgeHoneypotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* 控制层：判断给定 ip 是否为蜜罐
* @author  ydq
* @date  2021/4/9/009 11:28
*/
@Controller
public class JudgeHoneypotController {

    @Autowired
    private JudgeHoneypotService service;

    @RequestMapping(value = "/isHoneypot/{ip}")
    @ResponseBody
    public String judgeHoneypotByIp(@PathVariable String ip){
        return service.judgeHoneypotByIp(ip);
    }
}
