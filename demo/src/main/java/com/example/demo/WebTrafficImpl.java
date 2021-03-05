package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebTrafficImpl implements WebTraffic{

    private int webTraffic = 0;

    @Override
    public void add(){ webTraffic++;}
    @Override
    public Integer getTraffic(){return webTraffic;}
}
