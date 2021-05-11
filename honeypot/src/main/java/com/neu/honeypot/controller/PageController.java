package com.neu.honeypot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String Pot(){
        return "honeypot";
    }

    @RequestMapping(value = "/sumary.html", method = RequestMethod.GET)
    public String Sumary(){
        return "sumary";
    }
}
