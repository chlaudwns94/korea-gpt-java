package com.korit.springboot_study.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {

    @Bean(value = "aaa")
    public ClassD call() {
        System.out.println("ConfigA call");
        return new ClassD();
    }

}
