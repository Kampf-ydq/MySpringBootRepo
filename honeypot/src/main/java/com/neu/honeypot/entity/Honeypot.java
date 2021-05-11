package com.neu.honeypot.entity;

import lombok.Data;

@Data
public class Honeypot {
    private int id;
    private String ip;
    private String IsHoneypot;
    private String IsS7;
    private String s7NameOfThePLC;
    private String s7PlantIdentification;
    private String s7SerialNumberOfModule;
    private String s7time5After;
    private String s7ResponseTime;
    private String IsModbus;
    private String modbusErrorRequestTime;
    private String modbusReadRegister;
    private String IsCloud;
    private String IPwhoisNetsDescription;
    private String OS;
    private String OSaccuracy;
    private String OpenPortNum;
    private String hopNum;
    private String IsAtg;
    private String atgSUPER;
    private String atgUNLEAD;
    private String atgDIESEL;
    private String atgPREMIUM;
    private String atgTwoTimesCompare;
    private String city;
    private String country;
    private String latitude;
    private String longitude;
    private String HoneypotFlag;
}
