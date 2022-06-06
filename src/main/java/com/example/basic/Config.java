package com.example.basic;

import com.example.basic.aop.TimeTraceAOP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TimeTraceAOP timeTraceAOP() {
        return new TimeTraceAOP();
    }

}
