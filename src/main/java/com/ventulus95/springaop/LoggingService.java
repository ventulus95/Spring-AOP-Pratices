package com.ventulus95.springaop;

import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    public void test(){
        System.out.println("1234");
    }
}
