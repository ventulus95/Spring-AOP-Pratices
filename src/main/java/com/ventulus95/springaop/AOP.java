package com.ventulus95.springaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AOP implements MethodInterceptor {

    private static Logger log = LoggerFactory.getLogger(AOP.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("Spring AOP Test를 위한 로그");
        Object reveal = invocation.proceed();
        log.info("Spring AOP 테스트를 위한 로그 종료");
        return reveal;
    }
}
