package com.neu.honeypot.controller;

import com.google.gson.Gson;
import com.neu.honeypot.entity.Honeypot;
import com.neu.honeypot.service.JudgeHoneypotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
* 控制层：判断给定 ip 是否为蜜罐
* @author  ydq
* @date  2021/4/9/009 11:28
*/
@Controller
public class JudgeHoneypotController {

    @Autowired
    private JudgeHoneypotService service;

    @RequestMapping(value = "/{ip}")
    public String judgeHoneypotByIp(@PathVariable String ip, HttpServletRequest request, Model model){
        Map<String,Object> map = new HashMap<>();
        String judgeStr = service.judgeHoneypotByIp(ip);
        System.out.println(judgeStr);
        if (judgeStr != null ){
            // 解析JSON格式的结果集
            Honeypot honeypot = new Gson().fromJson(judgeStr,Honeypot.class);
            request.setAttribute("honeypot",honeypot);
            model.addAttribute("isS7", "True".equals(honeypot.getIsS7()) ? true : false);
            model.addAttribute("isModbus", "True".equals(honeypot.getIsModbus()) ? true : false);
            model.addAttribute("isAtg", "True".equals(honeypot.getIsAtg()) ? true : false);
            model.addAttribute("isHoneypot", "true".equals(honeypot.getHoneypotFlag()) ? true : false);
//            honeypot.getOpenPortNum();
//            System.out.println(model.getAttribute("isHoneypot"));
            /*map.put("ip",honeypot.getIp());
            map.put("IsHoneypot",honeypot.getIsHoneypot());

            // S7
            map.put("IsS7",honeypot.getIsS7());
            map.put("s7NameOfThePLC",honeypot.getS7NameOfThePLC());
            map.put("s7PlantIdentification",honeypot.getS7PlantIdentification());
            map.put("s7SerialNumberOfModule",honeypot.getS7SerialNumberOfModule());
            map.put("s7time5After",honeypot.getS7time5After());
            map.put("s7ResponseTime",honeypot.getS7ResponseTime());

            // Modbus
            map.put("IsModbus",honeypot.getIsModbus());
            map.put("modbusErrorRequestTime",honeypot.getModbusErrorRequestTime());
            map.put("modbusReadRegister",honeypot.getModbusReadRegister());

            // Atg
            map.put("IsAtg",honeypot.getIsAtg());
            map.put("atgSUPER",honeypot.getAtgSUPER());
            map.put("atgUNLEAD",honeypot.getAtgUNLEAD());
            map.put("atgDIESEL",honeypot.getAtgDIESEL());
            map.put("atgPREMIUM",honeypot.getAtgPREMIUM());
            map.put("atgTwoTimesCompare",honeypot.getAtgTwoTimesCompare());

            map.put("IsCloud",honeypot.getIsCloud());
            map.put("IPwhoisNetsDescription",honeypot.getIPwhoisNetsDescription());
            map.put("OS",honeypot.getOS());
            map.put("OSaccuracy",honeypot.getOSaccuracy());
            map.put("OpenPortNum",honeypot.getOpenPortNum());
            map.put("hopNum",honeypot.getHopNum());
            map.put("city",honeypot.getCity());
            //map.put("country",honeypot.getCountry());
            map.put("country","Shanghai");
            map.put("latitude",honeypot.getLatitude());
            map.put("longitude",honeypot.getLongitude());
            map.put("HoneypotFlag",honeypot.getHoneypotFlag());

            System.out.println(map.get("country"));*/
            //map.put("honeypot",honeypot);
            return "result";
        } else {
            return "error";
        }
    }
}
