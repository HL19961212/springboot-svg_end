package com.kuang;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;


@SpringBootApplication
@EnableScheduling
public class SpringbootSvgApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSvgApplication.class, args);
    }




}
