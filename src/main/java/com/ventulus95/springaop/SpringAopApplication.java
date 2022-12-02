package com.ventulus95.springaop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication {

    public static LoggingService loggingService;

    public SpringAopApplication(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);

        ProxyFactory proxyFactory = new ProxyFactory(loggingService);
        //Proxy를 만들어서...
        proxyFactory.addAdvice(new AOP());
        //거기에 Advice (Interceptor)가 들어가서..
        LoggingService proxyService = (LoggingService) proxyFactory.getProxy();
        //실객체는 아니지만.. 프록시 객체를 뽑아내서
        loggingService.test();
        proxyService.test();
        //그 프록시 객체에서 .test 함수를 실행시키면 메소드 사이에 낑겨서 함수 작동을 하게 할 수 있다 이말이구만
        //.... 근데 너무 귀찮구만..

    }


}
