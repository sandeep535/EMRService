package com.emr.emrlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmrLiteApplication {


    public static void main(String[] args) {
        SpringApplication.run(EmrLiteApplication.class, args);
    }
//    @Bean
//    public FilterRegistrationBean<EMRSecurityFilter> dawsonApiFilter() {
//        FilterRegistrationBean<EMRSecurityFilter> registration = new FilterRegistrationBean();
//        registration.setFilter(new EMRSecurityFilter());
//        registration.addUrlPatterns("/*");
//        return registration;
//    }

}
